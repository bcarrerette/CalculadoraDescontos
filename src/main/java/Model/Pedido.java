package Model;

import Services.UsuarioLogadoService;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import Logger.*;
import java.io.IOException;

public class Pedido {
    private ILog logger;
    private double taxaEntrega;
    private LocalDate dataPedido;
    private Cliente cliente;
    private String codigoDeCupom = "nenhum";
    private double valorPedido = 0;
    private ArrayList<CupomDesconto> cuponsEntrega = new ArrayList<>();
    private ArrayList<CupomDesconto> cuponsValorTotal = new ArrayList<>();
    private final List<Item> itens = new ArrayList<>();
    

    public Pedido(double taxaEntrega, LocalDate dataPedido, Cliente cliente) {
        if (taxaEntrega < 0 || dataPedido == null || cliente == null) {
            throw new IllegalArgumentException("Valores inválidos para criar o pedido.");
        }

        this.taxaEntrega = taxaEntrega;
        this.dataPedido = dataPedido;
        this.cliente = cliente;

    }
    
    public void setXMLLogger(){
        logger = new LogXML();
    }
    
    public void setJSONLogger(){
        logger = new LogJSON();
    }
    
    
    public void adicionarItem(Item item) {
        itens.add(item);
        calcularValorPedido();
    }

    private void calcularValorPedido(){
        valorPedido = 0;
        for (Item item : itens) {
            valorPedido += item.getValorTotal();
        }
    }
    
    public double getValorPedidoTotal() {
        return valorPedido + taxaEntrega;
    }

    public void setCodigoDeCupom(String codigoDeCupom) {
        this.codigoDeCupom = codigoDeCupom;
    }
    
    public double calcularValorPedidoSemDesconto() throws IOException{
        double valor = 0;
        logger.gravarLog(getCliente().getNome(), UsuarioLogadoService.getNomeUsuario(), "2",
                "Calculo de Valor Total sem descontos");
        calcularValorPedido();
        valor = valorPedido + taxaEntrega;
        return valor;
    }
    
    private void aplicarDescontoValorTotal(){
        double descontoValorTotal = 0;
        calcularValorPedido();
        for (CupomDesconto cupom : cuponsValorTotal){
            descontoValorTotal += cupom.getValorDesconto();
        }
        if (descontoValorTotal >= 1)
            descontoValorTotal = 1;
        
        valorPedido = valorPedido*(1.0 - descontoValorTotal);
               
    }
    
    private void aplicarDescontoTaxaDeEntrega(){
        double descontoEntrega = 0;
        for (CupomDesconto cupom : cuponsEntrega){
            descontoEntrega += cupom.getValorDesconto();
        }
        if (descontoEntrega >= 1)
            descontoEntrega = 1;
        
        taxaEntrega = taxaEntrega*(1.0 - descontoEntrega);
    }
    
    public void aplicarDescontos() throws IOException {
        logger.gravarLog(getCliente().getNome(), UsuarioLogadoService.getNomeUsuario(), "1",
                "Calculo de Valor Total com descontos");
        aplicarDescontoTaxaDeEntrega();
        aplicarDescontoValorTotal();
    }

    public Cliente getCliente() {
        return cliente;
    }

    public List<Item> getItens() {
        return Collections.unmodifiableList(itens);
    }

    public double getTaxaEntrega() {
        return taxaEntrega;
    }

    public LocalDate getDataPedido() {
        return dataPedido;
    }

    public ArrayList<CupomDesconto> getCuponsEntrega() {
        return cuponsEntrega;
    }
    
    public void teste(){
        for (CupomDesconto cupons : cuponsEntrega){
            System.out.println(cupons.getNomeMetodo() + " " + cupons.getValorDesconto());
        }
        System.out.println("Valor da taxa de entrega" + this.taxaEntrega);
        System.out.println("Valor do pedido após descontos " + this.valorPedido);
    
    }

    public ArrayList<CupomDesconto> getCuponsValorTotal() {
        return cuponsValorTotal;
    }

    public String getCodigoDeCupom() {
        return codigoDeCupom;
    }

    public double getValorPedido() {
        return valorPedido;
    }
    
    

    @Override
    public String toString() {
        return "Pedido{" + "taxaEntrega=" + taxaEntrega + ", cliente=" + cliente + ", itens=" + itens + '}';
    }
}
