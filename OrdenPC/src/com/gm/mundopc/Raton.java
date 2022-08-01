package com.gm.mundopc;

public class Raton extends DispositivoEntrada{
    private final int idRaton;
    private static int contadorRatones;

    public Raton(String tipoDeEntrada, String marca) {
        super(tipoDeEntrada, marca);
        this.idRaton=++contadorRatones;
    }

    @Override
    public String toString() {
        return "Raton{" +
                "idRaton=" + idRaton +
                "} " + super.toString();
    }
}
