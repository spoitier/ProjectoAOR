package programa;

import java.io.IOException;
import java.time.LocalDate;


public class Main {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        Administrador adm1 = new Administrador("rodrigo@gmail.com", "12345", "Rodrigo", 12345, "Rua 3", 91242342 );
        //System.out.println(adm1.getId());

        Administrador adm2 = new Administrador("sonia@gmail.com", "password", "Sonia", 12885, "Rua 4", 91282342);
        //System.out.println(adm2.getId());
        Cliente cli1 = new Cliente("maria@gmail.com", "123456", "Maria", 1241234, "Coimbra", 913123123,"Normal", LocalDate.of(2022, 12, 13));
        Cliente cli2 = new Cliente("albertina@gmail.com", "123456", "Albertina", 1241234, "Coimbra", 913123123,  "Premium", LocalDate.of(2022, 12, 13));
        //System.out.println(cli1.getId());
        //System.out.println(cli2.getId());
        Motorista m1 = new Motorista("Jose", "Jose@gamil.com");
        Motorista m2 = new Motorista("Maria", "Maria@gamil.com");

        Autocarro a1 = new Autocarro(50, "xi-00-89","Honda","Civic");
        Autocarro a2 = new Autocarro(15, "aa-00-95","Mercedez","Civic");

        Aor_Autocarro guedes = new Aor_Autocarro();
        guedes.addAutocarro(a1);
        guedes.addAutocarro(a2);
        guedes.addMotorista(m1);
        guedes.addMotorista(m2);
        guedes.addUtilizador(adm1);
        guedes.addUtilizador(adm2);
        guedes.addUtilizador(cli1);
        guedes.addUtilizador(cli2);


        Reserva r1 = new Reserva(cli1,a1,m1,LocalDate.of(2022,03,11),LocalDate.of(2022,03,11),2,15,"Coimbra","Lisboa",180);
        Paypal p1 = new Paypal(r1,"maria@gmail.com","12345");
        Multibanco mb1 = new Multibanco(r1,12345,3423423,r1.getCusto());
        CartaoCredito cc1 = new CartaoCredito(r1,2312312,"joao",LocalDate.of(2022,03,11),123);

        guedes.listaPagamentos.add(mb1);

        guedes.reservas.add(r1);
        //System.out.println(guedes.listaPagamentos);




        // guedes.validarRegisto(adm1.getEmail(), adm2.palavraChave);

        System.out.println(guedes.identificarTipoPagamento(r1));


      /*public static void gravarFicheiro (Aor_Autocarro guedes) throws IOException{
      FicheiroDeObjectos fdo = new FicheiroDeObjectos();
      fdo.abreEscrita("Aor_Autocarro");
      fdo.escreveObjeto(guedes);
      fdo.fechaEscrita();
      }

      public static void Aor_Autocarro leficheiro() throws IOException,ClassNotFoundException{
      FicheiroDeObjectos fdo = new FicheiroDeObjectos();
      fdo.abreLeitura("Aor_Autocarro");
      guedes = (Aor_Autocarro) fdo.leObjeto();
      fdo.fechaLeitura();
      }*/

    }
}