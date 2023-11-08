package com.myshoppingcart.persistence;

import com.myshoppingcart.model.Compra;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.time.LocalDate;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;

public class CompraDBRepositoryTest {

    private ICompraRepository repo;

    @BeforeEach
    void sepUp() throws IOException {
        repo = new CompraDBRepository();
    }

    @Test
    public void dadaCompraValida_cuandoinsertCompra_entoncesOK() throws Exception {
        Compra compra = new Compra(null, 1, 1, 3, LocalDate.now());

        Compra ncompra = repo.insertCompra(compra);

        assertThat(ncompra.getCid(), greaterThan(1));

    }

    @Test
    public void dadaCompraNoValida_cuandoinsertCompra_entoncesExcepcion() throws Exception {

    }
}
