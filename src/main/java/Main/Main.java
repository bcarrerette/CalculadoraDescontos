package Main;
import Model.*;
import Services.*;
import java.io.IOException;
import java.time.LocalDate;

public class Main {

    
    public static void main (String args[]) throws IOException{
    try {
    LocalDate hora = LocalDate.now();
    Item item1 = new Item("Diploma", 1, 500, "Educação");
    Cliente c1 = new Cliente("José", 0, "tanto faz", "Centro", "Alegre", "Bronze");
    Pedido p1 = new Pedido(100, hora, c1);
    DescontoTEChainService chain = new DescontoTEChainService();
    DescontoVTChainService chain2 = new DescontoVTChainService();
    
    //p1.setCodigoDeCupom("DESC30");
    p1.setJSONLogger();
    p1.adicionarItem(item1);
    chain.calcularDescontosEntrega(p1);
    chain2.calcularDescontosValorTotal(p1);

    p1.aplicarDescontos();
    
    System.out.println(p1.getValorPedidoTotal());
    p1.teste();
    
    }
    catch (IOException e) {
           throw new IOException("Erro ao salvar arquivo");
        }}
}
