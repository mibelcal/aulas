package com.myshoppingcart.persistence;

import com.myshoppingcart.model.Producto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.is;

public class ProductosDBRepositoryTest {

    private IProductoRepository repo;

    @BeforeEach
    void sepUp() throws IOException {
        repo = new ProductoDBRepository();
    }

    @Test
    public void dadosProductos_cuandogetUserProductsUsuarioEnDB_entoncesProductos() throws Exception {
        List<Producto> productos = repo.getUserProducts(1);

        System.out.println(productos);

        assertThat(productos.size(), greaterThan(0));

    }

    @Test
    public void dadosProductos_cuandogetUserProductsUsuarioNoEnDB_entoncesVacio() throws Exception {
        List<Producto> productos = repo.getUserProducts(100);

        System.out.println(productos);

        assertThat(productos.size(), is(0));

    }

    @Test
    public void dadoUnProducto_cuandoInserto_entoncesIDvalido() throws Exception {
        Producto prod = new Producto(null, "1567", "marca", "util", 20, 100);

        repo.insertarProducto(prod);

        assertThat(prod.getMid(), greaterThan(0));
    }

    @Test
    void dadoProductoExistente_cuandoActualiza_entonces_Ok() throws Exception {
        Producto prod = repo.getProduct(11);
        prod.setCodigo("6666");

        repo.updateProducto(prod);

        assertThat(prod.getCodigo(), is("6666"));
    }
    @Test
    void dadoProducto_cuandoDelete_entonces_Ok() throws Exception {
        int id = 11;
        boolean ok = repo.deleteProducto(id);

        assertThat(ok, is(true));
    }
}
