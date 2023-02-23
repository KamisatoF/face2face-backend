package br.com.face2face.service;

import br.com.face2face.domain.Usuario;
import br.com.face2face.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository repo;

    public Usuario find(Long id) {
        return repo.findById(id).orElseThrow(() -> new RuntimeException("Objeto não encontrado: " + id));
    }

    public Usuario auth(String email, String senha) {
        return repo.findByEmailAndSenha(email, senha);
    }

    public Usuario insert(Usuario usuario) {
        usuario.setId(null);
        return repo.save(usuario);
    }

    public Usuario update(Usuario usuario) {
        find(usuario.getId());
        return repo.save(usuario);
    }

    public void delete(Long id) {
        find(id);
        try {
            repo.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao excluir: " + id);
        }
    }

    public void deleteAll() {
        repo.deleteAll();
    }

}
