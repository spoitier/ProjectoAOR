package interfacegrafica;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Autocarros extends JPanel implements ActionListener {

    PainelFundo painelFundo;

    JButton sairBotao;
    JButton opcao1;
    JButton opcao2;
    JButton opcao3;
    JButton opcao4;

    JButton opcao5;

    JButton opcao6;

    JButton adicionarButton;
    JButton removerButton;
    JButton editarButton;

    public Autocarros(PainelFundo painelFundo) {
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
        JLabel segundoTitulo = new JLabel("Autocarros ");
        segundoTitulo.setBounds(50, 100, 900, 30);
        this.add(segundoTitulo);

        //======================================================================
        //Formulario

        JPanel formulario = new JPanel();
        formulario.setLayout(null);
        formulario.setBounds(10, 100, 350, 500);


        //Labels
        JLabel matriculaLabel = new JLabel("Matricula:");
        matriculaLabel.setBounds(50, 50, 200, 30);
        JLabel marcaLabel = new JLabel("Marca:");
        marcaLabel.setBounds(50, 90, 200, 30);
        JLabel modeloLabel = new JLabel("Modelo:");
        modeloLabel.setBounds(50, 130, 200, 30);
        JLabel lotacaoLabel = new JLabel("Lotação:");
        lotacaoLabel.setBounds(50, 170, 200, 30);
        JLabel matricularemoverLabel = new JLabel("Matricula:");
        matricularemoverLabel.setBounds(50, 300, 200, 30);
        JLabel matriculaEditarLabel = new JLabel("Matricula");
        matriculaEditarLabel.setBounds(50, 400, 200, 30);

        //Fields
        JTextField matriculaField = new JTextField();
        matriculaField.setBounds(150, 50, 200, 30);
        JTextField marcaField = new JTextField();
        marcaField.setBounds(150, 90, 200, 30);
        JTextField modeloField = new JTextField();
        modeloField.setBounds(150, 130, 200, 30);
        JTextField lotacaoField = new JTextField();
        lotacaoField.setBounds(150, 170, 200, 30);
        JTextField matriculaFieldRemover = new JTextField();
        matriculaFieldRemover.setBounds(150, 300, 200, 30);
        JTextField matriculaFieldEditar = new JTextField();
        matriculaFieldEditar.setBounds(150, 400, 200, 30);

        //Adicionar ao formulario
        formulario.add(matriculaLabel);
        formulario.add(marcaLabel);
        formulario.add(modeloLabel);
        formulario.add(lotacaoLabel);
        formulario.add(matricularemoverLabel);
        formulario.add(matriculaEditarLabel);
        formulario.add(matriculaField);
        formulario.add(marcaField);
        formulario.add(modeloField);
        formulario.add(lotacaoField);
        formulario.add(matriculaFieldRemover);
        formulario.add(matriculaFieldEditar);
        this.add(formulario);

        adicionarButton = new JButton("Adicionar");
        adicionarButton.setBounds(400, 200, 100, 30);


        removerButton = new JButton("Remover");
        removerButton.setBounds(400, 400, 100, 30);


        editarButton = new JButton("Editar");
        editarButton.setBounds(400, 500, 100, 30);

        this.add(adicionarButton);
        this.add(removerButton);
        this.add(editarButton);


        //========================================
        // Tabela
        String[] colunas = {"Matricula", "Marca", "Modelo", "Lotação"};

        String[][] data = {{"", "", "", ""}
                , {"", "", "", ""}};

        JTable tabela = new JTable(data, colunas);
        JScrollPane sp = new JScrollPane(tabela);
        sp.setBounds(550, 150, 300, 400);
        this.add(sp);


        opcaoPainel.add(opcao1);
        opcaoPainel.add(opcao2);
        opcaoPainel.add(opcao3);
        opcaoPainel.add(opcao4);
        opcaoPainel.add(opcao5);
        opcaoPainel.add(opcao6);

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
            painelFundo.mudaEcra("AutocarrosEditar");

        }

    }
}
