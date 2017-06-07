package co.zw.mdpcz.online.reg.controller;

import co.zw.mdpcz.online.reg.domain.Role;
import co.zw.mdpcz.online.reg.service.RoleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.inject.Inject;
import java.util.Optional;

/**
 * Created by kmadondo on 5/22/17.
 */
@Controller
@RequestMapping("/role")
public class RoleController {

    private final Logger logger = LoggerFactory.getLogger(RoleController.class);

    @Inject
    private RoleService roleService;

    @RequestMapping(value = {"/add", "/add/{id}"}, method = RequestMethod.GET)
    public String add(Optional<Long> idOptional , Model model) {

        final Role role;
        if(idOptional.isPresent())
        {
            role = roleService.findOne(idOptional.get()).get();
        }else{
            role = new Role();
        }

        logger.debug("role - add() is executed!");

        model.addAttribute("role", role);

        return "/role/add";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(@ModelAttribute("role") @Validated Role role,
                       BindingResult result, Model model,
                       final RedirectAttributes redirectAttributes) {

        logger.debug("save() : {}", role);

        if (result.hasErrors()) {

            return "/role/add";
        } else {
            redirectAttributes.addFlashAttribute("css", "success");
            if (role.isNew()) {
                redirectAttributes.addFlashAttribute("msg", "Role added successfully!");
            } else {
                redirectAttributes.addFlashAttribute("msg", "Role updated successfully!");
            }
            roleService.save(role);
            return "redirect:/";
        }

    }

}
