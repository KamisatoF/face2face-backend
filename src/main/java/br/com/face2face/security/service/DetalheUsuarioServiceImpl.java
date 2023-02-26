package br.com.face2face.security.service;

import br.com.face2face.domain.Usuario;
import br.com.face2face.repository.UsuarioRepository;
import br.com.face2face.security.data.DetalhesUsuario;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class DetalheUsuarioServiceImpl implements UserDetailsService {
    private final UsuarioRepository repo;

    public DetalheUsuarioServiceImpl(UsuarioRepository repo) {
        this.repo = repo;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Usuario> usuario = repo.findByEmail(username);
        if (usuario.isEmpty()) {
            throw new UsernameNotFoundException("Usuario " + username + " não encontrado!");
        }

        return new DetalhesUsuario(usuario);
    }
}
