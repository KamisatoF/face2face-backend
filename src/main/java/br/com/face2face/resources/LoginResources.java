package br.com.face2face.resources;

import br.com.face2face.domain.Servico;
import br.com.face2face.domain.Usuario;
import br.com.face2face.service.ServicoService;
import br.com.face2face.service.UsuarioService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/login")
@Slf4j
public class LoginResources {
	
	@Autowired
	private UsuarioService usuarioService;

	@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
	public ResponseEntity<?> authenticate(@RequestBody Usuario obj) {
		Usuario usuario = usuarioService.auth(obj.getEmail(), obj.getSenha());

		if (usuario!=null)
			return ResponseEntity.ok().body(usuario);
		else
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Usuário ou senha inválidos");
	}

}
