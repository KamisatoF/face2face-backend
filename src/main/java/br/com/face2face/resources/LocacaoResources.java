package br.com.face2face.resources;

import br.com.face2face.service.LocacaoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/locacao")
@Slf4j
public class LocacaoResources {

    @Autowired
    private LocacaoService locacaoService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> find(@PathVariable Long id, @RequestParam(value = "dataInicio") @DateTimeFormat(pattern = "yyyy-MM-dd") Date dataInicio, @RequestParam(value = "dataFim") @DateTimeFormat(pattern = "yyyy-MM-dd") Date dataFim) {
        return ResponseEntity.ok().body(locacaoService.find(id, dataInicio, dataFim));
    }

    @RequestMapping(value = "/findAll", method = RequestMethod.GET)
    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok().body(locacaoService.findAll());
    }


}
