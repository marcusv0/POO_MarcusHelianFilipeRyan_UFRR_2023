public class Locadora {
    // Atributos privados para armazenar informações da locadora
    private String nome;
    private String cnpj;
    private String endereco;
    private String telefone;
    private Funcionario funcionario;

    /**
     * Obtém o nome da locadora.
     * @return O nome da locadora.
     */
    public String getNome() {
        return nome;
    }

    /**
     * Define o nome da locadora.
     * @param nome O novo nome da locadora.
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Obtém o CNPJ da locadora.
     * @return O CNPJ da locadora.
     */
    public String getCnpj() {
        return cnpj;
    }

    /**
     * Define o CNPJ da locadora.
     * @param cnpj O novo CNPJ da locadora.
     */
    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    /**
     * Obtém o endereço da locadora.
     * @return O endereço da locadora.
     */
    public String getEndereco() {
        return endereco;
    }

    /**
     * Define o endereço da locadora.
     * @param endereco O novo endereço da locadora.
     */
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    /**
     * Obtém o telefone da locadora.
     * @return O telefone da locadora.
     */
    public String getTelefone() {
        return telefone;
    }

    /**
     * Define o telefone da locadora.
     * @param telefone O novo telefone da locadora.
     */
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    /**
     * Obtém o funcionário associado à locadora.
     * @return O funcionário associado à locadora.
     */
    public Funcionario getFuncionario() {
        return funcionario;
    }

    /**
     * Define o funcionário associado à locadora.
     * @param funcionario O novo funcionário associado à locadora.
     */
    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }
}
