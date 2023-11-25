import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Cliente extends Pessoa implements ManipularDados{
    private String cnh;
    private int idade;

    public Cliente(String nome, String rg, String endereco, String telefone, String cnh, int idade) {
        super(nome, rg, endereco, telefone);
        this.cnh = cnh;
        this.idade = idade;
    }

    public String getCnh(){
        return cnh;
    }
    public void setCnh(String cnh){
        this.cnh = cnh;
    }

    public int getIdade(){
        return idade;
    }

    public void setIdade(int idade){
        this.idade = idade;
    }


    public boolean estaAptoParaAlugarCarro() {
        if (this.getIdade() < 18) {
            return false;
        }
        return true;
    }

    public void registrarDados() {
        String caminho = new String("dadosCliente" + File.separator + "cliente_" + getNome());
        try {
            FileWriter arquivo = new FileWriter(caminho, true); // se não existe, cria
            BufferedWriter escritor = new BufferedWriter(arquivo);

            escritor.write("Nome do cliente: " + getNome());
            escritor.newLine();
            escritor.write("RG do cliente:" + getRg());
            escritor.newLine();
            escritor.write("CNH do cliente: " + getCnh());
            escritor.newLine();
            escritor.write("Telefone do cliente: " + getTelefone());
            escritor.newLine();
            escritor.write("Endereço do cliente: " + getEndereco());
            escritor.newLine();
            escritor.write("Idade do cliente: " + getIdade());
            escritor.newLine();


            escritor.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void excluirDadosDoArquivo() {
        String caminho = new String("dadosCliente" + File.separator + "cliente_" + getNome());
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
