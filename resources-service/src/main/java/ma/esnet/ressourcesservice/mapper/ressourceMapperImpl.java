package ma.esnet.ressourcesservice.mapper;

import ma.esnet.ressourcesservice.dto.ressourceDTO;
import ma.esnet.ressourcesservice.entities.Ressource;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ressourceMapperImpl implements ressourceMapper {
    @Override
    public ressourceDTO ressourceToressourceDto(Ressource ressource) {
        if(ressource==null){
            return null;
        }

        ressourceDTO ressourceDTO= new ressourceDTO();
        ressourceDTO.setId(ressource.getId());
        ressourceDTO.setNom(ressource.getNom());
        ressourceDTO.setRessourceType(ressource.getRessourceType());

      return ressourceDTO;
    }

    @Override
    public Ressource ressourceDtoToressource(ressourceDTO ressourceDTO) {
        if(ressourceDTO==null){
            return null;
        }
        Ressource ressource= new Ressource();
        ressource.setId(ressourceDTO.getId());
        ressource.setNom(ressourceDTO.getNom());
        ressource.setRessourceType(ressourceDTO.getRessourceType());

        return ressource;
    }

    @Override
    public List<ressourceDTO> map(List<Ressource> ressources) {
        if (ressources == null) {
            return null;
        }

        List<ressourceDTO> list = new ArrayList<>(ressources.size());
        for (Ressource ressource : ressources) {
            list.add(ressourceToressourceDto(ressource));
        }

        return list;
    }
}
