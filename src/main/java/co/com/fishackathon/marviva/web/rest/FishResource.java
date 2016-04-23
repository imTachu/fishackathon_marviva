package co.com.fishackathon.marviva.web.rest;

import com.codahale.metrics.annotation.Timed;
import co.com.fishackathon.marviva.domain.Fish;
import co.com.fishackathon.marviva.service.FishService;
import co.com.fishackathon.marviva.web.rest.util.HeaderUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

/**
 * REST controller for managing Fish.
 */
@RestController
@RequestMapping("/api")
public class FishResource {

    private final Logger log = LoggerFactory.getLogger(FishResource.class);
        
    @Inject
    private FishService fishService;
    
    /**
     * POST  /fish : Create a new fish.
     *
     * @param fish the fish to create
     * @return the ResponseEntity with status 201 (Created) and with body the new fish, or with status 400 (Bad Request) if the fish has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @RequestMapping(value = "/fish",
        method = RequestMethod.POST,
        produces = MediaType.APPLICATION_JSON_VALUE)
    @Timed
    public ResponseEntity<Fish> createFish(@RequestBody Fish fish) throws URISyntaxException {
        log.debug("REST request to save Fish : {}", fish);
        if (fish.getId() != null) {
            return ResponseEntity.badRequest().headers(HeaderUtil.createFailureAlert("fish", "idexists", "A new fish cannot already have an ID")).body(null);
        }
        Fish result = fishService.save(fish);
        return ResponseEntity.created(new URI("/api/fish/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert("fish", result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /fish : Updates an existing fish.
     *
     * @param fish the fish to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated fish,
     * or with status 400 (Bad Request) if the fish is not valid,
     * or with status 500 (Internal Server Error) if the fish couldnt be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @RequestMapping(value = "/fish",
        method = RequestMethod.PUT,
        produces = MediaType.APPLICATION_JSON_VALUE)
    @Timed
    public ResponseEntity<Fish> updateFish(@RequestBody Fish fish) throws URISyntaxException {
        log.debug("REST request to update Fish : {}", fish);
        if (fish.getId() == null) {
            return createFish(fish);
        }
        Fish result = fishService.save(fish);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert("fish", fish.getId().toString()))
            .body(result);
    }

    /**
     * GET  /fish : get all the fish.
     * @Param q 
     * @return the ResponseEntity with status 200 (OK) and the list of fish in body
     */
    @RequestMapping(value = "/fish",
        method = RequestMethod.GET,
        produces = MediaType.APPLICATION_JSON_VALUE)
    @Timed
    public List<Fish> getAllFish(@RequestParam(required = false, value = "q") String q) {
        log.debug("REST request to get all Fish");
        if (q != null) {
            return fishService.findByName(q);
        }
        return fishService.findAll();
    }

    /**
     * GET  /fish/:id : get the "id" fish.
     *
     * @param id the id of the fish to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the fish, or with status 404 (Not Found)
     */
    @RequestMapping(value = "/fish/{id}",
        method = RequestMethod.GET,
        produces = MediaType.APPLICATION_JSON_VALUE)
    @Timed
    public ResponseEntity<Fish> getFish(@PathVariable Long id) {
        log.debug("REST request to get Fish : {}", id);
        Fish fish = fishService.findOne(id);
        return Optional.ofNullable(fish)
            .map(result -> new ResponseEntity<>(
                result,
                HttpStatus.OK))
            .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    /**
     * DELETE  /fish/:id : delete the "id" fish.
     *
     * @param id the id of the fish to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @RequestMapping(value = "/fish/{id}",
        method = RequestMethod.DELETE,
        produces = MediaType.APPLICATION_JSON_VALUE)
    @Timed
    public ResponseEntity<Void> deleteFish(@PathVariable Long id) {
        log.debug("REST request to delete Fish : {}", id);
        fishService.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert("fish", id.toString())).build();
    }

}
