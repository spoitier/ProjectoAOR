package interfacegrafica;

import programa.Aor_Autocarro;
import programa.Cliente;
import programa.FicheiroDeObjectos;
import programa.Utilizador;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;


public class Login extends JPanel implements ActionListener {

    Aor_Autocarro aor_autocarro = new Aor_Autocarro();
    Cliente cliente;


    PainelFundo painelFundo;
    TextField emailField;
    JPasswordField palavraChaveField;
    JButton botaoautenticar;
    JButton botaoregistar;


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
        emailField = new TextField();
        emailField.setBounds(150, 50, 170, 30);

        // Textofield da palavrachave
        palavraChaveField = new JPasswordField();
        palavraChaveField.setBounds(150, 100, 170, 30);

        //Botão de auntenticar
        botaoautenticar = new JButton("Autenticar");
        botaoautenticar.setBounds(20, 160, 300, 30);

        //Botao de Registar programa.Utilizador
        botaoregistar = new JButton("Registar Novo Utilizador");
        botaoregistar.setBounds(275, 400, 350, 50);

        // Adicionar componentes ao painel
        loginPanel.add(login);
        loginPanel.add(email);
        loginPanel.add(palavraChave);
        loginPanel.add(emailField);
        loginPanel.add(palavraChaveField);
        loginPanel.add(botaoautenticar);


        //Adicionar paineis ao frame
        this.add(mainPanel);
        this.add(loginPanel);
        this.add(botaoregistar);

        // Adicionar ao Listener
        botaoregistar.addActionListener(this);
        botaoautenticar.addActionListener(this);


    }
    //====================================
    //Codigo só funciona com metodo nesta classe
    public boolean validarEmail(String email) {
        boolean validar = false;
        String[] email2 = email.split("");
        for (int i = 0; i < email2.length; i++) {
            if (email2[i].equals("@")) {
                for (int j = i; j < email2.length; j++) {
                    if (email2[j].equals(".")) {
                        validar = true;
                    }
                }
            }
        }return validar;
    }



    //*******************************************
    //Eventos
    @Override
    public void actionPerformed(ActionEvent ae) {

        String email = emailField.getText();
        String password = new String(palavraChaveField.getPassword());//para transformar em string

        if (ae.getActionCommand().equals("Autenticar")) {
            if ((validarEmail(email))&&(aor_autocarro.validarRegisto(email,password ))){
                JOptionPane.showMessageDialog(null, "Login efetuado com Sucesso! " + email);
                if(aor_autocarro.verificarTipoUtilizador(email,password).equals("cliente")){
                    painelFundo.mudaEcra("ReservaViagem");
                }
                else if(aor_autocarro.verificarTipoUtilizador(email,password).equals("administrador")){
                    painelFundo.mudaEcra("RegistarNovoAdministrador");
                }
            } else{
                JOptionPane.showMessageDialog(null, "Login Invalido!");

            }
        }
        if(ae.getActionCommand().equals("Registar Novo Utilizador")) {
            painelFundo.mudaEcra("RegistarUtilizador");
        }
    }
}