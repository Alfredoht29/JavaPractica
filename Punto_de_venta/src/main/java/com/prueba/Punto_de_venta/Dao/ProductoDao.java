package com.prueba.Punto_de_venta.Dao;
import com.prueba.Punto_de_venta.DbConfig;
import com.prueba.Punto_de_venta.Modelos.Producto;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductoDao {

    public List<Producto> getInventario() throws SQLException {
        List<Producto> productosList=new ArrayList();
        Connection connection= DbConfig.getConnection();
        CallableStatement cstmt=connection.prepareCall("{call inventario()}");
        cstmt.execute();
        ResultSet rs = cstmt.getResultSet();
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

