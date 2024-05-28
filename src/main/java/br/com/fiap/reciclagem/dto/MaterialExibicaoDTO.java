package br.com.fiap.reciclagem.dto;
import br.com.fiap.reciclagem.model.Material;
import lombok.Data;

@Data
public class MaterialExibicaoDTO {
    private Long id;
    private String nome;
    private String descricao;
    private String tipo;
    private Double peso;
    private Double volume;

    public MaterialExibicaoDTO(Material material) {
        this.id = material.getMaterialID();
        this.nome = material.getNome();
        this.descricao = material.getDescricao();
        this.tipo = material.getTipo();
        this.peso = material.getPeso();
        this.volume = material.getVolume();
    }
}
