package br.com.fiap.reciclagem.service;

import br.com.fiap.reciclagem.dto.MaterialCadastroDTO;
import br.com.fiap.reciclagem.dto.MaterialExibicaoDTO;
import br.com.fiap.reciclagem.model.Material;
import br.com.fiap.reciclagem.repository.MaterialRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MaterialService {

    @Autowired
    private MaterialRepository materialRepository;

    public MaterialExibicaoDTO salvarMaterial(MaterialCadastroDTO materialDTO) {
        Material material = new Material();
        BeanUtils.copyProperties(materialDTO, material);
        Material materialSalvo = materialRepository.save(material);
        return new MaterialExibicaoDTO(materialSalvo);
    }

    public MaterialExibicaoDTO buscarPorId(Long id) {
        Optional<Material> materialOptional = materialRepository.findById(id);

        if (materialOptional.isPresent()) {
            return new MaterialExibicaoDTO(materialOptional.get());
        } else {
            throw new RuntimeException("Material não existe!");
        }
    }

    public MaterialExibicaoDTO buscarPorNome(String nome) {
        Optional<Material> materialOptional = materialRepository.findByNome(nome);

        if (materialOptional.isPresent()) {
            return new MaterialExibicaoDTO(materialOptional.get());
        } else {
            throw new RuntimeException("Material não existe!");
        }
    }

    public Page<MaterialExibicaoDTO> listarTodos(Pageable paginacao) {
        return materialRepository
                .findAll(paginacao)
                .map(MaterialExibicaoDTO::new);
    }

    public List<MaterialExibicaoDTO> listarMateriaisPorTipo(String tipo) {
        return materialRepository
                .findByTipo(tipo)
                .stream()
                .map(MaterialExibicaoDTO::new)
                .collect(Collectors.toList());
    }

    public void excluir(Long id) {
        Optional<Material> materialOptional = materialRepository.findById(id);

        if (materialOptional.isPresent()) {
            materialRepository.delete(materialOptional.get());
        } else {
            throw new RuntimeException("Material não encontrado!");
        }
    }

    public MaterialExibicaoDTO atualizar(MaterialCadastroDTO materialDTO) {
        Optional<Material> materialOptional = materialRepository.findById(materialDTO.getMaterialId());

        if (materialOptional.isPresent()) {
            Material material = materialOptional.get();
            BeanUtils.copyProperties(materialDTO, material);
            return new MaterialExibicaoDTO(materialRepository.save(material));
        } else {
            throw new RuntimeException("Material não encontrado!");
        }
    }
}
