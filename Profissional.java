package Clinica;

public class Profissional {
	String nome;
	String especialidade;
	double valorConsulta;
	String[] diasSemana = new String[7];
	public Profissional(String nomeProfissional, String especialidadeProfissional, double valorCobrado) {
		this.nome = nomeProfissional;
		this.especialidade = especialidadeProfissional;
		this.valorConsulta = valorCobrado;
		for (int x = 0; x < diasSemana.length; x++) {
			diasSemana[x] = "NÃO ATENDE";
		}
	}
	
	public void diasSemana(String semana) {
		switch (semana.toLowerCase().trim()) {
		case "domingo":
			diasSemana[0] = "ATENDE";
		case "segunda":
			diasSemana[1] = "ATENDE";
		case "terça":
			diasSemana[2] = "ATENDE";
		case "quarta":
			diasSemana[3] = "ATENDE";
		case "quinta":
			diasSemana[4] = "ATENDE";
		case "sexta":
			diasSemana[5] = "ATENDE";
		case "sabado":
			diasSemana[6] = "ATENDE";
		}
	}
}
