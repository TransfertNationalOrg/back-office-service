package ma.ensa.Transfert;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name="transfert-service")
public interface TransfertFeign {
    @GetMapping("/transfert/")
    List<TransfertDTO> findAll();

    @PostMapping("/transfert/")
    ResponseEntity<?> save(@RequestBody TransfertDTO transfertDTO);

    @PutMapping("/transfert/")
    ResponseEntity<?> update(@RequestBody TransfertDTO transfertDTO);

    @DeleteMapping("/transfert/{id}")
    ResponseEntity<?> delete(@PathVariable Long id);

    @GetMapping("/transfert/agent/{idAgent}")
    List<TransfertDTO> getTransfertsByAgent(@PathVariable("idAgent") Long idAgent);

    @GetMapping("/transfert/client/{idAgent}")
    List<TransfertDTO> getTransfertsByClient(@PathVariable("idClient") Long idClient);

    @GetMapping("/transfert/beneficiaire/{idBeneficiaire}")
    List<TransfertDTO> getTransfertsByBeneficiaire(@PathVariable("idBeneficiaire") Long idBeneficiaire);
}
