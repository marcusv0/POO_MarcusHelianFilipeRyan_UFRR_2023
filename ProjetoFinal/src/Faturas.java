import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Faturas implements ManipularDados{
    private Reserva reserva;
    private Multa multa;
    private Cliente cliente;
    private Carro carro;

    public Faturas(Cliente cliente, Reserva reserva, Multa multa, Carro carro){
        this.cliente = cliente;
        this.reserva = reserva;
        this.multa = multa;
        this.carro = carro;
    }
    
    public void registrarDados() {
        String caminho = new String("dadosFatura" + File.separator + "fatura_" + cliente.getNome() + "_" + carro.getModelo());
        try {
            FileWriter arquivo = new FileWriter(caminho, true); // se não existe, cria
            BufferedWriter escritor = new BufferedWriter(arquivo);

            escritor.write("CNH do cliente: " + cliente.getCnh());
            escritor.newLine();
            escritor.write("Modelo do carro: " + carro.getModelo());
            escritor.newLine();
            escritor.write("Marca do carro: " + carro.getMarca());
            escritor.newLine();
            escritor.write("Placa do carro: " + carro.getPlaca());
            escritor.newLine();
            escritor.write("Descrição da multa: " + multa.getDescricao());
            escritor.newLine();
            double valorFatura = reserva.getValorTotal() + multa.getValor();
            escritor.write("Valor da fatura: " + valorFatura);
            escritor.newLine();


            escritor.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void excluirDadosDoArquivo() {
        String caminho = new String("dadosFatura" + File.separator + "fatura_" + cliente.getNome() + "_" + carro.getModelo());
        try {
            File arquivo = new File(caminho);

            if (arquivo.exists()) {
                if (arquivo.delete()) {
                    System.out.println("Dados removidos do arquivo com sucesso!");
                } else {
                    System.err.println("Erro ao remover o arquivo.");
                }
            } else {
                System.out.println("Arquivo não encontrado.");
            }
        } catch (Exception e) {
            System.err.println("Erro ao excluir dados do arquivo: " + e.getMessage());
        }
    }

}
