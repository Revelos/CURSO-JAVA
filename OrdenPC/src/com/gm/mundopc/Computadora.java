package com.gm.mundopc;

public class Computadora {
    private int idComputadora;
    private String nombre;
    private Teclado teclado;
    private Monitor monitor;
    private Raton raton;
    private static int contadorComputadora;

    private Computadora(){
        idComputadora=++contadorComputadora;
    }

    public Computadora(String nombre, Monitor monitor, Teclado teclado, Raton raton){
        this();
        this.nombre=nombre;
        this.monitor=monitor;
        this.teclado=teclado;
        this.raton=raton;
    }


    @Override
    public String toString() {
        return "Computadora{" +
                "idComputadora=" + idComputadora +
                ", nombre='" + nombre + '\'' +
                ", teclado=" + teclado +
                ", monitor=" + monitor +
                ", raton=" + raton +
                '}';
    }

    public int getIdComputadora() {
        return idComputadora;
    }

    public void setIdComputadora(int idComputadora) {
        this.idComputadora = idComputadora;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Teclado getTeclado() {
        return teclado;
    }

    public void setTeclado(Teclado teclado) {
        this.teclado = teclado;
    }

    public Monitor getMonitor() {
        return monitor;
    }

    public void setMonitor(Monitor monitor) {
        this.monitor = monitor;
    }

    public Raton getRaton() {
        return raton;
    }

    public void setRaton(Raton raton) {
        this.raton = raton;
    }


}
