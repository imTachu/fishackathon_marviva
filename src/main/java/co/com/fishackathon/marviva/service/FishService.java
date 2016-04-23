package co.com.fishackathon.marviva.service;

import co.com.fishackathon.marviva.domain.Fish;
import co.com.fishackathon.marviva.repository.FishRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

/**
 * Service Implementation for managing Fish.
 */
@Service
@Transactional
public class FishService {

    private final Logger log = LoggerFactory.getLogger(FishService.class);
    
    @Inject
    private FishRepository fishRepository;
    
    /**
     * Save a fish.
     * 
     * @param fish the entity to save
     * @return the persisted entity
     */
    public Fish save(Fish fish) {
        log.debug("Request to save Fish : {}", fish);
        Fish result = fishRepository.save(fish);
        return result;
    }

    /**
     *  Get all the fish.
     *  
     *  @return the list of entities
     */
    @Transactional(readOnly = true) 
    public List<Fish> findAll() {
        log.debug("Request to get all Fish");
        List<Fish> result = fishRepository.findAll();
        return result;
    }

    /**
     *  Get one fish by id.
     *
     *  @param id the id of the entity
     *  @return the entity
     */
    @Transactional(readOnly = true) 
    public Fish findOne(Long id) {
        log.debug("Request to get Fish : {}", id);
        Fish fish = fishRepository.findOne(id);
        return fish;
    }

    /**
     *  Delete the  fish by id.
     *  
     *  @param id the id of the entity
     */
    public void delete(Long id) {
        log.debug("Request to delete Fish : {}", id);
        fishRepository.delete(id);
    }
}
