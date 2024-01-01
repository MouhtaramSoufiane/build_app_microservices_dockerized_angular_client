package ma.esnet.conferenceservice;

import ma.esnet.conferenceservice.enities.Personne;
import ma.esnet.conferenceservice.enities.Reservation;
import ma.esnet.conferenceservice.respository.PersonneRepository;
import ma.esnet.conferenceservice.respository.ReservationRepository;
import ma.esnet.conferenceservice.services.RessourceRestClientService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.List;

@SpringBootApplication
@EnableFeignClients
public class ReservationServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReservationServiceApplication.class, args);
	}
	@Bean
	CommandLineRunner start(RessourceRestClientService restClientService,ReservationRepository reservationRepository, PersonneRepository personneRepository){
		return args -> {

			List.of("Soufiane", "Mohamed", "Yassine", "Khalid").forEach(p->{
				Personne personne = Personne.builder()
						.nom(p)
						.email(p+"@gmail.com")
						.fonction(Math.random()>0.5?"President":"Rapporteur")
						.build();

				Personne savedPersonne = personneRepository.save(personne);

				for (int i = 1; i < 4; i++) {

					Reservation reservation= Reservation.builder()
							.nom("Reservation"+i)
							.date(new Date())
							.duree(Math.random()*1000)
							.context(Math.random()>0.6?"AI":"Software Engineering")
							.personne(savedPersonne)
							.ressourceId((long)i)
							.ressource(restClientService.getRessourceById((long) i))
							.build();

					reservationRepository.save(reservation);

				}

			});

		};
	}

}
