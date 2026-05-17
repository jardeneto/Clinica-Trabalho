package Clinica;

public class Consulta {

    Paciente paciente;
    Profissional profissional;

    String data;
    int horario;

    String tipoConsulta;
    String statusConsulta;

    double multa;

    public Consulta(Paciente pacienteConsulta,
                     Profissional profissionalConsulta,
                     String dataConsulta,
                     int horarioConsulta) {

        this.paciente = pacienteConsulta;
        this.profissional = profissionalConsulta;

        this.data = dataConsulta;
        this.horario = horarioConsulta;

        this.tipoConsulta = "Inicial";
        this.statusConsulta = "Agendada";

        this.multa = 0;
    }

    public Consulta(Paciente pacienteConsulta,
                     Profissional profissionalConsulta,
                     String dataConsulta,
                     int horarioConsulta,
                     String tipo) {

        this.paciente = pacienteConsulta;
        this.profissional = profissionalConsulta;

        this.data = dataConsulta;
        this.horario = horarioConsulta;

        this.tipoConsulta = tipo;
        this.statusConsulta = "Agendada";

        this.multa = 0;
    }

    // Sobrecarga
    public void cancelarConsulta() {

        statusConsulta = "Cancelada";
    }

    // Sobrecarga
    public void cancelarConsulta(String justificativa) {

        statusConsulta = "Cancelada";

        System.out.println("Justificativa:");
        System.out.println(justificativa);
    }

    // Sobrecarga
    public Consulta remarcarConsulta(int novoHorario) {

        statusConsulta = "Remarcada";

        Consulta novaConsulta =
            new Consulta(
                paciente,
                profissional,
                data,
                novoHorario,
                tipoConsulta);

        return novaConsulta;
    }

    // Sobrecarga
    public Consulta remarcarConsulta(String novaData,
                                     int novoHorario) {

        statusConsulta = "Remarcada";

        Consulta novaConsulta =
            new Consulta(
                paciente,
                profissional,
                novaData,
                novoHorario,
                tipoConsulta);

        return novaConsulta;
    }

    public void realizarConsulta() {

        statusConsulta = "Realizada";
    }

    public void mostrarConsulta() {

        System.out.println("Paciente: "
                           + paciente.nome);

        System.out.println("Profissional: "
                           + profissional.nome);

        System.out.println("Data: "
                           + data);

        System.out.println("Horario: "
                           + horario);

        System.out.println("Tipo: "
                           + tipoConsulta);

        System.out.println("Status: "
                           + statusConsulta);

        if(multa > 0) {

            System.out.println("Multa: "
                               + multa);
        }
    }
}
