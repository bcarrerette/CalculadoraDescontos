package CalculadoraDeDescontoValorTotalChain;

import Model.CupomDesconto;
import Model.Pedido;

public class DescontoTipoCodigoVTChain implements IDescontoValorTotalChain{
    private IDescontoValorTotalChain next;

    public DescontoTipoCodigoVTChain(IDescontoValorTotalChain next) {
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
            if(p.getCodigoDeCupom().equals("DESC30")) {
                cupom = new CupomDesconto("Cupom de Código DESC30", 0.3);
                p.getCuponsValorTotal().add(cupom);
                next(p);
            }
            if(p.getCodigoDeCupom().equals("DESC20")) {
                cupom = new CupomDesconto("Cupom de Código DESC20", 0.2);
                p.getCuponsValorTotal().add(cupom);
                next(p);
            }
            if(p.getCodigoDeCupom().equals("DESC10")) {
                cupom = new CupomDesconto("Cupom de Código DESC10", 0.1);
                p.getCuponsValorTotal().add(cupom);
                next(p);
            }
        }
        else
            next(p);
    }
    
    
    @Override
    public boolean seAplica(Pedido p) {
        return p.getCodigoDeCupom().equals("DESC30") || p.getCodigoDeCupom().equals("DESC20") ||
                p.getCodigoDeCupom().equals("DESC10");
    }
}
