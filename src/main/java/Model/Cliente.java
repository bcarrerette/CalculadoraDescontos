package Model;


public class Cliente {
    private String nome;
    private double fidelidade;
    private String logradouro;
    private String bairro;
    private String cidade;
    private String tipo;

    public Cliente(String nome, double fidelidade, String logradouro, String bairro, String cidade, String tipo) {
        this.nome = nome;
        this.fidelidade = fidelidade;
        this.logradouro = logradouro;
        this.bairro = bairro;
        this.cidade = cidade;
        this.tipo = tipo;
    }
    
    public String getTipo() {
        return tipo;
    }

    public String getNome() {
        return nome;
    }

    public double getFidelidade() {
        return fidelidade;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public String getBairro() {
        return bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setFidelidade(double fidelidade) {
        this.fidelidade = fidelidade;
    }
    
    
    
}
