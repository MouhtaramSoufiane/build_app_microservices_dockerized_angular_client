package ma.esnet.ressourcesservice.mapper;

import ma.esnet.ressourcesservice.dto.ressourceDTO;
import ma.esnet.ressourcesservice.entities.Ressource;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ressourceMapper {
    ressourceMapper INSTANCE = Mappers.getMapper(ressourceMapper.class);
    @Mapping(source = "numberOfSeats", target = "seatCount")
    ressourceDTO ressourceToressourceDto(Ressource ressource);

    @Mapping(source = "numberOfSeats", target = "seatCount")
    Ressource ressourceDtoToressource(ressourceDTO ressourceDTO);

    @Mapping(source = "numberOfSeats", target = "seatCount")
    List<ressourceDTO> map(List<Ressource> ressources);
}
