package co.com.fishackathon.marviva.repository;

import co.com.fishackathon.marviva.domain.Fish;

import org.springframework.data.jpa.repository.*;

import java.util.List;
import org.springframework.data.repository.query.Param;

/**
 * Spring Data JPA repository for the Fish entity.
 */
public interface FishRepository extends JpaRepository<Fish, Long> {

    public List<Fish> findByLastName(String lastName);

    @Query("SELECT f FROM Fish f WHERE f.nombreComun = LOWER(:nombre)")
    public List<Fish> find(@Param("nombre") String nombre);

    
}
