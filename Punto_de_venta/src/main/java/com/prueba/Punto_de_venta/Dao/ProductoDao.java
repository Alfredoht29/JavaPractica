package com.prueba.Punto_de_venta.Dao;
import com.prueba.Punto_de_venta.DbConfig;
import com.prueba.Punto_de_venta.Modelos.Producto;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProductoDao {

    public List<Producto> getInventario() throws SQLException {
        List<Producto> productosList=new ArrayList();
        Connection connection= DbConfig.getConnection();
        Statement sql = connection.createStatement();
        ResultSet rs = sql.executeQuery("SELECT * FROM inventario WHERE stock > 0");
        while (rs.next()){
            Producto producto = new Producto();
            producto.setId(rs.getInt("id_producto"));
            producto.setProducto_name(rs.getString("producto_name"));
            producto.setPrecio(rs.getDouble("precio"));
            producto.setStock(rs.getInt("stock"));
            producto.setImagen(rs.getString("imagen"));
            productosList.add(producto);
        }
        rs.close();
        return productosList;
    }
}

