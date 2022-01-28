package ma.ensa.client;

import ma.ensa.Transfert.TransfertDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name="transfert-service")
public interface ClientFeign {
    //Get all clients from client-service
    @GetMapping("client/")
    List<ClientDTO> findAll();

    //Get a client by id from client-service
    @GetMapping("client/{idClient}")
    ClientDTO getClientById(@PathVariable("id") Long id);

    //Add a client
    @PostMapping("/client/")
    ResponseEntity<?> save (@RequestBody ClientDTO clientDTO);

    //Update a client
    @PutMapping("/client/")
    ResponseEntity<?> update (@RequestBody ClientDTO clientDTO);

    //Delete a client
    @DeleteMapping("/client/{id}")
    ResponseEntity<?> delete(@PathVariable Long id);

    //TRANSFERT-SERVICE

    //Get all transferts by idClient
    @GetMapping("/transfert/client/{id}")
    List<TransfertDTO> getTransfertsByClient(@PathVariable("id") Long id);

}
