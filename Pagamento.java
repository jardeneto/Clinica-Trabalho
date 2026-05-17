package Clinica;

public class Pagamento {

    Consulta consulta;

    double valor;

    String tipoPagamento;

    int parcelas;

    public Pagamento(Consulta consulta,
                      double valor,
                      String tipoPagamento) {

        this.consulta = consulta;

        this.valor = valor;

        this.tipoPagamento =
            tipoPagamento;

        parcelas = 1;
    }

    public Pagamento(Consulta consulta,
                      String tipoPagamento) {

        this.consulta = consulta;

        this.valor =
            consulta.profissional.valorConsulta;

        this.tipoPagamento =
            tipoPagamento;

        parcelas = 1;
    }

    // Sobrecarga
    public double calcularValor() {

        return consulta.profissional
               .valorConsulta;
    }

    // Sobrecarga
    public double calcularValor(
        double desconto) {

        double valorFinal =
            consulta.profissional
            .valorConsulta;

        valorFinal =
            valorFinal - desconto;

        if(valorFinal < 0) {

            valorFinal = 0;
        }

        return valorFinal;
    }

    public void parcelarPagamento(
        int parcelas) {

        if(parcelas >= 1
            &&
            parcelas <= 3) {

            this.parcelas = parcelas;
        }
    }

    public void mostrarPagamento() {

        System.out.println(
            "Paciente: "
            + consulta.paciente.nome);

        System.out.println(
            "Valor: "
            + valor);

        System.out.println(
            "Pagamento: "
            + tipoPagamento);

        System.out.println(
            "Parcelas: "
            + parcelas);
    }
}
