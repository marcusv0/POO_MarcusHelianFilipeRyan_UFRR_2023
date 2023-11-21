import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
public class Reserva {
    private Cliente cliente;
    private Data dataInicio;
    private Data dataTermino;
    private Carro carro;

    public Reserva(Cliente cliente, Data dataInicio, Data dataTermino, Carro carro) {
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

    public void salvarReservaEmArquivo() {
        String caminho = new String("dadosReserva" + File.separator + "reserva_" + cliente.getNome() + "_" + carro.getModelo());
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(caminho, true))) {
            writer.write("Cliente: " + cliente.getNome());
            writer.newLine();
            writer.write("Data de Início: " + dataInicio.toString());
            writer.newLine();
            writer.write("Data de Término: " + dataTermino.toString());
            writer.newLine();
            writer.write("Carro: " + carro.getModelo());
            writer.close();

            System.out.println("Reserva salva em arquivo com sucesso.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

