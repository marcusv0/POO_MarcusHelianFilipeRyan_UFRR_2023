public class Data {
    int dia;
    int mes;
    int ano;

    public Data(int dia, int mes, int ano) {
        this.dia = dia;
        this.mes = mes;
        this.ano = ano;
    }

    public String toString() {
        return dia + "/" + mes + "/" + ano;
    }

    // Calcula a diferença de dias entre duas datas
    public int diferencaEmDias(Data data1, Data data2) {

        int diferencaDias;
        int diferencaMeses;
        int diferencaAnos;
        int diferencaTotal;

        if (data1.dia >= data2.dia){
            diferencaDias = data1.dia - data2.dia;
        }
        else {
            diferencaDias = data2.dia - data1.dia;
        }

        if (data1.mes >= data2.mes){
            diferencaMeses = data1.mes - data2.mes;
        }
        else {
            diferencaMeses = data2.mes - data1.mes;
        }

        if (data1.ano >= data2.ano){
            diferencaAnos = data1.ano - data2.ano;
        }
        else {
            diferencaAnos = data2.ano - data1.ano;
        }

        diferencaTotal = diferencaDias + (diferencaMeses * 30) + (diferencaAnos * 365);

        return diferencaTotal;
    }
}
