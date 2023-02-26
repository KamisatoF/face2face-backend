package br.com.face2face.resources;

import br.com.face2face.service.UsuarioService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/usuario")
@Slf4j
public class UsuarioResource {

    @Autowired
    private UsuarioService service;

    @RequestMapping(value = "/{email}", method = RequestMethod.GET)
    public ResponseEntity<?> find(@PathVariable String email) {
        return ResponseEntity.ok().body(service.findByEmail(email));
    }
}
