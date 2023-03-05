package br.com.face2face.service;

import br.com.face2face.domain.Usuario;
import br.com.face2face.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class CadastroService {

    private static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    @Autowired
    private UsuarioRepository repo;

    public Usuario find(Long id) {
        return repo.findById(id).orElseThrow(() -> new RuntimeException("Objeto não encontrado: " + id));
    }

    public Usuario insert(Usuario usuario) {
        normalize(usuario);
        usuario.setId(null);

        return repo.save(usuario);
    }

    private void normalize(Usuario usuario) {
        usuario.setSenha(encoder.encode(usuario.getSenha()));
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
