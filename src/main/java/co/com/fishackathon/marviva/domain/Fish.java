package co.com.fishackathon.marviva.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import co.com.fishackathon.marviva.domain.InformacionNutricional;
import co.com.fishackathon.marviva.domain.Economia;
import co.com.fishackathon.marviva.domain.Regulacion;

/**
 * A Fish.
 */
@Entity
@Table(name = "fish")
public class Fish implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "nombre_comun")
    private String nombreComun;

    @Column(name = "nombre_cientifico")
    private String nombreCientifico;

    @Column(name = "nombre_etiquetado")
    private String nombreEtiquetado;

    @Column(name = "caracteristicas_filete")
    private String caracteristicasFilete;

    @Column(name = "caracteristicas_animal")
    private String caracteristicasAnimal;

    @Column(name = "longitud_minima_filete")
    private Long longitudMinimaFilete;

    @Column(name = "longitud_maxima_filete")
    private Long longitudMaximaFilete;

    @Column(name = "peso_minimo_filete")
    private Long pesoMinimoFilete;

    @Column(name = "peso_maximo_filete")
    private Long pesoMaximoFilete;

    @Column(name = "longitud_minima_animal")
    private Long longitudMinimaAnimal;

    @Column(name = "longitud_maxima_animal")
    private Long longitudMaximaAnimal;

    @Column(name = "peso_minimo_animal")
    private Long pesoMinimoAnimal;

    @Column(name = "peso_maximo_animal")
    private Long pesoMaximoAnimal;

    @Column(name = "imagenes")
    @ElementCollection
    private List<String> imagenes;

    @Column(name = "origen")
    private String origen;

    @Column(name = "coloracion")
    private String coloracion;

    @Column(name = "olor")
    private String olor;

    @Column(name = "estado_conservacion")
    private String estadoConservacion;

    @OneToOne(fetch=FetchType.EAGER, mappedBy="informacion_nutricional_id")
    private InformacionNutricional informacionNutricional;

    @OneToOne(fetch=FetchType.EAGER, mappedBy="economia_id")
    private Economia economia;

    @OneToOne(fetch=FetchType.EAGER, mappedBy="regulacion_id")
    private Regulacion regulacion;

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

}
