import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.*;

public class Multa {
    private static int contadorMulta = 1;
    private int id;
    private int valor;
    private Cliente cliente;
    private Carro carro;
    private String cnh;
    private String descricao;

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public String getCnh() {
        return cnh;
    }
    public void setCnh(String cnh) {
        this.cnh = cnh;
    }

    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id = id;
    }

    public void registrarMulta(int id, int valor, String cnh, Cliente cliente, Carro carro, String descricao) {
        this.id = id;
        this.valor = valor;
        this.cnh = cnh;
        this.cliente = cliente;
        this.carro = carro;
        this.descricao = descricao;
        salvarDadosEmArquivo();
    }

    public void cancelarMulta(int id) {
        removerDadosDoArquivo(id);
        System.out.println("Multa cancelada com sucesso!");
    }

    private void salvarDadosEmArquivo() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("dados_multas.txt", true))) {
            // Adiciona os dados ao arquivo
            writer.write("ID: " + id + "\n");
            writer.write("Cliente: " + cliente.getNome() + "\n");
            writer.write("Carro: " + carro.getModelo() + "\n");
            writer.write("CNH: " + cnh + "\n");
            writer.write("Descrição da Multa: " + descricao + "\n");
            writer.write("Valor da Multa: " + valor + "\n");
            writer.write("\n");  // Adiciona uma linha em branco para separar as multas

            System.out.println("Dados salvos no arquivo com sucesso!");
        } catch (IOException e) {
            System.err.println("Erro ao salvar os dados no arquivo: " + e.getMessage());
        }
    }

    private void removerDadosDoArquivo(int id) {
        try {
            // Lê o conteúdo do arquivo
            BufferedReader reader = new BufferedReader(new FileReader("dados_multas.txt"));
            StringBuffer stringBuffer = new StringBuffer();
            String line;

            while ((line = reader.readLine()) != null) {
                // Verifica se a linha contém o ID da multa a ser removida
                if (line.contains("ID: " + id)) {
                    // Pula as linhas da multa a ser removida
                    for (int i = 0; i < 6; i++) {
                        reader.readLine();
                    }
                } else {
                    // Adiciona a linha ao buffer
                    stringBuffer.append(line).append("\n");
                }
            }

            reader.close();

            // Escreve o conteúdo modificado de volta no arquivo
            BufferedWriter writer = new BufferedWriter(new FileWriter("dados_multas.txt"));
            writer.write(stringBuffer.toString());
            writer.close();

            System.out.println("Dados removidos do arquivo com sucesso!");
        } catch (IOException e) {
            System.err.println("Erro ao remover os dados do arquivo: " + e.getMessage());
        }
    }
}
