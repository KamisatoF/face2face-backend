package br.com.face2face.service;

import br.com.face2face.domain.Usuario;
import br.com.face2face.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CadastroService {

    @Autowired
    private UsuarioRepository repo;

    public Usuario find(Long id) {
        return repo.findById(id).orElseThrow(() -> new RuntimeException("Objeto não encontrado: " + id));
    }

    public Usuario insert(Usuario usuario) {
        normalizeUsuario(usuario);
        usuario.setId(null);

        return repo.save(usuario);
    }

    private void normalizeUsuario(Usuario usuario) {
        usuario.setRecebeInformacoesEmail(usuario.getRecebeInformacoesEmailString() != null);
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

    public Object findAll() {
        return repo.findAll();
    }
}
