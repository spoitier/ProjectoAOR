package interfacegrafica;

import programa.Aor_Autocarro;
import programa.Cliente;
import programa.FicheiroDeObjectos;
import programa.Utilizador;


import java.io.IOException;
import java.time.LocalDate;

public class Main {



    public static Aor_Autocarro leficheiro() throws IOException, ClassNotFoundException {
        FicheiroDeObjectos fdo = new FicheiroDeObjectos();
        fdo.abreLeitura("Aor_Autocarro");
        Aor_Autocarro guedes = (Aor_Autocarro) fdo.leObjeto();
        fdo.fechaLeitura();
        return guedes;
    }

    public static void main(String[] args) {
        Aor_Autocarro guedes = new Aor_Autocarro();
      Cliente cliente=new Cliente("","","","","","","", LocalDate.now());



        PainelFundo painelFundo = new PainelFundo();

//Não apagar, serve para testes
        String nome="Maria Amelia9";
        System.out.println(cliente.validarNome(nome));



    }

}