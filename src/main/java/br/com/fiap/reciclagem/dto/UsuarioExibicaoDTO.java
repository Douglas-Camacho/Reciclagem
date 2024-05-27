package br.com.fiap.reciclagem.dto;

import br.com.fiap.reciclagem.model.Usuario;

public record UsuarioExibicaoDTO(
        Long usuarioId,
        String nome,
        String email) {

    public UsuarioExibicaoDTO(Usuario usuario) {
        this(
            usuario.getUsuarioId(),
            usuario.getNome(),
            usuario.getEmail());
    }

}
