package com.prueba.Punto_de_venta.Controllers;

import com.prueba.Punto_de_venta.Accion.Accion_Corte;
import com.prueba.Punto_de_venta.Accion.Accion_Venta;
import com.prueba.Punto_de_venta.Dao.ProductoDao;
import com.prueba.Punto_de_venta.Modelos.Producto;
import com.prueba.Punto_de_venta.Modelos.Venta;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.util.List;
@RestController
public class PuntodeVentaController {

    @GetMapping("inventario")
    public List<Producto> inventario() throws SQLException {
        ProductoDao dao = new ProductoDao();
        List<Producto>inventario=dao.getInventario();
        return inventario;
    }
    @PostMapping(value = "venta",consumes = {"application/json"})
    public String venta(@RequestBody List<Venta> ventas) throws SQLException{
       Accion_Venta accion_venta = new Accion_Venta();
        accion_venta.venta(ventas);
        return "ok";
    }
    @GetMapping("corte")
    public String corte_de_caja()throws SQLException{
        Accion_Corte corte = new Accion_Corte();
        corte.corte();
        return "ok";
    }

}
