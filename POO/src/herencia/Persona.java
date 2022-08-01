package herencia;

public class Persona {
    //Moodificadores de acceso
    protected  String nombre;
    protected  char genero;
    protected int edad;
    protected String direccion;

    public Persona() {
    }

    public Persona(String nombre, char genero, int edad, String direccion) {
        this.nombre = nombre;
        this.genero = genero;
        this.edad = edad;
        this.direccion = direccion;
    }

    public Persona(String nombre) {
        this.nombre = nombre;
    }

    public String obtenerDetalles(){
        return "Nombre: %s  Edad:  %d".formatted(this.nombre,this.edad);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public char getGenero() {
        return genero;
    }

    public void setGenero(char genero) {
        this.genero = genero;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Persona{");
        sb.append("nombre='").append(this.nombre).append('\'');
        sb.append(", genero=").append(this.genero);
        sb.append(", edad=").append(this.edad);
        sb.append(", direccion='").append(this.direccion).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
