package CalculadoraDeDescontoEntregaChain;

import Model.CupomDesconto;
import Model.Pedido;

public class DescontoTipoClienteTEChain implements IDescontoEntregaChain {
    private IDescontoEntregaChain next;

    public DescontoTipoClienteTEChain(IDescontoEntregaChain next) {
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
            if(p.getCliente().getTipo().equals("Ouro")) {
                cupom = new CupomDesconto("Cupom de Cliente Ouro", 0.3);
                p.getCuponsEntrega().add(cupom);
                next(p);
            }
            if(p.getCliente().getTipo().equals("Prata")) {
                cupom = new CupomDesconto("Cupom de Cliente Prata", 0.2);
                p.getCuponsEntrega().add(cupom);
                next(p);
            }
            if(p.getCliente().getTipo().equals("Bronze")) {
                cupom = new CupomDesconto("Cupom de Cliente Bronze", 0.1);
                p.getCuponsEntrega().add(cupom);
                next(p);
            }
        }
        else
            next(p);
    }

    @Override
    public boolean seAplica(Pedido p) {
        return p.getCliente().getTipo().equals("Ouro") || p.getCliente().getTipo().equals("Prata") ||
                p.getCliente().getTipo().equals("Bronze");
    }
    
}
