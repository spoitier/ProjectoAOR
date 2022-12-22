package interfacegrafica;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DadosPessoaisCliente extends JPanel implements ActionListener {

    PainelFundo painelFundo;
    JButton sairBotao;
    JButton opcao1;
    JButton opcao2;
    JButton opcao3;
    JButton opcao4;
    JButton opcao5;

    JButton alterarPalavraChave;
    JButton alterarPlanoSubscricao;


    public DadosPessoaisCliente(PainelFundo painelFundo) {
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
        opcaoPainel.setLayout(new GridLayout(1, 5, 15, 0));
        opcaoPainel.setBounds(0, 35, 900, 50);
        opcaoPainel.setBorder(BorderFactory.createLineBorder(Color.BLACK));


        opcao1 = new JButton("Reserva Autocarro");
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
        JLabel segundoTitulo = new JLabel("Dados Pessoais");
        segundoTitulo.setBounds(50, 100, 900, 30);
        this.add(segundoTitulo);

        //Painel Formulario

        JPanel formulario = new JPanel();
        formulario.setLayout(null);
        formulario.setBounds(25, 100, 400, 350);


        //Labels
        JLabel nomeLabel = new JLabel("Nome:");
        nomeLabel.setBounds(50, 50, 200, 30);
        JLabel nifLabel = new JLabel("NIF:");
        nifLabel.setBounds(50, 90, 200, 30);
        JLabel moradaLabel = new JLabel("Morada:");
        moradaLabel.setBounds(50, 130, 200, 30);
        JLabel telefoneLabel = new JLabel("Telefone:");
        telefoneLabel.setBounds(50, 170, 200, 30);
        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setBounds(50, 210, 200, 30);
        JLabel palavraChaveLabel = new JLabel("Palavra Chave:");
        palavraChaveLabel.setBounds(50, 250, 200, 30);

        //Fields
        JLabel nomeField = new JLabel("Valor preenchido");
        nomeField.setBounds(150, 50, 200, 30);
        JLabel nifField = new JLabel("Valor preenchido");
        nifField.setBounds(150, 90, 200, 30);
        JLabel moradaField = new JLabel("Valor preenchido");
        moradaField.setBounds(150, 130, 200, 30);
        JLabel telefoneField = new JLabel("Valor preenchido");
        telefoneField.setBounds(150, 170, 200, 30);
        JLabel emailField = new JLabel("Valor preenchido");
        emailField.setBounds(150, 210, 200, 30);
        JLabel palavraChaveField = new JLabel("Valor preenchido");
        palavraChaveField.setBounds(150, 250, 200, 30);

        formulario.add(nomeLabel);
        formulario.add(nifLabel);
        formulario.add(moradaLabel);
        formulario.add(telefoneLabel);
        formulario.add(emailLabel);
        formulario.add(palavraChaveLabel);
        formulario.add(nomeField);
        formulario.add(nifField);
        formulario.add(moradaField);
        formulario.add(telefoneField);
        formulario.add(emailField);
        formulario.add(palavraChaveField);
        this.add(formulario);

        //===============================================
        //Painel de botoes

        JPanel botoesPainel = new JPanel(new GridLayout(2, 1, 0, 10));
        botoesPainel.setBounds(450, 200, 200, 100);

        alterarPalavraChave = new JButton("Alterar palavra chave");
        alterarPlanoSubscricao = new JButton("Alterar plano subsrição");
        botoesPainel.add(alterarPalavraChave);
        botoesPainel.add(alterarPlanoSubscricao);
        this.add(botoesPainel);


        opcao1.addActionListener(this);
        opcao2.addActionListener(this);
        opcao3.addActionListener(this);
        opcao4.addActionListener(this);
        opcao5.addActionListener(this);
        sairBotao.addActionListener(this);
        alterarPalavraChave.addActionListener(this);
        alterarPlanoSubscricao.addActionListener(this);


    }


    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getActionCommand().equals("ReservaViagem")) {
            painelFundo.mudaEcra("ReservaViagem");
        }

        if (e.getActionCommand().equals("Histórico Reservas")) {
            painelFundo.mudaEcra("HistoricoReservas");
        }

        if (e.getActionCommand().equals("Consultar Reservas")) {
            painelFundo.mudaEcra("ConsultarReservas");
        }

        if (e.getActionCommand().equals("Cancelar Reservas")) {
            painelFundo.mudaEcra("CancelarReserva");
        }
        if (e.getActionCommand().equals("Dados Pessoais")) {
            painelFundo.mudaEcra("DadosPessoaisClientes");
        }
        if (e.getActionCommand().equals("Sair")) {
            painelFundo.mudaEcra("Login");
        }
        if (e.getActionCommand().equals("Alterar palavra chave")) {
            painelFundo.mudaEcra("AlterarPalavraChave");
        }
        if (e.getActionCommand().equals("Alterar plano subsrição")) {
            painelFundo.mudaEcra("PlanoSubscrição");

        }

    }
}