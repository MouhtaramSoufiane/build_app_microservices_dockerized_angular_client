package ma.esnet.conferenceservice.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.List;


@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class PersonneDTO {
    private Long id;
    private String nom;
    private String email;
    private String fonction;
    private List<reservationDTO> reservations;
}
