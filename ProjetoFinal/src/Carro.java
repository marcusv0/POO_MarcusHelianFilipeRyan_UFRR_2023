public abstract class Carro {
    protected String modelo;
    protected String placa;
    protected String marca;
    protected int quantidade;

    public int getQuantidade(){
        return quantidade;
    }
    public void setQuantidade(int quantidade){
        this.quantidade = quantidade;
    }

    public String getModelo(){
        return modelo;
    }

    public void setModelo(String modelo){
        this.modelo = modelo;
    }

    public String getPlaca(){
        return placa;
    }

    public void setPlaca(String placa){
        this.placa = placa;
    }

    public String getMarca(){
        return marca;
    }

    public void setMarca(String marca){
        this.marca = marca;
    }

    public boolean verificarDisponibilidade() {
        // Verifica se a quantidade disponível é maior que zero
        return quantidade > 0;
    }
}
