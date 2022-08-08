package br.com.face2face.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.face2face.domain.Servico;

@Repository
public interface ServicoRepository extends JpaRepository<Servico, Long> {

	public List<Servico> findAllByOrderByIdDesc();
	
}
