package agenda;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

/**
 * Interface com menus texto para manipular uma agenda de contatos.
 * 
 * @author nazarenoandrade e Yalle Carvalho - 119210523
 *
 */
public class MainAgenda {

	public static void main(String[] args) {
		Agenda agenda = new Agenda();

		System.out.println("Carregando agenda inicial");
		try {
			/*
			 * Essa é a maneira de lidar com possíveis erros por falta do arquivo. 
			 */
			carregaAgenda("agenda_inicial.csv", agenda);
		} catch (FileNotFoundException e) {
			System.err.println("Arquivo não encontrado: " + e.getMessage());
		} catch (IOException e) {
			System.err.println("Erro lendo arquivo: " + e.getMessage());
		}

		Scanner scanner = new Scanner(System.in);
		String escolha = "";
		while (true) {
			escolha = menu(scanner);
			comando(escolha, agenda, scanner);
		}

	}

	/**
	 * Exibe o menu e captura a escolha do/a usuário/a.
	 * 
	 * @param scanner Para captura da opção do usuário.
	 * @return O comando escolhido.
	 */
	private static String menu(Scanner scanner) {
		System.out.println(
				"\n---\nMENU\n" + 
						"(C)adastrar Contato\n" + 
						"(L)istar Contatos\n" + 
						"(E)xibir Contato\n" +
						"(F)avoritos\n" +
						"(A)dicionar Favorito\n" +
						"(S)air\n" + 
						"\n" + 
						"Opção> ");
		return scanner.next().toUpperCase();
	}

	/**
	 * Interpreta a opção escolhida por quem está usando o sistema.
	 * 
	 * @param opcao   Opção digitada.
	 * @param agenda  A agenda que estamos manipulando.
	 * @param scanner Objeto scanner para o caso do comando precisar de mais input.
	 */
	private static void comando(String opcao, Agenda agenda, Scanner scanner) {
		switch (opcao) {
		case "C":
			cadastraContato(agenda, scanner);
			break;
		case "L":
			listaContatos(agenda);
			break;
		case "E":
			exibeContato(agenda, scanner);
			break;
		case "F":
			listaFavoritos(agenda);
			break;
		case "A":
			adicionaFavorito(agenda, scanner);
			break;
		case "S":
			sai();
			break;
		default:
			System.out.println("Opção inválida!");
		}
	}

	/**
	 * Imprime lista de contatos da agenda.
	 * 
	 * @param agenda A agenda sendo manipulada.
	 */
	private static void listaContatos(Agenda agenda) {
		System.out.println("\nLista de contatos: ");
		System.out.println(agenda.listaContatos());
	}

	/**
	 * Imprime os detalhes de um dos contatos da agenda. 
	 * 
	 * @param agenda A agenda.
	 * @param scanner Scanner para capturar qual contato.
	 */
	private static void exibeContato(Agenda agenda, Scanner scanner) {
		System.out.print("\nQual contato> ");
		int posicao = scanner.nextInt();
		System.out.println("\n" + agenda.exibeContato(posicao));
	}

	/**
	 * Imprime a lista de contatos favoritos existente
	 * @param agenda A agenda
	 */
	private static void listaFavoritos(Agenda agenda) {
		System.out.println("\n Lista de favoritos: ");
		System.out.println(agenda.listaFavoritos());}

	/**
	 * Adiciona um contato da agenda como favorito. Caso o contato ja esteja na lista de favoritos, ele não será cadastrado novamente.
	 * @param agenda A agenda.
	 * @param scanner Scanner para pedir informações do contato.
	 */
	private static void adicionaFavorito(Agenda agenda, Scanner scanner) {
		System.out.print("\nContato> ");
		int contato = scanner.nextInt();
		System.out.print("\nPosição> ");
		int posicao = scanner.nextInt();
		if (agenda.testaFavoritos(contato)) {
			System.out.println("FAVORITO JÁ CADASTRADO!");
		} else {
			agenda.cadastraFavorito(contato, posicao);
			System.out.print("\nCONTATO FAVORITADO NA POSIÇÃO " + posicao + "!");
		}
	}
	/**
	 * Cadastra um contato na agenda. 
	 * 
	 * @param agenda A agenda.
	 * @param scanner Scanner para pedir informações do contato.
	 */
	private static void cadastraContato(Agenda agenda, Scanner scanner) {
		System.out.print("\nPosição na agenda> ");
		int posicao = scanner.nextInt();
		if (posicao < 1 || posicao > 100) {
			System.out.println("POSIÇÃO INVÁLIDA");
		} else {
			scanner.nextLine();
			System.out.print("\nNome> ");
			String nome = scanner.nextLine();
			if (nome == null || nome.isBlank()) {
				throw new IllegalArgumentException("Nome nulo.");
			}
			System.out.print("\nSobrenome> ");
			String sobrenome = scanner.nextLine();
			if (sobrenome == null || sobrenome.isBlank()) {
				throw new IllegalArgumentException("Sobrenome nulo.");
			}
			String nomeCompleto = nome + " " + sobrenome;
			if (agenda.testaContatosIguais(nomeCompleto)) {
				System.out.println("CADASTRO JÁ REALIZADO!");
			} else {
				System.out.print("\nPrioritário> ");
				String prioritario = scanner.nextLine();
				if (prioritario == null || prioritario.isBlank()) {
					throw new IllegalArgumentException("Telefone nulo. É necessário cadastrar um telefone prioritário.");
				}
				System.out.print("\nWhatsapp> ");
				String whats = scanner.nextLine();
				if (whats == null || whats.isBlank()) {
					throw new IllegalArgumentException("Telefone nulo. É necessário cadastrar um telefone whatsapp");
				}
				System.out.print("\nAdicional> ");
				String adicional = scanner.nextLine();

				agenda.cadastraContato(posicao, nome, sobrenome, prioritario, whats, adicional);
				System.out.print("\nCADASTRO REALIZADO");
			}
		}
	}
	/**
	 * Sai da aplicação.
	 */
	private static void sai() {
		System.out.println("\nVlw flw o/");
		System.exit(0);
	}

	/**
	 * Lê uma agenda de um arquivo csv. 
	 * 
	 * @param arquivoContatos O caminho para o arquivo.
	 * @param agenda A agenda que deve ser populada com os dados. 
	 * @throws IOException Caso o arquivo não exista ou não possa ser lido.
	 */
	private static void carregaAgenda(String arquivoContatos, Agenda agenda) throws FileNotFoundException, IOException {
		LeitorDeAgenda leitor = new LeitorDeAgenda();
		
		int carregados =  leitor.carregaContatos(arquivoContatos, agenda);
		System.out.println("Carregamos " + carregados + " registros.");
	}
}
