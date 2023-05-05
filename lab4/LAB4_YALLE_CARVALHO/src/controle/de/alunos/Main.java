package controle.de.alunos;

import java.util.Scanner;

/* Classe para realiza��o das intera��es com o usu�rio.
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
						"(A)locar Aluno no Grupo e Verificar pertin�ncia a Grupos\n" +
						"(R)egistrar Aluno que Respondeu\n" +
						"(I)mprimir Alunos que Responderam\n"+
						"(O)xe, e a contagem dos grupos com restri��o de curso?\n" +
						"(S)im, quero fechar o programa!\n" + 
						"\n" + 
						"Op��o> ");
		String escolha = sc.next().toUpperCase().trim();
	
			switch(escolha) {
			case "C":
				System.out.print("Matr�cula: ");
				sc.nextLine();
				String matricula = sc.nextLine();
				System.out.print("Nome: ");
				String nome = sc.nextLine();
				System.out.print("Curso: ");
				String curso = sc.nextLine();
				if (controleDeAlunos.cadastraAluno(matricula, nome, curso)) {
					System.out.println("CADASTRADO REALIZADO!");
				} else {
					System.out.println("MATR�CULA J� CADASTRADA!");
				}
				System.out.println();
				
				break;
			case "E":
				System.out.print("Matr�cula: ");
				sc.nextLine();
				matricula = sc.nextLine();
				System.out.println(controleDeAlunos.exibeAluno(matricula));
				break;
			case "N":
				System.out.print("Grupo: ");
				sc.nextLine();
				String nomeGrupo = sc.nextLine();
				System.out.print("Restri��o? ");
				String restricao = sc.nextLine();
				if (controleDeAlunos.cadastraGrupo(nomeGrupo, restricao)) {
					System.out.println("CADASTRADO REALIZADO!");
				} else {
					System.out.println("GRUPO J� CADASTRADO!");
				}
				System.out.println();
				break;
			case "A":
				System.out.println("(A)locar Aluno ou (P)ertin�ncia a Grupo?");
				sc.nextLine();
				String opcao = sc.nextLine().toUpperCase().trim();
				if (opcao.equals("A")) {
					System.out.print("Matr�cula: ");
					matricula = sc.nextLine();
					System.out.print("Grupo: ");
					nomeGrupo = sc.nextLine();
					System.out.println(controleDeAlunos.alocaAluno(matricula, nomeGrupo));
				} else if (opcao.equals("P")) {
					System.out.println("Grupo: ");
					nomeGrupo = sc.nextLine();
					System.out.println("Matr�cula: ");
					matricula = sc.nextLine();
					System.out.println(controleDeAlunos.pertenceAoGrupo(nomeGrupo, matricula));
				} else {
					throw new IllegalArgumentException("Op��o inv�lida");
				}
				break;
			case "R":
				sc.nextLine();
				System.out.print("Matr�cula: ");
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
				System.out.println("Op��o inexistente");
				System.out.println();
				break;
			}
		}

	}

}
