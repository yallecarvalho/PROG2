package controle.de.alunos;

/**
 * Representa um aluno no controle de alunos. Cada aluno é representado por sua matrícula, seu nome e o seu curso. 
 * @author Yalle Carvalho - 119210523
 *
 */
public class Aluno {

	/**
	 * Matrícula do aluno
	 */
	private String matricula;
	/**
	 * Nome do aluno
	 */
	private String nome;
	/**
	 * Curso do aluno
	 */
	private String curso;
	
	/**
	 * Cria um aluno. 
	 * @param matricula matricula do aluno
	 * @param nome nome do aluno
	 * @param curso curso do aluno
	 */
	public Aluno (String matricula, String nome, String curso) {
		
		if (matricula.isBlank()) {
			throw new IllegalArgumentException("Matrícula inválida");
		} 
		if (nome.isBlank()) {
			throw new IllegalArgumentException("Nome inválido");
		}
		if (curso.isBlank()) {
			throw new IllegalArgumentException("Curso inválido");
		} 
		this.matricula = matricula;
		this.nome = nome;
		this.curso = curso;
	
	}
	/**
	 * Retorna a matrícula do aluno
	 * @return matrícula
	 */
	public String getMatricula() {
		return this.matricula;
		
	}
	/**
	 * Retorna o nome do aluno
	 * @return nome
	 */
	public String getNome() {
		return this.nome;
	}
	/**
	 * Retorna o curso do aluno
	 * @return curso
	 */
	public String getCurso() {
		return this.curso;
	}
	/**
	 * Retorna uma representação do aluno em string, contendo sua matrícula, nome e curso. 
	 * @return a representação do aluno
	 */
	@Override
	public String toString() {
		return matricula + " - " + nome + " - " + curso;
	}
	/**
	 * Retorna o código hash do objeto aluno.
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((matricula == null) ? 0 : matricula.hashCode());
		return result;
	}
	/**
	 * Checa se dois alunos são iguais de acordo com o número da sua matrícula. 
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Aluno other = (Aluno) obj;
		if (matricula == null) {
			if (other.matricula != null)
				return false;
		} else if (!matricula.equals(other.matricula))
			return false;
		return true;
	}
}
