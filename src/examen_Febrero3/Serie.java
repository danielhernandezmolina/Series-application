package examen_Febrero3;

class Serie {
    // 1. Atributos
    private static int contadorIds = 0; // Variable estática para autoincrementar
    private int id;
    private String titulo;
    private int numeroTemporadas;
    private int anio;
    private Episodio episodio; // Inicialmente null

    // 2. Constructores
    // Constructor vacío
    public Serie() {
        this.id = contadorIds++; // Asigna y luego incrementa
        this.titulo = "Serie Nueva";
        this.numeroTemporadas = 1;
        this.anio = 2024;
        this.episodio = null;
    }

    // Constructor parametrizado
    public Serie(String titulo, int numeroTemporadas, int anio) {
        this.id = contadorIds++; // Asigna y luego incrementa
        this.titulo = titulo;
        this.numeroTemporadas = numeroTemporadas;
        this.anio = anio;
        this.episodio = null;
    }

    // Método setter para añadir episodio (necesario para el menú)
    public boolean agregarEpisodio(Episodio nuevoEpisodio) {
        if (this.episodio != null) {
            System.out.println("AVISO: Esta serie ya tiene un episodio. No es posible añadir más.");
            return false;
        } else {
            this.episodio = nuevoEpisodio;
            System.out.println("Episodio añadido correctamente a la serie " + this.titulo);
            return true;
        }
    }

    // Getter para el título (para usar en el menú)
    public String getTitulo() {
        return titulo;
    }

    // 3. Métodos
    public void verSerie() {
        if (this.episodio == null) {
            System.out.println("Esta serie no tiene episodios disponibles.");
        } else {
            // Simulación de elección (al solo haber 1, se muestra ese)
            System.out.println("Episodios disponibles:");
            System.out.println("1. " + episodio.getTitulo());
            
            // Simplemente confirmamos que se ve el episodio
            System.out.println(">> Viendo episodio: " + episodio.getTitulo());
        }
    }

    public void duracionSerie() {
        if (this.episodio == null) {
            System.out.println("Esta serie no tiene episodios disponibles.");
        } else {
            int totalMinutos = episodio.getDuracion();
            
            
            if (totalMinutos > 60) {
                int horas = totalMinutos / 60;
                int minutos = totalMinutos % 60;
                
                System.out.println(horas + " horas y " + minutos + " minutos.");
            } else {
            	System.out.print("Duración total de '" + totalMinutos + " minutos.");
            }
        }
    }

    @Override
    public String toString() {
        String info = "ID: " + id + " | Título: " + titulo + 
                      " | Temp: " + numeroTemporadas + " | Año: " + anio;
        if (this.episodio != null) {
            info += "\n" + this.episodio.toString();
        } else {
            info += "\n   -> Sin episodios registrados.";
        }
        return info;
    }
}
