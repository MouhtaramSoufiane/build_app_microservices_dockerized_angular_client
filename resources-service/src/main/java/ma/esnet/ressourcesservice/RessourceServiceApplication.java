package ma.esnet.ressourcesservice;

import ma.esnet.ressourcesservice.entities.Ressource;
import ma.esnet.ressourcesservice.enums.ressourceType;
import ma.esnet.ressourcesservice.respository.RessourceRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class RessourceServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(RessourceServiceApplication.class, args);
	}
	@Bean
	CommandLineRunner start(RessourceRepository ressourceRepository){
		return args -> {
			for (int i = 0; i <3 ; i++) {
				Ressource ressource= Ressource.builder()
						.nom(Math.random()>0.8?"R1":"R2")
						.ressourceType(Math.random()>0.4?ressourceType.MATERIEL_INF0:ressourceType.MATERIEL_AUDIO_VUSUEL)
						.build();
				ressourceRepository.save(ressource);
			}
		};
	}

}
