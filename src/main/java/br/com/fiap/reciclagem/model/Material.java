package br.com.fiap.reciclagem.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "TBL_MATERIAL")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Material {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "SEQ_MATERIAL"
    )
    @SequenceGenerator(
            name = "SEQ_MATERIAL",
            sequenceName = "SEQ_MATERIAL",
            allocationSize = 1
    )
    @Column(name = "MATERIAL_ID")
    private Long materialID;

    @Column(name = "NOME", nullable = false)
    private String nome;

    @Column(name = "DESCRICAO")
    private String descricao;

    @Column(name = "TIPO", nullable = false)
    private String tipo;

    @Column(name = "PESO")
    private Double peso;

    @Column(name = "VOLUME")
    private Double volume;

    // Getters and Setters
    public Long getMaterialID() {
        return materialID;
    }

    public void setMaterialID(Long materialID) {
        this.materialID = materialID;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public Double getVolume() {
        return volume;
    }

    public void setVolume(Double volume) {
        this.volume = volume;
    }

    // Constructors
    public Material() {
    }

    public Material(Long materialID, String nome, String descricao, String tipo, Double peso, Double volume) {
        this.materialID = materialID;
        this.nome = nome;
        this.descricao = descricao;
        this.tipo = tipo;
        this.peso = peso;
        this.volume = volume;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Material material = (Material) o;

        return materialID != null ? materialID.equals(material.materialID) : material.materialID == null;
    }

    @Override
    public int hashCode() {
        return materialID != null ? materialID.hashCode() : 0;
    }
}


