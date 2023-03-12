package br.com.face2face.service;

import br.com.face2face.domain.ServiceResponse;
import br.com.face2face.domain.Usuario;
import br.com.face2face.repository.UsuarioRepository;
import br.com.face2face.utils.NormalizeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class CadastroService {

    private static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    @Autowired
    private UsuarioRepository repo;

    public Usuario find(Long id) {
        return repo.findById(id).orElseThrow(() -> new RuntimeException("Objeto não encontrado: " + id));
    }

    public ServiceResponse insert(Usuario usuario) {
        normalize(usuario);
        ServiceResponse serviceResponse = validate(usuario);
        if (serviceResponse != null) {
            return serviceResponse;
        }
        usuario.setId(null);
        Usuario resp = repo.save(usuario);
        return new ServiceResponse(HttpStatus.OK, "Cadastro realizado com sucesso!", resp);
    }

    private ServiceResponse validate(Usuario usuario) {
        if (usuario.getCpf().length() != 11) {
            return new ServiceResponse(HttpStatus.BAD_REQUEST, "O CPF deve ter 11 digitos!", null);
        } else if (usuario.getTelefone().length() != 11) {
            return new ServiceResponse(HttpStatus.BAD_REQUEST, "O telefone deve ter 11 digitos (considerando o DDD)!", null);
        } else if (!usuario.getEmail().contains("@")) {
            return new ServiceResponse(HttpStatus.BAD_REQUEST, "O email deve conter um @!", null);
        } else if (repo.findByEmail(usuario.getEmail()).isPresent()) {
            return new ServiceResponse(HttpStatus.BAD_REQUEST, "Email já cadastrado!", null);
        } else if (repo.findByCpf(usuario.getCpf()).isPresent()) {
            return new ServiceResponse(HttpStatus.BAD_REQUEST, "CPF já cadastrado!", null);
        }
        return null;
    }

    private void normalize(Usuario usuario) {
        usuario.setCpf(NormalizeUtils.onlyNumbers(usuario.getCpf()));
        usuario.setTelefone(NormalizeUtils.onlyNumbers(usuario.getTelefone()));
        usuario.setSenha(usuario.getSenha() != null ? encoder.encode(usuario.getSenha()) : null);
        usuario.setRecebeInformacoesEmail(usuario.getRecebeInformacoesEmailString() != null);
    }

    public Usuario update(Usuario usuario) {
        Usuario db = find(usuario.getId());
        normalize(usuario);
        if (usuario.getSenha() == null) {
            usuario.setSenha(db.getSenha());
        }

        return repo.save(usuario);
    }

    public void delete(Long id) {
        find(id);
        try {
            repo.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao excluir: " + id);
        }
    }

    public void deleteAll() {
        repo.deleteAll();
    }

    public Object findAll() {
        return repo.findAll();
    }
}
