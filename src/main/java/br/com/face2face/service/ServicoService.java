package br.com.face2face.service;

import br.com.face2face.domain.Servico;
import br.com.face2face.domain.Usuario;
import br.com.face2face.repository.ServicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicoService {

    @Autowired
    private ServicoRepository repo;

    public List<Servico> find(String id) {
        Usuario usuario = new Usuario();
        usuario.setId(Long.valueOf(id));
        return repo.findByUsuario(usuario).orElseThrow(() -> new RuntimeException("Objeto não encontrado: " + id));
    }

    public List<Servico> find(Long id) {
        Usuario usuario = new Usuario();
        usuario.setId(id);
        return repo.findByUsuario(usuario).orElseThrow(() -> new RuntimeException("Objeto não encontrado: " + id));
    }

    public Servico insert(Servico servico) {
        Usuario us = new Usuario();
        us.setId(servico.getUserid());
        servico.setUsuario(us);
        servico.setId(null);
        return repo.save(servico);
    }

    public Servico update(Servico servico) {
        find(servico.getId());
        Usuario us = new Usuario();
        us.setId(servico.getUserid());
        servico.setUsuario(us);
        return repo.save(servico);
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
