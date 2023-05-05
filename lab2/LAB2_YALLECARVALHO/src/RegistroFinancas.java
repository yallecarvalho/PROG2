/**
 * Representação das finanças de um aluno para auxílio no controle dos seus gastos.
 * Esse controle é feito através do registro das receitas e despesas do aluno
 *
 * @author Yalle Carvalho - 119210523
 */
public class RegistroFinancas {
    /**
     * receita inicial advinda da fonte de reda tipo 1
     */
    private int receitaInicialDoTipo1;
    /**
     * receita inicial advinda da fonte de reda tipo 2
     */
    private int receitaInicialDoTipo2;
    /**
     * receita inicial advinda da fonte de reda tipo 3
     */
    private int receitaInicialDoTipo3;
    /**
     * receita inicial advinda da fonte de reda tipo 4
     */
    private int receitaInicialDoTipo4;
    /**
     * Receita total do aluno, somando todas as rendas e não levando em consideração as despesas.
     */
    private int receitaTotal;
    /**
     * Despesa total do aluno.
     */
    private int despesaTotal;
    /**
     * Receita atual do aluno, valor sem as despesas.
     */
    private int receitaAtual;

    /**
     * Constrói o registo das finanças do aluno, com objetivo de controlar suas receitas e despesas.
     * @param receitaInicialDoTipo1 primeira receita recebida, da fonte 1.
     */
    public RegistroFinancas(int receitaInicialDoTipo1){
        this.receitaInicialDoTipo1 = receitaInicialDoTipo1;
        this.receitaInicialDoTipo2 = 0;
        this.receitaInicialDoTipo3 = 0;
        this.receitaInicialDoTipo4 = 0;
    }

    /**
     * Método usado para receber novas receitas e aumentar a receita total do aluno.
     * @param valorCentavos valor em centavos da receita
     * @param tipoFonte fonte de renda 1, 2, 3 ou 4.
     */
    public void aumentaReceita(int valorCentavos, int tipoFonte){
        if (tipoFonte == 1) { receitaInicialDoTipo1 += valorCentavos; }
        else if (tipoFonte == 2) {receitaInicialDoTipo2 += valorCentavos;}
        else if (tipoFonte == 3) {receitaInicialDoTipo3 += valorCentavos;}
        else {
            receitaInicialDoTipo4 += valorCentavos;
        }
    }

    /**
     * Método usado para receber novas despesas e atualizar o valor da receita atual e da despesa total.
     * @param valorCentavos valor da despesa registrada
     */
    public void pagaDespesa(int valorCentavos){
        receitaTotal = receitaInicialDoTipo1 + receitaInicialDoTipo2 + receitaInicialDoTipo3 + receitaInicialDoTipo4;
        receitaAtual = receitaTotal - valorCentavos;
        despesaTotal += valorCentavos; }

    /**
     * Método usado para exibir as fontes e suas respectivas receitas acumuladas.
     * @return retorna uma String com todas as fontes e suas receitas acumuladas.
     */
    public String exibeFontes(){
        String fonte1 = "1 - " + receitaInicialDoTipo1;
        String fonte2 = "2 - " + receitaInicialDoTipo2;
        String fonte3 = "3 - " + receitaInicialDoTipo3;
        String fonte4 = "4 - " + receitaInicialDoTipo4;
        return fonte1 + "\n" + fonte2 + "\n" + fonte3 + "\n" + fonte4; }
    /**
     * Retorna a String que representa o registro das finanças do aluno.
     * A representação segue o formato "Receita total: x, Receita atual: x, Despesas totais: x".
     * @return a representação do registro de finanças do aluno.
     */
    public String toString() {
        return "Receita total: " + receitaTotal + ", Receita atual: " + receitaAtual + ", Despesas Totais: " + despesaTotal; }

    }

