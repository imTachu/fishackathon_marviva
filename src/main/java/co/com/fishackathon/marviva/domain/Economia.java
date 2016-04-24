package co.com.fishackathon.marviva.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import co.com.fishackathon.marviva.domain.Fish;

@Entity
@Table(name = "economia")
public class Economia implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne(fetch=FetchType.LAZY, mappedBy="fish_id")
    private Fish fish;

    @Column(name = "precio_promedio_kg")
    private Long precioPromedioKg;

    @Column(name = "forma_comercializacion")
    private String formaComercializacion;

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
     * @return the precioPromedioKg
     */
    public Long getPrecioPromedioKg() {
        return precioPromedioKg;
    }

    /**
     * @param precioPromedioKg the precioPromedioKg to set
     */
    public void setPrecioPromedioKg(Long precioPromedioKg) {
        this.precioPromedioKg = precioPromedioKg;
    }

    /**
     * @return the formaComercializacion
     */
    public String getFormaComercializacion() {
        return formaComercializacion;
    }

    /**
     * @param formaComercializacion the formaComercializacion to set
     */
    public void setFormaComercializacion(String formaComercializacion) {
        this.formaComercializacion = formaComercializacion;
    }

}
