package co.com.fishackathon.marviva.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import co.com.fishackathon.marviva.domain.Fish;

@Entity
@Table(name = "informacion_nutricional")
public class InformacionNutricional implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne(fetch=FetchType.LAZY, mappedBy="fish_id")
    private Fish fish;

    @Column(name = "proteinas")
    private String proteinas;

    @Column(name = "carbohidratos")
    private String carbohidratos;

    @Column(name = "calorias")
    private String calorias;

    @Column(name = "grasas")
    private String grasas;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Fish fish = (Fish) o;
        if(fish.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), fish.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return the fish
     */
    public Fish getFish() {
        return fish;
    }

    /**
     * @param fish the fish to set
     */
    public void setFish(Fish fish) {
        this.fish = fish;
    }

    /**
     * @return the proteinas
     */
    public String getProteinas() {
        return proteinas;
    }

    /**
     * @param proteinas the proteinas to set
     */
    public void setProteinas(String proteinas) {
        this.proteinas = proteinas;
    }

    /**
     * @return the carbohidratos
     */
    public String getCarbohidratos() {
        return carbohidratos;
    }

    /**
     * @param carbohidratos the carbohidratos to set
     */
    public void setCarbohidratos(String carbohidratos) {
        this.carbohidratos = carbohidratos;
    }

    /**
     * @return the calorias
     */
    public String getCalorias() {
        return calorias;
    }

    /**
     * @param calorias the calorias to set
     */
    public void setCalorias(String calorias) {
        this.calorias = calorias;
    }

    /**
     * @return the grasas
     */
    public String getGrasas() {
        return grasas;
    }

    /**
     * @param grasas the grasas to set
     */
    public void setGrasas(String grasas) {
        this.grasas = grasas;
    }

    
}
