import java.time.LocalDate;

public class Main {
    public static void main(String[] args){
        Locadora locadora = new Locadora("Locadora A", "123456789", "Rua Principal", "987654321");
        Funcionario funcionario1 = new Funcionario("Emerson", "45812-9", "Av. Brasil", "(95) 99178-6549", "Atendente");
        locadora.contratarFuncionario(funcionario1);
        Cliente cliente1 = new Cliente("André", "25539", "Av. Venezuela", "95-99948-7633", "962488", 23);
        cliente1.registrarDados();
        Carro carro1 = new Carro("ModeloXYZ", "ABC123", "MarcaXYZ");
        carro1.registrarDados();
        Multa multa1 = new Multa(150, cliente1, carro1, "Excesso de velocidade");
        multa1.registrarDados();
        LocalDate data1 = LocalDate.of(2022, 1, 1);
        LocalDate data2 = LocalDate.of(2022, 1, 8);
        Reserva reserva1 = new Reserva(cliente1, data1, data2, carro1, 200);
        reserva1.registrarDados();
        Faturas fatura1 = new Faturas(cliente1, reserva1, multa1, carro1);
        fatura1.registrarDados();
        
        Funcionario funcionario2 = new Funcionario("Maria", "222", "Avenida dos Trabalhadores", "123-456-789", "Gerente");
        locadora.contratarFuncionario(funcionario2);
        Cliente cliente2 = new Cliente("Pedro", "8539", "Av. Ville Roy", "98-9948-7633", "712488", 30);
        cliente2.registrarDados();
        Carro carro2 = new Carro("ModelYZX", "DEF456", "MarcaYZX");
        carro2.registrarDados();
        Multa multa2 = new Multa(350, cliente2, carro2, "Atravessar sinal vermelho");
        multa2.registrarDados();
        LocalDate data3 = LocalDate.of(2022, 11, 10);
        LocalDate data4 = LocalDate.of(2022, 11, 17);
        Reserva reserva2 = new Reserva(cliente2, data3, data4, carro2, 300);
        reserva2.registrarDados();
        Faturas fatura2 = new Faturas(cliente2, reserva2, multa2, carro2);
        fatura2.registrarDados();
        locadora.registrarDados();

        
        Leitor.lerPasta("dadosFuncionario");
        Leitor.lerPasta("dadosLocadora");

        multa1.excluirDadosDoArquivo();
        multa2.excluirDadosDoArquivo();
        carro1.excluirDadosDoArquivo();
        carro2.excluirDadosDoArquivo();
        cliente1.excluirDadosDoArquivo();
        cliente2.excluirDadosDoArquivo();
        reserva1.excluirDadosDoArquivo();
        reserva2.excluirDadosDoArquivo();
        fatura1.excluirDadosDoArquivo();
        fatura2.excluirDadosDoArquivo();
        
        locadora.demitirFuncionario(funcionario1);
        locadora.demitirFuncionario(funcionario2);
        locadora.excluirDadosDoArquivo();
        
    }
}
