package controle.de.alunos;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Representa um controle de alunos, que ir� controlar todas os alunos e grupos de estudo e qualquer inteira��o sobre eles. 
 * @author  Yalle Carvalho - 119210523
 *
 */

public class ControleDeAlunos {
	
	/**
	 * Mapa de alunos, onde acontece o mapeamento do identificador de aluno, que nesse caso � a matr�cula do aluno e os dados do aluno.
	 */
	private HashMap<String, Aluno> alunos;
	/**
	 * Mapa de grupos de estudo, onde acontece o mapeamento do identificador de grupos, que nesse caso � o nome do grupo e os dados do grupo. 
	 */
	private HashMap<String, GrupoDeEstudo> grupos;
	
	/**
	 * Lista de alunos participativos, no caso, que responderam perguntas no quadro.
	 */
	private ArrayList<Aluno> alunosParticipativos;
	
	/**
	 * Cria um controle de alunos, iniciando o mapa de alunos e o mapa de grupos de estudo.
	 */
	public ControleDeAlunos() {
		alunos = new HashMap<>();
		grupos = new HashMap<>();
		alunosParticipativos = new ArrayList<>();
		
	
	}
	/**
	 * Cadastra alunos no controle de alunos a partir de sua matr�cula, nome e curso. 
	 * Caso a matr�cula recebida j� esteja associada com um aluno, o cadastro n�o � realizado
	 * @param matricula matricula do aluno
	 * @param nome nome do aluno
	 * @param curso curso do aluno
	 * @return um booleano que representa se o cadastro foi realizado ou n�o. 
	 */
	public boolean cadastraAluno(String matricula, String nome, String curso) {
		boolean cadastra = true;
		if (alunos.containsKey(matricula)) {
			cadastra = false;
		} else {
			alunos.put(matricula, new Aluno(matricula, nome, curso));
		}
		return cadastra;
	}
	/**
	 * Exibe os dados de um aluno atrav�s de sua matr�cula
	 * @param matricula matr�cula do aluno
	 * @return a representa��o do aluno. 
	 */
	public String exibeAluno(String matricula) {
		String saida = ""; 
		if(matricula.isBlank()) {
				throw new IllegalArgumentException("Matr�cula inv�lida!");
		} else {
			if(alunos.containsKey(matricula)) {
				saida = "Aluno: " + this.alunos.get(matricula).toString();
		} else {
			saida = "ALUNO N�O CADASTRADO."; 
		} 
		} return saida;
	}
		
