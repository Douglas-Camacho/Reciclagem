package br.com.fiap.Reciclagem.repository;

import br.com.fiap.Reciclagem.model.Veiculo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VeiculoRepository extends JpaRepository<Veiculo, Long> {

    public Veiculo findbyNome(String placa);

}
