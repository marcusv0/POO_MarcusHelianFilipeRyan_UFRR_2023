public class Data {
    int dia;
    int mes;
    int ano;

    // Construtor que inicializa a data com dia, mês e ano
    public Data(int dia, int mes, int ano) {
        this.dia = dia;
        this.mes = mes;
        this.ano = ano;
    }

    // Representação da data como string no formato "dia/mês/ano"
    public String toString() {
        return dia + "/" + mes + "/" + ano;
    }

    // Método que calcula a diferença em dias entre duas datas
    public int diferencaEmDias(Data data1, Data data2) {
        int diferencaDias;
        int diferencaMeses;
        int diferencaAnos;
        int diferencaTotal;

        // Cálculo da diferença em dias, meses e anos
        if (data1.dia >= data2.dia) {
            diferencaDias = data1.dia - data2.dia;
        } else {
            diferencaDias = data2.dia - data1.dia;
        }

        if (data1.mes >= data2.mes) {
            diferencaMeses = data1.mes - data2.mes;
        } else {
            diferencaMeses = data2.mes - data1.mes;
        }

        if (data1.ano >= data2.ano) {
            diferencaAnos = data1.ano - data2.ano;
        } else {
            diferencaAnos = data2.ano - data1.ano;
        }

        // Cálculo da diferença total em dias considerando meses de 30 dias e anos de 365 dias
        diferencaTotal = diferencaDias + (diferencaMeses * 30) + (diferencaAnos * 365);

        return diferencaTotal;
    }
}
