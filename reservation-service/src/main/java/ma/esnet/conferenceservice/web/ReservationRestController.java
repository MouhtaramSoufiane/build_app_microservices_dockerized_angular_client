package ma.esnet.conferenceservice.web;

import ma.esnet.conferenceservice.dto.reservationDTO;
import ma.esnet.conferenceservice.enities.Personne;
import ma.esnet.conferenceservice.enities.Reservation;
import ma.esnet.conferenceservice.mapper.mapperImpl;
import ma.esnet.conferenceservice.model.Ressource;
import ma.esnet.conferenceservice.respository.PersonneRepository;
import ma.esnet.conferenceservice.respository.ReservationRepository;
import ma.esnet.conferenceservice.services.RessourceRestClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ReservationRestController {

    private ReservationRepository reservationRepository;

     final RessourceRestClientService restClientService;

     private PersonneRepository personneRepository;


    @Autowired
    private mapperImpl reservationMapper;

    public ReservationRestController(ReservationRepository reservationRepository, RessourceRestClientService restClientService, PersonneRepository personneRepository) {
        this.reservationRepository = reservationRepository;

        this.restClientService = restClientService;
        this.personneRepository = personneRepository;
    }
    @GetMapping("/reservations")
    public List<reservationDTO> reservations(){
        List<reservationDTO> reservationDTOS = reservationMapper.map(reservationRepository.findAll());
        return reservationDTOS;
    }
    @GetMapping("/reservations/{id}")
    public reservationDTO reservation(@PathVariable Long id){
        Reservation reservation = reservationRepository.findById(id).orElseGet(null);

        return reservationMapper.reservationToreservationDto(reservation);
    }

    @PostMapping("/reservations")
    public reservationDTO addReservations(@RequestBody Reservation reservation){
        Ressource ressource = restClientService.addRessources(reservation.getRessource());

        Long ressourceId = ressource.getId();
        Personne personne = personneRepository.save(reservation.getPersonne());
        reservation.setPersonne(personne);
        reservation.setRessourceId(ressourceId);
        reservation.setRessource(ressource);
        Reservation save = reservationRepository.save(reservation);
        reservationDTO reservationDTO1 = reservationMapper.reservationToreservationDto(save);
        return reservationDTO1;

    }
    @PutMapping("/reservations/{id}")
    public reservationDTO updateReservations(@RequestBody reservationDTO reservationDTO,@PathVariable(name = "id") Long id){
        Reservation reservation1 = reservationRepository.findById(id).get();
        reservation1.setNom(reservationDTO.getNom());
        reservation1.setDate(reservationDTO.getDate());
        reservation1.setContext(reservationDTO.getContext());
        reservation1.setDuree(reservationDTO.getDuree());
        Reservation save = reservationRepository.save(reservation1);
        reservationDTO reservationDTO1 = reservationMapper.reservationToreservationDto(save);
        return reservationDTO1;

    }

    @DeleteMapping("/reservations/{id}")
    public void deleteReservationById(@PathVariable Long id){
        reservationRepository.deleteById(id);

    }

}
