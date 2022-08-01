package matrices;

public class EjemploMatrices {


    public static void main(String[] args) {
        Persona[][] personas= new Persona[3][2];
        personas[0][0]=new Persona("Juan");
        personas[0][1]=new Persona("Carlos");
        personas[1][0]=new Persona("Brenda");
        personas[1][1]=new Persona("Gerardo");
        personas[2][0]=new Persona("Bryan");
        personas[2][1]=new Persona("Maria");

        String nombres[][]={{"Teresa","Cesar","William"},{"Juan","Fabiola","Johanna"},{"Juan","Fabiola","Johanna"}};

        System.out.println("");
        for(int i=0;i<personas.length;i++){
            for (int j=0;j<personas[i].length;j++){
                System.out.println("Matriz indice : "+ i +"-"+j+" : "+personas[i][j]);
            }
        }

        System.out.println("");
        for(int i=0;i<nombres.length;i++){
            for (int j=0;j<nombres[i].length;j++){
                System.out.println(personas[i][j]+"\t");
            }
            System.out.println("\n");
        }

    }
}
