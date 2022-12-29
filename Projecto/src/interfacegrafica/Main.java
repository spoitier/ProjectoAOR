package interfacegrafica;

import programa.*;
import javax.swing.*;
import java.io.IOException;
import java.time.LocalDate;

public class Main {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        //Aor_Autocarro aor_autocarro = new Aor_Autocarro();
        FicheiroDeObjectos ficheiroDeObjectos = new FicheiroDeObjectos();
        Aor_Autocarro aor_autocarro = ficheiroDeObjectos.leObjeto();

        if (aor_autocarro == null) {
            aor_autocarro = new Aor_Autocarro();
        }else{
            aor_autocarro.setUserLogado(null);
        }
        PainelFundo painelFundo = new PainelFundo(aor_autocarro);

        //System.out.println(aor_autocarro.getUtilizadores());

        Utilizador gerente = new Administrador("Adm0", "admin@gmail.com", "ADMIN2022", "Rodrigo Ferreira",
                "123456789", "Coimbra", "967895432");
        aor_autocarro.getUtilizadores().add(gerente);

        /*Utilizador cli1 = new Cliente("cl1","maria@gmail.com", "123456", "Maria", "124123443", "Coimbra", "913123123","Normal", LocalDate.of(2022, 12, 13));
        Utilizador cli2 = new Cliente("cl2","albertina@gmail.com", "123456", "Albertina", "124123454", "Coimbra", "913123123",  "Premium", LocalDate.of(2022, 12, 13));
        aor_autocarro.getUtilizadores().add(cli1);
        aor_autocarro.getUtilizadores().add(cli2);*/



        try {
            ficheiroDeObjectos.escreveObjeto(aor_autocarro);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Erro");
        }

        try {
            ficheiroDeObjectos.leObjeto();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Erro");
        }

    }
}


