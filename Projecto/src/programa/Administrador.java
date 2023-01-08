package programa;

import java.io.Serializable;

/**
 * The type Administrador.
 */
public class Administrador extends Utilizador implements Serializable {

    private String id;


    /**
     * Instantiates a new Administrador.
     *
     * @param id           the id
     * @param email        the email
     * @param palavraChave the palavra chave
     * @param nome         the nome
     * @param nif          the nif
     * @param morada       the morada
     * @param telefone     the telefone
     */
    public Administrador(String id,String email, String palavraChave, String nome, String nif, String morada, String telefone) {
        super(id,email, palavraChave, nome, nif, morada, telefone);
        this.id=id;
        this.palavraChave = "ADMIN2022";
    }

    //Metodo para gerar chave inicial



    @Override
    public String toString() {
        return "Administrador:" +
                "id=" + id +
                ",nome=" + nome +
                ",nif=" + nif +
                ",morada=" + morada  +
                ",telefone=" + telefone +
                ",email=" + email +
                ",palavraChave=" + palavraChave+"\n";
    }

    public String getId() {
        return id;
    }
}
