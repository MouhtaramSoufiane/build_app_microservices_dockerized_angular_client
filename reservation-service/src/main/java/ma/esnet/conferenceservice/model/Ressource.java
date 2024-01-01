package ma.esnet.conferenceservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor @Builder
public class Ressource {
    private Long id;
    private String nom;
    private String ressourceType;
}
