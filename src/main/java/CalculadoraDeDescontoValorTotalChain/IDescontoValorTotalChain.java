package CalculadoraDeDescontoValorTotalChain;

import Model.Pedido;

public interface IDescontoValorTotalChain {
    public void calcularDesconto(Pedido p);
    public boolean seAplica(Pedido p);
    public void next(Pedido p);
}
