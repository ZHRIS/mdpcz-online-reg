package co.zw.mdpcz.online.reg.controller;

import co.zw.mdpcz.online.reg.domain.User;
import co.zw.mdpcz.online.reg.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.inject.Inject;

/**
 * Created by kmadondo on 5/19/17.
 */
@Controller
//@RequestMapping("/user")
public class UserController {

    private final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Inject
    private UserService userService;


    /*@RequestMapping(value = "/home/{id}", method = RequestMethod.GET)
    public String home(@PathVariable("id") Long id, Model model) {

        Optional<User> userOptional = userService.findOne(id);
        if (!userOptional.isPresent()) {
            model.addAttribute("css", "danger");
            model.addAttribute("msg", "User not found");
        } else {

            final User user = userOptional.get();
            model.addAttribute("title", "Patient Detail");

            model.addAttribute("patient", user);
            model.addAttribute("patient", user);

        }
        return "/user/home";
    }*/

    /*@RequestMapping(value = {"/", "/{id}"}, method = RequestMethod.GET)
    public String home(@PathVariable("id") Long id, Model model) {

        Optional<User> userOptional = userService.findOne(id);
        if (!userOptional.isPresent()) {
            model.addAttribute("css", "danger");
            model.addAttribute("msg", "User not found");
        } else {

            final User user = userOptional.get();
            model.addAttribute("title", "Patient Detail");

            model.addAttribute("patient", user);
            model.addAttribute("patient", user);

        }
        return "/user/home";
    }*/

    /*@RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String show(@PathVariable("id") Long id, Model model) {

        logger.debug("show -patient() id: {}", id);

        Optional<Patient> patientOptional = patientService.findOne(id);
        if (!patientOptional.isPresent()) {
            model.addAttribute("css", "danger");
            model.addAttribute("msg", "Patient not found");
        } else {

            final Patient patient = patientOptional.get();
            model.addAttribute("title", "Patient Detail");

            model.addAttribute("patient", patient);
            model.addAttribute("patient", patient);
            model.addAttribute("employmentList", employmentService.findByPatient(patient));
            model.addAttribute("prescriptionList", prescriptionService.findByPatient(patient, null));
            model.addAttribute("medicalAidList", medicalAidService.findByPatient(patient).orElse(Collections.<MedicalAid>emptyList()));
            model.addAttribute("addressList", addressService.findByPatient(patient).orElse(Collections.<Address>emptyList()));
            model.addAttribute("contactList", contactService.findByPatient(patient).orElse(Collections.<Contact>emptyList()));
            model.addAttribute("patientAllergiesList", patientAllergieService.findByPatient(patient).orElse(Collections.<PatientAllergie>emptyList()));
            model.addAttribute("diagnosisList", diagnosisService.findByPatient(patient).orElse(Collections.<Diagnosis>emptyList()));
        }

        return "patient/view";

    }*/

    @RequestMapping(value = {"/", "/home"}, method = RequestMethod.GET)
    public String welcome(Model model, User user) {

        model.addAttribute("user", user);
        model.addAttribute("user", user);

        return "/user/home";
    }
}
