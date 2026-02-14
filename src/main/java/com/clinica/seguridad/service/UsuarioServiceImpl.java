package com.clinica.seguridad.service;

import com.clinica.seguridad.model.Usuario;
import com.clinica.seguridad.model.dto.LoginInputDTO;
import com.clinica.seguridad.model.dto.RegistrarUsuarioInputDTO;
import com.clinica.seguridad.model.dto.GenericOutputDTO;
import com.clinica.seguridad.repository.UsuarioRepository;
import com.clinica.seguridad.util.BCryptUtil;
import com.clinica.seguridad.util.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UsuarioServiceImpl implements  UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final BCryptUtil bCryptUtil;

    @Override
    public GenericOutputDTO createUsuario(RegistrarUsuarioInputDTO inputDTO) {
        Usuario usuario = new Usuario();
        usuario.setNombreUsuario(inputDTO.nombreUsuario());
        usuario.setClaveUsuario(inputDTO.claveUsuario());
        usuario.setNombres(inputDTO.nombres());
        usuario.setApellidoPaterno(inputDTO.apellidoPaterno());
        usuario.setApellidoMaterno(inputDTO.apellidoMaterno());
        usuario.setDni(inputDTO.dni());
        usuario.setCorreo(inputDTO.correo());
        usuario.setClaveUsuario(bCryptUtil.encriptar(usuario.getClaveUsuario()));

        try{
            Usuario nuevo = usuarioRepository.save(usuario);
            return new GenericOutputDTO(true, "Usuario registrado correctamente", nuevo);
        }catch (Exception e){
            return  new GenericOutputDTO(false, "Error al registrar usuario", null);
        }
    }

    @Override
    public GenericOutputDTO login(LoginInputDTO inputDTO) throws Exception {
        Optional<Usuario> usuario = usuarioRepository.getUsuarioByNombreUsuario(inputDTO.nombreUsuario());
        if (usuario.isPresent()){
            if (bCryptUtil.validarPassword(inputDTO.claveUsuario(), usuario.get().getClaveUsuario())){
                return new GenericOutputDTO(true, "Login correcto", JwtUtil.generateToken(inputDTO.nombreUsuario()));
            }
        }
        return new GenericOutputDTO(false, "Verifique sus credenciales", null);
    }

    @Override
    public List<Usuario> listar() {
        return usuarioRepository.findAll();
    }
}
