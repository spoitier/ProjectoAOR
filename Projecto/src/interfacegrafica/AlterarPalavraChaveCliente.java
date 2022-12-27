package interfacegrafica;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AlterarPalavraChaveCliente extends JPanel implements ActionListener {

    PainelFundo painelFundo;
    JButton opcao1;
    JButton opcao2;
    JButton opcao3;
    JButton opcao4;
    JButton opcao5;
    JButton sairBotao;
    JButton alterarPalavraChaveButton;

    JLabel clienteNome;
    JLabel emailPreenchido;
    TextField palavraChaveAtualField;
    TextField novaPalavraChaveField;
    TextField confirmePalavraChaveField;


    public AlterarPalavraChaveCliente(PainelFundo painelFundo) {
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
        clienteNome = new JLabel("Nome do Cliente");
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


        opcao1 = new JButton("programa.Reserva programa.Autocarro");
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


        //=========================================================================
        //Formulario para alterar palavra chave

        JPanel formularioPanel = new JPanel();
        formularioPanel.setLayout(null);
        formularioPanel.setBounds(150, 200, 425, 250);


        JLabel email = new JLabel("Email:");
        email.setBounds(0, 25, 80, 30);

        JLabel palavraChaveAtual = new JLabel("Palavra-Chave atual:\n");
        palavraChaveAtual.setBounds(0, 75, 200, 30);

        JLabel novaPalavraChave = new JLabel("Nova Palavra-Chave: ");
        novaPalavraChave.setBounds(0, 125, 200, 30);

        JLabel confirmePalavraChave = new JLabel("Confirme a Palavra-Chave:\n");
        confirmePalavraChave.setBounds(0, 175, 200, 30);


        emailPreenchido = new JLabel("Preenchido automaticamente");
        emailPreenchido.setBounds(200, 25, 170, 30);

        palavraChaveAtualField = new TextField();
        palavraChaveAtualField.setBounds(200, 75, 170, 30);

        novaPalavraChaveField = new TextField();
        novaPalavraChaveField.setBounds(200, 125, 170, 30);

        confirmePalavraChaveField = new TextField();
        confirmePalavraChaveField.setBounds(200, 175, 170, 30);


        formularioPanel.add(email);
        formularioPanel.add(palavraChaveAtual);
        formularioPanel.add(novaPalavraChave);
        formularioPanel.add(confirmePalavraChave);
        formularioPanel.add(emailPreenchido);
        formularioPanel.add(palavraChaveAtualField);
        formularioPanel.add(novaPalavraChaveField);
        formularioPanel.add(confirmePalavraChaveField);

        this.add(formularioPanel);

        alterarPalavraChaveButton = new JButton("Alterar palavra chave");
        alterarPalavraChaveButton.setBounds(650, 225, 200, 30);
        this.add(alterarPalavraChaveButton);

        opcao1.addActionListener(this);
        opcao2.addActionListener(this);
        opcao3.addActionListener(this);
        opcao4.addActionListener(this);
        opcao5.addActionListener(this);
        sairBotao.addActionListener(this);
        alterarPalavraChaveButton.addActionListener(this);


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
        }


    }
}
