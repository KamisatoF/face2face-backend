package br.com.face2face.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.face2face.domain.Servico;

@Repository
public interface ServicoRepository extends JpaRepository<Servico, Long> {

}