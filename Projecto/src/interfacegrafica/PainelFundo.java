package interfacegrafica;

import programa.Aor_Autocarro;
import programa.Cliente;
import programa.FicheiroDeObjectos;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.time.LocalDate;
import java.util.HashMap;


public class PainelFundo {


 JFrame f;
 JPanel painelPrincipal;

 CardLayout layout;
 Aor_Autocarro aor_autocarro;

 HashMap<String,JPanel>mapaPaineis;

 public PainelFundo(Aor_Autocarro aor_autocarro) {
  this.aor_autocarro = aor_autocarro;

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


  mapaPaineis=new HashMap<>();
  mapaPaineis.put("Login",new Login(this,aor_autocarro));
  painelPrincipal.add(mapaPaineis.get("Login"), "Login");
  mapaPaineis.put("RegistarUtilizador",new RegistarUtilizador(this,aor_autocarro));
  painelPrincipal.add(mapaPaineis.get("RegistarUtilizador"),"RegistarUtilizador");
  mapaPaineis.put("PlanoSubscrição",new PlanoSubscricao(this,aor_autocarro));
  painelPrincipal.add(mapaPaineis.get("PlanoSubscrição"),"PlanoSubscrição");
  mapaPaineis.put("ReservaViagem",new ReservaViagem(this,aor_autocarro));
  painelPrincipal.add(mapaPaineis.get("ReservaViagem"),"ReservaViagem");
  mapaPaineis.put("Pagamentos",new TipoDePagamentos(this,aor_autocarro));
  painelPrincipal.add(mapaPaineis.get("Pagamentos"),"Pagamentos");
  mapaPaineis.put("PayPal",new PayPal(this,aor_autocarro));
  painelPrincipal.add(mapaPaineis.get("PayPal"),"PayPal");
  mapaPaineis.put("CartaoCredito",new CartaoCredito(this,aor_autocarro));
  painelPrincipal.add(mapaPaineis.get("CartaoCredito"),"CartaoCredito");
  mapaPaineis.put("Multibanco",new Multibanco(this,aor_autocarro));
  painelPrincipal.add(mapaPaineis.get("Multibanco"),"Multibanco");
  mapaPaineis.put("HistoricoReservas",new HistoricoReservas(this, aor_autocarro));
  painelPrincipal.add(mapaPaineis.get("HistoricoReservas"),"HistoricoReservas");
  mapaPaineis.put("ConsultarReservas",new ConsultarReservas(this, aor_autocarro));
  painelPrincipal.add(mapaPaineis.get("ConsultarReservas"),"ConsultarReservas");
  mapaPaineis.put("CancelarReserva",new CancelarReserva(this,aor_autocarro));
  painelPrincipal.add(mapaPaineis.get("CancelarReserva"),"CancelarReserva");
  mapaPaineis.put("DadosPessoaisCliente",new DadosPessoaisCliente(this,aor_autocarro));
  painelPrincipal.add(mapaPaineis.get("DadosPessoaisCliente"),"DadosPessoaisCliente");
  mapaPaineis.put("AlterarPalavraChave",new AlterarPalavraChaveCliente(this,aor_autocarro));
  painelPrincipal.add(mapaPaineis.get("AlterarPalavraChave"),"AlterarPalavraChave");
  mapaPaineis.put("RegistarNovoAdministrador",new RegistarNovoAdministrador(this,aor_autocarro));
  painelPrincipal.add(mapaPaineis.get("RegistarNovoAdministrador"),"RegistarNovoAdministrador");
  mapaPaineis.put("Motoristas",new Motoristas(this,aor_autocarro));
  painelPrincipal.add(mapaPaineis.get("Motoristas"),"Motoristas");
  mapaPaineis.put("Autocarros",new Autocarros(this,aor_autocarro));
  painelPrincipal.add(mapaPaineis.get("Autocarros"),"Autocarros");
  mapaPaineis.put("AutocarrosEditar",new AutocarrosEditar(this,aor_autocarro));
  painelPrincipal.add(mapaPaineis.get("AutocarrosEditar"),"AutocarrosEditar");
  mapaPaineis.put("AdicionarClientes",new AdicionarClientes(this,aor_autocarro));
  painelPrincipal.add(mapaPaineis.get("AdicionarClientes"),"AdicionarClientes");
  mapaPaineis.put("ClientesEditar",new ClientesEditar(this,aor_autocarro));
  painelPrincipal.add(mapaPaineis.get("ClientesEditar"),"ClientesEditar");
  mapaPaineis.put("Estatistica",new Estatistica(this,aor_autocarro));
  painelPrincipal.add(mapaPaineis.get("Estatistica"),"Estatistica");
  mapaPaineis.put("DadosPessoaisAdmin",new DadosPessoaisAdmin(this,aor_autocarro));
  painelPrincipal.add(mapaPaineis.get("DadosPessoaisAdmin"),"DadosPessoaisAdmin");
  mapaPaineis.put("AlterarPalavraChaveAdmin",new AlterarPalavraChaveAdmin(this,aor_autocarro));
  painelPrincipal.add(mapaPaineis.get("AlterarPalavraChaveAdmin"),"AlterarPalavraChaveAdmin");






  f.getContentPane().add(painelPrincipal);


  //layout.show(painelPrincipal,"Login"); NAO APAGAR, ESTA LINHA ESTÁ CORRECTA


  //painelPrincipal.add(new Login(this));


  f.setVisible(true);


 }


 public void mudaEcra(String ecra) {

  layout.show(painelPrincipal,ecra);


 }

}