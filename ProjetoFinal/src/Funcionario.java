public class Funcionario {
    // Atributos privados para armazenar informações do funcionário
    private String nome;
    private String rg;
    private String endereco;
    private String telefone;

    /**
     * Obtém o nome do funcionário.
     * @return O nome do funcionário.
     */
    public String getNome() {
        return nome;
    }

    /**
     * Define o nome do funcionário.
     * @param nome O novo nome do funcionário.
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Obtém o RG do funcionário.
     * @return O RG do funcionário.
     */
    public String getRg() {
        return rg;
    }

    /**
     * Define o RG do funcionário.
     * @param rg O novo RG do funcionário.
     */
    public void setRg(String rg) {
        this.rg = rg;
    }

    /**
     * Obtém o endereço do funcionário.
     * @return O endereço do funcionário.
     */
    public String getEndereco() {
        return endereco;
    }

    /**
     * Define o endereço do funcionário.
     * @param endereco O novo endereço do funcionário.
     */
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    /**
     * Obtém o telefone do funcionário.
     * @return O telefone do funcionário.
     */
    public String getTelefone() {
        return telefone;
    }

    /**
     * Define o telefone do funcionário.
     * @param telefone O novo telefone do funcionário.
     */
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}
