package net.alex.pokedex.Model;

import jakarta.persistence.*;

import java.util.Objects;

/**
 *
 * @author alex
 */
@Entity
@Table(name = "POKEMONCONSULTADO")
public class PokemonConsultado {
    @Id
    @Basic(optional = false)
    @Column(name = "IDPOKEMONCONSULTADO")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idpokemonconsultado;
    @Basic(optional = false)
    @Column(name = "NOMBRE")
    private String nombre;
    @Basic(optional = false)
    @Column(name = "TIPO_1")
    private String tipo1;
    @Column(name = "TIPO_2")
    private String tipo2;
    @Basic(optional = false)
    @Column(name = "NOPOKEDEX")
    private int nopokedex;
    @Column(name = "EXPBASE")
    private int expbase;
    @Column(name = "ALTURA")
    private Double altura;
    @Column(name = "PESO")
    private int peso;

    public PokemonConsultado() {}

    public PokemonConsultado( String nombre, String tipo1, String tipo2, int nopokedex, int expbase, Double altura, int peso) {
        this.nombre = nombre;
        this.tipo1 = tipo1;
        this.tipo2 = tipo2;
        this.nopokedex = nopokedex;
        this.expbase = expbase;
        this.altura = altura;
        this.peso = peso;
    }

    public Long getIdpokemonconsultado() {
        return idpokemonconsultado;
    }

    public void setIdpokemonconsultado(Long idpokemonconsultado) {
        this.idpokemonconsultado = idpokemonconsultado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo1() {
        return tipo1;
    }

    public void setTipo1(String tipo1) {
        this.tipo1 = tipo1;
    }

    public String getTipo2() {
        return tipo2;
    }

    public void setTipo2(String tipo2) {
        this.tipo2 = tipo2;
    }

    public int getNopokedex() {
        return nopokedex;
    }

    public void setNopokedex(int nopokedex) {
        this.nopokedex = nopokedex;
    }

    public int getExpbase() {
        return expbase;
    }

    public void setExpbase(int expbase) {
        this.expbase = expbase;
    }

    public Double getAltura() {
        return altura;
    }

    public void setAltura(Double altura) {
        this.altura = altura;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PokemonConsultado that)) return false;
        return Objects.equals(getIdpokemonconsultado(), that.getIdpokemonconsultado());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIdpokemonconsultado());
    }

    @Override
    public String toString() {
        return "PokemonConsultado{" +
                "idpokemonconsultado=" + idpokemonconsultado +
                ", nombre='" + nombre + '\'' +
                ", tipo1='" + tipo1 + '\'' +
                ", tipo2='" + tipo2 + '\'' +
                ", nopokedex=" + nopokedex +
                ", expbase=" + expbase +
                ", altura=" + altura +
                ", peso=" + peso +
                '}';
    }
}