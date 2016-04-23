package co.com.fishackathon.marviva.repository;

import co.com.fishackathon.marviva.domain.Fish;

import org.springframework.data.jpa.repository.*;

import java.util.List;

/**
 * Spring Data JPA repository for the Fish entity.
 */
public interface FishRepository extends JpaRepository<Fish,Long> {

}
