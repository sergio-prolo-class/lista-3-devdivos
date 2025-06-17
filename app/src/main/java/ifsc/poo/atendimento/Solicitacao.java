package ifsc.poo.atendimento;

public class Solicitacao {
    private Cliente cliente;
    private String descricao;   

    //Construtor
    public Solicitacao(Cliente cliente, String descricao) {
        this.cliente = cliente;
        this.descricao = descricao;
    }

    //Getters
    public Cliente getCliente() {
        return cliente;
    }

    public String getDescricao() {
        return descricao;
    }
    
}
