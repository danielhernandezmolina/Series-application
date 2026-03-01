package examen_Febrero3;

class Episodio {
    // 1. Attributes
    private String titulo;
    private int duracion; // in minutes

    // 2. Constructors
    // Empty Constructor
    public Episodio() {
        this.titulo = "No title";
        this.duracion = 0;
    }

    // Parameterized Constructor
    public Episodio(String titulo, int duracion) {
        this.titulo = titulo;
        this.duracion = duracion;
    }

    // Getter for duration (needed for calculations in Serie)
    public int getDuracion() {
        return duracion;
    }
    
    public String getTitulo() {
        return titulo;
    }

    // 3. Methods
    @Override
    public String toString() {
        return "   -> Episode: " + titulo + " (" + duracion + " min)";
    }
}
