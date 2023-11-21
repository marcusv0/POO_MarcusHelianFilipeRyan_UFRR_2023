import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Carro {
    protected String modelo;
    protected String placa;
    protected String marca;
    private static int quantidade=0;

    public Carro(String modelo, String placa, String marca) {
        this.modelo = modelo;
        this.placa = placa;
        this.marca = marca;
        quantidade++;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void testeAtributos() {
        System.out.println("Marca: " + this.marca);
        System.out.println("Modelo: " + this.modelo);
        System.out.println("Placa: " + this.placa);
    }

    public void salvarCarro() {
        String caminho = new String("dadosCarro" + File.separator + "carro" + Carro.getQuantidade());
        try {
            FileWriter arquivo = new FileWriter(caminho, true); // se não existe, cria
            BufferedWriter escritor = new BufferedWriter(arquivo);

            escritor.write(this.getModelo());
            escritor.write("\n" + this.getMarca());
            escritor.write("\n" + this.getPlaca());


            escritor.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void excluirDadosDoArquivo() {
        String caminho = new String("dadosCarro" + File.separator + "carro" + Carro.getQuantidade());
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

    public static int getQuantidade() {
        return quantidade;
    }
}
