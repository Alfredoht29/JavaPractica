package com.prueba.Punto_de_venta.Accion;

import com.prueba.Punto_de_venta.DbConfig;

import java.sql.*;

public class Accion_Corte {

    public void corte() throws SQLException {
        double corte = 0;
        Connection connection= DbConfig.getConnection();
        Statement sql = connection.createStatement();
        ResultSet rs = sql.executeQuery("SELECT SUM(costo) as dinero from ventas where venta_date >= curdate()");
        while(rs.next()) {
            corte = rs.getDouble("dinero");
        }
        sql.close();
        rs.close();
        PreparedStatement sql2 = connection.prepareStatement("INSERT INTO Caja\n" +
                "(id_Caja,\n" +
                "dinero,\n" +
                "hora_Corte)\n" +
                "VALUES\n" +
                "(NULL,\n" +
                "?,\n" +
                "CURRENT_TIMESTAMP);");
        sql2.setDouble(1,corte);
        sql2.execute();
        sql2.close();
    }

}
