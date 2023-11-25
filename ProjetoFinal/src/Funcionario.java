import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Funcionario extends Pessoa implements ManipularDados{
    private String cargo;

    public Funcionario(String nome, String rg, String endereco, String telefone, String cargo) {
        super(nome, rg, endereco, telefone);
        this.cargo = cargo;
    }

    public String getCargo(){
        return cargo;
    }

    public void setCargo(String cargo){
        this.cargo = cargo;
    }

    public void registrarDados() {
        String caminho = new String("dadosFuncionario" + File.separator + "funcionario_" + getNome());
        try {
            FileWriter arquivo = new FileWriter(caminho, true); // se não existe, cria
            BufferedWriter escritor = new BufferedWriter(arquivo);

            escritor.write("Nome do funcionário: " + getNome());
            escritor.newLine();
            escritor.write("RG: do funcionário: " + getRg());
            escritor.newLine();
            escritor.write("Endereço do funcionário: " + getEndereco());
            escritor.newLine();
            escritor.write("Telefone do funcionário: " + getTelefone());
            escritor.write("Cargo do funcionário: " + getCargo());


            escritor.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void excluirDadosDoArquivo() {
        String caminho = new String("dadosFuncionario" + File.separator + "funcionario_" + getNome());
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
