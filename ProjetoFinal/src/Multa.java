import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Multa {
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

    public void registrarMulta() {
        // Lógica para registrar a multa...

        // Agora, vamos salvar os dados no arquivo txt
        salvarDadosEmArquivo();
    }

    private void salvarDadosEmArquivo() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("dados_multas.txt", true))) {
            // Adiciona os dados ao arquivo
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
}
