package Clinica;

public class Paciente {
	String nome;
	int idade;
	String cpf;
	String dataAdmissao;
	String quadro;
	boolean convenio;
	String telefone;
	boolean status;
	
	public Paciente(String nomePaciente, int idadePaciente, String dataPaciente, String cpfPaciente, String quadroPaciente, boolean convenioPaciente) {
		this.nome = nomePaciente;
		this.idade = idadePaciente;
		this.dataAdmissao = dataPaciente;
		this.cpf = cpfPaciente;
		this.quadro = quadroPaciente;
		this.convenio = convenioPaciente;
		this.status = true;
	}
	
	public Paciente(String nomePaciente, int idadePaciente, String dataPaciente, String cpfPaciente, String quadroPaciente, boolean convenioPaciente, String telefonePaciente) {
		this.nome = nomePaciente;
		this.idade = idadePaciente;
		this.dataAdmissao = dataPaciente;
		this.cpf = cpfPaciente;
		this.quadro = quadroPaciente;
		this.status = true;
		this.telefone = telefonePaciente;
	}
	
	
	
}
