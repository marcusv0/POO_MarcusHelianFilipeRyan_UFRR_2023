import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.File;

public class Leitor {

    public static void lerPasta(String caminho) {
        String diretorio = caminho;
        File pasta = new File(diretorio);

        if (pasta.exists() && pasta.isDirectory()) {
            // Lista todos os arquivos no diretório
            File[] arquivos = pasta.listFiles();

            // Itera sobre os arquivos
            for (File arquivo : arquivos) {
                // Verifica se o arquivo é um arquivo de texto (.txt)
                if (arquivo.isFile() && arquivo.getName().endsWith(".txt")) {
                    // Chama o método para ler o conteúdo do arquivo
                    Leitor.lerArquivo(caminho + arquivo);
                }
            }
        } else {
            System.out.println("O diretório especificado não existe ou não é uma pasta.");
        }
    }

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