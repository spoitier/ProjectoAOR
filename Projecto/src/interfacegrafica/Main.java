package interfacegrafica;

import programa.*;

import javax.swing.*;
import java.io.IOException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        //Aor_Autocarro aor_autocarro = new Aor_Autocarro();
        FicheiroDeObjectos ficheiroDeObjectos = new FicheiroDeObjectos();
        Aor_Autocarro aor_autocarro = ficheiroDeObjectos.leObjeto();

        if (aor_autocarro == null) {
            aor_autocarro = new Aor_Autocarro();
        } else {
            aor_autocarro.setUserLogado(null);
        }
        PainelFundo painelFundo = new PainelFundo(aor_autocarro);

        if (aor_autocarro.getUtilizadores().size() == 0) {
            Utilizador gerente = new Administrador("Adm0", "admin@gmail.com", "ADMIN2022", "Rodrigo Ferreira",
                    "123456789", "Coimbra", "967895432");
            aor_autocarro.getUtilizadores().add(gerente);
        }

        /*
        Autocarro a1 =new Autocarro("AA-55-BB", "Ford", "Fiesta", "50");
        Autocarro a2 =new Autocarro("AA-44-CC", "Ford", "Fiesta", "50");
        Autocarro a3 =new Autocarro("AA-33-DD", "Ford", "Fiesta", "50");
        Autocarro a4 =new Autocarro("AA-11-EE", "Ford", "Fiesta", "50");
        Autocarro a5 =new Autocarro("AA-22-FF", "Ford", "Fiesta", "50");

        aor_autocarro.getAutocarros().add(a1);
        aor_autocarro.getAutocarros().add(a2);
        aor_autocarro.getAutocarros().add(a3);
        aor_autocarro.getAutocarros().add(a4);
        aor_autocarro.getAutocarros().add(a5);

        Motorista m1 = new Motorista("João", "Joao@gmail.com");
        Motorista m2 = new Motorista("Ricardo", "Ricardo@gmail.com");
        Motorista m3 = new Motorista("Pedro", "Pedro@gmail.com");
        Motorista m4 = new Motorista("Andre", "Andre@gmail.com");
        Motorista m5 = new Motorista("José", "José@gmail.com");


        aor_autocarro.getMotoristas().add(m1);
        aor_autocarro.getMotoristas().add(m2);
        aor_autocarro.getMotoristas().add(m3);
        aor_autocarro.getMotoristas().add(m4);
        aor_autocarro.getMotoristas().add(m5);

        Cliente cl1 = new Cliente("cli1","maria@gmail.com","123","Maria Ferreira",
                "123456789","rua","123456789","Premium",LocalDate.of(2023,01,05));
        Cliente cl2 = new Cliente("cli2","rodrigo@gmail.com","123","rodrigo Ferreira",
                "123456789","rua","123456789","Premium",LocalDate.of(2023,01,05));
        Cliente cl3 = new Cliente("cli3","joao@gmail.com","123","Joao Ferreira",
                "123456789","rua","123456789","Premium",LocalDate.of(2023,01,05));
        Cliente cl4 = new Cliente("cli4","José@gmail.com","123","José Ferreira",
                "123456789","rua","123456789","Premium",LocalDate.of(2023,01,05));
        Cliente cl5 = new Cliente("cli5","Mariana@gmail.com","123","Mariana Ferreira",
                "123456789","rua","123456789","Premium",LocalDate.of(2023,01,05));

        aor_autocarro.getUtilizadores().add(cl1);
        aor_autocarro.getUtilizadores().add(cl2);
        aor_autocarro.getUtilizadores().add(cl3);
        aor_autocarro.getUtilizadores().add(cl4);
        aor_autocarro.getUtilizadores().add(cl5);


        Reserva r1 = new Reserva(cl1,a1,m1,LocalDate.now(),LocalDate.of(2023,01,10),
                "10","30","Coimbra","Lisboa","100");
        Reserva r2 = new Reserva(cl1,a2,m1,LocalDate.now(),LocalDate.of(2023,01,10),
                "10","30","Faro","Lisboa","100");
        Reserva r3 = new Reserva(cl1,a3,m1,LocalDate.now(),LocalDate.of(2023,01,10),
                "10","30","Madrid","Lisboa","100");
        Reserva r4 = new Reserva(cl1,a2,m1,LocalDate.now(),LocalDate.of(2023,01,10),
                "10","30","Coimbra","China","100");
        Reserva r5 = new Reserva(cl1,a2,m1,LocalDate.now(),LocalDate.of(2023,01,10),
                "10","30","Coimbra","Madeira","100");

        aor_autocarro.getReservas().add(r1);
        aor_autocarro.getReservas().add(r2);
        aor_autocarro.getReservas().add(r3);
        aor_autocarro.getReservas().add(r4);
        aor_autocarro.getReservas().add(r5);





         */
        ficheiroDeObjectos.escreveObjeto(aor_autocarro);


        //aor_autocarro=ficheiroDeObjectos.leObjeto();


    }
}


