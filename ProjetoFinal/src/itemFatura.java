public class itemFatura {
    // Atributos privados para armazenar informações do item da fatura
    private String descricao;
    private double valor;

    /**
     * Obtém a descrição do item da fatura.
     * @return A descrição do item da fatura.
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * Define a descrição do item da fatura.
     * @param descricao A nova descrição do item da fatura.
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /**
     * Obtém o valor do item da fatura.
     * @return O valor do item da fatura.
     */
    public double getValor() {
        return valor;
    }

    /**
     * Define o valor do item da fatura.
     * @param valor O novo valor do item da fatura.
     */
    public void setValor(double valor) {
        this.valor = valor;
    }
}
