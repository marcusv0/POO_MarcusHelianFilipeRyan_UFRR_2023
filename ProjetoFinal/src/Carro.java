public class Carro {
    protected String modelo;
    protected String placa;
    protected String marca;

    public Carro(String modelo, String placa, String marca) {
        this.modelo = modelo;
        this.placa = placa;
        this.marca = marca;
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

    public void testeAtributos() {
        System.out.println(this.marca);
        System.out.println(this.modelo);
        System.out.println(this.placa);
    }
}
