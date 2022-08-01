package manejocolecciones;

import java.util.*;

public class ColeccionesGenericas{
        public static void main(String[] args) {
            List<String> miLista = new ArrayList<>();
            miLista.add("1");
            miLista.add("2");
            miLista.add("3");
            miLista.add("4");

            imprimir(miLista);

            Set<String> miSet = new HashSet<>();
            miSet.add("100");
            miSet.add("200");
            miSet.add("300");
            miSet.add("400");
            miSet.add("500");

            imprimir(miSet);

            Map<String,String> mimap = new HashMap<>();
            mimap.put("1","Juan");
            mimap.put("2","Carlos");
            mimap.put("3","Rosario");
            mimap.put("4","Esperanza");
            mimap.put("5","Cristian");

            imprimir(mimap.keySet());

            imprimir(mimap.values());

        }

        public  static  void imprimir(Collection<String> coleccion){
            for (Object elemento:
                    coleccion) {
                System.out.print(elemento + "  ");
            }
            System.out.println(" ");
        }
}