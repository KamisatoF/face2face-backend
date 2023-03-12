package br.com.face2face.service;

import br.com.face2face.domain.Equipamento;
import br.com.face2face.domain.Usuario;
import br.com.face2face.repository.EquipamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EquipamentoService {

    @Autowired
    private EquipamentoRepository repo;

    public List<Equipamento> find(Long id) {
        Usuario usuario = new Usuario();
        usuario.setId(id);
        return repo.findByUsuario(usuario).orElseThrow(() -> new RuntimeException("Objeto não encontrado: " + id));
    }

    public Equipamento insert(Equipamento equipamento) {
        Usuario us = new Usuario();
        us.setId(equipamento.getUserid());
        equipamento.setUsuario(us);
        equipamento.setId(null);
        return repo.save(equipamento);
    }

    public Equipamento update(Equipamento equipamento) {
        find(equipamento.getId());
        Usuario us = new Usuario();
        us.setId(equipamento.getUserid());
        equipamento.setUsuario(us);
        return repo.save(equipamento);
    }

    public void delete(Long id) {
        find(id);
        try {
            repo.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao excluir: " + id);
        }
    }

    public Object findAll() {
        return repo.findAllByOrderByIdDesc();
    }

    public void deleteAll() {
        repo.deleteAll();
    }

}
