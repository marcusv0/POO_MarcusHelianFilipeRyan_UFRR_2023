import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.*;

public class Multa {
    private static int contadorMulta = 1; // Contador para gerar IDs únicos para cada multa
    private int id;
    private int valor;
    private Cliente cliente;
    private Carro carro;
    private String cnh;
    private String descricao;

    /**
     * Obtém o valor da multa.
     * @return O valor da multa.
     */
    public int getValor() {
        return valor;
    }

    /**
     * Define o valor da multa.
     * @param valor O novo valor da multa.
     */
    public void setValor(int valor) {
        this.valor = valor;
    }

    /**
     * Obtém o número da CNH associado à multa.
     * @return O número da CNH.
     */
    public String getCnh() {
        return cnh;
    }

    /**
     * Define o número da CNH associado à multa.
     * @param cnh O novo número da CNH.
     */
    public void setCnh(String cnh) {
        this.cnh = cnh;
    }

    /**
     * Obtém o ID único da multa.
     * @return O ID da multa.
     */
    public int getId() {
        return id;
    }

    /**
     * Define o ID da multa.
     * @param id O novo ID da multa.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Registra uma nova multa com os dados fornecidos e salva no arquivo.
     * @param id O ID único da multa.
     * @param valor O valor da multa.
     * @param cnh O número da CNH associado à multa.
     * @param cliente O cliente associado à multa.
     * @param carro O carro associado à multa.
     * @param descricao A descrição da multa.
     */
    public void registrarMulta(int id, int valor, String cnh, Cliente cliente, Carro carro, String descricao) {
        this.id = id;
        this.valor = valor;
        this.cnh = cnh;
        this.cliente = cliente;
        this.carro = carro;
        this.descricao = descricao;
        salvarDadosEmArquivo();
    }

    /**
     * Cancela uma multa com base no ID fornecido e remove os dados do arquivo.
     * @param id O ID da multa a ser cancelada.
     */
    public void cancelarMulta(int id) {
        removerDadosDoArquivo(id);
        System.out.println("Multa cancelada com sucesso!");
    }

    /**
     * Salva os dados da multa em um arquivo.
     */
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

    /**
     * Remove os dados da multa do arquivo com base no ID fornecido.
     * @param id O ID da multa a ser removida.
     */
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
