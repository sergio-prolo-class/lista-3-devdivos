package ifsc.poo.catalogo;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Catalogo {

    private ArrayList<Filme> filmes;

    public Catalogo() {
        this.filmes = new ArrayList<>();
    }


public boolean adicionarFilme(Filme filme) {
    for (Filme f : filmes) { //verifica se existe um filme igual no catalogo
        if (f.getTitulo().equalsIgnoreCase(filme.getTitulo()) &&
                f.getAnoLancamento() == filme.getAnoLancamento() &&
                f.getGenero().equalsIgnoreCase(filme.getGenero())) {
            return false;
        }
    }
    filmes.add(filme); //adiciona o filme
    return true;
}


    public boolean removerFilme(String titulo) {
        return this.filmes.removeIf(filme -> filme.getTitulo().equalsIgnoreCase(titulo));
    } //aqui remove um filme do catálogo com base no título

    public List<Filme> listarFilmesPorTitulo() {
        return this.filmes.stream()
                .sorted(Comparator.comparing(Filme::getTitulo, String.CASE_INSENSITIVE_ORDER))
                .collect(Collectors.toList());
    } //retora uma lista de filmes ordenada por titulos

    public List<Filme> listarFilmesPorGenero() {
        return this.filmes.stream()
                .sorted(Comparator.comparing(Filme::getGenero, String.CASE_INSENSITIVE_ORDER)
                        .thenComparing(Filme::getTitulo, String.CASE_INSENSITIVE_ORDER))
                .collect(Collectors.toList());
    } // retorna uma lista ordenda por generos

    public List<Filme> listarFilmesPorAno() {
        return this.filmes.stream()
                .sorted(Comparator.comparingInt(Filme::getAnoLancamento)
                        .thenComparing(Filme::getTitulo, String.CASE_INSENSITIVE_ORDER))
                .collect(Collectors.toList());
    } // retorna a lista ordenada por ordem de ano de lancamento

    public List<Filme> getTodosFilmes() {
        return new ArrayList<>(this.filmes); // Retorna cópia para evitar modificação externa
    }
}