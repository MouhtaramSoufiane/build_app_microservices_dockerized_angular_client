package ma.esnet.conferenceservice.respository;

import ma.esnet.conferenceservice.enities.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation,Long> {
}
