package CalculadoraDeDescontoValorTotalChain;

import Model.CupomDesconto;
import Model.Pedido;
import Model.Item;

public class DescontoTipoItemVTChain implements IDescontoValorTotalChain {
    private IDescontoValorTotalChain next;

    public DescontoTipoItemVTChain(IDescontoValorTotalChain next) {
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
            for(Item item: p.getItens()){
                if(item.getTipo().equals("Educação")){
                    next(p);
                    cupom = new CupomDesconto("Cupom de Item Educação", 0.2);
                    p.getCuponsValorTotal().add(cupom);
                    return;
                }
            }
            for(Item item: p.getItens()){
                if(item.getTipo().equals("Lazer")){
                    next(p);
                    cupom = new CupomDesconto("Cupom de Item Lazer", 0.15);
                    p.getCuponsValorTotal().add(cupom);
                    return;
                }
            }
            for(Item item: p.getItens()){
                if(item.getTipo().equals("Alimentação")){
                    next(p);
                    cupom = new CupomDesconto("Cupom de Item Alimentação", 0.05);
                    p.getCuponsValorTotal().add(cupom);
                    return;
                }
            }
        }
        else
            next(p);
    }

    @Override
    public boolean seAplica(Pedido p) {
        return p.getCuponsValorTotal().isEmpty();
    }
    
}
