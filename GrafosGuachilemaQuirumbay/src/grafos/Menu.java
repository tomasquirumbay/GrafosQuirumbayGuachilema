package grafos;
import java.util.List;
import java.util.Scanner;
public class Menu {
    int contadorVertices = 0;
    String nombre;
    public void menu(GrafoMatriz grafo) {
        Scanner sc = new Scanner(System.in);
        System.out.println("------------------------------------------------");
        System.out.println("            Menú principal de grafos        ");
        System.out.println("------------------------------------------------");
        System.out.println("Presiona 1.....................Ingresar vértices");
        System.out.println("Presiona 2.....................conectar vertices");
        System.out.println("3....Verificar si un vetice es adyacente con otro");
        System.out.println("4.....buscar todas las adyacencias de un vértice");
        System.out.println("5.....Recorrer el grafo con anchura");
        System.out.println("6.....Recorrer el grafo con profundidad");
        System.out.println("Presiona 7............................Para salir");
        int opcion = sc.nextInt();
        sc.nextLine(); // Consumimos el salto de línea después de leer el entero.
        switch (opcion) {
            case 1:
                System.out.println("------------------------------------------------");
                System.out.println("          Creación de vértices (nodos)");
                System.out.println("------------------------------------------------");
                System.out.println("Ingrese cuántos vértices va a crear:");
                int nVertices = sc.nextInt();
                sc.nextLine(); // Consumimos el salto de línea después de leer el entero.
                int totalVertices = nVertices + contadorVertices;
                if (nVertices < 1) {
                    System.out.println("Lo sentimos no puede ingresar un número negativo:");                    
                } else {
                    if (totalVertices > 20) {
                        System.out.println("Lo sentimos, la cantidad que usted ingresa sobrepasa los vértices totales permitidos");                       
                    } else {
                        for (int i = 0; i < nVertices; i++) {
                            int verticesTotales = contadorVertices + 1;
                            System.out.println("------------------------------------------------");
                            System.out.println("          Creación del grafo número " + verticesTotales);
                            System.out.println("------------------------------------------------");
                            System.out.println("Ingrese el nombre de referencia para el vértice:");
                            nombre = sc.nextLine();
                            grafo.nuevoVertice(nombre.trim());
                            System.out.println("-----------------Se creó correctamente-----------");
                            contadorVertices = contadorVertices + 1;
                        }                        
                    }
                }
                menu(grafo);
                break;
            case 2:
                int verticesTotales = contadorVertices + 1;
                System.out.println("------------------------------------------------");
                System.out.println("      Conectar vértices (" + verticesTotales + ": grafos totales)");
                System.out.println("------------------------------------------------");
                System.out.println("Ingrese el nombre del vértice a conectar:");
                String vertice1 = sc.nextLine();
                System.out.println("Ingrese el nombre del vértice a conectar con " + vertice1);
                String vertice2 = sc.nextLine();
                try {
                    grafo.nuevoArco(vertice1, vertice2);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                menu(grafo);
                break;
            case 3:
                System.out.println("------------------------------------------------");
                System.out.println("      Verificar si un vértice es adyacente");
                System.out.println("------------------------------------------------");
                System.out.println("Ingrese el nombre del vértice a verificar:");
                String vertice = sc.nextLine();
                System.out.println("Ingrese el nombre del vértice a verificar con:" + vertice);
                String verticeVerificar = sc.nextLine();
                try {
                    System.out.println(grafo.adyacente(vertice, verticeVerificar));                  
                } catch (Exception e) {
                    e.printStackTrace();
                }
                menu(grafo);
                break;
            case 4:
                System.out.println("------------------------------------------------");
                System.out.println("  Buscar todos las adyacencias de un vértice");
                System.out.println("------------------------------------------------");
                System.out.println("Ingrese el nombre del vértice a buscar sus adyacencias:");
                String verticeBuscar = sc.nextLine();
                try {
                    List<Vertice> nodosConectadosA = grafo.nodosConectados(verticeBuscar);
                    System.out.println("Nodos conectados a ("+verticeBuscar+")");
                    for (Vertice v : nodosConectadosA) {
                        System.out.println(v.nomVertice());
                    }
                }catch (Exception e) {
                    e.printStackTrace();
                }
                menu(grafo);
            	break;
            case 5:
            	System.out.println("------------------------------------------------");
                System.out.println("         Recorrer el grafo en anchura (BFS)");
                System.out.println("------------------------------------------------");
                System.out.println("Ingrese el nombre del vértice desde donde iniciar el recorrido:");
                String verticeInicio = sc.nextLine();
                try {
                    grafo.recorridoAnchura(verticeInicio);
                    System.out.println(); // Salto de línea para separar el resultado del menú
                } catch (Exception e) {
                    e.printStackTrace();
                }
                menu(grafo);
            	break;
            case 6:
                System.out.println("------------------------------------------------");
                System.out.println("       Recorrer el grafo en profundidad (DFS)");
                System.out.println("------------------------------------------------");
                System.out.println("Ingrese el nombre del vértice desde donde iniciar el recorrido:");
                String verticeInicioDFS = sc.nextLine();
                try {
                    grafo.recorridoProfundidad(verticeInicioDFS);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                menu(grafo);
            	break;
            case 7:
                System.out.println("------------------------------------------------");
                System.out.println("           Muchas gracias por su visita");
                System.out.println("------------------------------------------------");
            	break;
        }
    }
}