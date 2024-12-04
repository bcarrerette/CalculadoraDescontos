package CalculadoraDeDescontoEntregaChain;

import Model.Pedido;


public interface IDescontoEntregaChain {
    public void calcularDesconto(Pedido p);
    public boolean seAplica(Pedido p);
    public void next(Pedido p);
}
