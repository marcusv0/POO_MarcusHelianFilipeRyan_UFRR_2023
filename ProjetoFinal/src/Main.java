public class Main {
    public static void main(String[] args){
        Carro carroteste1 = new Carro("Triton", "54354", "Mitsubish");
        carroteste1.testeAtributos();
        carroteste1.salvarCarro();

        Carro carroteste2 =  new Carro("Civic", "f12345", "Honda");
        carroteste2.testeAtributos();
        carroteste2.salvarCarro();
        
        System.out.println(Carro.getQuantidade()); // retorna a quantidade de carros
    }
}
