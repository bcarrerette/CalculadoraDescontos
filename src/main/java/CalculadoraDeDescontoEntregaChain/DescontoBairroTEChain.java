package CalculadoraDeDescontoEntregaChain;

import Model.CupomDesconto;
import Model.Pedido;

public class DescontoBairroTEChain implements IDescontoEntregaChain {
    private IDescontoEntregaChain next;

    public DescontoBairroTEChain(IDescontoEntregaChain next) {
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
            if(p.getCliente().getBairro().equals("Centro")) {
                cupom = new CupomDesconto("Cupom de Bairro Centro", 0.2);
                p.getCuponsEntrega().add(cupom);
                next(p);
            }
            if(p.getCliente().getBairro().equals("Bela Vista")) {
                cupom = new CupomDesconto("Cupom de Bairro Bela Vista", 0.3);
                p.getCuponsEntrega().add(cupom);
                next(p);
            }
            if(p.getCliente().getBairro().equals("Cidade Maravilhosa")) {
                cupom = new CupomDesconto("Cupom de Bairro Cidade Maravilhosa", 0.15);
                p.getCuponsEntrega().add(cupom);
                next(p);
            }
        }
        else
            next(p);
    }

    @Override
    public boolean seAplica(Pedido p) {
        return p.getCliente().getBairro().equals("Centro") || p.getCliente().getBairro().equals("Bela Vista") ||
                p.getCliente().getBairro().equals("Cidade Maravilhosa");
    }
    
    
    
}
