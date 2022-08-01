package datos;

import excepciones.ValidarNumeros;

public class ImplementacionCalculadora implements Operaciones {

    private Integer numero;

    public ImplementacionCalculadora(Integer numero) {
        this.numero = numero;
    }

    @Override
    public void logaritmo() throws ValidarNumeros {
        Double resultado;
        if(numero<=0){
            throw new ValidarNumeros("No existe logaritmo de 0 o menor");
        }
        resultado=Math.log(numero);
        System.out.println("R// ln("+numero+") = "+resultado);
    }

    @Override
    public void raizCuadrada() throws ValidarNumeros {
        Double resultado;
        if(numero<0){
            throw new ValidarNumeros("No existe raiz cuadra de numeros negativos");
        }
        resultado=Math.sqrt(numero);
        System.out.println("R// sqrt("+numero+") = "+resultado);
    }


    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

}
