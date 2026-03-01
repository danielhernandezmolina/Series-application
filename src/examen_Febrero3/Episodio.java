package examen_Febrero3;

class Episodio {
    // 1. Atributos
    private String titulo;
    private int duracion; // en minutos

    // 2. Constructores
    // Constructor vacío
    public Episodio() {
        this.titulo = "Sin título";
        this.duracion = 0;
    }

    // Constructor parametrizado
    public Episodio(String titulo, int duracion) {
        this.titulo = titulo;
        this.duracion = duracion;
    }

    // Getter para la duración (necesario para cálculos en Serie)
    public int getDuracion() {
        return duracion;
    }
    
    public String getTitulo() {
        return titulo;
    }

    // 3. Métodos
    @Override
    public String toString() {
        return "   -> Episodio: " + titulo + " (" + duracion + " min)";
    }
}
