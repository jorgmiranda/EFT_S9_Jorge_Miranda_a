package com.sumativa.a.usuario.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.sumativa.a.usuario.model.Rol;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class RolRepositoryTest {
    @Autowired
    private RolRepository rolRepository;

    @Test
    public void crearRolTest(){
        //Arrange
        Rol rol = new Rol();
        rol.setNombreRol("Administrador Regional");
        rol.setDescripcion("Usuario encargado del ver el estado regional");

        //Act
        Rol resultado = rolRepository.save(rol);

        //Assert
        assertNotNull(resultado.getId());
        assertEquals("Administrador Regional", resultado.getNombreRol());
        assertEquals("Usuario encargado del ver el estado regional", resultado.getDescripcion());

    }
}
