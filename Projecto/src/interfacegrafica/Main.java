package interfacegrafica;

import programa.Aor_Autocarro;
import programa.FicheiroDeObjectos;

import java.io.IOException;

public class Main {

    Aor_Autocarro guedes = new Aor_Autocarro();
    public static Aor_Autocarro leficheiro() throws IOException,ClassNotFoundException{
        FicheiroDeObjectos fdo = new FicheiroDeObjectos();
        fdo.abreLeitura("Aor_Autocarro");
        Aor_Autocarro guedes = (Aor_Autocarro) fdo.leObjeto();
        fdo.fechaLeitura();
        return guedes;
    }

    public static void main(String[] args) {


        PainelFundo painelFundo = new PainelFundo();












    }

}