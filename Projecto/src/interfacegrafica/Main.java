package interfacegrafica;

import programa.*;

import java.io.IOException;
import java.io.StringReader;
import java.time.LocalDate;


public class Main {

    /*
    public static void alterarPalavraChave(String email, String palavraChaveAtual,
                                           String novaPalavraChave, String confirmePalavraChave) {
        if (guedes.validarRegisto(email, palavraChaveAtual)) {
            if (novaPalavraChave.equals(confirmePalavraChave)) {
                for (Utilizador cliente : guedes.getUtilizadores()) {
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



     */
    public static void validarMatricula(String matricula) {
        int traco = 0;
        int numero = 0;
        int letra = 0;
        if (matricula.length() == 8) {
            for (int i = 0; i < matricula.length(); i++) {
                if (matricula.charAt(i) == '-') {
                    traco++;
                }
                if (Character.isDigit(matricula.charAt(i))) {
                    numero++;
                }
                if (Character.isLetter(matricula.charAt(i))) {
                    letra++;
                }

            }
        }
        if (traco == 2 && (numero == letra * 2 || letra == numero * 2)) {
            System.out.println("Matricula Valida");
        } else {
            System.out.println("Matricula Invalida");
        }

    }

    public static void validarLotacao(String lotacao) {
        try {
            int lotacaoInteiro = Integer.parseInt(lotacao);
            if (lotacaoInteiro <= 50) {
                System.out.println("Adicionar à lista");
            } else {
                System.out.println("Capacidade maxima é 50");
            }
        } catch (NumberFormatException ex) {
            System.out.println("Dados invalidos");
        }


    }

    /*
    public static void alterarSubscricao(String email) {
        for (Utilizador utilizador : guedes.getUtilizadores()) {
            if (((Cliente) utilizador).getTipoCliente().equals("N")) {
                ((Cliente) utilizador).setTipoCliente("P");
            } else if (((Cliente) utilizador).getTipoCliente().equals("P")) {
                ((Cliente) utilizador).setTipoCliente("N");

            }

        }
    }


     */

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        /*

        Aor_Autocarro guedes = new Aor_Autocarro();

        Cliente  cl1 = new Cliente("rodrigo@gmail.com","123456","rodrigo","123456789","rua","914234234","N",LocalDate.now());
        Cliente  cl2 = new Cliente("maria@gmail.com","123456","rodrigo","123456789","rua","914234234","F",LocalDate.now());
        Cliente  cl3 = new Cliente("manel@gmail.com","123456","rodrigo","123456789","rua","914234234","N",LocalDate.now());

        guedes.getUtilizadores().add(cl1);
        guedes.getUtilizadores().add(cl2);
        guedes.getUtilizadores().add(cl3);


        System.out.println(cl1.getEmail() + "  " + cl1.getTipoCliente());
        for(Utilizador utilizador: guedes.getUtilizadores()) {
            System.out.println( ((Cliente) utilizador).getTipoCliente());
        }

        System.out.println(cl1.getEmail() + "  " + cl1.getTipoCliente());



         */
    }

}