package controller;

import org.springframework.beans.factory.annotation.Autowired;
import usuarios.UsuarioRepository;

public class UsuarioController {
    @Autowired
    private UsuarioRepository usuarioRepository;
}
