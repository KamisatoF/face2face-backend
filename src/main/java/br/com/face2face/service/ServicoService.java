package br.com.face2face.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.face2face.domain.Servico;
import br.com.face2face.repository.ServicoRepository;

@Service
public class ServicoService {
	
	@Autowired
	private ServicoRepository repo;
	
	public Servico find(Long id) {
		return repo.findById(id).orElseThrow(() -> new RuntimeException("Objeto não encontrado: " + id));
	}
	
	public Servico insert(Servico servico) {
		servico.setId(null);
		return repo.save(servico);
	}
	
	public Servico update(Servico servico) {
		find(servico.getId());
		return repo.save(servico);
	}
	
	public void delete(Long id) {
		find(id);
		try {
			repo.deleteById(id);
		} catch (Exception e) {
			throw new RuntimeException("Erro ao excluir: " + id);
		}
	}

	public Object findAll() {
		return repo.findAll();
	}
	
	public void deleteAll() {
		repo.deleteAll();
	}

}
