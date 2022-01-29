package ma.ensa.controller;

import lombok.Data;
import ma.ensa.Transfert.TransfertDTO;
import ma.ensa.Transfert.TransfertFeign;
import ma.ensa.agent.AgentDTO;
import ma.ensa.agent.AgentFeign;
import ma.ensa.beneficiaire.BeneficiaireDTO;
import ma.ensa.beneficiaire.BeneficiaireFeign;
import ma.ensa.client.ClientDTO;
import ma.ensa.client.ClientFeign;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.cache.annotation.CachePut;
import org.springframework.http.*;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("back-office")
@Data
public class BackOfficeController {

    private final AgentFeign agentFeign;
    private final TransfertFeign transfertFeign;
    private final BeneficiaireFeign beneficiaireFeign;
    private final ClientFeign clientFeign;
    // private final AgenceFeign agenceFeign;

    //FROM AGENT-SERVICE

    //Get all agents
    @GetMapping("/agent")
    List<AgentDTO> findAllAgent(){
        return agentFeign.findAll();
    }

    //Add an agent
    @PostMapping("/agent")
    ResponseEntity<?> save(@RequestBody AgentDTO agentDTO){
        return agentFeign.save(agentDTO);
    }

    //Update an agent
    @PutMapping("/agent")
    ResponseEntity<?> update(@RequestBody AgentDTO agentDTO){
        return agentFeign.update(agentDTO);
    }

    //Delete an agent
    @DeleteMapping("/agent/{id}")
    ResponseEntity<?> deleteAgent(@PathVariable Long id){
        return agentFeign.delete(id);
    }

    //FROM CLIENT-SERVICE

    //Get all clients
    @GetMapping("/client")
    List<ClientDTO> findAllClient(){
        return clientFeign.findAll();
    }

    //Add a client
    @PostMapping("/client")
    ResponseEntity<?> save(@RequestBody ClientDTO clientDTO){
        return clientFeign.save(clientDTO);
    }

    //Update a client
    @PutMapping("/client")
    ResponseEntity<?> update(@RequestBody ClientDTO clientDTO){
        return clientFeign.update(clientDTO);
    }

    //Delete a client
    @DeleteMapping("/client/{id}")
    ResponseEntity<?> deleteClient(@PathVariable Long id){
        return clientFeign.delete(id);
    }

    //FROM BENEFICIAIRE-SERVICE

    //Get all beneficiaires
    @GetMapping("/beneficiaire")
    List<BeneficiaireDTO> findAllBeneficiaire(){
        return beneficiaireFeign.findAll();
    }

    //Add a beneficiaire
    @PostMapping("/beneficiaire")
    ResponseEntity<?> save(@RequestBody BeneficiaireDTO beneficiaireDTO){
        return beneficiaireFeign.save(beneficiaireDTO);
    }

    //Update a beneficiaire
    @PutMapping("/beneficiaire")
    ResponseEntity<?> update(@RequestBody BeneficiaireDTO beneficiaireDTO){
        return beneficiaireFeign.update(beneficiaireDTO);
    }

    //Delete a beneficiaire
    @DeleteMapping("/beneficiaire/{id}")
    ResponseEntity<?> deleteBeneficiaire(@PathVariable Long id){
        return beneficiaireFeign.delete(id);
    }

    //FROM TRANSFERT-SERVICE

    //Get all transferts
    @GetMapping("/transfert")
    List<TransfertDTO> findAllTransferts(){
        return transfertFeign.findAll();
    }

    //Add a transfert
    @PostMapping("/transfert")
    ResponseEntity<?> save(@RequestBody TransfertDTO transfertDTO){
        return transfertFeign.save(transfertDTO);
    }

    //Update a transfert
    @PutMapping("/transfert")
    ResponseEntity<?> update(@RequestBody TransfertDTO transfertDTO){
        return transfertFeign.update(transfertDTO);
    }

    //Delete a transfert
    @DeleteMapping("/transfert/{id}")
    ResponseEntity<?> delete(@PathVariable Long id){
        return transfertFeign.delete(id);
    }

    //Get all transferts by agent from transfert-service
    @GetMapping("/allTransferts/{id}")
    public List<TransfertDTO> getAllTransfertsByAgent(@PathVariable("id") Long id){
        return transfertFeign.getTransfertsByAgent(id);
    }

    //Get all transferts by client from transfert-service
    @GetMapping("/allTransferts/{idClient}")
    public List<TransfertDTO> getAllTransfertsByClient(@PathVariable("id") Long id){
        return transfertFeign.getTransfertsByClient(id);
    }

    //Get all transferts by beneficiare from transfert-service
    @GetMapping("/allTransferts/{idBeneficiaire}")
    public List<TransfertDTO> getAllTransfertsByBeneficiaire(@PathVariable("id") Long id){
        return transfertFeign.getTransfertsByBeneficiaire(id);
    }
}
