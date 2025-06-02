package ifsc.poo.atendimento;

public class Cliente {

    private final String nome; 
    private int idade;
    private String numeroTelefone;

    //Construtor 
    public Cliente(String nome, int idade, String numeroTelefone) {
        this.nome = nome;
        this.idade = idade;
        this.numeroTelefone = numeroTelefone;
    }

    //Getters
    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    public String getNumeroTelefone() {
        return numeroTelefone;
    }    

}