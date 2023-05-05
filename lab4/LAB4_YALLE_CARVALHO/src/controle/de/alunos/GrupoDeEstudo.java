package controle.de.alunos;

import java.util.HashSet;

/**
 * Representa um grupo de estudos no controle de alunos. Cada grupo � representado por seu nome e sua restri��o (quando houver)
 * @author Yalle Carvalho - 119210523
 *
 */

public class GrupoDeEstudo {
	
	/**
	 * Nome do grupo de estudos.
	 */
	private String nomeGrupo;
	/**
	 * Curso que restringe o grupo.
	 */
	private String restricao;
	/**
	 * Conjunto de alunos em um grupo. 
	 */
	private HashSet<Aluno> alunos;
	
	/**
	 * Constr�i um grupo de estudos e inicializa o conjunto de alunos. 
	 * @param nomeGrupo nome do grupo
	 * @param restricao curso que restringe o grupo
	 */
	public GrupoDeEstudo(String nomeGrupo, String restricao) {
		if (nomeGrupo.isBlank()) {
			throw new IllegalArgumentException("Nome inv�lido");
		}
		
		this.nomeGrupo = nomeGrupo;
		this.restricao = restricao;
		this.alunos = new HashSet<>();
	}
	
	/**
	 * Retorna o nome de um grupo de estudos.
	 * @return nome do grupo
	 */
	public String getNome(){
		return this.nomeGrupo;	
	}
	/**
	 * Retorna a restri��o de um grupo de estudos.
	 * @return a restri��o
	 */
	public String getRestricao(){
		return this.restricao;
	}

	/**
	 * Retorna o conjunto de alunos.
	 * @return conjunto de alunos
	 */
	public HashSet<Aluno> getAlunosNoGrupo(){
		return this.alunos;
	}
	
	/**
	 * Checa os alunos que est�o em um grupo atrav�s da matr�cula
	 * @return todas as matriculas (alunos) que fazem parte do grupo
	 */
	public String checarMatricula(){
		String matriculas = "";
		for (Aluno a: this.alunos) {
			matriculas += a.getMatricula() + "\n";
		} return matriculas;
	}
	/**
	 * Retorna o c�digo hash do objeto Grupo de Estudo.
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nomeGrupo == null) ? 0 : nomeGrupo.hashCode());
		return result;
	}
	/**
	 * Checa se dois grupos s�o iguais de acordo com o nome do grupo. 
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		GrupoDeEstudo other = (GrupoDeEstudo) obj;
		if (nomeGrupo == null) {
			if (other.nomeGrupo != null)
				return false;
		} else if (!nomeGrupo.equals(other.nomeGrupo))
			return false;
		return true;
	}
	
}