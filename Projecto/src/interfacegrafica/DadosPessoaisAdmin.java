package interfacegrafica;

import programa.Aor_Autocarro;
import programa.Utilizador;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DadosPessoaisAdmin extends JPanel implements ActionListener {

    PainelFundo painelFundo;
    Aor_Autocarro aor_autocarro;
    JLabel clienteNome;

    JButton opcao1;
    JButton opcao2;
    JButton opcao3;
    JButton opcao4;
    JButton opcao5;
    JButton opcao6;
    JButton sairButton;
    JButton alterarPalavraChave;

    JLabel nomeField;

    JLabel nifField;

    JLabel moradaField;

    JLabel telefoneField;
    JLabel emailField;
    JLabel palavraChaveField;


    public DadosPessoaisAdmin(PainelFundo painelFundo, Aor_Autocarro aor_autocarro) {
        this.aor_autocarro = aor_autocarro;
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
        clienteNome = new JLabel();
        clienteNome.setBounds(700, 0, 100, 30);
        cabecalho.add(clienteNome);

        // Botao para sair para o login
        sairButton = new JButton("Sair");
        sairButton.setBounds(810, 1, 70, 28);
        cabecalho.add(sairButton);
        this.add(cabecalho);

        //===========================================================
        //Painel de escolhas do Admin
        JPanel opcaoPainel = new JPanel();
        opcaoPainel.setLayout(new GridLayout(1, 5, 15, 0));
        opcaoPainel.setBounds(0, 35, 900, 50);
        opcaoPainel.setBorder(BorderFactory.createLineBorder(Color.BLACK));


        opcao1 = new JButton("Adminstradores");
        opcao2 = new JButton("Motoristas");
        opcao3 = new JButton("Autocarros");
        opcao4 = new JButton("Clientes");
        opcao5 = new JButton("Estatistica");
        opcao6 = new JButton("Dados Pessoais");

        opcaoPainel.add(opcao1);
        opcaoPainel.add(opcao2);
        opcaoPainel.add(opcao3);
        opcaoPainel.add(opcao4);
        opcaoPainel.add(opcao5);
        opcaoPainel.add(opcao6);

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
        nomeField = new JLabel("Valor preenchido");
        nomeField.setBounds(150, 50, 200, 30);
        nifField = new JLabel("Valor preenchido");
        nifField.setBounds(150, 90, 200, 30);
        moradaField = new JLabel("Valor preenchido");
        moradaField.setBounds(150, 130, 200, 30);
        telefoneField = new JLabel("Valor preenchido");
        telefoneField.setBounds(150, 170, 200, 30);
        emailField = new JLabel("Valor preenchido");
        emailField.setBounds(150, 210, 200, 30);
        palavraChaveField = new JLabel("Valor preenchido");
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

        botoesPainel.add(alterarPalavraChave);

        this.add(botoesPainel);

        opcao1.addActionListener(this);
        opcao2.addActionListener(this);
        opcao3.addActionListener(this);
        opcao4.addActionListener(this);
        opcao5.addActionListener(this);
        opcao6.addActionListener(this);
        alterarPalavraChave.addActionListener(this);
        sairButton.addActionListener(this);


    }


    public Utilizador nomeLogado() {
        if (aor_autocarro.getUserLogado() == null) {
            nomeField.setText("");
        } else {
            clienteNome.setText(aor_autocarro.getUserLogado().getNome());
            nomeField.setText(aor_autocarro.getUserLogado().getNome());
            nifField.setText(aor_autocarro.getUserLogado().getNif());
            moradaField.setText(aor_autocarro.getUserLogado().getMorada());
            telefoneField.setText(aor_autocarro.getUserLogado().getTelefone());
            emailField.setText(aor_autocarro.getUserLogado().getEmail());
            palavraChaveField.setText(aor_autocarro.getUserLogado().getPalavraChave());
        }
        return null;
    }





    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Adminstradores")) {
            painelFundo.mudaEcra("RegistarNovoAdministrador");
        }

        if (e.getActionCommand().equals("Motoristas")) {
            painelFundo.mudaEcra("Motoristas");
        }

        if (e.getActionCommand().equals("Autocarros")) {
            painelFundo.mudaEcra("Autocarros");
        }

        if (e.getActionCommand().equals("Clientes")) {
            ((AdicionarClientes)(painelFundo.mapaPaineis.get("AdicionarClientes"))).nomeLogado();
            painelFundo.mudaEcra("AdicionarClientes");
        }
        if (e.getActionCommand().equals("Estatistica")) {
            ((Estatistica)(painelFundo.mapaPaineis.get("Estatistica"))).nomeLogado();
            painelFundo.mudaEcra("Estatistica");
        }

        if (e.getActionCommand().equals("Sair")) {
            painelFundo.mudaEcra("Login");
        }

        if (e.getActionCommand().equals("Alterar palavra chave")) {
            Utilizador administrador =aor_autocarro.getAdministrador(emailField.getText());
            ((AlterarPalavraChaveAdmin)painelFundo.mapaPaineis.get("AlterarPalavraChaveAdmin")).setAdministrador(administrador);

            painelFundo.mudaEcra("AlterarPalavraChaveAdmin");
        }

    }
}
