package br.com.fiap.reciclagem.repository;

import br.com.fiap.reciclagem.model.Material;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface MaterialRepository extends JpaRepository<Material, Long> {

    // Método para buscar material pelo nome
    Optional<Material> findByNome(String nome);

    // Método para listar materiais por tipo
    List<Material> findByTipo(String tipo);
}
