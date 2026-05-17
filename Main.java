package Clinica;

import java.util.Scanner;

public class Main {

    // limite fixo de 100 pros array
    public final int LIMITE = 100;

    // Arrays de armazenamento, todas public 
    public Paciente[] pacientes = new Paciente[LIMITE];
    public int qtdPacientes = 0;

    public Profissional[] profissionais = new Profissional[LIMITE];
    public int qtdProfissionais = 0;

    public Consulta[] consultas = new Consulta[LIMITE];
    public int qtdConsultas = 0;

    public Atendimento[] atendimentos = new Atendimento[LIMITE];
    public int qtdAtendimentos = 0;

    public Pagamento[] pagamentos = new Pagamento[LIMITE];
    public int qtdPagamentos = 0;

    public static void main(String[] args) {
        // Criando o objeto do Main para rodar o contexto não estatico
        Main sistema = new Main();
        sistema.executar();
    }

    public void executar() {
        Scanner sc = new Scanner(System.in);
        int opcao = -1;

        while (opcao != 0) {
        	
        	
            System.out.println("\n=================================");
            System.out.println("   SISTEMA CLÍNICA VIDAPLENA   ");
            System.out.println("=================================\n");
            System.out.println("1 - Menu de Pacientes");
            System.out.println("2 - Menu de Profissionais");
            System.out.println("3 - Menu de Consultas");
            System.out.println("4 - Menu de Atendimentos");
            System.out.println("5 - Menu de Pagamentos");
            System.out.println("0 - Encerrar Sistema");
            System.out.print("Escolha uma opção: ");

            opcao = sc.nextInt();
            sc.nextLine();
            
            //Apos usar o scanner, o sistema redirecionará entre os métodos
            switch (opcao) {
                case 1:
                    menuPacientes(sc);
                    break;
                case 2:
                    menuProfissionais(sc);
                    break;
                case 3:
                    menuConsultas(sc);
                    break;
                case 4:
                    menuAtendimentos(sc);
                    break;
                case 5:
                    menuPagamentos(sc);
                    break;
                case 0:
                    System.out.println("Programa Encerrado.");
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        }
        sc.close();
    }



    public void menuPacientes(Scanner sc) {
        System.out.println("\n--- CADASTRO DE PACIENTE ---");
        if (qtdPacientes >= LIMITE) {
            System.out.println("Limite de pacientes atingido!");
            
            // caso o limite de 100 for atingido ele n procede 
            
            return;
        }

        System.out.print("Nome do Paciente: ");
        String nome = sc.nextLine();
        System.out.print("CPF: ");
        String cpf = sc.nextLine();
        System.out.print("Idade: ");
        int idade = sc.nextInt();
        sc.nextLine();
        System.out.print("Data de Admissão: ");
        String data = sc.nextLine();
        System.out.print("Quadro Clínico: ");
        String quadro = sc.nextLine();
        System.out.print("Possui Convênio? (true/false): ");
        boolean temConvenio = sc.nextBoolean();
        sc.nextLine();
        System.out.print("Telefone: ");
        String telefone = sc.nextLine();

        // O construtor sobrecarregado completo do paciente que cria o objeto
        
        pacientes[qtdPacientes] = new Paciente(nome, idade, data, cpf, quadro, temConvenio, telefone);
        qtdPacientes++;
        System.out.println("Paciente cadastrado com sucesso!");
    }

    /* Apartir daqui os metodos dos "submenus" seguirão a exata mesma lógica para criar os objetos
     * , por isso a ausência de comentários*/

    public void menuProfissionais(Scanner sc) {
        System.out.println("\n--- CADASTRO DE PROFISSIONAL ---");
        if (qtdProfissionais >= LIMITE) {
            System.out.println("Limite de profissionais atingido!");
            return;
        }

        System.out.print("Nome do Profissional: ");
        String nome = sc.nextLine();
        System.out.print("Especialidade (clínica geral, fisioterapia, psicologia, nutrição): ");
        String esp = sc.nextLine();
        System.out.print("Registro Profissional: ");
        String registro = sc.nextLine();
        System.out.print("Valor da Consulta: ");
        double valor = sc.nextDouble();
        sc.nextLine();

        profissionais[qtdProfissionais] = new Profissional(nome, esp, registro, valor);
        qtdProfissionais++;
        System.out.println("Profissional cadastrado com sucesso!");
    }

    public void menuConsultas(Scanner sc) {
        System.out.println("\n--- AGENDAMENTO DE CONSULTA ---");
        if (qtdConsultas >= LIMITE) {
            System.out.println("Limite de consultas atingido!");
            return;
        }

        System.out.print("Digite o CPF do Paciente: ");
        String cpf = sc.nextLine();
        Paciente pac = buscarPaciente(cpf);

        if (pac == null) {
            System.out.println("Paciente não encontrado!");
            return;
        }

        System.out.print("Digite o Nome do Profissional: ");
        String nomeProf = sc.nextLine();
        Profissional prof = buscarProfissional(nomeProf);

        if (prof == null) {
            System.out.println("Profissional não encontrado!");
            return;
        }

        System.out.print("Data da Consulta (DD/MM/AAAA): ");
        String data = sc.nextLine();
        System.out.print("Horário (Apenas hora cheia em inteiro, ex: 14): ");
        int horario = sc.nextInt();
        sc.nextLine();

        consultas[qtdConsultas] = new Consulta(pac, prof, data, horario);
        qtdConsultas++;
        System.out.println("Consulta agendada com sucesso!");
    }

    public void menuAtendimentos(Scanner sc) {
        System.out.println("\n--- REGISTRO DE ATENDIMENTO ---");
        if (qtdAtendimentos >= LIMITE) {
            System.out.println("Limite de atendimentos atingido!");
            return;
        }

        System.out.print("Digite o CPF do Paciente para iniciar o atendimento: ");
        String cpf = sc.nextLine();
        Consulta cons = buscarConsultaAgendada(cpf);

        if (cons == null) {
            System.out.println("Nenhuma consulta agendada encontrada para este paciente.");
            return;
        }

        System.out.print("Observações Médicas: ");
        String obs = sc.nextLine();
        System.out.print("Diagnóstico: ");
        String diag = sc.nextLine();

        Atendimento ate = new Atendimento(cons, obs, diag);

        System.out.print("Deseja adicionar um procedimento? (sim/não): ");
        String resp = sc.nextLine();
        if (resp.equalsIgnoreCase("sim")) {
            System.out.print("Nome do procedimento: ");
            String proc = sc.nextLine();
            ate.adicionarProcedimento(proc); // Usa a sobrecarga do Atendimento
        }

        atendimentos[qtdAtendimentos] = ate;
        qtdAtendimentos++;
        System.out.println("\nAtendimento Concluído!");
        ate.mostrarAtendimento();
    }

    public void menuPagamentos(Scanner sc) {
        System.out.println("\n--- PROCESSAR PAGAMENTO ---");
        if (qtdPagamentos >= LIMITE) {
            System.out.println("Limite de pagamentos atingido!");
            return;
        }

        System.out.print("Digite o CPF do Paciente: ");
        String cpf = sc.nextLine();
        Consulta cons = buscarConsultaRealizada(cpf);

        if (cons == null) {
            System.out.println("Nenhuma consulta realizada encontrada para faturamento.");
            return;
        }

        System.out.print("Tipo de Pagamento (Dinheiro/Cartão/Convênio): ");
        String tipo = sc.nextLine();

        Pagamento pag = new Pagamento(cons, tipo);
        
        System.out.print("Houve desconto especial? (Valor em R$, digite 0 se não houver): ");
        double desc = sc.nextDouble();
        sc.nextLine();

        if (desc > 0) {
            pag.valor = pag.calcularValor(desc); // aqui pra usar a sobrecarga do método calcularValor
        }

        if (tipo.equalsIgnoreCase("cartão") || tipo.equalsIgnoreCase("cartao")) {
            System.out.print("Deseja parcelar em quantas vezes (1 a 3)? ");
            int parc = sc.nextInt();
            sc.nextLine();
            pag.parcelarPagamento(parc);
        }

        pagamentos[qtdPagamentos] = pag;
        qtdPagamentos++;
        System.out.println("\nPagamento Processado com sucesso!");
        pag.mostrarPagamento();
    }


    // MÉTODOS DE BUSCA AUXILIARES (Usando laços, simples sobre os arrays pra buscar os objetos criados)


    public Paciente buscarPaciente(String cpf) {
        for (int i = 0; i < qtdPacientes; i++) {
            if (pacientes[i].cpf.equals(cpf)) {
                return pacientes[i];
            }
        }
        return null;
    }

    public Profissional buscarProfissional(String nome) {
        for (int i = 0; i < qtdProfissionais; i++) {
            if (profissionais[i].nome.equalsIgnoreCase(nome)) {
                return profissionais[i];
            }
        }
        return null;
    }

    public Consulta buscarConsultaAgendada(String cpf) {
        for (int i = 0; i < qtdConsultas; i++) {
            if (consultas[i].paciente.cpf.equals(cpf) && consultas[i].statusConsulta.equals("Agendada")) {
                return consultas[i];
            }
        }
        return null;
    }

    public Consulta buscarConsultaRealizada(String cpf) {
        for (int i = 0; i < qtdConsultas; i++) {
            if (consultas[i].paciente.cpf.equals(cpf) && consultas[i].statusConsulta.equals("Realizada")) {
                return consultas[i];
            }
        }
        return null;
    }
}
