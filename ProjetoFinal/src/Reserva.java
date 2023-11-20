import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Reserva {
    private Cliente cliente;
    private Data dataInicio;
    private Data dataTermino;
    private Carro carro;

    /**
     * Construtor padrão da classe Reserva.
     */
    public Reserva() {
    }

    /**
     * Realiza uma reserva com os dados fornecidos.
     * @param cliente O cliente que está fazendo a reserva.
     * @param dataInicio A data de início da reserva.
     * @param dataTermino A data de término da reserva.
     * @param carro O carro que está sendo reservado.
     */
    public void fazerReserva(Cliente cliente, Data dataInicio, Data dataTermino, Carro carro) {
        this.cliente = cliente;
        this.dataInicio = dataInicio;
        this.dataTermino = dataTermino;
        this.carro = carro;
        System.out.println("Reserva feita com sucesso.");
    }

    /**
     * Cancela a reserva, tornando nulos os atributos associados.
     */
    public void cancelarReserva() {
        this.cliente = null;
        this.dataInicio = null;
        this.dataTermino = null;
        this.carro = null;
        System.out.println("Reserva cancelada com sucesso.");
    }

    /**
     * Salva os detalhes da reserva em um arquivo.
     * @param nomeArquivo O nome do arquivo onde os detalhes da reserva serão salvos.
     */
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

