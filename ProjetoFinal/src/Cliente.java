import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Cliente {
    private String nome;
    private String rg;
    private String endereco;
    private String telefone;
    private String cnh;
    private int idade;

    public Cliente(String nome, String rg, String endereco, String telefone, String cnh, int idade) {
        this.nome = nome;
        this.rg = rg;
        this.endereco = endereco;
        this.telefone = telefone;
        this.cnh = cnh;
        this.idade = idade;
    }
    
    public String getNome(){
        return nome;
    }
    public void setNome(String nome){
        this.nome = nome;
    }

    public String getRg(){
        return rg;
    }
    public void setRg(String rg){
        this.rg = rg;
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

    public void registrarCliente() {
        String caminho = new String("dadosCliente" + File.separator + "cliente_" + this.nome);
        try {
            FileWriter arquivo = new FileWriter(caminho, true); // se não existe, cria
            BufferedWriter escritor = new BufferedWriter(arquivo);

            escritor.write(this.nome);
            escritor.write("\n" + this.rg);
            escritor.write("\n" + this.cnh);
            escritor.write("\n" + this.telefone);
            escritor.write("\n" + this.endereco);
            escritor.write("\n" + this.idade);
            escritor.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
