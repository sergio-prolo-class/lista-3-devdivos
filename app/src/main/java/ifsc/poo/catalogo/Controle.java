package ifsc.poo.catalogo;

import java.util.List;
import java.util.Scanner;

public class Controle {

    private Catalogo catalogo;

    public Controle() {
        this.catalogo = new Catalogo();
    }
    public void executar(){
        Scanner scanner = new Scanner(System.in);
        int opcao;


        do {
            System.out.println("\n----- Catálogo de Filmes -----\n");
            System.out.println("1 - Adicionar Filme");
            System.out.println("2 - Remover Filme");
            System.out.println("3 - Listar Filmes por título");
            System.out.println("4 - Listar Filmes por gênero");
            System.out.println("5 - Listar Filmes por ano de lançamento");
            System.out.println("6 - Listar Filmes por um ano específico");
            System.out.println("0 - Sair");
            System.out.println("\nSelecione uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.println("Título: ");
                    String titulo = scanner.nextLine();
                    System.out.println("Ano de lançamento: ");
                    int ano = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Genero: ");
                    String genero = scanner.nextLine();

                    Filme novoFilme = new Filme(titulo, ano, genero);
                    boolean adicionado = catalogo.adicionarFilme(novoFilme);
                    if (adicionado) {
                        System.out.println("Filme adicionado com sucesso!");
                    } else {
                        System.out.println("Filme já existe no catálogo!");
                    }
                    break;

                case 2:
                    System.out.println("Digite o título do filme a ser removido");
                    String tituloRemover = scanner.nextLine();
                    if(catalogo.removerFilme(tituloRemover)) {
                        System.out.println("Filme removidado com sucesso!");
                    } else {
                        System.out.println("Erro ao remover filme!");
                    }
                    break;

                case 3:
                    System.out.println("\n === Filmes por Título ===");
                    exibirFilmes(catalogo.listarFilmesPorTitulo());
                    break;

                case 4:
                    System.out.println("\n === Filmes por Gênero ===");
                    exibirFilmes(catalogo.listarFilmesPorGenero());
                    break;

                case 5:
                    System.out.println("\n === Filmes por Ano de Lançamento ===");
                    exibirFilmes(catalogo.listarFilmesPorAno());
                    break;

                case 6:
                    System.out.println("Insira o ano: ");
                    int anoBusca = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("\n === Filmes lançados em " + anoBusca + " ===");
                    exibirFilmes(catalogo.getTodosFilmes().stream().filter(f -> f.getAnoLancamento() == anoBusca).toList());
                    break;

                case 0:
                    System.out.println("Encerrando o programa.");
                    break;

                default:
                    System.out.println("Opção invalida! Tente novamente.");

            }
        } while (opcao != 0);
        scanner.close();
    }

    private static void exibirFilmes(List<Filme> filmes) {
        if(filmes.isEmpty()){
            System.out.println("Nenhum filme encontrado!");
        } else {
            for (Filme filme : filmes) {
                System.out.printf("Título: %s | Ano: %d | Gênero %s\n", filme.getTitulo(), filme.getAnoLancamento(), filme.getGenero());
            }
        }

    }
}
