package interfacegrafica;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Motoristas extends JPanel implements ActionListener {

    PainelFundo painelFundo;

    JButton sairBotao;
    JButton opcao1;
    JButton opcao2;
    JButton opcao4;
    JButton opcao3;
    JButton opcao5;
    JButton opcao6;
    JButton adicionarButton;
    JButton removerButton;
    JButton editarButton;


    public Motoristas(PainelFundo painelFundo) {
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
        JLabel segundoTitulo = new JLabel("Motoristas ");
        segundoTitulo.setBounds(50, 100, 900, 30);
        this.add(segundoTitulo);

        //Painel do Login
        JPanel loginPanel = new JPanel();
        loginPanel.setLayout(null);
        loginPanel.setBounds(50, 200, 350, 150);

        //Label do nomeLabel
        JLabel nomeLabel = new JLabel("Nome:");
        nomeLabel.setBounds(30, 50, 80, 30);

        //Label da palavra chave
        JLabel emailLabel = new JLabel("Email");
        emailLabel.setBounds(30, 100, 100, 30);

        // Textofield do nomeLabel
        TextField nomeField = new TextField();
        nomeField.setBounds(150, 50, 170, 30);

        // Textofield da palavrachave
        TextField emailField = new TextField();
        emailField.setBounds(150, 100, 170, 30);
        ;
        // Adicionar componentes ao painel
        loginPanel.add(nomeLabel);
        loginPanel.add(emailLabel);
        loginPanel.add(nomeField);
        loginPanel.add(emailField);
        this.add(loginPanel);

        //==========================================
        // Painel botoes

        JPanel botoesPainel = new JPanel(new GridLayout(1, 3, 10, 10));
        botoesPainel.setBounds(50, 400, 400, 30);

        adicionarButton = new JButton("Adicionar");
        removerButton = new JButton("Remover");
        editarButton = new JButton("Editar");
        botoesPainel.add(adicionarButton);
        botoesPainel.add(removerButton);
        botoesPainel.add(editarButton);

        this.add(botoesPainel);

        //========================================
        // Tabela

        JPanel tabelaPainel = new JPanel();
        tabelaPainel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        tabelaPainel.setBounds(550, 250, 250, 200);
        setLayout(null);

        String[] colunas = {"Nome", "Email"};

        String[][] data = {{"Rodrigo", "qq@gmail.com"}
                , {"Sonia", "qq@gmail.com"}};


        JTable tabela = new JTable(data, colunas);
        JScrollPane sp = new JScrollPane(tabela);
        sp.setBounds(550, 150, 300, 400);
        this.add(sp);

        opcao1.addActionListener(this);
        opcao2.addActionListener(this);
        opcao3.addActionListener(this);
        opcao4.addActionListener(this);
        opcao5.addActionListener(this);
        opcao6.addActionListener(this);
        sairBotao.addActionListener(this);
        adicionarButton.addActionListener(this);
        removerButton.addActionListener(this);
        editarButton.addActionListener(this);



    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("Adminstradores")) {
            painelFundo.mudaEcra("RegistarNovoAdministrador");
        }

        if(e.getActionCommand().equals("Motoristas")) {
            painelFundo.mudaEcra("Motoristas");
        }

        if(e.getActionCommand().equals("Autocarros")) {
            painelFundo.mudaEcra("Autocarros");
        }

        if(e.getActionCommand().equals("Clientes")) {
            painelFundo.mudaEcra("AdicionarClientes");
        }
        if(e.getActionCommand().equals("Estatistica")) {
            painelFundo.mudaEcra("Estatistica");
        }
        if(e.getActionCommand().equals("Dados Pessoais")) {
            painelFundo.mudaEcra("DadosPessoaisAdmin");
        }

        if(e.getActionCommand().equals("Sair")){
            painelFundo.mudaEcra("Login");
        }

        if(e.getActionCommand().equals("Adicionar")) {

        }
        if(e.getActionCommand().equals("Remover")) {

        }





    }
}
