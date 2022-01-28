package ma.ensa.beneficiaire;

import ma.ensa.Transfert.TransfertDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name="transfert-service")
public interface BeneficiaireFeign {
    //Get all beneficiaires from beneficiaire-service
    @GetMapping("/beneficiaire/")
    List<BeneficiaireDTO> findAll();

    //Get a beneficiaire by id from beneficiaire-service
    @GetMapping("beneficiaire/{idBeneficiaire}")
    BeneficiaireDTO getBeneficiaireById(@PathVariable("id") Long id);

    //Add a beneficiaire
    @PostMapping("/beneficiaire/")
    ResponseEntity<?> save(@RequestBody BeneficiaireDTO beneficiaireDTO);

    //Update a beneficiaire
    @PutMapping("/beneficiaire/")
    ResponseEntity<?> update(@RequestBody BeneficiaireDTO beneficiaireDTO);

    //Delete a beneficiaire
    @DeleteMapping("/beneficiaire/{id}")
    ResponseEntity<?> delete(@PathVariable Long id);

    //TRANSFERT-SERVICE

    //Get all transferts by idBeneficiaire
    @GetMapping("/transfert/beneficiaire/{id}")
    List<TransfertDTO> getTransfertsByBeneficiare(@PathVariable("id") Long id);


}