	/**
	 * Cadastra um grupo de estudos no controle de alunos.
	 * @param nomeGrupo nome do grupo de estudos
	 * @param restricao curso que restringe o grupo
	 * @return um booleano que representa se o cadastro foi realizado ou n�o.
	 */
	public boolean cadastraGrupo(String nomeGrupo, String restricao) {
		boolean cadastra = true;
			nomeGrupo = nomeGrupo.toUpperCase();
			if (grupos.containsKey(nomeGrupo)) {
				cadastra = false;
			} else {
				grupos.put(nomeGrupo, new GrupoDeEstudo(nomeGrupo, restricao));
			} return cadastra;
	}
	/**
	 * Aloca um aluno em um grupo de estudos
	 * @param matricula matricula do aluno
	 * @param nomeGrupo nome do grupo de estudos
	 * @return retorna uma String que diz se o aluno foi alocado ou n�o no grupo de estudos. 
	 */
	public String alocaAluno(String matricula, String nomeGrupo) {
		String saida = "";
		if  (matricula.isBlank() && nomeGrupo.isBlank())  {
			throw new IllegalArgumentException("Param�tros inv�lidos!");
		} else if (matricula.isBlank() || nomeGrupo.isBlank()) {
			throw new IllegalArgumentException("Matr�cula inv�lida!");
		} else if(nomeGrupo.isBlank()){
			throw new IllegalArgumentException("Grupo inv�lido!");
		} else {
			nomeGrupo = nomeGrupo.toUpperCase();
			if (grupos.containsKey(nomeGrupo) && alunos.containsKey(matricula)) {
				if (!grupos.get(nomeGrupo).getRestricao().toUpperCase().equals(alunos.get(matricula).getCurso().toUpperCase())) {
						grupos.get(nomeGrupo).getAlunosNoGrupo().add(alunos.get(matricula));
						saida = "ALUNO ALOCADO!";
				} else { 
					saida = "GRUPO COM RESTRI��O DE CURSO";
				}
			} else if(!alunos.containsKey(matricula) && grupos.containsKey(nomeGrupo)) {
				saida = "ALUNO N�O CADASTRADO.";
			} else if(!grupos.containsKey(nomeGrupo) && alunos.containsKey(matricula)) {
				saida = "GRUPO N�O CADASTRADO";
			} else {
				saida = "GRUPO E ALUNOS N�O CADASTRADOS";
			}
		}
		return saida;
	}
	/**
	 * Checa se um aluno pertence a um grupo de estudos atrav�s da sua matr�cula e do nome do grupo.
	 * @param nomeGrupo nome do grupo
	 * @param matricula matricula do aluno
	 * @return retorna um booleano que representa se o aluno faz parte do grupo ou n�o. 
	 */
	public String pertenceAoGrupo(String nomeGrupo, String matricula) {
		String saida = "";
		if  (matricula.isBlank() && nomeGrupo.isBlank())  {
			throw new IllegalArgumentException("Param�tros inv�lidos!");
		} else if (matricula.isBlank() || nomeGrupo.isBlank()) {
			throw new IllegalArgumentException("Matr�cula inv�lida!");
		} else if(nomeGrupo.isBlank()){
			throw new IllegalArgumentException("Grupo inv�lido!");
		} else {
			nomeGrupo = nomeGrupo.toUpperCase();
			if (!alunos.containsKey(matricula)) {
				saida = "ALUNO N�O CADASTRADO";
			} else {
				if (grupos.containsKey(nomeGrupo)) {
						if(grupos.get(nomeGrupo).checarMatricula().contains(matricula)){
							saida = "ALUNO PERTENCE AO GRUPO";
						} else {
							saida = "ALUNO N�O PERTENCE AO GRUPO"; 
						} 
				} else {
					saida = "GRUPO N�O CADASTRADO";
				}
			}
		} return saida;
	}
	/**
	 * Cadastra alunos que responderam quest�es no quadro
	 * @param matricula matricula do aluno
	 * @return uma string que confirma se o aluno foi registrado
	 */
	public String cadastraRespostaNoQuadro(String matricula) {
		 if(matricula.isBlank()) {
				throw new IllegalArgumentException("Matr�cula inv�lida");
			} else {
				String saida = "";
				if(!alunos.containsKey(matricula)) {
					saida = "ALUNO N�O CADASTRADO!";
					} else { 
						alunosParticipativos.add(alunos.get(matricula));
						saida = "ALUNO REGISTRADO!";
				} return saida;
			}
		}
	/**
	 * Imprime a lista de alunos que responderam quest�es no quadro
	 * @return a lista de alunos
	 */
	public String imprimeAlunosParticipativos() {
		String saida = "";
		if (alunosParticipativos.isEmpty()) {
			throw new NullPointerException("N�o h� alunos registrados.");
		} else {
			saida = "Alunos: \n";
			int numeroDoAluno = 0;
			for (int i = 0; i < alunosParticipativos.size(); i++) {
				numeroDoAluno++;
				saida += Integer.toString(numeroDoAluno) + ". " + alunosParticipativos.get(i) + "\n";
			} 
		} return saida;	
	}
	/**
	 * Retorna o n�mero de grupos que possuem esse curso como restri��o
	 * @param curso curso do aluno
	 * @return uma string com o curso e o n�mero de grupos que o tem como restri��o
	 */
	public String contaRestricao(String curso) {
		int restricao = 0;
		String saida = curso + " " + restricao + "\n";
		if(curso.isBlank()) {
			throw new IllegalArgumentException("Curso inv�lido");
		} else {
			for (GrupoDeEstudo grupo: this.grupos.values()) {
				if(!grupo.getRestricao().isBlank() && grupo.getRestricao().toUpperCase().equals(curso.toUpperCase())) {
					restricao++;
					saida = curso + " " + restricao + "\n";
				}
			}
		} return saida;
	}

}
