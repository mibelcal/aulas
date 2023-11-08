package com.myshoppingcart.persistence;

import com.myshoppingcart.exception.UsuarioNotFoundException;
import com.myshoppingcart.model.Producto;
import com.myshoppingcart.properties.PropertyValues;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductoDBRepository implements IProductoRepository {
    private static String connUrl;

    public ProductoDBRepository() throws IOException {
        PropertyValues props = new PropertyValues();
        connUrl = props.getPropValues().getProperty("db_url");
    }

    @Override
    public Producto getProduct(Integer idp) throws Exception {
         Producto prod = null;

        try (
                Connection conn = DriverManager.getConnection(connUrl);
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM producto p WHERE p.pid='" + idp +"'");
        ) {
            if (rs.next()) {
                prod = new Producto(
                        rs.getInt("pid"),
                        rs.getString("codigo"),
                        rs.getString("marca"),
                        rs.getString("tipo"),
                        rs.getInt("precio"),
                        rs.getInt("existencias")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
            throw new Exception(e);
        }
        return prod;
    }


    @Override
    public List<Producto> getProducts() throws Exception {
        List<Producto> listADevolver = new ArrayList<>();
        String sql = "SELECT p.* FROM producto p WHERE 1";

        try (
                Connection conn = DriverManager.getConnection(connUrl);
                // ordenes sql
                PreparedStatement pstm = conn.prepareStatement(sql);
                ResultSet rs = pstm.executeQuery();
        ) {
            while (rs.next()) {
                listADevolver.add(new Producto(rs.getInt("mid"), rs.getString("codigo"), rs.getString("marca"),
                        rs.getString("tipo"), rs.getInt("precio"), rs.getInt("existencias")));
            }
        }

        return listADevolver;
    }

    @Override
    public List<Producto> getUserProducts(int uid) throws Exception {
        List<Producto> listADevolver = new ArrayList<>();
        String sql = "SELECT p.* FROM producto p INNER JOIN compra c ON c.producto=p.pid WHERE c.usuario=?";

        try (
                Connection conn = DriverManager.getConnection(connUrl);
                PreparedStatement stmt = conn.prepareStatement(sql)
        ) {
            stmt.setInt(1, uid);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                listADevolver.add(new Producto(
                        rs.getInt("pid"),
                        rs.getString("codigo"),
                        rs.getString("marca"),
                        rs.getString("tipo"),
                        rs.getInt("precio"),
                        rs.getInt("existencias")
                ));
            }
        }

        return listADevolver;
    }

    @Override
    public Producto insertarProducto(Producto prod) throws Exception {
        String sql = "INSERT INTO producto values (NULL,?,?,?,?,?)";

        try (
                Connection conn = DriverManager.getConnection(connUrl);
                PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        ) {
            //stmt.setInt(1, prod.getMid());
            stmt.setString(1, prod.getCodigo());
            stmt.setString(2, prod.getMarca());
            stmt.setString(3, prod.getTipo());
            stmt.setDouble(4, prod.getPrecio());
            stmt.setInt(5, prod.getExistencias());

            int rows = stmt.executeUpdate();

            ResultSet genKeys = stmt.getGeneratedKeys();
            if (genKeys.next()) {
                prod.setMid(genKeys.getInt(1));
            } else {
                throw new SQLException("Producto creado erroneamente!!!");
            }

        } catch (SQLException e) {
            e.printStackTrace();
            throw new Exception(e);
        }

        return prod;
    }

    @Override
    public Producto updateProducto(Producto unProd) throws Exception {
        String sql = "UPDATE producto set codigo=? WHERE pid=?";

        try (
                Connection conn = DriverManager.getConnection(connUrl);
                PreparedStatement stmt = conn.prepareStatement(sql);
        ) {
            stmt.setString(1, unProd.getCodigo());
            stmt.setInt(2, unProd.getMid());

            int rows = stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }

        return unProd;
    }

    @Override
    public boolean deleteProducto(Integer pid) throws Exception {
        String sql = "DELETE FROM producto WHERE pid=?";

        try (
                Connection conn = DriverManager.getConnection(connUrl);
                PreparedStatement stmt = conn.prepareStatement(sql);
        ) {
            stmt.setInt(1, pid);

            int rows = stmt.executeUpdate();
            System.out.println(rows);

            if(rows<=0){
                throw new UsuarioNotFoundException();
            }

        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }

        return true;
    }


}

