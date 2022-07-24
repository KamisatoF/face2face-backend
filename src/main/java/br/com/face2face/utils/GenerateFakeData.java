package br.com.face2face.utils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.face2face.domain.Servico;
import br.com.face2face.repository.ServicoRepository;

@Service
public class GenerateFakeData {
	
	@Autowired
	ServicoRepository repo;
	
	@PostConstruct
	public void setUp() {
		List<Servico> list = new ArrayList<>();
		list.add(new Servico(null, "nom1", "det1", BigDecimal.TEN));
		list.add(new Servico(null, "nom2", "det2", BigDecimal.TEN));
		list.add(new Servico(null, "nom3", "det3", BigDecimal.TEN));
		list.add(new Servico(null, "nom4", "det4", BigDecimal.TEN));
		
		repo.saveAll(list);
	}

}
