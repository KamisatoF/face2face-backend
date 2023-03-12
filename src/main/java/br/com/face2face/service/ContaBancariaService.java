package br.com.face2face.service;

import br.com.face2face.domain.ContaBancaria;
import br.com.face2face.domain.Usuario;
import br.com.face2face.repository.ContaBancariaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContaBancariaService {

    @Autowired
    private ContaBancariaRepository repo;

    public List<ContaBancaria> find(Long id) {
        Usuario usuario = new Usuario();
        usuario.setId(id);
        return repo.findByUsuario(usuario).orElseThrow(() -> new RuntimeException("Objeto não encontrado: " + id));
    }

    public ContaBancaria insert(ContaBancaria contaBancaria) {
        Usuario us = new Usuario();
        us.setId(contaBancaria.getUserid());
        contaBancaria.setUsuario(us);
        contaBancaria.setId(null);
        return repo.save(contaBancaria);
    }

    public ContaBancaria update(ContaBancaria contaBancaria) {
        find(contaBancaria.getId());
        Usuario us = new Usuario();
        us.setId(contaBancaria.getUserid());
        contaBancaria.setUsuario(us);
        return repo.save(contaBancaria);
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
