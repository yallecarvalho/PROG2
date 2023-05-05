package agenda;

/**
 * Uma agenda que mantém uma lista de contatos com posições. Podem existir 100 contatos. 
 * 
 * @author nazarenoandrade e Yalle Carvalho - 119210523
 *
 */
public class Agenda {

	private static final int TAMANHO_AGENDA = 100;
	private Contato[] contatos;
	private Contato[] favoritos;

	/**
	 * Cria uma agenda.
	 * Inicia a lista de contatos e a lista de contatos favoritos.
	 */
	public Agenda() {
		this.contatos = new Contato[TAMANHO_AGENDA];
		this.favoritos = new Contato[10];
	}

	/**
	 * Acessa a lista de contatos cadastrados.
	 * @return Uma string com a lista de contatos.
	 */
	public String listaContatos() {
		String lista = "";
		for (int i = 0; i < contatos.length; i++) {
			if (contatos[i] != null) {
				 lista += i+1 + ": " + contatos[i].getNomeSobrenome() + "\n"; }
			} return lista;
		}

	/**
	 * Acessa a lista de contatos favoritados.
	 * @return Uma string com a lista de contatos favoritados.
	 */
	public String listaFavoritos() {
		String listaFav = "";
		for (int i = 0; i < favoritos.length; i++) {
			if (favoritos[i] != null) {
				listaFav += i+1 + " - " + favoritos[i].getNomeSobrenome() + "\n"; }
			} return listaFav;
	}

	/**
	 * Acessa os dados de um contato específico.
	 *
	 * @param posicao Posição do contato na agenda.
	 * @return Dados do contato, com o coração em caso de contato favoritado. Null se não há contato na posição.
	 */
	public String exibeContato(int posicao) {
		if (contatos[posicao-1] == null) {
			throw new NullPointerException("Sem contato na posição!");
		} else {
			for (int i = 0; i < favoritos.length; i++) {
				if (favoritos[i] != null) {
					if (contatos[posicao - 1].getNomeSobrenome().equals(favoritos[i].getNomeSobrenome())) {
						return "<3 " + contatos[posicao-1].toString();
					}
				}
			}
		}
		return contatos[posicao-1].toString();
	}

	/**
	 * Testa se o contato que está sendo cadastro já possui cadastro na agenda, de acordo com o nome e sobrenome.
	 * @param nomeCompleto nome completo do contato
	 * @return true se forem iguais e false caso não sejam.
	 */

	public boolean testaContatosIguais(String nomeCompleto) {
		for (int i = 0; i < contatos.length; i++)
			if (contatos[i] != null) {
				if (contatos[i].getNomeSobrenome().equals(nomeCompleto)) {
					return true;
				}
			} return false;
	}
	/**
	 * Cadastra um contato em uma posição. Um cadastro em uma posição que já existe sobrescreve o anterior. 
	 * @param posicao Posição do contato.
	 * @param nome Nome do contato.
	 * @param sobrenome sobrenome do contato.
	 * @param prioritario telefone prioritário.
	 * @param whats telefone whatsapp.
	 * @param adicional telefone adicional (não obrigatório).
	 */
	public void cadastraContato(int posicao, String nome, String sobrenome, String prioritario, String whats, String adicional) {
		this.contatos[posicao-1] = new Contato(nome, sobrenome, prioritario, whats, adicional);
	}

	/**
	 * Cadastra um contato como favorito na posição de um array de dez posições de contatos favoritados.
	 * @param contato A posição do contato que está sendo favoritado.
	 * @param posicao A posição em que o contato está sendo favoritado na lista de favoritos.
	 */
	public void cadastraFavorito(int contato, int posicao){

		this.favoritos[posicao-1] = contatos[contato-1];
	}

	/**
	 * Testa se o contato que está sendo cadastrado como favorito ja pertence a lista.
	 * @param contato contato que está sendo cadastrado
	 * @return true se forem iguais e false caso não sejam.
	 */
	public boolean testaFavoritos(int contato){
		for (int i = 0; i < favoritos.length; i++) {
			if (favoritos[i] != null)
			if (contatos[contato-1].getNomeSobrenome().equals(favoritos[i].getNomeSobrenome())){
				return true;
			}
		}  return false;
 	}
}
