package CalculadoraDeDescontoEntregaChain;

import Model.CupomDesconto;
import Model.Pedido;

public class DescontoValorPedidoTEChain implements IDescontoEntregaChain {
private IDescontoEntregaChain next;

    public DescontoValorPedidoTEChain(IDescontoEntregaChain next) {
        this.next = next;
    }
    
    @Override
    public void next(Pedido p){
        if(this.next != null)
        next.calcularDesconto(p);
    }
    @Override
    public void calcularDesconto(Pedido p) {
        CupomDesconto cupom;
        if (seAplica(p)){
            cupom = new CupomDesconto("Cupom de Valor do Pedido", 0.15);
            p.getCuponsEntrega().add(cupom);
            next(p);
        }
        else
            next(p);
    }

    @Override
    public boolean seAplica(Pedido p) {
        return (p.getValorPedido() > 2000);
    }
    
}