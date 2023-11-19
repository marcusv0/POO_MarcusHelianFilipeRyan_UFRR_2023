public class Cliente {
    private String nome;
    private String rg;
    private String endereco;
    private String telefone;
    private String cnh;
    private int idade;

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

    public void registrarCliente(String nome, String rg, String endereco, String telefone, String cnh) {
        this.nome = nome;
        this.rg = rg;
        this.endereco = endereco;
        this.telefone = telefone;
        this.cnh = cnh;
    }

    public boolean estaAptoParaAlugarCarro() {
        if (this.getIdade() < 18) {
            return false;
        }
        return true;
    }

}
