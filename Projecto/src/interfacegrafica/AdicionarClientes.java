package interfacegrafica;

import javax.swing.*;
import java.awt.*;

public class AdicionarClientes extends JPanel {
    PainelFundo painelFundo;

    JPanel jPanel;

    public  AdicionarClientes (PainelFundo painelFundo) {
        this.painelFundo =  painelFundo;
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
        JButton sairBotao = new JButton("Sair");
        sairBotao.setBounds(810, 1, 70, 28);
        cabecalho.add(sairBotao);
        this.add(cabecalho);

        //===========================================================
        //Painel de escolhas do Admin
        JPanel opcaoPainel = new JPanel();
        opcaoPainel.setLayout(new GridLayout(1, 5,15,0));
        opcaoPainel.setBounds(0, 35, 900, 50);
        opcaoPainel.setBorder(BorderFactory.createLineBorder(Color.BLACK));



        JButton opcao1 = new JButton("Adminstradores");
        JButton opcao2 = new JButton("Motoristas");
        JButton opcao3 = new JButton("Autocarros");
        JButton opcao4 = new JButton("Estatistica");
        JButton opcao5 = new JButton("Dados Pessoais");

        opcaoPainel.add(opcao1);
        opcaoPainel.add(opcao2);
        opcaoPainel.add(opcao3);
        opcaoPainel.add(opcao4);
        opcaoPainel.add(opcao5);

        this.add(opcaoPainel);


        //=====================================================================
        //Segundo titulo
        JLabel segundoTitulo =new JLabel("Clientes ");
        segundoTitulo.setBounds(50,100,900,30);
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
        nifRemoverLabel.setBounds(50,425,200,30);
        JLabel nifEditarLabel = new JLabel("NIF:");
        nifEditarLabel.setBounds(50,500,200,30);


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
        nifRemoverField.setBounds(150,425,200,30);
        JTextField nifEditarField = new JTextField();
        nifEditarField.setBounds(150,500,200,30);

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

        JButton adicionar = new JButton("Adicionar");
        adicionar.setBounds(375,150,100,30);;

        JButton remover = new JButton("Remover");
        remover.setBounds(375,525,100,30);;

        JButton editar = new JButton("Editar");
        editar.setBounds(375,600,100,30);

        this.add(adicionar);
        this.add(remover);
        this.add(editar);


        //========================================
        // Tabela
        String [] colunas = {"Id","Nome","NIF","Morada","Telefone","Email"};

        String [][] data = {{"","","","","",""}
                ,{"","","","","",""}};

        JTable tabela = new JTable(data,colunas);
        JScrollPane sp = new JScrollPane(tabela);
        sp.setBounds(500,150,350,400);



        this.add(sp);


    }
}
