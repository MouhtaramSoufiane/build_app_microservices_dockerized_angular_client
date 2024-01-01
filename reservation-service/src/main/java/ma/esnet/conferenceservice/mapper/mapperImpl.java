package ma.esnet.conferenceservice.mapper;

import ma.esnet.conferenceservice.dto.PersonneDTO;
import ma.esnet.conferenceservice.dto.reservationDTO;
import ma.esnet.conferenceservice.enities.Personne;
import ma.esnet.conferenceservice.enities.Reservation;

import ma.esnet.conferenceservice.model.Ressource;
import ma.esnet.conferenceservice.respository.PersonneRepository;
import ma.esnet.conferenceservice.services.RessourceRestClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class mapperImpl implements mapper {
    @Autowired
    private PersonneRepository personneRepository;
    @Autowired
    private RessourceRestClientService restClientService;
    @Override
    public reservationDTO reservationToreservationDto(Reservation reservation) {
        if(reservation==null){
            return null;
        }

        reservationDTO reservationDTO= new reservationDTO();
        reservationDTO.setId(reservation.getId());
        reservationDTO.setDate(reservation.getDate());
        reservationDTO.setDuree(reservation.getDuree());
        reservationDTO.setRessourceId(reservation.getRessourceId());
        reservationDTO.setNom(reservation.getNom());
        reservationDTO.setPersonne(reservation.getPersonne());
        Ressource ressource = restClientService.getRessourceById(reservation.getRessourceId());

        reservationDTO.setRessource(ressource);
        reservationDTO.setContext(reservation.getContext());



      return reservationDTO;
    }

    @Override
    public Reservation reservationDtoToreservation(reservationDTO reservationDTO) {
        if(reservationDTO==null){
            return null;
        }

        Reservation reservation = reservationDtoToreservation(reservationDTO);

        return reservation;
    }

    @Override
    public List<reservationDTO> map(List<Reservation> reservations) {
        if (reservations == null) {
            return null;
        }

        List<reservationDTO> list = new ArrayList<>(reservations.size());
        for (Reservation reservation : reservations) {
            list.add(reservationToreservationDto(reservation));
        }

        return list;
    }

    @Override
    public PersonneDTO PersonneToPersonneDto(Personne personne) {

        if(personne==null){
            return null;
        }
        PersonneDTO personneDTO=new PersonneDTO();
        personneDTO.setNom(personne.getNom());
        personneDTO.setId(personne.getId());
        personneDTO.setEmail(personne.getEmail());
        personneDTO.setFonction(personne.getFonction());
        List<Reservation> reservations = personne.getReservations();
        List<reservationDTO> reservationDTOS = map(reservations);
        personneDTO.setReservations(reservationDTOS);
        return personneDTO;
    }

    @Override
    public Personne PersonneDTOToPersonne(PersonneDTO personneDTO) {
        return null;
    }

    @Override
    public List<PersonneDTO> mapPersonnes(List<Personne> personnes) {
        if (personnes == null) {
            return null;
        }

        List<PersonneDTO> list = new ArrayList<>(personnes.size());
        for (Personne personne : personnes) {
            list.add(PersonneToPersonneDto(personne));
        }

        return list;
    }
}
