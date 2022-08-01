package ventas;

import com.gm.ventas.Orden;
import com.gm.ventas.Producto;

public class Ventas {
    public static void main(String[] args) {

        Producto producto = new Producto("Peras",25.30);
        Producto producto1 = new Producto("Manzanas",13.37);
        Orden orden = new Orden();
        orden.agregarProducto(producto);
        orden.agregarProducto(producto1);
        orden.mostrarOrden();

    }
}
