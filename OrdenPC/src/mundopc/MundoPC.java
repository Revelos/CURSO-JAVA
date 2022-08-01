package mundopc;

import com.gm.mundopc.*;

public class MundoPC {

    public static void main(String[] args) {
        Monitor monitorToshi = new Monitor("Toshiba",13);
        Teclado tecladoToshi = new Teclado("Bluetooth","Toshiba");
        Raton ratonToshiba = new Raton("Bluetooth","Toshiba");
        Computadora compuToshiba = new Computadora("Computadora Toshiba",monitorToshi,tecladoToshi,ratonToshiba);

        Monitor monitorDell = new Monitor("Dell",15);
        Teclado tecladoDell = new Teclado("USB","Dell");
        Raton ratonDell = new Raton("USB","Dell");
        Computadora compuDell = new Computadora("Computadora Dell",monitorDell,tecladoDell,ratonDell);

        Computadora compuArmada = new Computadora("Computadora Armada",monitorDell,tecladoToshi,ratonToshiba);

        Orden orden1 = new Orden();
        orden1.agregarComputadoras(compuToshiba);
        orden1.agregarComputadoras(compuDell);
        orden1.agregarComputadoras(compuArmada);

        orden1.mostrarOrden();

        Orden orden2 = new Orden();

        orden2.agregarComputadoras(compuArmada);
        orden2.agregarComputadoras(compuDell);
        System.out.println("");
        orden2.mostrarOrden();

    }

}
