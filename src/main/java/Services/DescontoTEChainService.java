package Services;

import CalculadoraDeDescontoEntregaChain.IDescontoEntregaChain;
import CalculadoraDeDescontoEntregaChain.DescontoBairroTEChain;
import CalculadoraDeDescontoEntregaChain.DescontoTipoClienteTEChain;
import CalculadoraDeDescontoEntregaChain.DescontoValorPedidoTEChain;
import Model.Pedido;

public class DescontoTEChainService {
    private IDescontoEntregaChain chain = new DescontoBairroTEChain(
        new DescontoTipoClienteTEChain(
        new DescontoValorPedidoTEChain(null)));

    public void calcularDescontosEntrega(Pedido p){
        p.getCuponsEntrega().clear();
        chain.calcularDesconto(p);
    }
    

}
