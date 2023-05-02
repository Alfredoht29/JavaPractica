package com.prueba.Punto_de_venta.Accion;

import com.prueba.Punto_de_venta.DbConfig;
import com.prueba.Punto_de_venta.Modelos.Venta;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class Accion_Venta {
    public void venta(List<Venta>ventaList) throws SQLException {
        Connection connection= DbConfig.getConnection();
        StringBuilder qry= new StringBuilder();
        int vendedor_id;
        String producto;
        int cantidad;
        double costo;
        qry.append("INSERT INTO Ventas\n" +
                "(id_venta, \n" +
                "vendedor_id, \n" +
                "producto, \n" +
                "cantidad, \n" +
                "costo, \n" +
                "venta_date) \n" +
                "VALUES \n" +
                "(NULL, \n" +
                "?, \n" +
                "?, \n" +
                "?, \n" +
                "?, \n" +
                "CURRENT_TIMESTAMP)\n");
        PreparedStatement ps = connection.prepareStatement(qry.toString());
        for(Venta venta:ventaList){
            vendedor_id=venta.getVendedor_id();
            producto=venta.getProducto();
            cantidad=venta.getCantidad();
            costo=venta.getCosto();
            ps.setInt(1,vendedor_id);
            ps.setString(2,producto);
            ps.setInt(3,cantidad);
            ps.setDouble(4,costo);
            ps.addBatch();
        }
        ps.executeBatch();
        ps.close();
    }
}
