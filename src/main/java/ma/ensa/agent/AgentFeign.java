package ma.ensa.agent;

import ma.ensa.Transfert.TransfertDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name="agent-service")
public interface AgentFeign {
    //AGENT-SERVICE

    //Get all agents from agent-service
    @GetMapping("/agent/")
    List<AgentDTO> findAll();

    //Get an agent by id from agent-service
    @GetMapping("/agent/{idAgent}")
    AgentDTO getAgentById(@PathVariable("id") Long id);

    //Add an agent
    @PostMapping("/agent/")
    ResponseEntity<?> save (@RequestBody AgentDTO agentDTO);

    //Update an agent
    @PutMapping("/agent/")
    ResponseEntity<?> update(@RequestBody AgentDTO agentDTO);

    //Delete an agent
    @DeleteMapping("/agent/{id}")
    ResponseEntity<?> delete(@PathVariable Long id);

    //TRANSFERT-SERVICE

    //Get all transferts by idAgent
    @GetMapping("/transfert/agent/{id}")
    List<TransfertDTO> getTransfertsByAgent(@PathVariable("id") Long id);


}
