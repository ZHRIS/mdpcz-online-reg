package co.zw.mdpcz.online.reg.controller;

import co.zw.mdpcz.online.reg.domain.InstitutionDTO;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.validation.Valid;
import java.io.IOException;
import java.lang.reflect.Type;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by kmadondo on 5/23/17.
 */
@Controller
@RequestMapping("/institution")
@RestController
public class InstitutionController {

    @RequestMapping(value = {"/add"}, method = RequestMethod.GET)
    public String add(Model model, InstitutionDTO institutionDTO) {

        InstitutionDTO institution = new InstitutionDTO();

        model.addAttribute("institution", institution);
        model.addAttribute("name", institutionDTO.getName());
        model.addAttribute("practitionerName", institutionDTO.getPractitionerInCharge());

        return "/institution/add";
    }

    @RequestMapping(value = "/save", method = RequestMethod.GET)
    public InstitutionDTO submitData(@ModelAttribute("institution") @Valid  InstitutionDTO institution,
                                     BindingResult result, ModelMap modelMap){

        RestTemplate restTemplate = new RestTemplate();

        final String uri = "http://localhost:8089/mdpcz2/institutions";

//        institution.setName(institution.getName());
//        institution.setPractitionerInCharge(institution.getPractitionerInCharge());
//        institution.setId(institution.getId());

        institution = restTemplate.postForObject( uri, institution, InstitutionDTO.class);

        return institution;
    }

    @RequestMapping(value = "/getInstitution")
    public ResponseEntity<InstitutionDTO> get(){

        InstitutionDTO institution = new InstitutionDTO();
        institution.setName(institution.getName());
        institution.setPractitionerInCharge(institution.getPractitionerInCharge());
        institution.setId(institution.getId());

        return new ResponseEntity<InstitutionDTO>(institution, HttpStatus.OK);
    }

    /*@RequestMapping(value = "/list", method = RequestMethod.GET)
    public String institutions(ModelMap model){

        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<List<InstitutionDTO>> institutionResponds
                = restTemplate.exchange("http://localhost:8080/institution/list",
                HttpMethod.GET, null, new ParameterizedTypeReference<List<InstitutionDTO>>() {
                });
        List<InstitutionDTO> institutions = institutionResponds.getBody();
        return "institution/list";
    }*/


    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String institutions(ModelMap model){

        model.addAttribute("details", getInstitutions());
        return "/institution/list";

    }


    public List<InstitutionDTO> getInstitutions() {
        URL url = null;
        List<InstitutionDTO> institutionList = new ArrayList<>();
        try {
            url = new URL("http://localhost:8080/institution/list");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        if (url != null) {
            try {
                Scanner scan = new Scanner(url.openStream());
                String str = new String();
                while (scan.hasNext()) {
                    str += scan.nextLine();
                }
                scan.close();

                Type listType = new TypeToken<List<InstitutionDTO>>() {
                }.getType();

                Gson gson = new GsonBuilder().setDateFormat("yyyy-mm-dd").create();
                institutionList = gson.fromJson(str, listType);

            } catch (MalformedURLException e) {

            } catch (IOException e) {

            }
        }
        return institutionList;

    }

}
