package herencia;

import java.util.Date;

public class Cliente extends Persona{
    private int idCliente;
    private Date fechaRegistro;
    private boolean vip;
    private static int contadorCliente;


    public Cliente(String nombre, char genero, int edad, String direccion,  Date fechaRegistro, boolean vip) {
        super(nombre, genero, edad, direccion);
        this.idCliente = ++contadorCliente;
        this.fechaRegistro = fechaRegistro;
        this.vip = vip;
    }

    @Override
    public String obtenerDetalles() {
        return super.obtenerDetalles()+" Es VIP: "+this.vip;
    }

    

    public int getIdCliente() {
        return idCliente;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public boolean isVip() {
        return vip;
    }

    public void setVip(boolean vip) {
        this.vip = vip;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Cliente{");
        sb.append("idCliente=").append(idCliente);
        sb.append(", fechaRegistro=").append(fechaRegistro);
        sb.append(", vip=").append(vip);
        sb.append(", nombre='").append(nombre).append('\'');
        sb.append(", genero=").append(genero);
        sb.append(", edad=").append(edad);
        sb.append(", direccion='").append(direccion).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
