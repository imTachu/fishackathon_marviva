package co.com.fishackathon.marviva.web.rest;

import co.com.fishackathon.marviva.MarvivaApp;
import co.com.fishackathon.marviva.domain.Fish;
import co.com.fishackathon.marviva.repository.FishRepository;
import co.com.fishackathon.marviva.service.FishService;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.hamcrest.Matchers.hasItem;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


/**
 * Test class for the FishResource REST controller.
 *
 * @see FishResource
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = MarvivaApp.class)
@WebAppConfiguration
@IntegrationTest
public class FishResourceIntTest {

    private static final String DEFAULT_NOMBRE_COMUN = "AAAAA";
    private static final String UPDATED_NOMBRE_COMUN = "BBBBB";
    private static final String DEFAULT_NOMBRE_CIENTIFICO = "AAAAA";
    private static final String UPDATED_NOMBRE_CIENTIFICO = "BBBBB";

    private static final Long DEFAULT_LONGITUD = 1L;
    private static final Long UPDATED_LONGITUD = 2L;

    private static final Long DEFAULT_PESO = 1L;
    private static final Long UPDATED_PESO = 2L;
    private static final String DEFAULT_IMAGEN = "AAAAA";
    private static final String UPDATED_IMAGEN = "BBBBB";

    @Inject
    private FishRepository fishRepository;

    @Inject
    private FishService fishService;

    @Inject
    private MappingJackson2HttpMessageConverter jacksonMessageConverter;

    @Inject
    private PageableHandlerMethodArgumentResolver pageableArgumentResolver;

    private MockMvc restFishMockMvc;

    private Fish fish;

    @PostConstruct
    public void setup() {
        MockitoAnnotations.initMocks(this);
        FishResource fishResource = new FishResource();
        ReflectionTestUtils.setField(fishResource, "fishService", fishService);
        this.restFishMockMvc = MockMvcBuilders.standaloneSetup(fishResource)
            .setCustomArgumentResolvers(pageableArgumentResolver)
            .setMessageConverters(jacksonMessageConverter).build();
    }

    @Before
    public void initTest() {
        fish = new Fish();
        fish.setNombre_comun(DEFAULT_NOMBRE_COMUN);
        fish.setNombre_cientifico(DEFAULT_NOMBRE_CIENTIFICO);
        fish.setLongitud(DEFAULT_LONGITUD);
        fish.setPeso(DEFAULT_PESO);
        fish.setImagen(DEFAULT_IMAGEN);
    }

    @Test
    @Transactional
    public void createFish() throws Exception {
        int databaseSizeBeforeCreate = fishRepository.findAll().size();

        // Create the Fish

        restFishMockMvc.perform(post("/api/fish")
                .contentType(TestUtil.APPLICATION_JSON_UTF8)
                .content(TestUtil.convertObjectToJsonBytes(fish)))
                .andExpect(status().isCreated());

        // Validate the Fish in the database
        List<Fish> fish = fishRepository.findAll();
        assertThat(fish).hasSize(databaseSizeBeforeCreate + 1);
        Fish testFish = fish.get(fish.size() - 1);
        assertThat(testFish.getNombre_comun()).isEqualTo(DEFAULT_NOMBRE_COMUN);
        assertThat(testFish.getNombre_cientifico()).isEqualTo(DEFAULT_NOMBRE_CIENTIFICO);
        assertThat(testFish.getLongitud()).isEqualTo(DEFAULT_LONGITUD);
        assertThat(testFish.getPeso()).isEqualTo(DEFAULT_PESO);
        assertThat(testFish.getImagen()).isEqualTo(DEFAULT_IMAGEN);
    }

    @Test
    @Transactional
    public void getAllFish() throws Exception {
        // Initialize the database
        fishRepository.saveAndFlush(fish);

        // Get all the fish
        restFishMockMvc.perform(get("/api/fish?sort=id,desc"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.[*].id").value(hasItem(fish.getId().intValue())))
                .andExpect(jsonPath("$.[*].nombre_comun").value(hasItem(DEFAULT_NOMBRE_COMUN.toString())))
                .andExpect(jsonPath("$.[*].nombre_cientifico").value(hasItem(DEFAULT_NOMBRE_CIENTIFICO.toString())))
                .andExpect(jsonPath("$.[*].longitud").value(hasItem(DEFAULT_LONGITUD.intValue())))
                .andExpect(jsonPath("$.[*].peso").value(hasItem(DEFAULT_PESO.intValue())))
                .andExpect(jsonPath("$.[*].imagen").value(hasItem(DEFAULT_IMAGEN.toString())));
    }

    @Test
    @Transactional
    public void getFish() throws Exception {
        // Initialize the database
        fishRepository.saveAndFlush(fish);

        // Get the fish
        restFishMockMvc.perform(get("/api/fish/{id}", fish.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
            .andExpect(jsonPath("$.id").value(fish.getId().intValue()))
            .andExpect(jsonPath("$.nombre_comun").value(DEFAULT_NOMBRE_COMUN.toString()))
            .andExpect(jsonPath("$.nombre_cientifico").value(DEFAULT_NOMBRE_CIENTIFICO.toString()))
            .andExpect(jsonPath("$.longitud").value(DEFAULT_LONGITUD.intValue()))
            .andExpect(jsonPath("$.peso").value(DEFAULT_PESO.intValue()))
            .andExpect(jsonPath("$.imagen").value(DEFAULT_IMAGEN.toString()));
    }

    @Test
    @Transactional
    public void getNonExistingFish() throws Exception {
        // Get the fish
        restFishMockMvc.perform(get("/api/fish/{id}", Long.MAX_VALUE))
                .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateFish() throws Exception {
        // Initialize the database
        fishService.save(fish);

        int databaseSizeBeforeUpdate = fishRepository.findAll().size();

        // Update the fish
        Fish updatedFish = new Fish();
        updatedFish.setId(fish.getId());
        updatedFish.setNombre_comun(UPDATED_NOMBRE_COMUN);
        updatedFish.setNombre_cientifico(UPDATED_NOMBRE_CIENTIFICO);
        updatedFish.setLongitud(UPDATED_LONGITUD);
        updatedFish.setPeso(UPDATED_PESO);
        updatedFish.setImagen(UPDATED_IMAGEN);

        restFishMockMvc.perform(put("/api/fish")
                .contentType(TestUtil.APPLICATION_JSON_UTF8)
                .content(TestUtil.convertObjectToJsonBytes(updatedFish)))
                .andExpect(status().isOk());

        // Validate the Fish in the database
        List<Fish> fish = fishRepository.findAll();
        assertThat(fish).hasSize(databaseSizeBeforeUpdate);
        Fish testFish = fish.get(fish.size() - 1);
        assertThat(testFish.getNombre_comun()).isEqualTo(UPDATED_NOMBRE_COMUN);
        assertThat(testFish.getNombre_cientifico()).isEqualTo(UPDATED_NOMBRE_CIENTIFICO);
        assertThat(testFish.getLongitud()).isEqualTo(UPDATED_LONGITUD);
        assertThat(testFish.getPeso()).isEqualTo(UPDATED_PESO);
        assertThat(testFish.getImagen()).isEqualTo(UPDATED_IMAGEN);
    }

    @Test
    @Transactional
    public void deleteFish() throws Exception {
        // Initialize the database
        fishService.save(fish);

        int databaseSizeBeforeDelete = fishRepository.findAll().size();

        // Get the fish
        restFishMockMvc.perform(delete("/api/fish/{id}", fish.getId())
                .accept(TestUtil.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk());

        // Validate the database is empty
        List<Fish> fish = fishRepository.findAll();
        assertThat(fish).hasSize(databaseSizeBeforeDelete - 1);
    }
}
