package Clinica;

public class Atendimento {

    Consulta consulta;

    String observacao;
    String diagnostico;

    String[] procedimentos =
        new String[10];

    int quantidadeProcedimentos;

    public Atendimento(Consulta consulta,
                       String observacao) {

        this.consulta = consulta;
        this.observacao = observacao;

        diagnostico = "";

        quantidadeProcedimentos = 0;

        consulta.realizarConsulta();
    }

    public Atendimento(Consulta consulta,
                       String observacao,
                       String diagnostico) {

        this.consulta = consulta;
        this.observacao = observacao;
        this.diagnostico = diagnostico;

        quantidadeProcedimentos = 0;

        consulta.realizarConsulta();
    }

    // Sobrecarga
    public void adicionarProcedimento(
        String procedimento) {

        if(quantidadeProcedimentos < 10) {

            procedimentos[
                quantidadeProcedimentos] =
                    procedimento;

            quantidadeProcedimentos++;
        }
    }

    // Sobrecarga
    public void adicionarProcedimento(
        String procedimento1,
        String procedimento2) {

        adicionarProcedimento(procedimento1);

        adicionarProcedimento(procedimento2);
    }

    public void mostrarAtendimento() {

        System.out.println(
            "Paciente: "
            + consulta.paciente.nome);

        System.out.println(
            "Observacao: "
            + observacao);

        if(!diagnostico.equals("")) {

            System.out.println(
                "Diagnostico: "
                + diagnostico);
        }

        for(int x = 0;
            x < quantidadeProcedimentos;
            x++) {

            System.out.println(
                procedimentos[x]);
        }
    }
}
