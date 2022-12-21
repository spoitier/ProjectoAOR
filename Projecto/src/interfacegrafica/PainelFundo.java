package interfacegrafica;

import programa.Aor_Autocarro;
import programa.FicheiroDeObjectos;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;


public class PainelFundo {

    Aor_Autocarro guedes = new Aor_Autocarro();

    JFrame f;
    JPanel painelPrincipal;

    CardLayout layout;

    public PainelFundo() {
        f = new JFrame("AOR-Empresa");
        f.setSize(900, 700);
        f.setLayout(new CardLayout());
        f.setLocationRelativeTo(null); //Colocado no centro do Monitor
        f.setResizable(false); //Não pode alterar o tamanho do frame
        f.setTitle("Aor-Autocarros"); //Titulo aplicação
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        layout = new CardLayout();
        painelPrincipal = new JPanel(layout);
        painelPrincipal.setBounds(0,0,900,700);
        painelPrincipal.setBorder(BorderFactory.createLineBorder(Color.BLACK));




        painelPrincipal.add(new Login(this), "Login");
        painelPrincipal.add(new RegistarUtilizador(this),"RegistarUtilizador");
        painelPrincipal.add(new PlanoSubscricao(this),"PlanoSubscrição");
        painelPrincipal.add(new ReservaViagem(this),"ClienteFrame");
        painelPrincipal.add(new TipoDePagamentos(this),"ClienteFrame2");
        painelPrincipal.add(new PayPal(this),"PayPal");
        painelPrincipal.add(new CartaoCredito(this),"programa.CartaoCredito");
        painelPrincipal.add(new Multibanco(this),"programa.Multibanco");
        painelPrincipal.add(new HistoricoReservas(this),"HistoricoReservas");
        painelPrincipal.add(new ConsultarReservas(this),"ConsultarReservas");
        painelPrincipal.add(new CancelarReserva(this),"CancelarReserva");
        painelPrincipal.add(new DadosPessoaisCliente(this),"DadosPessoaisClientes");
        painelPrincipal.add(new AlterarPalavraChaveCliente(this),"AlterarPalavraChave");
        painelPrincipal.add(new RegistarNovoAdministrador(this),"RegistarNovoAdministrador");
        painelPrincipal.add(new Motoristas(this),"Motoristas");
        painelPrincipal.add(new Autocarros(this),"Autocarros");
        painelPrincipal.add(new AutocarrosEditar(this),"AutocarrosEditar");
        painelPrincipal.add(new AdicionarClientes(this),"AdicionarClientes");
        painelPrincipal.add(new ClientesEditar(this),"ClientesEditar");
        painelPrincipal.add(new Estatistica(this),"Estatistica");
        painelPrincipal.add(new DadosPessoaisAdmin(this),"DadosPessoaisAdmin");
        painelPrincipal.add(new AlterarPalavraChaveAdmin(this),"AlterarPalavraChaveAdmin");



        f.getContentPane().add(painelPrincipal);


        //layout.show(painelPrincipal,"Login"); NAO APAGAR, ESTA LINHA ESTÁ CORRECTA


        //painelPrincipal.add(new Login(this));

        f.setVisible(true);

    }
    public void Aor_Autocarroleficheiro() throws IOException,ClassNotFoundException{
        FicheiroDeObjectos fdo = new FicheiroDeObjectos();
        fdo.abreLeitura("Aor_Autocarro");
        guedes = (Aor_Autocarro) fdo.leObjeto();
        fdo.fechaLeitura();
    }

    //Rodrigo , não mexer
    public void mudaEcra(String ecra) {

        layout.show(painelPrincipal,ecra);


    }

}