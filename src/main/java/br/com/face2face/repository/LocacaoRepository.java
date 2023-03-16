package br.com.face2face.repository;

import br.com.face2face.domain.Locacao;
import br.com.face2face.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface LocacaoRepository extends JpaRepository<Locacao, Long> {

    public List<Locacao> findAllByOrderByIdDesc();

    public Optional<List<Locacao>> findByUsuarioAndDataInicioBetween(Usuario usuario, Date dataInicio, Date dataFim);

    public Optional<List<Locacao>> findByUsuarioOrderByDataInicio(Usuario usuario);
}
