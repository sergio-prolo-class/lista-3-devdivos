package ifsc.poo.catalogo;

public class Filme {
    private String titulo;
    private int anoLancamento;
    private String genero;

    public Filme(String titulo, int anoLancamento, String genero) {
        this.titulo = titulo;
        this.anoLancamento = anoLancamento;
        this.genero = genero;
    }

    public String getTitulo() {
        return titulo;
    }

    public int getAnoLancamento() {
        return anoLancamento;
    }
    public String getGenero() {
        return genero;
    }
}
