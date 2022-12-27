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
import java.time.LocalDate;

public class RegistarUtilizador extends JPanel implements ActionListener {

    PainelFundo painelFundo;
    JButton prosseguirButton;
    JButton retrocessoButton;
    Aor_Autocarro aor_autocarro;
    JLabel nomeLabel;
    JLabel nifLabel;

    JLabel moradaLabel;

    JLabel telefoneLabel;
    JLabel emailLabel;
    JLabel palavraChaveLabel;
    JTextField nomeField;
    JTextField nifField;
    JTextField moradaField;
    JTextField telefoneField;
    JTextField emailField;
    JTextField palavraChaveField;


    public RegistarUtilizador(PainelFundo painelfundo, Aor_Autocarro aor_autocarro) {
        this.aor_autocarro = aor_autocarro;
        this.painelFundo = painelfundo;
        this.setLayout(null);


        JPanel cabecalho = new JPanel();
        cabecalho.setLayout(null);
        cabecalho.setBounds(0, 50, 900, 100);
        cabecalho.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        JLabel tituloPrimario = new JLabel("AOR-AUTOCARROS");
        tituloPrimario.setBounds(0, 20, 300, 30);

        JLabel tituloSecundario = new JLabel("Registar Novo Utilizador:\n");
        tituloSecundario.setBounds(0, 70, 300, 30);

        retrocessoButton = new JButton("Retrocesso");
        retrocessoButton.setBounds(750, 65, 100, 30);

        cabecalho.add(tituloPrimario);
        cabecalho.add(tituloSecundario);
        cabecalho.add(retrocessoButton);
        this.add(cabecalho);

        //Painel Formulario

        JPanel formulario = new JPanel();
        formulario.setLayout(null);
        formulario.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        formulario.setBounds(250, 200, 400, 350);


        //Labels
        nomeLabel = new JLabel("Nome:");
        nomeLabel.setBounds(50, 50, 200, 30);
        nifLabel = new JLabel("NIF:");
        nifLabel.setBounds(50, 90, 200, 30);
        moradaLabel = new JLabel("Morada:");
        moradaLabel.setBounds(50, 130, 200, 30);
        telefoneLabel = new JLabel("Telefone:");
        telefoneLabel.setBounds(50, 170, 200, 30);
        emailLabel = new JLabel("Email:");
        emailLabel.setBounds(50, 210, 200, 30);
        palavraChaveLabel = new JLabel("Palavra Chave:");
        palavraChaveLabel.setBounds(50, 250, 200, 30);

        //Fields
        nomeField = new JTextField();
        nomeField.setBounds(150, 50, 200, 30);
        nifField = new JTextField();
        nifField.setBounds(150, 90, 200, 30);
        moradaField = new JTextField();
        moradaField.setBounds(150, 130, 200, 30);
        telefoneField = new JTextField();
        telefoneField.setBounds(150, 170, 200, 30);
        emailField = new JTextField();
        emailField.setBounds(150, 210, 200, 30);
        palavraChaveField = new JTextField();
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


        // Buttons
        prosseguirButton = new JButton("Prosseguir");
        prosseguirButton.setBounds(340, 575, 200, 70);

        //Adicionar botoes ao actionListener
        prosseguirButton.addActionListener(this);
        retrocessoButton.addActionListener(this);


        this.add(prosseguirButton);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        boolean validar = true;
        if (e.getActionCommand().equals("Prosseguir")) {


            //verificar se todos os campos estão preenchidos
            if (nomeField.getText().equals("") || nifField.getText().equals("") ||
                    moradaField.getText().equals("") || telefoneField.getText().equals("") ||
                    emailField.getText().equals("") || palavraChaveField.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Há campos de preenchimento obrigatório que não foram preenchidos");
                validar=false;
            }
            //Verificar se email é válido
            if (!Utilizador.validarEmail(emailField.getText())) {
                emailLabel.setForeground(Color.red);
                JOptionPane.showMessageDialog(null, "Email inválido");
                validar=false;
            }
            //Verificar se o nome é constituído só por letras
            if (!Utilizador.validarNome(nomeField.getText())) {
                nomeLabel.setForeground(Color.red);
                JOptionPane.showMessageDialog(null, "Nome com carateres inválidos");
                validar=false;
            }
            //Verificar se o nif é constituído por 9 números
            if (Utilizador.validarTlfeNif(nifField.getText())) {
                nifLabel.setForeground(Color.red);
                JOptionPane.showMessageDialog(null, "Nif inválido");
                validar=false;
            }
            //Verificar se o telefone é constituído por 9 números
            if (Utilizador.validarTlfeNif(telefoneField.getText())) {
                telefoneLabel.setForeground(Color.red);
                JOptionPane.showMessageDialog(null, "Número de telefone inválido");
                validar=false;
            }
            //Verificar se existe já algum Cliente registado com o nif registado
            if (aor_autocarro.verificarDuplicaçãoNif(nifField.getText())) {
                nifLabel.setForeground(Color.red);
                JOptionPane.showMessageDialog(null, "Já existe um cliente registado com esse nif");
                validar=false;
            }
            //Verificar se existe já algum Cliente registado com o email registado
            if (aor_autocarro.verificarDuplicaçãoEmail(emailField.getText())) {
                emailLabel.setForeground(Color.red);
                JOptionPane.showMessageDialog(null, "Já existe um cliente registado com esse email");
                validar=false;
            }
            if (validar == false) {
            } else {
                String id="cl".concat(String.valueOf(aor_autocarro.contarCliente()));
                System.out.println("cl"+aor_autocarro.contarCliente());
                aor_autocarro.getUtilizadores().add(new Cliente(id,emailField.getText(), palavraChaveField.getText(), nomeField.getText(), nifField.getText(),
                        moradaField.getText(), telefoneField.getText(), "Normal", LocalDate.now()));
                try {
                    FicheiroDeObjectos.escreveObjeto(aor_autocarro);
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(null,"Erro");
                }
                painelFundo.mudaEcra("PlanoSubscrição");
            }
        }
        if (e.getActionCommand().equals("Retrocesso")) {
            painelFundo.mudaEcra("Login");
        }
    }

}