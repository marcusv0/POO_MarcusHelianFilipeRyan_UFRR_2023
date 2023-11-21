import java.io.*;

public class Multa {
    private static int contadorMulta = 0;
    private int id;
    private int valor;
    private Cliente cliente;
    private Carro carro;
    private String descricao;

    public Multa(int valor, Cliente cliente, Carro carro, String descricao) {
        this.id = ++contadorMulta; // Incrementa o contador para obter um novo ID
        this.valor = valor;
        this.cliente = cliente;
        this.carro = carro;
        this.descricao = descricao;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id = id;
    }

    public void cancelarMulta(int id) {
        removerDadosDoArquivo(id);
        System.out.println("Multa cancelada com sucesso!");
    }

    public void registrarMulta() {
        String caminho = new String("dadosMultas" + File.separator + "multa_" + this.id);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(caminho, true))) {
            // Adiciona os dados ao arquivo
            writer.write("Cliente: " + cliente.getNome() + "\n");
            writer.write("Carro: " + carro.getModelo() + "\n");
            writer.write("CNH: " + cliente.getCnh() + "\n");
            writer.write("Descrição da Multa: " + this.descricao + "\n");
            writer.write("Valor da Multa: " + this.valor + "\n");
            writer.write("\n");  // Adiciona uma linha em branco para separar as multas
            writer.close();

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
            e.printStackTrace();
        }
    }
}
