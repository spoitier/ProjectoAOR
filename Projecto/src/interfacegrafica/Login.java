package interfacegrafica;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Login extends JPanel implements ActionListener {

    PainelFundo painelFundo;


    public Login(PainelFundo painelfundo) {

        this.painelFundo = painelfundo;
        this.setLayout(null);


        //Painel do cabeçalho
        JPanel mainPanel = new JPanel();
        mainPanel.setBounds(-10, 30, 900, 60);
        mainPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        JLabel tituloPrincipal = new JLabel("Aor-Autocarros");
        tituloPrincipal.setBounds(10, 30, 900, 30);
        tituloPrincipal.setHorizontalAlignment(JLabel.CENTER);
        tituloPrincipal.setVerticalAlignment(JLabel.CENTER);
        mainPanel.add(tituloPrincipal);


        //Painel do Login
        JPanel loginPanel = new JPanel();
        loginPanel.setLayout(null);
        loginPanel.setBounds(275, 125, 350, 200);
        loginPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        //Label do login
        JLabel login = new JLabel("Login:");
        login.setBounds(10, 0, 50, 30);

        //Label do email
        JLabel email = new JLabel("Email");
        email.setBounds(30, 50, 80, 30);

        //Label da palavra chave
        JLabel palavraChave = new JLabel("Palavra-Chave");
        palavraChave.setBounds(30, 100, 100, 30);

        // Textofield do email
        TextField emailField = new TextField("Escreve aqui o seu email");
        emailField.setBounds(150, 50, 170, 30);

        // Textofield da palavrachave
        JPasswordField PalavraChaveField = new JPasswordField("Escreve aqui a sua Palavra-Chave");
        PalavraChaveField.setBounds(150, 100, 170, 30);

        //Botão de auntenticar
        JButton botaoautenticar = new JButton("Autenticar");
        botaoautenticar.setBounds(20, 160, 300, 30);

        //Botao de Registar Utilizador
        JButton botaoregistar = new JButton("Registar Novo Utilizador");
        botaoregistar.setBounds(275, 400, 350, 50);

        // Adicionar componentes ao painel
        loginPanel.add(login);
        loginPanel.add(email);
        loginPanel.add(palavraChave);
        loginPanel.add(emailField);
        loginPanel.add(PalavraChaveField);
        loginPanel.add(botaoautenticar);


        //Adicionar paineis ao frame
        this.add(mainPanel);
        this.add(loginPanel);
        this.add(botaoregistar);

        // Adicionar ao Listener
        botaoregistar.addActionListener(this);


    }

    //*******************************************
    //Eventos

    public void actionPerformed(ActionEvent ae) {

        painelFundo.mudaEcra("RegistarUtilizador");

        {

        }
    }
}