package examen_Febrero3;

class Serie {
    // 1. Attributes
    private static int contadorIds = 0; // Static variable for auto-increment
    private int id;
    private String titulo;
    private int numeroTemporadas;
    private int anio;
    private Episodio episodio; // Initially null

    // 2. Constructors
    // Empty Constructor
    public Serie() {
        this.id = contadorIds++; // Assign and then increment
        this.titulo = "New Series";
        this.numeroTemporadas = 1;
        this.anio = 2024;
        this.episodio = null;
    }

    // Parameterized Constructor
    public Serie(String titulo, int numeroTemporadas, int anio) {
        this.id = contadorIds++; // Assign and then increment
        this.titulo = titulo;
        this.numeroTemporadas = numeroTemporadas;
        this.anio = anio;
        this.episodio = null;
    }

    // Setter method to add an episode (needed for the menu)
    public boolean agregarEpisodio(Episodio nuevoEpisodio) {
        if (this.episodio != null) {
            System.out.println("NOTICE: This series already has an episode. Cannot add more.");
            return false;
        } else {
            this.episodio = nuevoEpisodio;
            System.out.println("Episode correctly added to the series: " + this.titulo);
            return true;
        }
    }

    // Getter for the title (to use in the menu)
    public String getTitulo() {
        return titulo;
    }

    // 3. Methods
    public void verSerie() {
        if (this.episodio == null) {
            System.out.println("This series has no episodes available.");
        } else {
            // Choice simulation (since there is only 1, that one is shown)
            System.out.println("Available episodes:");
            System.out.println("1. " + episodio.getTitulo());
            
            // We simply confirm the episode is being watched
            System.out.println(">> Watching episode: " + episodio.getTitulo());
        }
    }

    public void duracionSerie() {
        if (this.episodio == null) {
            System.out.println("This series has no episodes available.");
        } else {
            int totalMinutos = episodio.getDuracion();
            
            if (totalMinutos > 60) {
                int horas = totalMinutos / 60;
                int minutos = totalMinutos % 60;
                
                System.out.println(horas + " hours and " + minutos + " minutes.");
            } else {
            	System.out.print("Total duration: " + totalMinutos + " minutes.");
            }
        }
    }

    @Override
    public String toString() {
        String info = "ID: " + id + " | Title: " + titulo + 
                      " | Seasons: " + numeroTemporadas + " | Year: " + anio;
        if (this.episodio != null) {
            info += "\n" + this.episodio.toString();
        } else {
            info += "\n   -> No episodes registered.";
        }
        return info;
    }
}
