package ma.ensa.service.impl;

import lombok.Data;
import ma.ensa.exception.DuplicatedException;
import ma.ensa.exception.NotFoundException;
import ma.ensa.model.Parametre;
import ma.ensa.repository.ParametreRepository;
import ma.ensa.service.ParametreService;
import org.springframework.stereotype.Service;

import java.util.List;

@Data
@Service
public class ParametreServiceImpl implements ParametreService {

    final ParametreRepository parametreRepository;

    @Override
    public Parametre save(Parametre parametre) throws DuplicatedException {
        Parametre parametreFromDB = parametreRepository.findById(parametre.getId()).orElse(null);
        if (parametreFromDB != null)
            throw new DuplicatedException(parametre.getId());
        return parametreRepository.save(parametre);
    }

    @Override
    public Parametre update(Parametre parametre) throws NotFoundException {
        Parametre parametreFromDB = parametreRepository.findById(parametre.getId()).orElse(null);
        if (parametreFromDB == null)
            throw new NotFoundException(parametre.getId());
        parametre.setId(parametreFromDB.getId());
        return parametreRepository.save(parametre);
    }

    @Override
    public Long delete(Long id) throws NotFoundException {
        Parametre parametreFromDB = parametreRepository.findById(id).orElse(null);
        if (parametreFromDB == null)
            throw new NotFoundException(id);
        parametreRepository.delete(parametreFromDB);
        return id;
    }

    @Override
    public List<Parametre> findAll() {
        return parametreRepository.findAll();
    }
}
