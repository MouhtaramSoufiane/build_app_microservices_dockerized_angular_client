package ma.esnet.ressourcesservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.esnet.ressourcesservice.enums.ressourceType;

@Data
@AllArgsConstructor @NoArgsConstructor @Builder
public class ressourceDTO {
    private Long id;
    private String nom;
    private ressourceType ressourceType;

}
