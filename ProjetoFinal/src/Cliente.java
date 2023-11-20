/**
 * Classe que representa um cliente da locadora de carros.
 */
public class Cliente {
    // Atributos privados para armazenar informações do cliente
    private String nome;
    private String rg;
    private String endereco;
    private String telefone;
    private String cnh;
    private int idade;

    /**
     * Obtém o nome do cliente.
     * @return O nome do cliente.
     */
    public String getNome() {
        return nome;
    }

    /**
     * Define o nome do cliente.
     * @param nome O novo nome do cliente.
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Obtém o RG do cliente.
     * @return O RG do cliente.
     */
    public String getRg() {
        return rg;
    }

    /**
     * Define o RG do cliente.
     * @param rg O novo RG do cliente.
     */
    public void setRg(String rg) {
        this.rg = rg;
    }

    /**
     * Obtém o endereço do cliente.
     * @return O endereço do cliente.
     */
    public String getEndereco() {
        return endereco;
    }

    /**
     * Define o endereço do cliente.
     * @param endereco O novo endereço do cliente.
     */
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    /**
     * Obtém o telefone do cliente.
     * @return O telefone do cliente.
     */
    public String getTelefone() {
        return telefone;
    }

    /**
     * Define o telefone do cliente.
     * @param telefone O novo telefone do cliente.
     */
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    /**
     * Obtém a CNH (Carteira Nacional de Habilitação) do cliente.
     * @return A CNH do cliente.
     */
    public String getCnh() {
        return cnh;
    }

    /**
     * Define a CNH (Carteira Nacional de Habilitação) do cliente.
     * @param cnh A nova CNH do cliente.
     */
    public void setCnh(String cnh) {
        this.cnh = cnh;
    }

    /**
     * Obtém a idade do cliente.
     * @return A idade do cliente.
     */
    public int getIdade() {
        return idade;
    }

    /**
     * Define a idade do cliente.
     * @param idade A nova idade do cliente.
     */
    public void setIdade(int idade) {
        this.idade = idade;
    }

    /**
     * Registra as informações básicas do cliente.
     * @param nome     O nome do cliente.
     * @param rg       O RG do cliente.
     * @param endereco O endereço do cliente.
     * @param telefone O telefone do cliente.
     * @param cnh      A CNH do cliente.
     */
    public void registrarCliente(String nome, String rg, String endereco, String telefone, String cnh) {
        this.nome = nome;
        this.rg = rg;
        this.endereco = endereco;
        this.telefone = telefone;
        this.cnh = cnh;
    }

    /**
     * Verifica se o cliente está apto para alugar um carro com base na idade.
     * @return true se o cliente está apto, false caso contrário.
     */
    public boolean estaAptoParaAlugarCarro() {
        return this.getIdade() >= 18;
    }
}
