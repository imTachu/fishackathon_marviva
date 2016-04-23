package co.com.fishackathon.marviva.service;

import co.com.fishackathon.marviva.domain.Fish;
import co.com.fishackathon.marviva.repository.FishRepository;
import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.PutObjectResult;
import java.io.File;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;
import java.util.UUID;

/**
 * Service Implementation for managing Fish.
 */
@Service
@Transactional
public class FishService {

    private final Logger log = LoggerFactory.getLogger(FishService.class);
    
    private final String BUCKET = "marviva";

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
     * Get all the fish.
     *
     * @return the list of entities
     */
    @Transactional(readOnly = true)
    public List<Fish> findAll() {
        log.debug("Request to get all Fish");
        List<Fish> result = fishRepository.findAll();
        return result;
    }

    /**
     * Get one fish by id.
     *
     * @param id the id of the entity
     * @return the entity
     */
    @Transactional(readOnly = true)
    public Fish findOne(Long id) {
        log.debug("Request to get Fish : {}", id);
        Fish fish = fishRepository.findOne(id);
        return fish;
    }

    /**
     * Delete the fish by id.
     *
     * @param id the id of the entity
     */
    public void delete(Long id) {
        log.debug("Request to delete Fish : {}", id);
        fishRepository.delete(id);
    }

    private String uploadFishPicture(File file, Long id) {
        AmazonS3Client s3client = new AmazonS3Client(new ProfileCredentialsProvider());
        StringBuilder key = new StringBuilder("fish/");
        key.append(id);
        key.append("/");
        key.append(UUID.randomUUID().toString());
        s3client.putObject(new PutObjectRequest(BUCKET, key.toString(), file));
        return s3client.getResourceUrl(BUCKET, key.toString());
    }
}
