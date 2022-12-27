package programa;

import java.io.Serializable;

public class Utilizador implements Serializable {

    Aor_Autocarro aor_autocarro = new Aor_Autocarro();

    protected String email;
    protected String palavraChave;
    protected String nome;
    protected String nif;
    protected String morada;
    protected String telefone;
    protected String id;
    //Fostes
    public Utilizador(String id,String email, String palavraChave, String nome, String nif, String morada, String telefone) {
        this.email = email;
        this.palavraChave = palavraChave;
        this.nome = nome;
        this.nif = nif;
        this.morada = morada;
        this.telefone = telefone;
    }

    public Utilizador() {

    }

    public static boolean validarEmail(String email) {
        boolean validar = false;
        String[] email2 = email.split("");
        for (int i = 0; i < email2.length; i++) {
            if (email2[i].equals("@")) {
                for (int j = i; j < email2.length; j++) {
                    if (email2[j].equals(".")) {
                        validar = true;
                    }
                }
            }
        }return validar;
    }
    public static boolean validarTlfeNif(String dadoNumerico) {
        dadoNumerico=dadoNumerico.replaceAll("\\s","");
        for(int i=0;i<dadoNumerico.length();i++){
            if(!Character.isDigit(dadoNumerico.charAt(i))){
                return  true;
            }
        }
        return false;
    }
    public static boolean validarNome(String nome) {
        boolean validar = false;
        nome=nome.replaceAll("\\s","");
        int contadorLetras=0;

        for(int i=0;i<nome.length();i++){
            if(!Character.isDigit(nome.charAt(i))){
                contadorLetras++;
            }
        }
        if(nome.length()==contadorLetras){
            validar=true;
        }
        return validar;
    }

    //====================================================
    //Alterar palavra chave
    public  void alterarPalavraChave(String email, String palavraChaveAtual,
                                           String novaPalavraChave, String confirmePalavraChave) {
        if (aor_autocarro.validarRegisto(email, palavraChaveAtual)) {
            if (novaPalavraChave.equals(confirmePalavraChave)) {
                for (Utilizador cliente : aor_autocarro.getUtilizadores()) {
                    if (cliente.getEmail() == email) {
                        cliente.setPalavraChave(novaPalavraChave);
                    }
                }
            } else {
                System.out.println("As palavras passes não coincidem");
            }
        } else {
            System.out.println("Password Errada");
        }
    }








    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPalavraChave(){
        return this.palavraChave;
    }

    public void setPalavraChave(String palavraChave) {
        this.palavraChave = palavraChave;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public String getMorada() {
        return morada;
    }

    public void setMorada(String morada) {
        this.morada = morada;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void esqueceuPalavraPasse(String email) {
        System.out.println("Foi enviado para seu email" + email + " uma nova palavra-passe");
        System.out.println("Volte a fazer o login com a nova palavra-passe");
    }

}
