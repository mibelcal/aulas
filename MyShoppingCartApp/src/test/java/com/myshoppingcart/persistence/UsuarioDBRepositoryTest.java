package com.myshoppingcart.persistence;

import com.myshoppingcart.exception.UsuarioNotFoundException;
import com.myshoppingcart.model.Usuario;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class UsuarioDBRepositoryTest {

    private IUsuarioRepository repo;

    @BeforeEach
    void setUp() throws Exception {
//        repo = new UsuarioInMemoryRepository();
        repo = new UsuarioDBRepository();
    }

    @Test
    void dadosUsuarios_cuandoExisteUsuarioEnDB_entoncesOK() throws Exception {
        boolean existe = repo.existeUsuario("juana@e.com", "juanason_1");
        assertThat(existe, is(true));
    }

    @Test
    void dadosUsuarios_cuandoExisteUsuarioNoEnDB_entoncesNOK() throws Exception {
        boolean existe = repo.existeUsuario("xxxx@e.com", "xxxx");
        assertThat(existe, is(false));
    }

    @Test
    void dadosUsuarios_cuandogetUsuarioEnDB_entoncesUsuario() throws Exception {
        Usuario usuario = repo.getUsuario("juana@e.com", "juanason_1");

        System.out.println(usuario);

        assertThat(usuario.getEmail(), is("juana@e.com"));

    }

    @Test
    void dadosUsuarios_cuandogetUsuariosEnDB_entoncesUsuarios() throws Exception {
        List<Usuario> usuarios = repo.getUsuarios("a");

        System.out.println(usuarios);

        assertThat(usuarios.size(), greaterThan(0));

    }

    @Test
    void dadosUsuarios_cuandogetUsuarioNoEnDB_entoncesExcepcion() {

        assertThrows(UsuarioNotFoundException.class, () -> {
            Usuario usuario = repo.getUsuario("xxxx@e.com", "xxxx");
        });

    }

    @Test
    void dadosUsuario_cuandoinsertarUsuarioEnDB_entoncesIdValido() throws Exception {
        Usuario user = new Usuario(null, "nuevo", "usuario",
                "n@n.com", 10, 0, "xxxx", LocalDate.of(2005, 02, 01), true);

        repo.insertUsuario(user);

        System.out.println(user);

        assertThat(user.getUid(), greaterThan(0));
    }

    @Test
    void dadoUsuarioExistente_cuandoActualiza_entonces_Ok() throws Exception {
        Usuario user = repo.getUsuario("juana@e.com", "juanason_1");
        user.setApellido("Juanez");
        user.setInteres(2);

        repo.updateUsuario(user);

        assertThat(user.getApellido(), is("Juanez"));
    }

    @Test
    void dadoUsuarioNoExistente_cuandoActualiza_entonces_Excepccion() throws Exception {
        Usuario user = new Usuario(null, "nuevo", "usuario", "n@n.com", 10, 0, "xxxx", LocalDate.of(2005, 02, 01), true);
        user.setApellido("Apellido nuevo");
        user.setInteres(2);

        assertThrows(Exception.class, () -> {
            repo.updateUsuario(user);
        });

    }

    @Test
    void dadoUsuario_cuandoDelete_entonces_Ok() throws Exception {
        int id = 11;
        boolean ok = repo.deleteUsuario(id);

        assertThat(ok, is(true));
    }

    @Test
    void dadoUsuario_cuandoupdateUsuarioEnDB_entoncesIdValido() throws Exception {
        Usuario user = repo.getUsuario("n@n.com", "xxxx");
        System.out.println("Usuario a modificar:"+user);

        user.setNombre("modificado1");

        repo.updateUsuario(user);

        System.out.println("Usuario modificado:"+user);

        assertThat(user.getUid(), is(11));
    }

    @Test
    void dadoUsuario_cuandodeleteUsuarioEnDB_entoncesIdValido() throws Exception {
//        Usuario user = repo.getUsuario("n@n.com", "xxxx");
//        System.out.println("Usuario a borrar:"+user);

        boolean result = repo.deleteUsuario(11);

        assertThat(result, is(true));
    }

}