package ma.esnet.conferenceservice.mapper;

import ma.esnet.conferenceservice.dto.PersonneDTO;
import ma.esnet.conferenceservice.dto.reservationDTO;
import ma.esnet.conferenceservice.enities.Personne;
import ma.esnet.conferenceservice.enities.Reservation;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface mapper {
    mapper INSTANCE = Mappers.getMapper(mapper.class);
    @Mapping(source = "numberOfSeats", target = "seatCount")
    reservationDTO reservationToreservationDto(Reservation reservation);

    @Mapping(source = "numberOfSeats", target = "seatCount")
    Reservation reservationDtoToreservation(reservationDTO reservationDTO);

    @Mapping(source = "numberOfSeats", target = "seatCount")
    List<reservationDTO> map(List<Reservation> ressources);


    @Mapping(source = "numberOfSeats", target = "seatCount")
    PersonneDTO PersonneToPersonneDto(Personne personne);

    @Mapping(source = "numberOfSeats", target = "seatCount")
    Personne PersonneDTOToPersonne(PersonneDTO personneDTO);

    @Mapping(source = "numberOfSeats", target = "seatCount")
    List<PersonneDTO> mapPersonnes(List<Personne> personnes);
}
