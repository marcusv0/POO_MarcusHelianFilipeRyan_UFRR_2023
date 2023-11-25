import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;

public class Leitor {
    public static void lerArquivo(String caminho) {
        // Usando try-with-resources para garantir o fechamento adequado do BufferedReader
        try (BufferedReader leitortxt = new BufferedReader(new FileReader(caminho))) {

            String linha;

            // ler cada linha do aquivo
            while ((linha = leitortxt.readLine()) != null) {
                System.out.println(linha);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}