package programa;

import java.io.*;

public class FicheiroDeObjectos {

    private ObjectInputStream iS;
    private ObjectOutputStream oS;
    //metodo para abrir ficheiro para leitura
    public void abreLeitura(String nomeDoFicheiro)throws IOException{
        iS=new ObjectInputStream(new FileInputStream(nomeDoFicheiro));
    }
    //metodo para abrir ficheiro para escrita
    public void abreEscrita(String nomeDoFicheiro)throws IOException{
        oS=new ObjectOutputStream(new FileOutputStream(nomeDoFicheiro));
    }
    //metodo para ler um objeto do ficheiro
    public Object leObjeto()throws IOException,ClassNotFoundException{
    return iS.readObject();
    }

    //metodo para escrever um objecto
    public void escreveObjeto(Object o)throws IOException{
        oS.writeObject(o);
    }
    //metodo para fechar um ficheiro aberto em modo leitura
    public void fechaLeitura()throws IOException{
        iS.close();
    }
    //metodo para fechar um ficheiro aberto em modo escrita
    public void fechaEscrita()throws IOException{
        oS.close();
    }
}
