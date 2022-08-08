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
		list.add(new Servico(null, "Brunch completo",
				"O brunch completo serve até 10 pessoaos com frios e queijos, diferentes tipos de pães, patês e geleias, iogurte, bolos, pão de queijo e frutas.",
				new BigDecimal("350.00")));
		list.add(new Servico(null, "Snacks", "Os snacks servem até 10 pessoas e são compostos das seguintes opções: biscoitos doces e salgados, pão de queijo e salada de frutas", new BigDecimal("100.00")));
		list.add(new Servico(null, "Água gelada", "Água gelada dísponivel para até 10 pessoas", new  BigDecimal("50.00")));
		list.add(new Servico(null, "Material de escritório", "10 blocos para anotação e canetas", new BigDecimal("100.00")));

		repo.saveAll(list);
	}

}
