package co.com.fishackathon.marviva.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import co.com.fishackathon.marviva.domain.Fish;
import java.time.LocalDate;

@Entity
@Table(name = "regulacion")
public class Regulacion implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne(fetch=FetchType.LAZY, mappedBy="fish_id")
    private Fish fish;

    @Column(name = "maximo_toneladas")
    private Long maximoToneladas;

    @Column(name = "inicio_veda")
    private LocalDate inicioVeda;

    @Column(name = "fin_veda")
    private LocalDate finVeda;

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
     * @return the maximoToneladas
     */
    public Long getMaximoToneladas() {
        return maximoToneladas;
    }

    /**
     * @param maximoToneladas the maximoToneladas to set
     */
    public void setMaximoToneladas(Long maximoToneladas) {
        this.maximoToneladas = maximoToneladas;
    }

    /**
     * @return the inicioVeda
     */
    public LocalDate getInicioVeda() {
        return inicioVeda;
    }

    /**
     * @param inicioVeda the inicioVeda to set
     */
    public void setInicioVeda(LocalDate inicioVeda) {
        this.inicioVeda = inicioVeda;
    }

    /**
     * @return the finVeda
     */
    public LocalDate getFinVeda() {
        return finVeda;
    }

    /**
     * @param finVeda the finVeda to set
     */
    public void setFinVeda(LocalDate finVeda) {
        this.finVeda = finVeda;
    }
}
