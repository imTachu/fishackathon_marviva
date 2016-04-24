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

    @OneToOne(cascade = CascadeType.ALL, optional = false, fetch = FetchType.EAGER, orphanRemoval = true)
     // @JoinColumn(name="USER_ID", nullable=false)
     @PrimaryKeyJoinColumn
    private InformacionNutricional informacionNutricional;

    @OneToOne(cascade = CascadeType.ALL, optional = false, fetch = FetchType.EAGER, orphanRemoval = true)
     // @JoinColumn(name="USER_ID", nullable=false)
     @PrimaryKeyJoinColumn
    private Economia economia;

    @OneToOne(cascade = CascadeType.ALL, optional = false, fetch = FetchType.EAGER, orphanRemoval = true)
     // @JoinColumn(name="USER_ID", nullable=false)
     @PrimaryKeyJoinColumn
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
     * @return the nombreComun
     */
    public String getNombreComun() {
        return nombreComun;
    }

    /**
     * @param nombreComun the nombreComun to set
     */
    public void setNombreComun(String nombreComun) {
        this.nombreComun = nombreComun;
    }

    /**
     * @return the nombreCientifico
     */
    public String getNombreCientifico() {
        return nombreCientifico;
    }

    /**
     * @param nombreCientifico the nombreCientifico to set
     */
    public void setNombreCientifico(String nombreCientifico) {
        this.nombreCientifico = nombreCientifico;
    }

    /**
     * @return the nombreEtiquetado
     */
    public String getNombreEtiquetado() {
        return nombreEtiquetado;
    }

    /**
     * @param nombreEtiquetado the nombreEtiquetado to set
     */
    public void setNombreEtiquetado(String nombreEtiquetado) {
        this.nombreEtiquetado = nombreEtiquetado;
    }

    /**
     * @return the caracteristicasFilete
     */
    public String getCaracteristicasFilete() {
        return caracteristicasFilete;
    }

    /**
     * @param caracteristicasFilete the caracteristicasFilete to set
     */
    public void setCaracteristicasFilete(String caracteristicasFilete) {
        this.caracteristicasFilete = caracteristicasFilete;
    }

    /**
     * @return the caracteristicasAnimal
     */
    public String getCaracteristicasAnimal() {
        return caracteristicasAnimal;
    }

    /**
     * @param caracteristicasAnimal the caracteristicasAnimal to set
     */
    public void setCaracteristicasAnimal(String caracteristicasAnimal) {
        this.caracteristicasAnimal = caracteristicasAnimal;
    }

    /**
     * @return the longitudMinimaFilete
     */
    public Long getLongitudMinimaFilete() {
        return longitudMinimaFilete;
    }

    /**
     * @param longitudMinimaFilete the longitudMinimaFilete to set
     */
    public void setLongitudMinimaFilete(Long longitudMinimaFilete) {
        this.longitudMinimaFilete = longitudMinimaFilete;
    }

    /**
     * @return the longitudMaximaFilete
     */
    public Long getLongitudMaximaFilete() {
        return longitudMaximaFilete;
    }

    /**
     * @param longitudMaximaFilete the longitudMaximaFilete to set
     */
    public void setLongitudMaximaFilete(Long longitudMaximaFilete) {
        this.longitudMaximaFilete = longitudMaximaFilete;
    }

    /**
     * @return the pesoMinimoFilete
     */
    public Long getPesoMinimoFilete() {
        return pesoMinimoFilete;
    }

    /**
     * @param pesoMinimoFilete the pesoMinimoFilete to set
     */
    public void setPesoMinimoFilete(Long pesoMinimoFilete) {
        this.pesoMinimoFilete = pesoMinimoFilete;
    }

    /**
     * @return the pesoMaximoFilete
     */
    public Long getPesoMaximoFilete() {
        return pesoMaximoFilete;
    }

    /**
     * @param pesoMaximoFilete the pesoMaximoFilete to set
     */
    public void setPesoMaximoFilete(Long pesoMaximoFilete) {
        this.pesoMaximoFilete = pesoMaximoFilete;
    }

    /**
     * @return the longitudMinimaAnimal
     */
    public Long getLongitudMinimaAnimal() {
        return longitudMinimaAnimal;
    }

    /**
     * @param longitudMinimaAnimal the longitudMinimaAnimal to set
     */
    public void setLongitudMinimaAnimal(Long longitudMinimaAnimal) {
        this.longitudMinimaAnimal = longitudMinimaAnimal;
    }

    /**
     * @return the longitudMaximaAnimal
     */
    public Long getLongitudMaximaAnimal() {
        return longitudMaximaAnimal;
    }

    /**
     * @param longitudMaximaAnimal the longitudMaximaAnimal to set
     */
    public void setLongitudMaximaAnimal(Long longitudMaximaAnimal) {
        this.longitudMaximaAnimal = longitudMaximaAnimal;
    }

    /**
     * @return the pesoMinimoAnimal
     */
    public Long getPesoMinimoAnimal() {
        return pesoMinimoAnimal;
    }

    /**
     * @param pesoMinimoAnimal the pesoMinimoAnimal to set
     */
    public void setPesoMinimoAnimal(Long pesoMinimoAnimal) {
        this.pesoMinimoAnimal = pesoMinimoAnimal;
    }

    /**
     * @return the pesoMaximoAnimal
     */
    public Long getPesoMaximoAnimal() {
        return pesoMaximoAnimal;
    }

    /**
     * @param pesoMaximoAnimal the pesoMaximoAnimal to set
     */
    public void setPesoMaximoAnimal(Long pesoMaximoAnimal) {
        this.pesoMaximoAnimal = pesoMaximoAnimal;
    }

    /**
     * @return the imagenes
     */
    public List<String> getImagenes() {
        return imagenes;
    }

    /**
     * @param imagenes the imagenes to set
     */
    public void setImagenes(List<String> imagenes) {
        this.imagenes = imagenes;
    }

    /**
     * @return the origen
     */
    public String getOrigen() {
        return origen;
    }

    /**
     * @param origen the origen to set
     */
    public void setOrigen(String origen) {
        this.origen = origen;
    }

    /**
     * @return the coloracion
     */
    public String getColoracion() {
        return coloracion;
    }

    /**
     * @param coloracion the coloracion to set
     */
    public void setColoracion(String coloracion) {
        this.coloracion = coloracion;
    }

    /**
     * @return the olor
     */
    public String getOlor() {
        return olor;
    }

    /**
     * @param olor the olor to set
     */
    public void setOlor(String olor) {
        this.olor = olor;
    }

    /**
     * @return the estadoConservacion
     */
    public String getEstadoConservacion() {
        return estadoConservacion;
    }

    /**
     * @param estadoConservacion the estadoConservacion to set
     */
    public void setEstadoConservacion(String estadoConservacion) {
        this.estadoConservacion = estadoConservacion;
    }

    /**
     * @return the informacionNutricional
     */
    public InformacionNutricional getInformacionNutricional() {
        return informacionNutricional;
    }

    /**
     * @param informacionNutricional the informacionNutricional to set
     */
    public void setInformacionNutricional(InformacionNutricional informacionNutricional) {
        this.informacionNutricional = informacionNutricional;
    }

    /**
     * @return the economia
     */
    public Economia getEconomia() {
        return economia;
    }

    /**
     * @param economia the economia to set
     */
    public void setEconomia(Economia economia) {
        this.economia = economia;
    }

    /**
     * @return the regulacion
     */
    public Regulacion getRegulacion() {
        return regulacion;
    }

    /**
     * @param regulacion the regulacion to set
     */
    public void setRegulacion(Regulacion regulacion) {
        this.regulacion = regulacion;
    }

}
