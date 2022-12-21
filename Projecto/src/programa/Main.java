package programa;

import java.io.IOException;
import java.time.LocalDate;


public class Main {

    Aor_Autocarro guedes = new Aor_Autocarro();



    public static void gravarFicheiro(Aor_Autocarro guedes) throws IOException,ClassNotFoundException{
        FicheiroDeObjectos fdo = new FicheiroDeObjectos();
        fdo.abreEscrita("Aor_Autocarro");
        fdo.escreveObjeto(guedes);
        fdo.fechaEscrita();

    }
    public static Aor_Autocarro leficheiro() throws IOException,ClassNotFoundException{
        FicheiroDeObjectos fdo = new FicheiroDeObjectos();
        fdo.abreLeitura("Aor_Autocarro");
        Aor_Autocarro guedes = (Aor_Autocarro) fdo.leObjeto();
        fdo.fechaLeitura();
        return guedes;
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {






    }
}