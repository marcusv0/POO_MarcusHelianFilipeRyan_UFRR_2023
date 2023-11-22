import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
public class Reserva {
    private Cliente cliente;
    private Data dataInicio;
    private Data dataTermino;
    private Carro carro;
    private double valorTotal;


    public Reserva(Cliente cliente, Data dataInicio, Data dataTermino, Carro carro, double valorReserva) {
        this.cliente = cliente;
        this.dataInicio = dataInicio;
        this.dataTermino = dataTermino;
        this.carro = carro;
        this.valorTotal = valorReserva * diferencaEmDias(dataInicio, dataTermino);
        System.out.println("Reserva feita com sucesso.");
    }

    // Calcula a diferença de dias entre duas datas
    public int diferencaEmDias(Data data1, Data data2) {

        int diferencaDias;
        int diferencaMeses;
        int diferencaAnos;
        int diferencaTotal;

        if (data1.dia >= data2.dia){
            diferencaDias = data1.dia - data2.dia;
        }
        else {
            diferencaDias = data2.dia - data1.dia;
        }

        if (data1.mes >= data2.mes){
            diferencaMeses = data1.mes - data2.mes;
        }
        else {
            diferencaMeses = data2.mes - data1.mes;
        }

        if (data1.ano >= data2.ano){
            diferencaAnos = data1.ano - data2.ano;
        }
        else {
            diferencaAnos = data2.ano - data1.ano;
        }

        diferencaTotal = diferencaDias + (diferencaMeses * 30) + (diferencaAnos * 365);

        return diferencaTotal;
    }

    public double getValorTotal(){
        return valorTotal;
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
            writer.newLine();
            writer.write("Valor total da reserva: " + this.valorTotal);
            writer.close();

            System.out.println("Reserva salva em arquivo com sucesso.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void excluirDadosDoArquivo() {
        String caminho = new String("dadosReserva" + File.separator + "reserva_" + cliente.getNome() + "_" + carro.getModelo());
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

