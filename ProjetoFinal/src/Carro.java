/**
 * Classe que representa um carro na locadora.
 * Contém informações como modelo, placa e marca do carro.
 */
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Carro {
    // Atributos protegidos para armazenar informações do carro
    protected String modelo;
    protected String placa;
    protected String marca;
    private static int quantidade=0;

    /**
     * Construtor que inicializa um objeto Carro com as informações fornecidas.
     * @param modelo O modelo do carro.
     * @param placa A placa do carro.
     * @param marca A marca do carro.
     */
    public Carro(String modelo, String placa, String marca) {
        this.modelo = modelo;
        this.placa = placa;
        this.marca = marca;
        quantidade++; // adiciona 1 à quantidade
    }

    /**
     * Obtém o modelo do carro.
     * @return O modelo do carro.
     */
    public String getModelo() {
        return modelo;
    }

    /**
     * Define o modelo do carro.
     * @param modelo O novo modelo do carro.
     */
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    /**
     * Obtém a placa do carro.
     * @return A placa do carro.
     */
    public String getPlaca() {
        return placa;
    }

    /**
     * Define a placa do carro.
     * @param placa A nova placa do carro.
     */
    public void setPlaca(String placa) {
        this.placa = placa;
    }

    /**
     * Obtém a marca do carro.
     * @return A marca do carro.
     */
    public String getMarca() {
        return marca;
    }

    /**
     * Define a marca do carro.
     * @param marca A nova marca do carro.
     */
    public void setMarca(String marca) {
        this.marca = marca;
    }

    /**
     * Método de teste que imprime os atributos do carro.
     */
    public void testeAtributos() {
        System.out.println("Marca: " + this.marca);
        System.out.println("Modelo: " + this.modelo);
        System.out.println("Placa: " + this.placa);
    }

    /**
     * Método que salva os dados do carro em um arquivo txt
     */
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

    /**
     * Método que retorna a quantidade de carros criados(atributo da classe)
     * @return A quantidade de carros
     */
    public static int getQuantidade() {
        return quantidade;
    }
}
