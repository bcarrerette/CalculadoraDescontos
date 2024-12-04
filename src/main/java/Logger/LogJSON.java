package Logger;


import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;


public class LogJSON implements ILog  {
    
    @Override
    public void gravarLog(String cliente, String usuario, String codigo, String operation) throws IOException {
        String log = String.format("{ \"Nome do usuário: \": \"%s\",  \"Nome do cliente: \": \"%s\", \"Código: \": \"%s\", \"Data da Operação\": \"%s\", \"Operação\": \"%s\"}",
                usuario ,cliente, codigo, LocalDateTime.now().toString(), operation);
        saveToFile(log);
    }

    private void saveToFile(String log) throws IOException {
        try (FileWriter writer = new FileWriter("Operações de Log.json", true)) {
            writer.write(log + System.lineSeparator());
        } catch (IOException e) {
           throw new IOException("Erro ao salvar arquivo");
        }
    }
}