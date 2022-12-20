package interfacegrafica;

import javax.swing.*;
import java.awt.*;

public class AlterarPalavraChaveAdmin  extends JPanel {

    PainelFundo painelFundo;



    public AlterarPalavraChaveAdmin(PainelFundo painelFundo) {
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
        JLabel segundoTitulo =new JLabel("Dados Pessoais");
        segundoTitulo.setBounds(50,100,900,30);
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


        JLabel emailPreenchido = new JLabel("Preenchido automaticamente");
        emailPreenchido.setBounds(200, 25, 170, 30);

        TextField palavraChaveAtualField = new TextField();
        palavraChaveAtualField.setBounds(200, 75, 170, 30);

        TextField novaPalavraChaveField = new TextField();
        novaPalavraChaveField.setBounds(200, 125, 170, 30);

        TextField confirmePalavraChaveField = new TextField();
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

        JButton alterarPalavraChaveButton = new JButton("Alterar palavra chave");
        alterarPalavraChaveButton.setBounds(650,225,200,30);
        this.add(alterarPalavraChaveButton);







    }
}
