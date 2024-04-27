package com.sumativa.a.usuario.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.sumativa.a.usuario.model.Usuario;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class UsuarioRepositoryTest {
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Test
    public void crearUsuario(){
        // Arrange
        Usuario usuario = new Usuario();
        usuario.setNombreCompleto("Segundo Miranda");
        usuario.setCorreo("seg.mir@prueba.cl");
        usuario.setContrasena("456");
        usuario.setDirecciones("La pinata 4321 Pudahuel");

        //Act
        Usuario resultado = usuarioRepository.save(usuario);
        assertNotNull(resultado.getId());
        assertEquals("Segundo Miranda", resultado.getNombreCompleto());
        assertEquals("seg.mir@prueba.cl", resultado.getCorreo());
        assertEquals("456", resultado.getContrasena());
        assertEquals("La pinata 4321 Pudahuel", resultado.getDirecciones());
    }
    
}
