package br.com.fiap.Reciclagem.repository;

import br.com.fiap.Reciclagem.model.Veiculo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface VeiculoRepository extends JpaRepository<Veiculo, Long> {

    public Optional<Veiculo> findByPlaca(String placa);

}