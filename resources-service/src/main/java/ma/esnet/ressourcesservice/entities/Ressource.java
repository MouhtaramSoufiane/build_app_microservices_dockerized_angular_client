package ma.esnet.ressourcesservice.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.esnet.ressourcesservice.enums.ressourceType;

@Entity
@Data
@AllArgsConstructor @NoArgsConstructor @Builder
public class Ressource {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    @Enumerated(EnumType.STRING)
    private ressourceType ressourceType;
}
