package br.com.face2face.utils;

import br.com.face2face.domain.Servico;
import br.com.face2face.domain.Usuario;
import br.com.face2face.repository.ServicoRepository;
import br.com.face2face.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.xml.bind.DatatypeConverter;
import java.math.BigDecimal;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

@Service
public class GenerateFakeData {

    private static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    @Autowired
    ServicoRepository repo;

    @Autowired
    UsuarioRepository usuarioRepository;

    @PostConstruct
    public void setUp() {
        createFakeServico();
        createFakeUser();
    }

    private void createFakeUser() {
        List<Usuario> list = new ArrayList<>();
        list.add(new Usuario(null, "Fabio Kamisato", "35346199519", "fabiokamisato@gmail.com", "(11) 97579-2503", encoder.encode("Blue#99"), false, null));
        list.add(new Usuario(null, "Thais Cavenago", "45283775860", "thaiscavenago@gmail.com", "(14) 97579-2502", encoder.encode("Blue#00"), true, "on"));
        list.add(new Usuario(null, "teste", "15283771860", "a@a", "(14) 97579-2502", encoder.encode("a"), true, "on"));

        usuarioRepository.deleteAll();
        usuarioRepository.saveAll(list);
    }

    private void createFakeServico() {
        List<Servico> list = new ArrayList<>();
        list.add(new Servico(null, "Brunch completo",
                "O brunch completo serve até 10 pessoaos com frios e queijos, diferentes tipos de pães, patês e geleias, iogurte, bolos, pão de queijo e frutas.",
                new BigDecimal("350.00")));
        list.add(new Servico(null, "Snacks", "Os snacks servem até 10 pessoas e são compostos das seguintes opções: biscoitos doces e salgados, pão de queijo e salada de frutas", new BigDecimal("100.00")));
        list.add(new Servico(null, "Água gelada", "Água gelada dísponivel para até 10 pessoas", new BigDecimal("50.00")));
        list.add(new Servico(null, "Material de escritório", "10 blocos para anotação e canetas", new BigDecimal("100.00")));
        list.add(new Servico(null, "Café", "Café dísponivel durante todo o tempo da reunião.", new BigDecimal("70.00")));
        list.add(new Servico(null, "Suporte Audiovisual", "Um especialista para ajudar com sua apresentação, ajustando a projeção, som, entre outros items.", new BigDecimal("70.00")));

        repo.deleteAll();
        repo.saveAll(list);
    }
}
