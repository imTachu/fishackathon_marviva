package co.com.fishackathon.marviva.domain;


import javax.persistence.*;
import java.io.Serializable;
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
    private String nombre_comun;

    @Column(name = "nombre_cientifico")
    private String nombre_cientifico;

    @Column(name = "longitud")
    private Long longitud;

    @Column(name = "peso")
    private Long peso;

    @Column(name = "imagen")
    private String imagen;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre_comun() {
        return nombre_comun;
    }

    public void setNombre_comun(String nombre_comun) {
        this.nombre_comun = nombre_comun;
    }

    public String getNombre_cientifico() {
        return nombre_cientifico;
    }

    public void setNombre_cientifico(String nombre_cientifico) {
        this.nombre_cientifico = nombre_cientifico;
    }

    public Long getLongitud() {
        return longitud;
    }

    public void setLongitud(Long longitud) {
        this.longitud = longitud;
    }

    public Long getPeso() {
        return peso;
    }

    public void setPeso(Long peso) {
        this.peso = peso;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Fish fish = (Fish) o;
        if(fish.id == null || id == null) {
            return false;
        }
        return Objects.equals(id, fish.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "Fish{" +
            "id=" + id +
            ", nombre_comun='" + nombre_comun + "'" +
            ", nombre_cientifico='" + nombre_cientifico + "'" +
            ", longitud='" + longitud + "'" +
            ", peso='" + peso + "'" +
            ", imagen='" + imagen + "'" +
            '}';
    }
}
