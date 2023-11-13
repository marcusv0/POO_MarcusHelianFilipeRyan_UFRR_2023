import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
public class Reserva {
    private Cliente cliente;
    private Data dataInicio;
    private Data dataTermino;
    private Carro carro;

    public Reserva() {
    }

    public void fazerReserva(Cliente cliente, Data dataInicio, Data dataTermino, Carro carro) {
        this.cliente = cliente;
        this.dataInicio = dataInicio;
        this.dataTermino = dataTermino;
        this.carro = carro;
        System.out.println("Reserva feita com sucesso.");
    }

    public void cancelarReserva() {
        this.cliente = null;
        this.dataInicio = null;
        this.dataTermino = null;
        this.carro = null;
        System.out.println("Reserva cancelada com sucesso.");
    }

    public void salvarReservaEmArquivo(String nomeArquivo) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nomeArquivo, true))) {
            writer.write("Cliente: " + cliente.getNome());
            writer.newLine();
            writer.write("Data de Início: " + dataInicio.toString());
            writer.newLine();
            writer.write("Data de Término: " + dataTermino.toString());
            writer.newLine();
            writer.write("Carro: " + carro.getModelo());
            writer.newLine();
            writer.write("----------------------------");
            writer.newLine();
            System.out.println("Reserva salva em arquivo com sucesso.");
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Erro ao salvar a reserva em arquivo.");
        }
    }
}
