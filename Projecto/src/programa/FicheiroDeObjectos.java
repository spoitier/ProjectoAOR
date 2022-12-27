package programa;

import java.io.*;
import java.util.ArrayList;

public class FicheiroDeObjectos {

    private  static ObjectInputStream iS;
    private static ObjectOutputStream oS;

    //metodo para abrir ficheiro para leitura
    public static void  abreLeitura(String nomeDoFicheiro) throws IOException {
        iS = new ObjectInputStream(new FileInputStream(nomeDoFicheiro));
    }

    //metodo para abrir ficheiro para escrita
    public static void  abreEscrita(String nomeDoFicheiro) throws IOException {
        oS = new ObjectOutputStream(new FileOutputStream(nomeDoFicheiro));
    }

    //metodo para ler um objeto do ficheiro
    public Aor_Autocarro leObjeto() throws IOException, ClassNotFoundException {
        try {
            FicheiroDeObjectos fdo = new FicheiroDeObjectos();
            fdo.abreLeitura("AOR");
            return (Aor_Autocarro) iS.readObject();

        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Erro" + e.getMessage());
            return null;
        }

    }
    //metodo para escrever um objecto
    public static void escreveObjeto(Aor_Autocarro aor_autocarro) throws IOException {
        try {
            abreEscrita("AOR");
            oS.writeObject(aor_autocarro);
            fechaEscrita();

        } catch (IOException e) {
            System.out.println("Erro" + e);
        }


    }

    //metodo para fechar um ficheiro aberto em modo leitura
    public void fechaLeitura() throws IOException {
        iS.close();
    }

    //metodo para fechar um ficheiro aberto em modo escrita
    public static void fechaEscrita() throws IOException {
        oS.close();
    }
}
