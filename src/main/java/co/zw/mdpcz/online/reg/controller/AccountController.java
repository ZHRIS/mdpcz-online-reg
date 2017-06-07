package co.zw.mdpcz.online.reg.controller;

import co.zw.mdpcz.online.reg.domain.User;
import co.zw.mdpcz.online.reg.service.UserService;
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
 * Created by kmadondo on 5/23/17.
 */
@Controller
@RequestMapping("/account")
public class AccountController {


    private final Logger logger = LoggerFactory.getLogger(AccountController.class);
    @Inject
    private UserService userService;

    @RequestMapping(value = {"/add", "/add/{id}"}, method = RequestMethod.GET)
    public String add(Optional<Long> idOptional , Model model) {

        final User user;
        if(idOptional.isPresent())
        {
            user = userService.findOne(idOptional.get()).get();
        }else{
            user = new User();
        }

        logger.debug("user - add() is executed!");

        model.addAttribute("user", user);
        return "/account/add";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(@ModelAttribute("user") @Validated User user,
                       BindingResult result, Model model,
                       final RedirectAttributes redirectAttributes) {

        logger.debug("save() : {}", user);

        if (result.hasErrors()) {

            return "/account/add";
        } else {
            redirectAttributes.addFlashAttribute("css", "success");
            if (user.isNew()) {
                redirectAttributes.addFlashAttribute("msg", "User added successfully!");
            } else {
                redirectAttributes.addFlashAttribute("msg", "User updated successfully!");
            }
            userService.createNew(user);
            return "redirect:/login";
        }

    }
}
