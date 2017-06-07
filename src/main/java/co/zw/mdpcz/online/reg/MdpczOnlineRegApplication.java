package co.zw.mdpcz.online.reg;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@SpringBootApplication
public class MdpczOnlineRegApplication extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(MdpczOnlineRegApplication.class);
	}

	public static void main(String[] args) throws Throwable{
		SpringApplication.run(MdpczOnlineRegApplication.class, args);


		/*RestTemplate restTemplate = new RestTemplate();

		ResponseEntity<List<InstitutionDTO>> institutionResponds
				= restTemplate.exchange("http://localhost:8080/institution/list",
				HttpMethod.GET, null, new ParameterizedTypeReference<List<InstitutionDTO>>() {
				});
		List<InstitutionDTO> institutions = institutionResponds.getBody();
		System.out.println(institutions);*/
	}
}
