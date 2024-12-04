package Logger;

import java.io.IOException;



public interface ILog {

    public void gravarLog(String cliente, String nome, String codigo, String operacao) throws IOException;
}