package interfacegrafica;

import javax.swing.*;
import java.awt.*;

public class Autocarros extends JPanel {

    PainelFundo painelFundo;

    public Autocarros (PainelFundo painelFundo) {
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
        JLabel segundoTitulo =new JLabel("Autocarros ");
        segundoTitulo.setBounds(50,100,900,30);
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

        JButton adicionar = new JButton("Adicionar");
        adicionar.setBounds(400,200,100,30);;

        JButton remover = new JButton("Remover");
        remover.setBounds(400,400,100,30);;

        JButton editar = new JButton("Editar");
        editar.setBounds(400,500,100,30);

        this.add(adicionar);
        this.add(remover);
        this.add(editar);


        //========================================
        // Tabela
        String [] colunas = {"Matricula","Marca","Modelo","Lotação"};

        String [][] data = {{"","","",""}
                ,{"","","",""}};

        JTable tabela = new JTable(data,colunas);
        JScrollPane sp = new JScrollPane(tabela);
        sp.setBounds(550,150,300,400);



        this.add(sp);





    }



}
