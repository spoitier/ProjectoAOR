package interfacegrafica;

import programa.*;

import java.io.IOException;
import java.io.StringReader;
import java.time.LocalDate;


public class Main {


    public static void alterarPalavraChave(String email, String palavraChaveAtual,
                                           String novaPalavraChave, String confirmePalavraChave) {
        if (Aor_Autocarro.validarRegisto(email, palavraChaveAtual)) {
            if (novaPalavraChave.equals(confirmePalavraChave)) {
                for (Utilizador cliente : Aor_Autocarro.getUtilizadores()) {
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


    public static void alterarSubscricao(String email) {
        for (Utilizador utilizador : Aor_Autocarro.getUtilizadores()) {
            if (((Cliente) utilizador).getTipoCliente().equals("N")) {
                ((Cliente) utilizador).setTipoCliente("P");
            } else if (((Cliente) utilizador).getTipoCliente().equals("P")) {
                ((Cliente) utilizador).setTipoCliente("N");

            }

        }
    }

    public static void validarMarca(String marca) {
        int contador = 0;
        for (int i =0;i<marca.length();i++) {
            if (Character.isLetter(marca.charAt(i))) {
                contador++;
            }
        }
        if(contador==marca.length()){
            System.out.println("valor valido");
        } else {
            System.out.println("Dados Invalidos");
        }
    }




    public static void main(String[] args)   {

        Aor_Autocarro aor_autocarro = new Aor_Autocarro();

        Cliente cl1 = new Cliente("rodrigo@gmail.com","123456","nome","123456789","rua","91234567","N",LocalDate.now());
        Cliente cl2 = new Cliente("maria@gmail.com","123456","nome","123456789","rua","91234567","P",LocalDate.now());
        Cliente cl3 = new Cliente("manel@gmail.com","123456","nome","123456789","rua","91234567","N",LocalDate.now());

        Autocarro a1 = new Autocarro(40,"33-44-AA","mercedez","x");
        Autocarro a2 = new Autocarro(30,"33-44-AB","ferrri","x");
        Autocarro a3 = new Autocarro(40,"33-44-AC","ferrri","x");


        aor_autocarro.addUtilizador(cl1);
        aor_autocarro.addUtilizador(cl2);
        aor_autocarro.addUtilizador(cl3);



        aor_autocarro.addAutocarro(a1);
        aor_autocarro.addAutocarro(a2);
        aor_autocarro.addAutocarro(a3);

        validarMarca(a1.getMarca());














    }

}