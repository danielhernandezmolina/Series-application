package examen_Febrero3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 4. Creación Inicial
        System.out.println("--- INICIALIZANDO SISTEMA DE SERIES ---");
        // Se crean dos objetos de la clase Serie sin episodios
        Serie serie1 = new Serie("Stranger Things", 4, 2016);
        Serie serie2 = new Serie("The Office", 9, 2005);
        Serie serie3 = new Serie("The Office", 9, 2005);

        // Se muestra el número total de series creadas usando el ID de la última
        // (Como los IDs son 0 y 1, el total es 2)
        System.out.println("Series creadas iniciales: 2");
        System.out.println("---------------------------------------");

        int opcion = 0;
        do {
            System.out.println("\n------ MENÚ INTERACTIVO ------");
            System.out.println("1. Añadir episodio a una serie");
            System.out.println("2. Ver serie");
            System.out.println("3. Mostrar duración de una serie");
            System.out.println("4. Imprimir información de las series");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            
            try {
                opcion = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                opcion = -1;
            }

            switch (opcion) {
                case 1: // Añadir episodio
                    Serie sAdd = seleccionarSerie(sc, serie1, serie2);
                    if (sAdd != null) {
                        System.out.print("Introduce el título del episodio: ");
                        String tituloEp = sc.nextLine();
                        System.out.print("Introduce la duración (minutos): ");
                        int duracionEp = Integer.parseInt(sc.nextLine());
                        
                        Episodio ep = new Episodio(tituloEp, duracionEp);
                        sAdd.agregarEpisodio(ep);
                    }
                    break;

                case 2: // Ver serie
                    Serie sVer = seleccionarSerie(sc, serie1, serie2);
                    if (sVer != null) {
                        sVer.verSerie();
                    }
                    break;

                case 3: // Mostrar duración
                    Serie sDur = seleccionarSerie(sc, serie1, serie2);
                    if (sDur != null) {
                        sDur.duracionSerie();
                    }
                    break;

                case 4: // Imprimir series
                    System.out.println("\n--- LISTADO DE SERIES ---");
                    System.out.println(serie1.toString());
                    System.out.println("-------------------------");
                    System.out.println(serie2.toString());
                    break;

                case 5:
                    System.out.println("Cerrando el programa...");
                    break;

                default:
                    System.out.println("Opción no válida.");
            }

        } while (opcion != 5);

        sc.close();
    }

    // Método auxiliar para no repetir código de selección de serie
    public static Serie seleccionarSerie(Scanner sc, Serie s1, Serie s2) {
        System.out.println("¿Sobre qué serie quieres realizar la acción?");
        System.out.println("1. " + s1.getTitulo());
        System.out.println("2. " + s2.getTitulo());
        System.out.print("Elige (1 o 2): ");
        try {
            int seleccion = Integer.parseInt(sc.nextLine());
            if (seleccion == 1) return s1;
            if (seleccion == 2) return s2;
        } catch (NumberFormatException e) {
            // Error handling below
        }
        System.out.println("Selección inválida.");
        return null;
    }
}
