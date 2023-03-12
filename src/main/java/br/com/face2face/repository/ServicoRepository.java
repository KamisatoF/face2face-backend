package br.com.face2face.repository;

import br.com.face2face.domain.Servico;
import br.com.face2face.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ServicoRepository extends JpaRepository<Servico, Long> {

    public List<Servico> findAllByOrderByIdDesc();

    public Optional<List<Servico>> findByUsuario(Usuario usuario);

}
