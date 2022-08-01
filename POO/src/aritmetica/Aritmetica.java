package aritmetica;

public class Aritmetica {
    int a;
    int b;

    Aritmetica(){}
    Aritmetica(int a, int b){
        this.a=a;
        this.b=b;
    }

    public int Sumar(){
      return a+b;
    }
    public int Restar(){
        return a-b;
    }
    public int Multiplicar(){
        return a*b;
    }
    public int Dividir(){
        return a/b;
    }

}
