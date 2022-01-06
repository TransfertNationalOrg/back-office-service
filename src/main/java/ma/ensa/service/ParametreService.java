package ma.ensa.service;

import ma.ensa.exception.DuplicatedException;
import ma.ensa.exception.NotFoundException;
import ma.ensa.model.Parametre;

import java.util.List;

public interface ParametreService {

    Parametre save(Parametre parametre) throws DuplicatedException;
    Parametre update(Parametre parametre) throws NotFoundException;
    Long delete(Long id) throws NotFoundException;
    List<Parametre> findAll();
}
