package Services;

import CalculadoraDeDescontoValorTotalChain.DescontoTipoClienteVTChain;
import CalculadoraDeDescontoValorTotalChain.DescontoTipoCodigoVTChain;
import CalculadoraDeDescontoValorTotalChain.DescontoTipoItemVTChain;
import CalculadoraDeDescontoValorTotalChain.IDescontoValorTotalChain;
import Model.Pedido;

public class DescontoVTChainService {
    private IDescontoValorTotalChain chain = new DescontoTipoClienteVTChain(
        new DescontoTipoCodigoVTChain(
        new DescontoTipoItemVTChain(null)));

    public void calcularDescontosValorTotal(Pedido p){
        p.getCuponsValorTotal().clear();
        chain.calcularDesconto(p);
    }
    

}