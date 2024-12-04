package Model;


public class Item {
    private String nome;
    private double quant;
    private double valorUnit;
    private String tipo;
    private double valorTotal;

    public Item(String nome, double quant, double valorUnit, String tipo) {
        this.nome = nome;
        this.quant = quant;
        this.valorUnit = valorUnit;
        this.tipo = tipo;
    }
    
    public double getValorTotal() {
        valorTotal = this.valorUnit * this.quant;
        return valorTotal;
    }

    public String getTipo() {
        return tipo;
    }

    public String getNome() {
        return nome;
    }

    public double getQuant() {
        return quant;
    }

    public double getValorUnit() {
        return valorUnit;
    }
    
    
    
}
