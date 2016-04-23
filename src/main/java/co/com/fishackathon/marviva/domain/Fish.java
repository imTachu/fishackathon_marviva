package co.com.fishackathon.marviva.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

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

    @Column(name = "otros_nombres")
    @ElementCollection
    private List<String> otrosNombres;
    
    @Column(name = "longitud_minima")
    private Long longitudMinima;

    @Column(name = "longitud_maxima")
    private Long longitudMaxima;

    @Column(name = "peso_minimo")
    private Long pesoMinimo;

    @Column(name = "peso_maximo")
    private Long pesoMaximo;

    @Column(name = "imagen")
    private String imagen;

    @Column(name = "origen")
    private String origen;

    @Column(name = "coloracion")
    private String coloracion;

    @Column(name = "olor")
    private String olor;

    @Column(name = "precio_kg")
    private String precioKg;
    
    @Column(name = "estado")
    private String estado;

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
     * @return the otrosNombres
     */
    public List<String> getOtrosNombres() {
        return otrosNombres;
    }

    /**
     * @param otrosNombres the otrosNombres to set
     */
    public void setOtrosNombres(List<String> otrosNombres) {
        this.otrosNombres = otrosNombres;
    }

    /**
     * @return the longitudMinima
     */
    public Long getLongitudMinima() {
        return longitudMinima;
    }

    /**
     * @param longitudMinima the longitudMinima to set
     */
    public void setLongitudMinima(Long longitudMinima) {
        this.longitudMinima = longitudMinima;
    }

    /**
     * @return the longitudMaxima
     */
    public Long getLongitudMaxima() {
        return longitudMaxima;
    }

    /**
     * @param longitudMaxima the longitudMaxima to set
     */
    public void setLongitudMaxima(Long longitudMaxima) {
        this.longitudMaxima = longitudMaxima;
    }

    /**
     * @return the pesoMinimo
     */
    public Long getPesoMinimo() {
        return pesoMinimo;
    }

    /**
     * @param pesoMinimo the pesoMinimo to set
     */
    public void setPesoMinimo(Long pesoMinimo) {
        this.pesoMinimo = pesoMinimo;
    }

    /**
     * @return the pesoMaximo
     */
    public Long getPesoMaximo() {
        return pesoMaximo;
    }

    /**
     * @param pesoMaximo the pesoMaximo to set
     */
    public void setPesoMaximo(Long pesoMaximo) {
        this.pesoMaximo = pesoMaximo;
    }

    /**
     * @return the imagen
     */
    public String getImagen() {
        return imagen;
    }

    /**
     * @param imagen the imagen to set
     */
    public void setImagen(String imagen) {
        this.imagen = imagen;
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
     * @return the precioKg
     */
    public String getPrecioKg() {
        return precioKg;
    }

    /**
     * @param precioKg the precioKg to set
     */
    public void setPrecioKg(String precioKg) {
        this.precioKg = precioKg;
    }

    /**
     * @return the estado
     */
    public String getEstado() {
        return estado;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }
}
