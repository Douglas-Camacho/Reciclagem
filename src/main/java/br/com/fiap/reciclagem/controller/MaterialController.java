package br.com.fiap.reciclagem.controller;

import br.com.fiap.reciclagem.dto.MaterialCadastroDTO;
import br.com.fiap.reciclagem.dto.MaterialExibicaoDTO;
import br.com.fiap.reciclagem.service.MaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MaterialController {

    @Autowired
    private MaterialService materialService;

    @PostMapping("/materiais")
    @ResponseStatus(HttpStatus.CREATED)
    public MaterialExibicaoDTO salvar(
            @RequestBody MaterialCadastroDTO material){
        return materialService.salvarMaterial(material);
    }

    @GetMapping("/materiais")
    @ResponseStatus(HttpStatus.OK)
    public Page<MaterialExibicaoDTO> listarTodos(
            @PageableDefault(size = 20, page = 0) Pageable paginacao
    ){
        return materialService.listarTodos(paginacao);
    }

    @RequestMapping(value = "/materiais", params = "nome")
    public ResponseEntity<MaterialExibicaoDTO> buscarPorNome(
            @RequestParam String nome){
        try {
            return ResponseEntity
                    .ok(materialService.buscarPorNome(nome));
        } catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }

    @RequestMapping(value = "/materiais", params = {"tipo"})
    @ResponseStatus(HttpStatus.OK)
    public List<MaterialExibicaoDTO> listarMateriaisPorTipo(
            @RequestParam String tipo
    ){
        return materialService.listarMateriaisPorTipo(tipo);
    }

    @GetMapping("/materiais/{materialId}")
    public ResponseEntity<MaterialExibicaoDTO> buscarPorId(
            @PathVariable Long materialId){
        try {
            return ResponseEntity
                    .ok(materialService.buscarPorId(materialId));
        } catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/materiais/{materialId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluir(@PathVariable Long materialId){
        materialService.excluir(materialId);
    }

    @PutMapping("/materiais")
    public ResponseEntity<MaterialExibicaoDTO> atualizar(
            @RequestBody MaterialCadastroDTO materialDTO){
        try {
            MaterialExibicaoDTO materialExibicaoDTO =
                    materialService.atualizar(materialDTO);
            return ResponseEntity.ok(materialExibicaoDTO);
        } catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }

}
