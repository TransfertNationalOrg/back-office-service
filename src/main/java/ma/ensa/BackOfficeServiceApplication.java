package ma.ensa;

import lombok.Data;
import ma.ensa.model.Parametre;
import ma.ensa.repository.ParametreRepository;
import ma.ensa.service.ParametreService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
@Data
@SpringBootApplication
@EnableFeignClients
public class BackOfficeServiceApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(BackOfficeServiceApplication.class, args);
	}

	private final ParametreService parametreService;
	private final ParametreRepository parametreRepository;

	@Override
	public void run(String... args) throws Exception {
		if(parametreRepository.findAll().size()==0){
			Parametre parametre = new Parametre();
			parametre.setId(1L);
			parametreService.save(parametre);
		}

	}
}
