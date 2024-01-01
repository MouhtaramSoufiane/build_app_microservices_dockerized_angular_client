package ma.esnet.conferenceservice.respository;

import ma.esnet.conferenceservice.enities.Personne;
import ma.esnet.conferenceservice.enities.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PersonneRepository extends JpaRepository<Personne,Long> {


}
