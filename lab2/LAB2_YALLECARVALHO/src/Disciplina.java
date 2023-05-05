import java.util.Arrays;
/**
 * Representação de uma disciplina do curso de Ciência da Computação.
 * @author Yalle Carvalho - 119210523
 */
public class Disciplina {

    /**
     * Nome da disciplina que o aluno quer registrar.
     */
    private String nomeDisciplina;
    /**
     * Horas de estudo dedicada a disciplina.
     */
    private int horas;
    /**
     * Array que vai ser usado para armazenar o valor das notas obtidas na disciplina.
     * Possui 4 posições, uma para cada nota.
     */
    private double[] notas = new double[4];
    /**
     * Varíavel onde será armazenado o total de notas para obtenção da média.
     */
    private double totalNotas;
    /**
     * Média obtida pelo aluno na disciplina.
     */
    private double media;
    /**
     * String usada para representar o array de notas.
     */
    private String arrayDeNotas;

    /**
     * Constrói uma disciplina a partir do seu nome.
     * @param nomeDisciplina nome da disciplina
     */
    public Disciplina(String nomeDisciplina) {
        this.nomeDisciplina = nomeDisciplina;
    }

    /**
     * Método usado para cadastrar o número de horas dedicadas ao estudo da disciplina.
     * @param horas horas dedicadas pelo aluno
     */
    public void cadastraHoras(int horas) {
        this.horas += horas;
    }

    /**
     * Método usado para cadastrar as notas obtidas pelo aluno na disciplina. O aluno pode obter 4 notas,
     * e as notas podem ser cadastradas mais de uma vez, sendo considerada apenas a última.
     * @param nota número da nota
     * @param valorNota valor da nota obtida
     */
    public void cadastraNota(int nota, double valorNota) {
        notas[nota - 1] = valorNota;

        arrayDeNotas = Arrays.toString(notas);

    }

    /**
     * Método usado para o cálculo da média do aluno através da soma das notas e sua divisão por quatro.
     * @return media;
     */
    private double calculaMedia() {
        for (int i = 0; i < notas.length; i++) {
            totalNotas += notas[i];
        }
        media = totalNotas/4;
        totalNotas = 0;
        return media;
    }

    /**
     * Método para verificar se o aluno foi aprovado ou não na disciplina.
     * É necessário uma média igual ou maior que  7.0 para ser aprovado.
     * @return boolean baseado no valor da média
     */
    public boolean aprovado() {
        return calculaMedia() >= 7;
    }

    /**
     * Retorna a String que representa a Disciplina. A representação segue o formato "Disciplina, horas dedicadas, média, conjunto de notas obtidas
     * @return a representação em String de uma disciplina.
     */
    @Override
    public String toString(){
        return this.nomeDisciplina + " " + this.horas + " " + this.calculaMedia() + " " + this.arrayDeNotas;
    }
}

