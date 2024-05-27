package br.com.fiap.Reciclagem.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "tbl_veiculos")
public class Veiculo {
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "SEQ_VEICULOS"
    )
    @SequenceGenerator(
            name = "SEQ_VEICULOS",
            sequenceName = "SEQ_VEICULOS",
            allocationSize = 50
    )
    private long id;
    private String placa;
    private String chassi;
    private long quilometragem;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getChassi() {
        return chassi;
    }

    public void setChassi(String chassi) {
        this.chassi = chassi;
    }

    public long getQuilometragem() {
        return quilometragem;
    }

    public void setQuilometragem(long quilometragem) {
        this.quilometragem = quilometragem;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Veiculo veiculo = (Veiculo) o;
        return id == veiculo.id && quilometragem == veiculo.quilometragem && Objects.equals(placa, veiculo.placa) && Objects.equals(chassi, veiculo.chassi);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, placa, chassi, quilometragem);
    }
}

