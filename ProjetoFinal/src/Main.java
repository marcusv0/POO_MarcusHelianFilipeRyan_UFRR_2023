public class Main {
    public static void main(String[] args){
        Cliente cliente1 = new Cliente("André", "25539", "Av. Venezuela", "95-99948-7633", "962488", 23);
        cliente1.registrarCliente();
        Carro carro1 = new Carro("ModeloXYZ", "ABC123", "MarcaXYZ");
        carro1.salvarCarro();
        Multa multa1 = new Multa(150, cliente1, carro1, "Excesso de velocidade");
        multa1.registrarMulta();
        Data data1 = new Data(1, 1, 2022);
        Data data2 = new Data(10, 11, 2023);
        Reserva reserva1 = new Reserva(cliente1, data1, data2, carro1, 2500);
        reserva1.salvarReservaEmArquivo();
        Faturas fatura1 = new Faturas(cliente1, reserva1, multa1, carro1);
        fatura1.salvarFatura();
        
        Cliente cliente2 = new Cliente("Pedro", "8539", "Av. Ville Roy", "98-9948-7633", "712488", 30);
        cliente2.registrarCliente();
        Carro carro2 = new Carro("ModelYZX", "DEF456", "MarcaYZX");
        carro2.salvarCarro();
        Multa multa2 = new Multa(350, cliente2, carro2, "Atravessar sinal vermelho");
        multa2.registrarMulta();
        Data data3 = new Data(18, 11, 2022);
        Data data4 = new Data(10, 8, 2023);
        Reserva reserva2 = new Reserva(cliente2, data3, data4, carro2, 1000);
        reserva2.salvarReservaEmArquivo();
        Faturas fatura2 = new Faturas(cliente2, reserva2, multa2, carro2);
        fatura2.salvarFatura();

        multa1.excluirDadosDoArquivo();
        carro2.excluirDadosDoArquivo();
        cliente1.excluirDadosDoArquivo();
        reserva2.excluirDadosDoArquivo();
        
    }
}
