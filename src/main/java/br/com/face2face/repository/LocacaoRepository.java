package br.com.face2face.repository;

import br.com.face2face.domain.Equipamento;
import br.com.face2face.domain.Locacao;
import br.com.face2face.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LocacaoRepository extends JpaRepository<Locacao, Long> {

    public List<Locacao> findAllByOrderByIdDesc();

    public Optional<List<Locacao>> findByUsuario(Usuario usuario);

}
