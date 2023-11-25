import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Reserva implements ManipularDados{
    private Cliente cliente;
    private LocalDate dataInicio;
    private LocalDate dataTermino;
    private Carro carro;
    private double valorTotal;

    public Reserva(Cliente cliente, LocalDate dataInicio, LocalDate dataTermino, Carro carro, double valorReserva) {
        this.cliente = cliente;
        this.dataInicio = dataInicio;
        this.dataTermino = dataTermino;
        this.carro = carro;
        this.valorTotal = valorReserva * diferencaEmDias(dataInicio, dataTermino);
        System.out.println("Reserva feita com sucesso.");
    }

    // Calcula a diferença de dias entre duas datas
    public long diferencaEmDias(LocalDate data1, LocalDate data2) {
        return Duration.between(data1.atStartOfDay(), data2.atStartOfDay()).toDays();
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void registrarDados() {
        String caminho = "dadosReserva" + File.separator + "reserva_" + cliente.getNome() + "_" + carro.getModelo();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(caminho, true))) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

            writer.write("Cliente: " + cliente.getNome());
            writer.newLine();
            writer.write("Data de Início: " + dataInicio.format(formatter));
            writer.newLine();
            writer.write("Data de Término: " + dataTermino.format(formatter));
            writer.newLine();
            writer.write("Carro: " + carro.getModelo());
            writer.newLine();
            writer.write("Valor total da reserva: " + this.valorTotal);
            writer.newLine();

            System.out.println("Reserva salva em arquivo com sucesso.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void excluirDadosDoArquivo() {
        String caminho = "dadosReserva" + File.separator + "reserva_" + cliente.getNome() + "_" + carro.getModelo();
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
