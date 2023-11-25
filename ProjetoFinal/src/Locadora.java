import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Locadora implements ManipularDados {
    private String nome;
    private String cnpj;
    private String endereco;
    private String telefone;
    private ArrayList<Funcionario> funcionarios;
    private int quantidadeFuncionarios;

    public Locadora(String nome, String cnpj, String endereco, String telefone) {
        this.nome = nome;
        this.cnpj = cnpj;
        this.endereco = endereco;
        this.telefone = telefone;
        this.funcionarios = new ArrayList<>();
        this.quantidadeFuncionarios = 0;
    }

    public String getNome(){
        return nome;
    }
    public void setNome(String nome){
        this.nome = nome;
    }

    public String getCnpj(){
        return cnpj;
    }
    public void setCnpj(String cnpj){
        this.cnpj = cnpj;
    }

    public String getEndereco(){
        return endereco;
    }
    public void setEndereco(String endereco){
        this.endereco = endereco;
    }

    public String getTelefone(){
        return telefone;
    }
    public void setTelefone(String telefone){
        this.telefone = telefone;
    }

    public void contratarFuncionario(Funcionario novoFuncionario) {
        funcionarios.add(novoFuncionario);
        quantidadeFuncionarios++;
        System.out.println("Funcionário contratado com sucesso!");
        novoFuncionario.registrarDados();
    }

    public void demitirFuncionario(Funcionario funcionarioParaDemitir) {
        if (funcionarios.remove(funcionarioParaDemitir)) {
            quantidadeFuncionarios--;
            System.out.println("Funcionário demitido com sucesso!");
            funcionarioParaDemitir.excluirDadosDoArquivo();
        } else {
            System.out.println("Funcionário não encontrado na lista.");
        }
    }

    public int getQuantidadeFuncionarios() {
        return quantidadeFuncionarios;
    }

    @Override
    public void registrarDados() {
        String caminho = new String("dadosLocadora" + File.separator + "locadora_" + getNome());
        try (BufferedWriter escritor = new BufferedWriter(new FileWriter(caminho, true))) {
            escritor.write("Nome da locadora: " + getNome());
            escritor.newLine();
            escritor.write("CNPJ da locadora: " + getCnpj());
            escritor.newLine();
            escritor.write("Endereço da locadora: " + getEndereco());
            escritor.newLine();
            escritor.write("Telefone da locadora: " + getTelefone());
            escritor.newLine();
            escritor.write("Quantidade de funcionários: " + getQuantidadeFuncionarios());
            escritor.newLine();

            escritor.close();
            System.out.println("Dados registrados com sucesso!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void excluirDadosDoArquivo() {
        String caminho = new String("dadosLocadora" + File.separator + "locadora_" + getNome());
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
