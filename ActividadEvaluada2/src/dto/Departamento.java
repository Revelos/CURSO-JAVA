package dto;

public class Departamento {
    private Long id;
    private String departamento;

    public Departamento() {
    }

    public Departamento(Long id, String departamento) {
        this.id = id;
        this.departamento = departamento;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    @Override
    public String toString() {
        return "Departamento{" +
                "id=" + id +
                ", departamento='" + departamento + '\'' +
                '}';
    }
}
