package herencia;

public class Empleado extends Persona{
    private int idEmpleado;
    private double sueldo;
    public static int contadorEmpleado;

    public Empleado(String nombre, double sueldo) {
        super(nombre);
        this.idEmpleado = ++contadorEmpleado;
        this.sueldo = sueldo;
    }

    @Override
    public String obtenerDetalles() {
        return super.obtenerDetalles()+" Sueldo: "+this.sueldo;
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Empleado{");
        sb.append("idEmpleado=").append(idEmpleado);
        sb.append(", sueldo=").append(sueldo);
        sb.append(",").append(super.toString()).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
