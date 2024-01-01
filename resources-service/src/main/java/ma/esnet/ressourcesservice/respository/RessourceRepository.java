package ma.esnet.ressourcesservice.respository;

import ma.esnet.ressourcesservice.entities.Ressource;
import org.springframework.data.jpa.repository.JpaRepository;


public interface RessourceRepository extends JpaRepository<Ressource,Long> {

}
