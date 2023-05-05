package agenda;

/**
 * Representa um contato na agenda de contatos. Cada contato é representado pelo seu nome e sobrenome,
 * um telefone prioritário, um telefone whatsapp e um telefone adicional.
 *
 * @author Yalle Carvalho - 119210523
 */
public class Contato {
    /**
     * Nome do contato.
     */
    private String nome;
    /**
     * Sobrenome do contato.
     */
    private String sobrenome;
    /**
     * Número de telefone prioritário do contato.
     */
    private String prioritario;
    /**
     * Número de telefone whatsapp do contato.
     */
    private String whats;
    /**
     * Número de telefone adicional do contato.
     */
    private String adicional;

    /**
     * Cria um contato.
     * @param nome nome do contato
     * @param sobrenome sobrenome do contato
     * @param prioritario telefone prioritário do contato
     * @param whats telefone whatsapp do contato
     * @param adicional telefone adicional do contato
     */
    public Contato(String nome, String sobrenome, String prioritario, String whats, String adicional) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.prioritario = prioritario;
        this.whats = whats;
        this.adicional = adicional;
    }
    /**
     * Acessa o nome do contato
     * @return nome do contato
     */
    public String getNome() {
        return this.nome;
    }
    /**
     * Acessa o sobrenome do contato
     * @return sobrenome do contato
     */
    public String getSobrenome() {
        return this.sobrenome;
    }
    /**
     * Acessa o nome do completo do contato (junção do nome e sobrenome)
     * @return nome completo - incluindo nome e sobrenome do contato.
     */
    public String getNomeSobrenome(){
        return getNome() + " " + getSobrenome();
    }
    /**
     * Exibe a descrição do contato completo - Nome, sobrenome, telefone prioritário, telefone whatsapp e telefone adicional (se houver).
     * @return a descrição do contato.
     */
    public String toString() {
        if ((this.adicional == null) || this.adicional.isBlank()) {
            return this.nome + " " + this.sobrenome + "\n" + this.prioritario + " (Prioritário)\n" + this.whats + " (Whatsapp)";
        } else {
            return this.nome + " " + this.sobrenome + "\n" + this.prioritario + " (Prioritário)\n" + this.whats + " (Whatsapp)" + "\n" + this.adicional + " (Adicional)";
        }
    }

}
