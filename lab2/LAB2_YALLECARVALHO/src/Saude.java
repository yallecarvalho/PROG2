/**
 * Representação da saúde do aluno.
 * O status geral do aluno é uma junção da sua saúde mental e física.
 *
 * @author Yalle Carvalho - 119210523
 */
public class Saude {
    /**
     * Estado da saúde mental do aluno
     */
    private String saudeMental;
    /**
     * Estado da saúde física do aluno
     */
    private String saudeFisica;
    /**
     * Estado da saúde geral do aluno.
     */
    private String saudeGeral;

    /**
     * Constrói a saúde do aluno, iniciando o estado de saúde física e mental como bom.
     */
    public Saude(){
        saudeMental = "boa";
        saudeFisica = "boa";
    }
    /**
     * Método para definir a saúde mental do aluno.
     * @param valor representa o estado de saúde, podendo ser 'boa' ou 'fraca.
     */
    public void defineSaudeMental(String valor){
        saudeMental = valor;
    }

    /**
     * Método para definir a saúde física do aluno
     * @param valor representa o estado de saúde, podendo ser 'boa' ou 'fraca
     */
    public void defineSaudeFisica(String valor){
        saudeFisica = valor;
    }

    /**
     * Método para verificar o estado da saúde geral do aluno, podendo ser "boa", "fraca" ou "ok",
     * a depender da junção da saúde física + saúde mental
     * @return um String com o estado de saúde geral do aluno
     */
    public String getStatusGeral(){
        if (saudeMental.equals(saudeFisica)){
            saudeGeral = saudeMental; }
        else {
            saudeGeral = "ok"; }
        return saudeGeral;
        }
}