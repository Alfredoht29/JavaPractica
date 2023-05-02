$(document).ready(function () {
    $.ajax({
        method: "GET",
        url: "http://localhost:8080/inventario",
        dataType: "json",
        success: function (response) {
            console.log(response);
            var tablebody = $("#Inventario");
            for (var i = 0; i < response.length; i++) {
                var item = response[i];
                var row = $("<tr></tr>");
                var rowimg = $("<td></td>");
                var rowmulti = $("<td></td>");
                row.append($("<td></td>").text(item.producto_name));
                row.append($("<td></td>").text(item.precio));
                row.append(rowimg.append($("<img height=50 width=100>").attr("src", item.imagen)))
                var btnhtml="<button type=button class='btn btn-primary' onclick=Agregar("+item.precio+",'"+item.producto_name+"')>Agregar</button>";
                var agregarbtn = $(btnhtml);
                agregarbtn.click(function () {
                    $("#modalclick").trigger("click")
                })
                row.append(rowmulti.append(agregarbtn));
                tablebody.append(row);
            }
        },
        error: function (error) {
            window.alert("El servidor springboot no esta activo")
        }
    })
})
function Cancelar(){
    $("#cantidadp").val("")
    $("#costop").val("")
}
function Agregar(x,y){
    $("#precio").val(x)
    $("#producto_name").val(y)
}
sessionStorage.setItem('vendedor_id', 1);
$("#cantidadp").on("change", function () {
    var costo;
    var precio = $("#precio").val();
    var cantidad = $("#cantidadp").val();
    costo = precio * cantidad;
    $("#costop").val(costo);
})
let total_a_pagar = []
let ventas=[]
function Agregarcarrito() {
    var vendedor_id = sessionStorage.getItem('vendedor_id');
    vendedor_id = parseInt(vendedor_id)
    var costo = $("#costop").val();
    costo = parseFloat(costo);
    var producto = $("#producto_name").val();
    var cantidad = $("#cantidadp").val();
    cantidad = parseInt(cantidad);
    let venta={"vendedor_id":vendedor_id,"producto":producto,"cantidad":cantidad,"costo":costo}
    ventas.push(venta);
    total_a_pagar.push(costo);
    var carrito = $("#Carritoid");
    var row = $("<tr></tr>");
    row.append($("<td></td>").text(producto));
    row.append($("<td></td>").text(cantidad));
    row.append($("<td></td>").text(costo));
    carrito.append(row)
}
function Cobrar() {
    let total = 0;
    total_a_pagar.forEach(totales => {
        let n = parseFloat(totales);
        total += n;
    });
    $("#Modal2").trigger("click");
    $("#cobroi").val(total);
    $("#cambioi").val("");
    $("#pagoi").val("");
}
$("#pagoi").on("blur", function () {
    cobro = $("#cobroi").val();
    pago = $("#pagoi").val();
    cambio = pago - cobro;
    cambio = parseFloat(cambio).toFixed(2)
    $("#cambioi").val(cambio)
})
function Cortar(){
    $.ajax({
        type:"GET",
        url:"http://localhost:8080/corte",
        dataType:"json",
        success:function(){
            alert("corte de caja exitoso")
        }
    })
}
function Pagar() {
    var cambio = $("#cambioi").val();
    if (cambio => 0) {
        $.ajax({
            type: "POST",
            url: "http://localhost:8080/venta",
            data: JSON.stringify(ventas),
            contentType: "application/json",
            dataType: "text",
            success: function (response) {
                console.log(response)
                alert("Venta exitosa")
            },
            error: function () {
                alert("Error compra no realizada")
            }
        });
    }else{
        alert("La cuenta no se ha pagado")
    }
}