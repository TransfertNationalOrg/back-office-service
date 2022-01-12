package ma.ensa.repository;

import ma.ensa.model.Parametre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ParametreRepository extends JpaRepository<Parametre, Long> {
}
