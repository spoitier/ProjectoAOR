package interfacegrafica;

import programa.Aor_Autocarro;
import programa.FicheiroDeObjectos;

import java.io.IOException;

public class Main {



    public static Aor_Autocarro leficheiro() throws IOException, ClassNotFoundException {
        FicheiroDeObjectos fdo = new FicheiroDeObjectos();
        fdo.abreLeitura("Aor_Autocarro");
        Aor_Autocarro guedes = (Aor_Autocarro) fdo.leObjeto();
        fdo.fechaLeitura();
        return guedes;
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Aor_Autocarro guedes = new Aor_Autocarro();


        PainelFundo painelFundo = new PainelFundo();
        leficheiro();



    }

}