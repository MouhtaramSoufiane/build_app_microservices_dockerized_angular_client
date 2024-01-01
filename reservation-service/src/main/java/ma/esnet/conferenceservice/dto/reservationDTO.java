package ma.esnet.conferenceservice.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.esnet.conferenceservice.enities.Personne;
import ma.esnet.conferenceservice.model.Ressource;

import java.util.Date;

@Data
@AllArgsConstructor @NoArgsConstructor @Builder
public class reservationDTO {
    private Long id;
    private String nom;
    private String context;
    private Date date;
    private Double duree;
    private Long ressourceId;
    private Personne personne;
    private Ressource ressource;
}
