package controle.de.alunos;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Representa um controle de alunos, que irá controlar todas os alunos e grupos de estudo e qualquer inteiração sobre eles. 
 * @author  Yalle Carvalho - 119210523
 *
 */

public class ControleDeAlunos {
	
	/**
	 * Mapa de alunos, onde acontece o mapeamento do identificador de aluno, que nesse caso é a matrícula do aluno e os dados do aluno.
	 */
	private HashMap<String, Aluno> alunos;
	/**
	 * Mapa de grupos de estudo, onde acontece o mapeamento do identificador de grupos, que nesse caso é o nome do grupo e os dados do grupo. 
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
	 * Cadastra alunos no controle de alunos a partir de sua matrícula, nome e curso. 
	 * Caso a matrícula recebida já esteja associada com um aluno, o cadastro não é realizado
	 * @param matricula matricula do aluno
	 * @param nome nome do aluno
	 * @param curso curso do aluno
	 * @return um booleano que representa se o cadastro foi realizado ou não. 
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
	 * Exibe os dados de um aluno através de sua matrícula
	 * @param matricula matrícula do aluno
	 * @return a representação do aluno. 
	 */
	public String exibeAluno(String matricula) {
		String saida = ""; 
		if(matricula.isBlank()) {
				throw new IllegalArgumentException("Matrícula inválida!");
		} else {
			if(alunos.containsKey(matricula)) {
				saida = "Aluno: " + this.alunos.get(matricula).toString();
		} else {
			saida = "ALUNO NÃO CADASTRADO."; 
		} 
		} return saida;
	}
		
	/**
	 * Cadastra um grupo de estudos no controle de alunos.
	 * @param nomeGrupo nome do grupo de estudos
	 * @param restricao curso que restringe o grupo
	 * @return um booleano que representa se o cadastro foi realizado ou não.
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
	 * @return retorna uma String que diz se o aluno foi alocado ou não no grupo de estudos. 
	 */
	public String alocaAluno(String matricula, String nomeGrupo) {
		String saida = "";
		if  (matricula.isBlank() && nomeGrupo.isBlank())  {
			throw new IllegalArgumentException("Paramêtros inválidos!");
		} else if (matricula.isBlank() || nomeGrupo.isBlank()) {
			throw new IllegalArgumentException("Matrícula inválida!");
		} else if(nomeGrupo.isBlank()){
			throw new IllegalArgumentException("Grupo inválido!");
		} else {
			nomeGrupo = nomeGrupo.toUpperCase();
			if (grupos.containsKey(nomeGrupo) && alunos.containsKey(matricula)) {
				if (!grupos.get(nomeGrupo).getRestricao().toUpperCase().equals(alunos.get(matricula).getCurso().toUpperCase())) {
						grupos.get(nomeGrupo).getAlunosNoGrupo().add(alunos.get(matricula));
						saida = "ALUNO ALOCADO!";
				} else { 
					saida = "GRUPO COM RESTRIÇÃO DE CURSO";
				}
			} else if(!alunos.containsKey(matricula) && grupos.containsKey(nomeGrupo)) {
				saida = "ALUNO NÃO CADASTRADO.";
			} else if(!grupos.containsKey(nomeGrupo) && alunos.containsKey(matricula)) {
				saida = "GRUPO NÃO CADASTRADO";
			} else {
				saida = "GRUPO E ALUNOS NÃO CADASTRADOS";
			}
		}
		return saida;
	}
	/**
	 * Checa se um aluno pertence a um grupo de estudos através da sua matrícula e do nome do grupo.
	 * @param nomeGrupo nome do grupo
	 * @param matricula matricula do aluno
	 * @return retorna um booleano que representa se o aluno faz parte do grupo ou não. 
	 */
	public String pertenceAoGrupo(String nomeGrupo, String matricula) {
		String saida = "";
		if  (matricula.isBlank() && nomeGrupo.isBlank())  {
			throw new IllegalArgumentException("Paramêtros inválidos!");
		} else if (matricula.isBlank() || nomeGrupo.isBlank()) {
			throw new IllegalArgumentException("Matrícula inválida!");
		} else if(nomeGrupo.isBlank()){
			throw new IllegalArgumentException("Grupo inválido!");
		} else {
			nomeGrupo = nomeGrupo.toUpperCase();
			if (!alunos.containsKey(matricula)) {
				saida = "ALUNO NÃO CADASTRADO";
			} else {
				if (grupos.containsKey(nomeGrupo)) {
						if(grupos.get(nomeGrupo).checarMatricula().contains(matricula)){
							saida = "ALUNO PERTENCE AO GRUPO";
						} else {
							saida = "ALUNO NÃO PERTENCE AO GRUPO"; 
						} 
				} else {
					saida = "GRUPO NÃO CADASTRADO";
				}
			}
		} return saida;
	}
	/**
	 * Cadastra alunos que responderam questões no quadro
	 * @param matricula matricula do aluno
	 * @return uma string que confirma se o aluno foi registrado
	 */
	public String cadastraRespostaNoQuadro(String matricula) {
		 if(matricula.isBlank()) {
				throw new IllegalArgumentException("Matrícula inválida");
			} else {
				String saida = "";
				if(!alunos.containsKey(matricula)) {
					saida = "ALUNO NÃO CADASTRADO!";
					} else { 
						alunosParticipativos.add(alunos.get(matricula));
						saida = "ALUNO REGISTRADO!";
				} return saida;
			}
		}
	/**
	 * Imprime a lista de alunos que responderam questões no quadro
	 * @return a lista de alunos
	 */
	public String imprimeAlunosParticipativos() {
		String saida = "";
		if (alunosParticipativos.isEmpty()) {
			throw new NullPointerException("Não há alunos registrados.");
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
	 * Retorna o número de grupos que possuem esse curso como restrição
	 * @param curso curso do aluno
	 * @return uma string com o curso e o número de grupos que o tem como restrição
	 */
	public String contaRestricao(String curso) {
		int restricao = 0;
		String saida = curso + " " + restricao + "\n";
		if(curso.isBlank()) {
			throw new IllegalArgumentException("Curso inválido");
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
