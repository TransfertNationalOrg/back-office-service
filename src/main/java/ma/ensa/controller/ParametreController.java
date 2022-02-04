package ma.ensa.controller;

import lombok.Data;
import ma.ensa.converter.ParametreConverter;
import ma.ensa.dto.ParametreDTO;
import ma.ensa.service.ParametreService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("parametre")
@Data
public class ParametreController {
    
    private final ParametreService parametreService;
    private final ParametreConverter parametreConverter;

    @PostMapping("/")
    public ResponseEntity<?> save(@RequestBody ParametreDTO parametreDTO) throws Exception {
        if (parametreDTO == null)
            return ResponseEntity.badRequest().body("The provided parametre is not valid");
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(parametreConverter.convertToDTO(parametreService.save(parametreConverter.convertToDM(parametreDTO))));
    }

    @PutMapping("/")
    public ResponseEntity<?> update(@RequestBody ParametreDTO parametreDTO) throws Exception {
        if (parametreDTO == null)
            return ResponseEntity.badRequest().body("The provided parametre is not valid");
        return ResponseEntity
                .ok().body(parametreConverter.convertToDTO(parametreService.update(parametreConverter.convertToDM(parametreDTO))));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) throws Exception {
        if(id == null)
            return ResponseEntity.badRequest().body("The provided parametre's id is not valid");
        return ResponseEntity.ok().body("Agent [" + parametreService.delete(id) + "] deleted successfully.");
    }

    @GetMapping("/")
    public ResponseEntity<List<ParametreDTO>> findAll() {
        return ResponseEntity.ok().body(parametreConverter.convertToDTOs(parametreService.findAll()));
    }
}
