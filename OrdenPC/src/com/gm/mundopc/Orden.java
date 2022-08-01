package com.gm.mundopc;

public class Orden {
    private final int idOrden;
    private final Computadora[] computadoras;
    private static int contadorOrdenes;
    private int contadorComputadoras;
    private static final int maxComputadoras=10;

    public Orden(){
        this.idOrden = ++contadorOrdenes;
        computadoras = new Computadora[maxComputadoras];
    }

    public void agregarComputadoras(Computadora computadora){
        if(contadorComputadoras<maxComputadoras){
            computadoras[contadorComputadoras++]=computadora;
        }else{
            System.out.println("Se ha superado el maximo de productos: "+maxComputadoras);
        }
    }

    public void mostrarOrden(){
        System.out.println("ORDEN #"+ idOrden);
        System.out.println("Computadoras de la orden #"+ idOrden);
        for(int i=0;i<contadorComputadoras;i++){
            System.out.println(computadoras[i]);
        }
    }
}
