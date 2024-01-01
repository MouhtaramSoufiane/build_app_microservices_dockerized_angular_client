package ma.esnet.conferenceservice.web;

import ma.esnet.conferenceservice.dto.PersonneDTO;
import ma.esnet.conferenceservice.enities.Personne;
import ma.esnet.conferenceservice.exceptions.NotFoundPersonException;
import ma.esnet.conferenceservice.mapper.mapperImpl;
import ma.esnet.conferenceservice.respository.PersonneRepository;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PersonneRestController {

    private PersonneRepository personneRepository;
    private mapperImpl mapper;

    public PersonneRestController(PersonneRepository personneRepository, mapperImpl mapper) {
        this.personneRepository = personneRepository;
        this.mapper = mapper;
    }

    @GetMapping("/persons")
    public List<PersonneDTO> getAll(){
        List<Personne> personnes = personneRepository.findAll();
        return mapper.mapPersonnes(personnes);

    }
    @GetMapping("/persons/{id}")
    public PersonneDTO getPersonneById(@PathVariable("id") Long id) throws NotFoundPersonException{
        return mapper.PersonneToPersonneDto(personneRepository.findById(id).orElseThrow(()-> new NotFoundPersonException("Person "+id+" not found exception")));

    }

    @DeleteMapping("/persons/{id}")
    public void deleteById(@PathVariable Long id){
         personneRepository.deleteById(id);
    }




}
