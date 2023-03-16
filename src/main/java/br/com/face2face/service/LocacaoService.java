package br.com.face2face.service;

import br.com.face2face.domain.Locacao;
import br.com.face2face.domain.Usuario;
import br.com.face2face.repository.LocacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class LocacaoService {

    @Autowired
    private LocacaoRepository repo;

    public List<Locacao> find(Long id, Date dataInicio, Date dataFim) {
        Usuario usuario = new Usuario();
        usuario.setId(id);
        dataFim = getDateOnLastMillisecOfTheDay(dataFim);
        return repo.findByUsuarioAndDataInicioBetween(usuario, dataInicio, dataFim).orElseThrow(() -> new RuntimeException("Objeto não encontrado: " + id));
    }

    private Date getDateOnLastMillisecOfTheDay(Date dataFim) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(dataFim);
        calendar.add(Calendar.DAY_OF_MONTH, 1);
        calendar.add(Calendar.MILLISECOND, -1);
        return calendar.getTime();
    }

    public List<Locacao> find(Long id) {
        Usuario usuario = new Usuario();
        usuario.setId(id);
        return repo.findByUsuarioOrderByDataInicio(usuario).orElseThrow(() -> new RuntimeException("Objeto não encontrado: " + id));
    }

    public Locacao insert(Locacao locacao) {
        Usuario us = new Usuario();
        us.setId(locacao.getUserid());
        locacao.setUsuario(us);
        locacao.setId(null);
        return repo.save(locacao);
    }

    public Locacao update(Locacao locacao) {
        find(locacao.getId());
        Usuario us = new Usuario();
        us.setId(locacao.getUserid());
        locacao.setUsuario(us);
        return repo.save(locacao);
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
        return repo.findAllByOrderByIdDesc();
    }

}
