package examen_Febrero3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 4. Initial Creation
        System.out.println("--- INITIALIZING SERIES SYSTEM ---");
        // Two Series objects are created without episodes
        Serie serie1 = new Serie("Stranger Things", 4, 2016);
        Serie serie2 = new Serie("The Office", 9, 2005);
        Serie serie3 = new Serie("The Office", 9, 2005);

        // Shows the total number of series created using the ID of the last one
        // (Since IDs are 0 and 1, the total is 2)
        System.out.println("Initial series created: 2");
        System.out.println("---------------------------------------");

        int opcion = 0;
        do {
            System.out.println("\n------ INTERACTIVE MENU ------");
            System.out.println("1. Add episode to a series");
            System.out.println("2. View series");
            System.out.println("3. Show series duration");
            System.out.println("4. Print series information");
            System.out.println("5. Exit");
            System.out.print("Select an option: ");
            
            try {
                opcion = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                opcion = -1;
            }

            switch (opcion) {
                case 1: // Add episode
                    Serie sAdd = seleccionarSerie(sc, serie1, serie2);
                    if (sAdd != null) {
                        System.out.print("Enter episode title: ");
                        String tituloEp = sc.nextLine();
                        System.out.print("Enter duration (minutes): ");
                        int duracionEp = Integer.parseInt(sc.nextLine());
                        
                        Episodio ep = new Episodio(tituloEp, duracionEp);
                        sAdd.agregarEpisodio(ep);
                    }
                    break;

                case 2: // View series
                    Serie sVer = seleccionarSerie(sc, serie1, serie2);
                    if (sVer != null) {
                        sVer.verSerie();
                    }
                    break;

                case 3: // Show duration
                    Serie sDur = seleccionarSerie(sc, serie1, serie2);
                    if (sDur != null) {
                        sDur.duracionSerie();
                    }
                    break;

                case 4: // Print series
                    System.out.println("\n--- SERIES LIST ---");
                    System.out.println(serie1.toString());
                    System.out.println("-------------------------");
                    System.out.println(serie2.toString());
                    break;

                case 5:
                    System.out.println("Closing program...");
                    break;

                default:
                    System.out.println("Invalid option.");
            }

        } while (opcion != 5);

        sc.close();
    }

    // Helper method to avoid repeating series selection code
    public static Serie seleccionarSerie(Scanner sc, Serie s1, Serie s2) {
        System.out.println("Which series do you want to perform the action on?");
        System.out.println("1. " + s1.getTitulo());
        System.out.println("2. " + s2.getTitulo());
        System.out.print("Choose (1 or 2): ");
        try {
            int seleccion = Integer.parseInt(sc.nextLine());
            if (seleccion == 1) return s1;
            if (seleccion == 2) return s2;
        } catch (NumberFormatException e) {
            // Error handling below
        }
        System.out.println("Invalid selection.");
        return null;
    }
}
