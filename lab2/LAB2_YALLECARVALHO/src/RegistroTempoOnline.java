/**
 * Representação do registro do tempo online que o aluno tem dedicado para o estudo da disciplina.
 *
 * @author Yalle Carvalho - 119210523
 */
public class RegistroTempoOnline {

    /**
     * Nome da disciplina
     */
    private String nomeDisciplina;
    /**
     * Tempo online que é esperado que o aluno dedique para a disciplina.
     */
    private int tempoOnlineEsperado;
    /**
     * Tempo total dedicado online para disciplina.
     */
    private int tempoTotal;

    /**
     * Constrói um registro para controle do tempo online dedicado através do nome da disciplina e
     * o tempo padrão esperado de estudo.
     * @param nomeDisciplina nome da disciplina
     */
    public RegistroTempoOnline(String nomeDisciplina) {
        this.nomeDisciplina = nomeDisciplina;
        tempoOnlineEsperado = 120;
    }

    /**
     * Constrói um registro para controle do tempo online dedicado através do nome da disciplina
     * e o tempo esperado de dedicação para mesma.
     * @param nomeDisciplina nome da disciplina
     * @param tempoOnlineEsperado tempo online que se espera que o aluno dedique pra disciplina
     */
    public RegistroTempoOnline(String nomeDisciplina, int tempoOnlineEsperado) {
        this.nomeDisciplina = nomeDisciplina;
        this.tempoOnlineEsperado = tempoOnlineEsperado;
    }

    /**
     * Método usado para adicionar o tempo fracionado que o aluno dedica ao estudo da disciplina ao tempo total.
     * @param tempo tempo usado no momento atual.
     */
    public void adicionaTempoOnline(int tempo) {
        tempoTotal += tempo;
    }

    /**
     * Método para verificar se o aluno atingiu a meta do tempo online esperado para dedicação a disciplina.
     * @return boolean baseado no atingimento da meta.
     */
    public boolean atingiuMetaTempoOnline() {
        if (tempoTotal >= tempoOnlineEsperado) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Retorna a String que representa o registro do tempo online.
     * A representação segue o formato "Nome da disciplina, tempo total dedicado, tempo esperado".
     * @return a representação em String do registro de tempo.
     */
    public String toString () {
            return this.nomeDisciplina + " " + this.tempoTotal + "/" + this.tempoOnlineEsperado;
        }
}