package br.com.fiap.reciclagem.dto;

import lombok.Data;

@Data
public class MaterialCadastroDTO {
    private Long materialId;
    private String nome;
    private String descricao;
    private String tipo;
    private Double peso;
    private Double volume;

    public Long getMaterialId() {
        return materialId;
    }
}
