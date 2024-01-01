package ma.esnet.conferenceservice.services;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import ma.esnet.conferenceservice.model.Ressource;

import ma.esnet.conferenceservice.security.FeignAdapter;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name = "ressources-service",configuration = FeignAdapter.class)

public interface RessourceRestClientService {
        @GetMapping("/ressources/{id}")
        @CircuitBreaker(name = "ressourcesService",fallbackMethod = "getDefaultResource")
         Ressource getRessourceById(@PathVariable Long id);
        @GetMapping("/ressources")
        @Retry(name = "retryAllResources",fallbackMethod = "getDefaultResources")
         List<Ressource> getAllressources();
        @PostMapping("/ressources")
         Ressource addRessources(@RequestBody Ressource ressource);
        default Ressource getDefaultResource(Long id,Exception e){
                return Ressource.builder()
                        .ressourceType("DEFAULT")
                        .nom("DEFAULT NAME")
                        .id(0L)
                        .build();
        }
        default List<Ressource> getDefaultResources(){
               return List.of();
        }

}
