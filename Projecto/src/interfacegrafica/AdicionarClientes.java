package interfacegrafica;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdicionarClientes extends JPanel implements ActionListener {
    PainelFundo painelFundo;

    JButton sairButton;
    JButton opcao1;
    JButton opcao2;
    JButton opcao3;
    JButton opcao4;
    JButton opcao5;
    JButton opcao6;
    JButton adicionarButton;
    JButton removerButton;
    JButton editarButton;


    public AdicionarClientes(PainelFundo painelFundo) {
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
        JLabel clienteNome = new JLabel("Nome do Admin");
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
        JLabel segundoTitulo = new JLabel("Clientes ");
        segundoTitulo.setBounds(50, 100, 900, 30);
        this.add(segundoTitulo);

        //======================================================================
        //Formulario

        JPanel formulario = new JPanel();
        formulario.setLayout(null);
        formulario.setBounds(0, 100, 350, 800);


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
        JLabel palavraChaveLabel = new JLabel("Palavra-Chave");
        palavraChaveLabel.setBounds(50, 250, 200, 30);
        JLabel nifRemoverLabel = new JLabel("NIF:");
        nifRemoverLabel.setBounds(50, 425, 200, 30);
        JLabel nifEditarLabel = new JLabel("NIF:");
        nifEditarLabel.setBounds(50, 500, 200, 30);


        //Fields
        JTextField nameField = new JTextField();
        nameField.setBounds(150, 50, 200, 30);
        JTextField nifField = new JTextField();
        nifField.setBounds(150, 90, 200, 30);
        JTextField moradaField = new JTextField();
        moradaField.setBounds(150, 130, 200, 30);
        JTextField telefoneField = new JTextField();
        telefoneField.setBounds(150, 170, 200, 30);
        JTextField emailField = new JTextField();
        emailField.setBounds(150, 210, 200, 30);
        JTextField palavraChaveField = new JTextField();
        palavraChaveField.setBounds(150, 250, 200, 30);
        JTextField nifRemoverField = new JTextField();
        nifRemoverField.setBounds(150, 425, 200, 30);
        JTextField nifEditarField = new JTextField();
        nifEditarField.setBounds(150, 500, 200, 30);

        //Adicionar ao formulario
        formulario.add(nomeLabel);
        formulario.add(nifLabel);
        formulario.add(moradaLabel);
        formulario.add(telefoneLabel);
        formulario.add(emailLabel);
        formulario.add(palavraChaveLabel);
        formulario.add(nifRemoverLabel);
        formulario.add(nifEditarLabel);
        formulario.add(nameField);
        formulario.add(nifField);
        formulario.add(moradaField);
        formulario.add(telefoneField);
        formulario.add(emailField);
        formulario.add(palavraChaveField);
        formulario.add(nifRemoverField);
        formulario.add(nifEditarField);
        this.add(formulario);

        adicionarButton = new JButton("Adicionar");
        adicionarButton.setBounds(375, 150, 100, 30);


        removerButton = new JButton("Remover");
        removerButton.setBounds(375, 525, 100, 30);


        editarButton = new JButton("Editar");
        editarButton.setBounds(375, 600, 100, 30);

        this.add(adicionarButton);
        this.add(removerButton);
        this.add(editarButton);


        //========================================
        // Tabela
        String[] colunas = {"Id", "Nome", "NIF", "Morada", "Telefone", "Email"};

        String[][] data = {{"", "", "", "", "", ""}
                , {"", "", "", "", "", ""}};

        JTable tabela = new JTable(data, colunas);
        JScrollPane sp = new JScrollPane(tabela);
        sp.setBounds(500, 150, 350, 400);


        this.add(sp);

        opcao1.addActionListener(this);
        opcao2.addActionListener(this);
        opcao3.addActionListener(this);
        opcao4.addActionListener(this);
        opcao5.addActionListener(this);
        opcao6.addActionListener(this);
        sairButton.addActionListener(this);
        adicionarButton.addActionListener(this);
        removerButton.addActionListener(this);
        editarButton.addActionListener(this);


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
            painelFundo.mudaEcra("AdicionarClientes");
        }
        if (e.getActionCommand().equals("Estatistica")) {
            painelFundo.mudaEcra("Estatistica");
        }
        if (e.getActionCommand().equals("Dados Pessoais")) {
            painelFundo.mudaEcra("DadosPessoaisAdmin");
        }

        if (e.getActionCommand().equals("Sair")) {
            painelFundo.mudaEcra("Login");
        }

        if (e.getActionCommand().equals("Adicionar")) {

        }
        if (e.getActionCommand().equals("Remover")) {

        }
        if(e.getActionCommand().equals("Editar")){
            painelFundo.mudaEcra("ClientesEditar");

        }



    }
}
