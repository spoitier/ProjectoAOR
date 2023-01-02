package interfacegrafica;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CancelarReserva extends JPanel implements ActionListener {

    PainelFundo painelFundo;
    JButton sairBotao;
    JButton opcao1 ;
    JButton opcao2 ;
    JButton opcao3;
    JButton opcao4 ;
    JButton opcao5 ;
    JButton cancelarButton;




    public CancelarReserva(PainelFundo painelFundo) {
        this.painelFundo = painelFundo;
        this.setLayout(null);

        //===================================================
        //Painel do Cabeçalho
        JPanel cabecalho = new JPanel();
        cabecalho.setLayout(null);
        cabecalho.setBounds(0, 0, 900, 30);

        //Label do nome da empresa
        JLabel empresaNome = new JLabel("Aor-Autocarros");
        empresaNome.setBounds(5, 0, 100, 30);
        cabecalho.add(empresaNome);

        // Nome do cliente
        JLabel clienteNome = new JLabel("Nome do Cliente");
        clienteNome.setBounds(700, 0, 100, 30);
        cabecalho.add(clienteNome);

        // Botao para sair para o login

        sairBotao = new JButton("Sair");
        sairBotao.setBounds(810, 1, 70, 28);
        cabecalho.add(sairBotao);
        this.add(cabecalho);

        //===========================================================
        //Painel de escolhas do cliente
        JPanel opcaoPainel = new JPanel();
        opcaoPainel.setLayout(new GridLayout(1, 5,15,0));
        opcaoPainel.setBounds(0, 35, 900, 50);
        opcaoPainel.setBorder(BorderFactory.createLineBorder(Color.BLACK));



         opcao1 = new JButton("ReservaViagem");
         opcao2 = new JButton("Histórico Reservas");
         opcao3 = new JButton("Consultar Reservas");
         opcao4 = new JButton("Cancelar Reservas");
         opcao5 = new JButton("Dados Pessoais");

        opcaoPainel.add(opcao1);
        opcaoPainel.add(opcao2);
        opcaoPainel.add(opcao3);
        opcaoPainel.add(opcao4);
        opcaoPainel.add(opcao5);

        this.add(opcaoPainel);

        //=====================================================================
        //Segundo titulo
        JLabel segundoTitulo =new JLabel("Cancelar reservas agendadas:\n");
        segundoTitulo.setBounds(50,100,900,30);
        this.add(segundoTitulo);

        JPanel reservaPainel = new JPanel(new GridLayout(1,3,10,10));
        reservaPainel.setBounds(50,200,300,30);

        JLabel reservaLabel = new JLabel("NºReserva");
        JTextField reservaField = new JTextField();
        cancelarButton  = new JButton("Cancelar");
        reservaPainel.add(reservaLabel);
        reservaPainel.add(reservaField);
        reservaPainel.add(cancelarButton);
        this.add(reservaPainel);

        opcao1.addActionListener(this);
        opcao2.addActionListener(this);
        opcao3.addActionListener(this);
        opcao4.addActionListener(this);
        opcao5.addActionListener(this);
        sairBotao.addActionListener(this);
        cancelarButton.addActionListener(this);




    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("ReservaViagem")) {
            painelFundo.mudaEcra("ReservaViagem");
        }

        if(e.getActionCommand().equals("Histórico Reservas")) {
            painelFundo.mudaEcra("HistoricoReservas");
        }

        if(e.getActionCommand().equals("Consultar Reservas")) {
            painelFundo.mudaEcra("ConsultarReservas");
        }

        if(e.getActionCommand().equals("Cancelar Reservas")) {
            painelFundo.mudaEcra("CancelarReserva");
        }
        if(e.getActionCommand().equals("Dados Pessoais")) {
            painelFundo.mudaEcra("DadosPessoaisClientes");
        }
        if(e.getActionCommand().equals("Sair")){
            painelFundo.mudaEcra("Login");
        }

    }
}
