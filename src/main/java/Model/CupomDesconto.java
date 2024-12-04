package Model;


public class CupomDesconto {
    private String nomeMetodo;
    private double valorDesconto;

    public CupomDesconto(String nomeMetodo, double valorDesconto) {
        this.nomeMetodo = nomeMetodo;
        this.valorDesconto = valorDesconto;
    }

    public String getNomeMetodo() {
        return nomeMetodo;
    }

    public double getValorDesconto() {
        return valorDesconto;
    }

    
    
}
