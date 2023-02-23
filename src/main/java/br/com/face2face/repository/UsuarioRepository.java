package br.com.face2face.repository;

import br.com.face2face.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    public Usuario findByEmailAndSenha(String email, String senha);

}
