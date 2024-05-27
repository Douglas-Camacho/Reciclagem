package br.com.fiap.Reciclagem.controller;

import br.com.fiap.Reciclagem.model.Veiculo;
import br.com.fiap.Reciclagem.repository.VeiculoRepository;
import br.com.fiap.Reciclagem.service.VeiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/apí")
public class VeiculoController {

    @Autowired
    private VeiculoService service;

    @PostMapping("/veiculos")
    @ResponseStatus(HttpStatus.CREATED)
    public Veiculo gravar (@RequestBody Veiculo veiculo) {
        return service.gravar(veiculo);
    }

    @GetMapping("/veiculos")
    @ResponseStatus(HttpStatus.OK)
    public List<Veiculo> listarTodosOsVeiculos(){
        return service.listarTodosOsVeiculos();
    }

    @DeleteMapping("/veiculos/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluir (@PathVariable Long id){
        service.excluir(id);
    }

    @PutMapping("/veiculos")
    public Veiculo atualizar (Veiculo veiculo){
        return service.atualizar(veiculo);
    }

    @GetMapping("/veiculos/{placa}")
    @ResponseStatus(HttpStatus.OK)
    public Veiculo buscarVeiculoPelaPlaca(@PathVariable String placa){
        return service.buscarPelaPlaca(placa);
    }

}
