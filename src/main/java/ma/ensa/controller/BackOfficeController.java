package ma.ensa.controller;

import lombok.Data;
import ma.ensa.Transfert.TransfertDTO;
import ma.ensa.Transfert.TransfertFeign;
import ma.ensa.agent.AgentDTO;
import ma.ensa.agent.AgentFeign;
import ma.ensa.beneficiaire.BeneficiaireFeign;
import ma.ensa.client.ClientFeign;
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
    ResponseEntity<?> delete(@PathVariable Long id){
        return agentFeign.delete(id);
    }

    //Get all transferts
    @GetMapping("/transfert")
    List<TransfertDTO> findAllTransferts(){
        return transfertFeign.findAll();
    }

    //Get all transferts by agent from transfert-service
    @GetMapping("/allTransferts/{id}")
    public List<TransfertDTO> getAllTransfertsByAgent(@PathVariable("id") Long id){
        return transfertFeign.getTransfertsByAgent(id);
    }

}
