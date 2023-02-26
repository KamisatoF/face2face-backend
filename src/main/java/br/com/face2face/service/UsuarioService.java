package br.com.face2face.service;

import br.com.face2face.domain.Usuario;
import br.com.face2face.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository repo;

    public Usuario findByEmail(String email) {
        return repo.findByEmail(email).get();    }
}
