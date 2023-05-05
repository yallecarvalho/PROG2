package controle.de.alunos;

import java.util.Scanner;

/* Classe para realização das interações com o usuário.
 * @author Yalle Carvalho - 119210523
 */

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ControleDeAlunos controleDeAlunos = new ControleDeAlunos();
		
		while(true){
		System.out.println(
				"\n---\nMENU\n" + 
						"(C)adastrar Aluno\n" + 
						"(E)xibir Aluno\n" + 
						"(N)ovo Grupo\n" +
						"(A)locar Aluno no Grupo e Verificar pertinência a Grupos\n" +
						"(R)egistrar Aluno que Respondeu\n" +
						"(I)mprimir Alunos que Responderam\n"+
						"(O)xe, e a contagem dos grupos com restrição de curso?\n" +
						"(S)im, quero fechar o programa!\n" + 
						"\n" + 
						"Opção> ");
		String escolha = sc.next().toUpperCase().trim();
	
			switch(escolha) {
			case "C":
				System.out.print("Matrícula: ");
				sc.nextLine();
				String matricula = sc.nextLine();
				System.out.print("Nome: ");
				String nome = sc.nextLine();
				System.out.print("Curso: ");
				String curso = sc.nextLine();
				if (controleDeAlunos.cadastraAluno(matricula, nome, curso)) {
					System.out.println("CADASTRADO REALIZADO!");
				} else {
					System.out.println("MATRÍCULA JÁ CADASTRADA!");
				}
				System.out.println();
				
				break;
			case "E":
				System.out.print("Matrícula: ");
				sc.nextLine();
				matricula = sc.nextLine();
				System.out.println(controleDeAlunos.exibeAluno(matricula));
				break;
			case "N":
				System.out.print("Grupo: ");
				sc.nextLine();
				String nomeGrupo = sc.nextLine();
				System.out.print("Restrição? ");
				String restricao = sc.nextLine();
				if (controleDeAlunos.cadastraGrupo(nomeGrupo, restricao)) {
					System.out.println("CADASTRADO REALIZADO!");
				} else {
					System.out.println("GRUPO JÁ CADASTRADO!");
				}
				System.out.println();
				break;
			case "A":
				System.out.println("(A)locar Aluno ou (P)ertinência a Grupo?");
				sc.nextLine();
				String opcao = sc.nextLine().toUpperCase().trim();
				if (opcao.equals("A")) {
					System.out.print("Matrícula: ");
					matricula = sc.nextLine();
					System.out.print("Grupo: ");
					nomeGrupo = sc.nextLine();
					System.out.println(controleDeAlunos.alocaAluno(matricula, nomeGrupo));
				} else if (opcao.equals("P")) {
					System.out.println("Grupo: ");
					nomeGrupo = sc.nextLine();
					System.out.println("Matrícula: ");
					matricula = sc.nextLine();
					System.out.println(controleDeAlunos.pertenceAoGrupo(nomeGrupo, matricula));
				} else {
					throw new IllegalArgumentException("Opção inválida");
				}
				break;
			case "R":
				sc.nextLine();
				System.out.print("Matrícula: ");
				matricula = sc.nextLine();
				System.out.println(controleDeAlunos.cadastraRespostaNoQuadro(matricula));
				break;
			case "I":
				System.out.print(controleDeAlunos.imprimeAlunosParticipativos());
				break;
			case "O":
				sc.nextLine();
				System.out.print("Curso: ");
				curso = sc.nextLine();
				System.out.print(controleDeAlunos.contaRestricao(curso));
				break;
			case "S":
				System.exit(0);
			default: 
				System.out.println("Opção inexistente");
				System.out.println();
				break;
			}
		}

	}

}
