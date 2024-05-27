package br.com.fiap.Reciclagem.service;

import br.com.fiap.Reciclagem.model.Veiculo;
import br.com.fiap.Reciclagem.repository.VeiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class VeiculoService {
    @Autowired
    private VeiculoRepository veiculoRepository;
    public Veiculo gravar (Veiculo veiculo){
        return veiculoRepository.save(veiculo);
    }

    public Veiculo buscarPorId(Long id){

        Optional<Veiculo> veiculoOptional = veiculoRepository.findById(id);
        if (veiculoOptional.isPresent()){
            return veiculoOptional.get();
        } else {
            throw new RuntimeException("veiculo não encontrado");
        }
    }

    public List<Veiculo> listarTodosOsVeiculos(){
        return veiculoRepository.findAll();
    }

    public void excluir(Long id){
        Optional<Veiculo> veiculoOptional = veiculoRepository.findById(id);

        if (veiculoOptional.isPresent()) {
            veiculoRepository.delete(veiculoOptional.get());
        } else {
            throw new RuntimeException("veículo não encontrado");
        }
    }

    public List<Veiculo> listarTodos(){
        return veiculoRepository.findAll();
    }

    public Veiculo atualizar (Veiculo veiculo){
        Optional<Veiculo> veiculoOptional = veiculoRepository.findById(veiculo.getId());
        if (veiculoOptional.isPresent()){
            return veiculoRepository.save(veiculo);
        } else {
            throw new RuntimeException("veiculo não encontrado");
        }

    }
    public Veiculo buscarPelaPlaca(String placa){
        Optional<Veiculo> veiculoOptional = veiculoRepository.findByPlaca(placa);
        if (veiculoOptional.isPresent()){
            return veiculoOptional.get();
        } else {
            throw new RuntimeException("veiculo não encontrado");
        }
    }

}