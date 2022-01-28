package ma.ensa.Transfert;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name="transfert-service")
public interface TransfertFeign {
    @GetMapping("/transfert/")
    List<TransfertDTO> findAll();

    @GetMapping("/transfert/agent/{idAgent}")
    List<TransfertDTO> getTransfertsByAgent(@PathVariable("idAgent") Long idAgent);

    @GetMapping("/transfert/client/{idAgent}")
    List<TransfertDTO> getTransfertsByClient(@PathVariable("idClient") Long idClient);

    @GetMapping("/transfert/beneficiaire/{idBeneficiaire}")
    List<TransfertDTO> getTransfertsByBeneficiaire(@PathVariable("idBeneficiaire") Long idBeneficiaire);
}
