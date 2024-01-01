package ma.esnet.ressourcesservice.web;

import ma.esnet.ressourcesservice.dto.ressourceDTO;
import ma.esnet.ressourcesservice.entities.Ressource;
import ma.esnet.ressourcesservice.mapper.ressourceMapperImpl;
import ma.esnet.ressourcesservice.respository.RessourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ressourceRestController {
    private RessourceRepository ressourceRepository;
    @Autowired
    private ressourceMapperImpl ressourceMapper;

    public ressourceRestController(RessourceRepository ressourceRepository) {
        this.ressourceRepository = ressourceRepository;
    }

    @GetMapping("/ressources")
    public List<Ressource> getAllressources(){
        List<Ressource> ressources = ressourceRepository.findAll();
        List<ressourceDTO> ressourceDTOS = ressourceMapper.map(ressources);
        return ressources;
    }

    @GetMapping("/ressources/{id}")
    public Ressource getRessourceById(@PathVariable("id") Long id){
        Ressource ressource = ressourceRepository.findById(id).orElseGet(null);
        ressourceDTO ressourceDTO = ressourceMapper.ressourceToressourceDto(ressource);
        return ressource;

    }

    @PostMapping("/ressources")
    public ressourceDTO addRessources(@RequestBody ressourceDTO ressourceDTO){
        Ressource ressource = ressourceMapper.ressourceDtoToressource(ressourceDTO);
        Ressource save = ressourceRepository.save(ressource);
        ressourceDTO dto = ressourceMapper.ressourceToressourceDto(save);
        return dto;

    }

    @DeleteMapping("/ressources/{id}")
    public void deleteRessourceById(@PathVariable(name = "id") Long id){
        ressourceRepository.deleteById(id);

    }

}
