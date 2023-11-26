import java.io.File;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args){
        // Criando uma locadora
        Locadora minhaLocadora = new Locadora("Minha Locadora", "123456789", "Rua da Locadora", "123456789");
        minhaLocadora.registrarDados();
        // Contratando funcionários
        Funcionario funcionario1 = new Funcionario("Funcionario1", "123", "Endereco1", "987654321", "Atendente");
        Funcionario funcionario2 = new Funcionario("Funcionario2", "456", "Endereco2", "987654322", "Gerente");

        minhaLocadora.contratarFuncionario(funcionario1);
        minhaLocadora.contratarFuncionario(funcionario2);

        // Registrando um cliente
        Cliente cliente1 = new Cliente("Cliente1", "789", "EnderecoCliente1", "987654323", "CNHCliente1", 25);
        try {
            if (cliente1.estaAptoParaAlugarCarro()) {
                cliente1.registrarDados();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        // Registrando um carro
        Carro carro1 = new Carro("ModeloCarro1", "ABC123", "MarcaCarro1");
        carro1.registrarDados();

        // Criando uma reserva
        LocalDate dataInicio = LocalDate.of(2022, 1, 1);
        LocalDate dataTermino = LocalDate.of(2022, 1, 8);
        Reserva reserva = new Reserva(cliente1, dataInicio, dataTermino, carro1, 100.0);

        // Registrando a reserva
        reserva.registrarDados();

        // Criando uma multa
        Multa multa = new Multa(50, cliente1, carro1, "Excesso de velocidade");

        // Registrando a multa
        multa.registrarDados();

        // Criando uma fatura
        Faturas fatura = new Faturas(cliente1, reserva, multa, carro1);

        // Registrando a fatura
        fatura.registrarDados();

        // Lendo os dados registrados
        System.out.println("Dados registrados da locadora:");
        Leitor.lerArquivo("dadosLocadora" + File.separator + "locadora_" + minhaLocadora.getNome());

        System.out.println("Dados registrados dos funcionários:");
        Leitor.lerPasta("dadosFuncionario");

        System.out.println("\nDados registrados do cliente:");
        Leitor.lerArquivo("dadosCliente" + File.separator + "cliente_" + cliente1.getNome());

        System.out.println("\nDados registrados do carro:");
        Leitor.lerArquivo("dadosCarro" + File.separator + "carro" + carro1.getIdentificador());

        System.out.println("\nDados registrados da reserva:");
        Leitor.lerArquivo("dadosReserva" + File.separator + "reserva_" + cliente1.getNome() + "_" + carro1.getModelo());

        System.out.println("\nDados registrados da multa:");
        Leitor.lerArquivo("dadosMultas" + File.separator + "multa_" + multa.getId());

        System.out.println("\nDados registrados da fatura:");
        Leitor.lerArquivo("dadosFatura" + File.separator + "fatura_" + cliente1.getNome() + "_" + carro1.getModelo());

        // Excluindo dados
        cliente1.excluirDadosDoArquivo();
        carro1.excluirDadosDoArquivo();
        reserva.excluirDadosDoArquivo();
        multa.excluirDadosDoArquivo();
        fatura.excluirDadosDoArquivo();
        minhaLocadora.demitirFuncionario(funcionario1);
        minhaLocadora.demitirFuncionario(funcionario2);
        minhaLocadora.excluirDadosDoArquivo();

        // Verificando se os dados foram removidos
        System.out.println("\nVerificando se os dados foram removidos:");
        Leitor.lerPasta("dadosLocadora");
        Leitor.lerPasta("dadosFuncionario");
        Leitor.lerPasta("dadosCliente");
        Leitor.lerPasta("dadosCarro");
        Leitor.lerPasta("dadosReserva");
        Leitor.lerPasta("dadosMultas");
        Leitor.lerPasta("dadosFatura");
    }
}
