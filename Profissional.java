package Clinica;

public class Profissional {

	//Atributos 
	
    public String nome;
    public String especialidade; 
    public String registroProfissional;
    public double valorConsulta;
    public String[] diasSemana = new String[7]; 

	//Construtores
	
    public Profissional(String nomeProfissional, String especialidadeProfissional) {
        this.nome = nomeProfissional;
        setEspecialidadeValidada(especialidadeProfissional);
        this.registroProfissional = "Não Informado";
        this.valorConsulta = 0.0; 
        inicializarDiasSemana();
    }

    public Profissional(String nomeProfissional, String especialidadeProfissional, String registro, double valorCobrado) {
        this.nome = nomeProfissional;
        setEspecialidadeValidada(especialidadeProfissional);
        this.registroProfissional = registro;
        this.valorConsulta = valorCobrado;
        inicializarDiasSemana();
    }

	//Métodos
    public void atualizarCadastro(String registro, double valor) {
        this.registroProfissional = registro;
        this.valorConsulta = valor;
    }

    public void atualizarCadastro(String registro, double valor, String[] diasAtivos, int qtdDias) {
        this.registroProfissional = registro;
        this.valorConsulta = valor;
        inicializarDiasSemana();
        for (int i = 0; i < qtdDias; i++) {
            this.configurarDiaAtendimento(diasAtivos[i]);
        }
    }

    public void inicializarDiasSemana() {
        for (int x = 0; x < diasSemana.length; x++) {
            diasSemana[x] = "NÃO ATENDE";
        }
    }
// usei 2 equals para adptar os acentos que o progama não lê
    public void setEspecialidadeValidada(String esp) {
        String formatada = esp.toLowerCase().trim();
        if (formatada.equals("clínica geral") || formatada.equals("clinica geral") ||
            formatada.equals("fisioterapia") || 
            formatada.equals("psicologia") || 
            formatada.equals("nutrição") || formatada.equals("nutricao")) {
            this.especialidade = formatada;
        } else {
            this.especialidade = "Inválida"; 
        }
    }

    public void configurarDiaAtendimento(String semana) {
        switch (semana.toLowerCase().trim()) {
            case "domingo":
                diasSemana[0] = "ATENDE";
                break;
            case "segunda":
                diasSemana[1] = "ATENDE";
                break;
            case "terça":
            case "terca":
                diasSemana[2] = "ATENDE";
                break;
            case "quarta":
                diasSemana[3] = "ATENDE";
                break;
            case "quinta":
                diasSemana[4] = "ATENDE";
                break;
            case "sábado":
                diasSemana[6] = "ATENDE";
                break;
        }
    }
}
