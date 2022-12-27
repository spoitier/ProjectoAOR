package interfacegrafica;

import programa.*;

import javax.swing.*;
import java.io.IOException;
import java.io.StringReader;
import java.time.LocalDate;


public class Main {


    public static void main(String[] args) throws IOException, ClassNotFoundException {

        Aor_Autocarro aor_autocarro = new Aor_Autocarro();
        FicheiroDeObjectos ficheiroDeObjectos = new FicheiroDeObjectos();
        Aor_Autocarro ficheiro = ficheiroDeObjectos.leObjeto();

        if (ficheiro == null) {
            ficheiro = new Aor_Autocarro();
        }
        PainelFundo painelFundo = new PainelFundo(ficheiro);

        System.out.println(painelFundo.aor_autocarro.getUtilizadores());

        Utilizador gerente = new Administrador("Adm0", "admin@gmail.com", "ADMIN2022", "Rodrigo Ferreira",
                "123456789", "Coimbra", "967895432");
        aor_autocarro.getUtilizadores().add(gerente);

        try {
            FicheiroDeObjectos.escreveObjeto(ficheiro);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Erro");
        }
    }
}


