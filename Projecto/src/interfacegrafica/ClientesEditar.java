package interfacegrafica;

import programa.Aor_Autocarro;
import programa.Cliente;
import programa.FicheiroDeObjectos;
import programa.Utilizador;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClientesEditar extends JPanel implements ActionListener {

    Aor_Autocarro aor_autocarro;
    PainelFundo painelFundo;

    Utilizador utilizador;
    JButton sairButton;
    JButton opcao1;
    JButton opcao2;
    JButton opcao3;
    JButton opcao4;
    JButton opcao5;
    JButton opcao6;
    JButton editarButton;
    JLabel nomeLabel;
    JLabel nifLabel;
    JLabel moradaLabel;
    JLabel telefoneLabel;
    JLabel emailLabel;
    JTextField nameField;
    JLabel nifLabelPreenchido;
    JTextField moradaField;
    JTextField telefoneField;
    JTextField emailField;


    ClientesEditar(PainelFundo painelFundo, Aor_Autocarro aor_autocarro) {
        this.aor_autocarro=aor_autocarro;
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


        //Fields
        nameField = new JTextField();
        nameField.setBounds(150, 50, 200, 30);
        nifLabelPreenchido = new JLabel();
        nifLabelPreenchido.setBounds(150, 90, 200, 30);
        moradaField = new JTextField();
        moradaField.setBounds(150, 130, 200, 30);
        telefoneField = new JTextField();
        telefoneField.setBounds(150, 170, 200, 30);
        emailField = new JTextField();
        emailField.setBounds(150, 210, 200, 30);


        //Adicionar ao formulario
        formulario.add(nomeLabel);
        formulario.add(nifLabel);
        formulario.add(moradaLabel);
        formulario.add(telefoneLabel);
        formulario.add(emailLabel);
        formulario.add(nameField);
        formulario.add(nifLabelPreenchido);
        formulario.add(moradaField);
        formulario.add(telefoneField);
        formulario.add(emailField);
        this.add(formulario);

        editarButton = new JButton("Editar");
        editarButton.setBounds(350, 400, 100, 30);
        this.add(editarButton);

        opcao1.addActionListener(this);
        opcao2.addActionListener(this);
        opcao3.addActionListener(this);
        opcao4.addActionListener(this);
        opcao5.addActionListener(this);
        opcao6.addActionListener(this);
        sairButton.addActionListener(this);
        editarButton.addActionListener(this);


    }

    public void setCliente(Utilizador utilizador) {
        if(!(utilizador==null)) {
            this.utilizador=utilizador;
            nifLabelPreenchido.setText(utilizador.getNif());
            nameField.setText(utilizador.getNome());
            moradaField.setText(utilizador.getMorada());
            telefoneField.setText(utilizador.getTelefone());
            emailField.setText(utilizador.getEmail());
            revalidate();
            repaint();
        }


    }

    /*
    public void nifDescrito() {

        if (adicionarClientes== null) {
           nifField.setText("");
        } else
            nifField.setText(adicionarClientes.getNifEditavel());
            System.out.println(adicionarClientes.getNifEditavel());
        revalidate();
        repaint();

    }

     */

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Editar")) {
            this.utilizador.setNome(nameField.getText());
            this.utilizador.setEmail(emailField.getText());
            this.utilizador.setMorada(moradaField.getText());
            this.utilizador.setTelefone(telefoneField.getText());
            FicheiroDeObjectos.escreveObjeto(aor_autocarro);

            nameField.setText("");
            nifLabelPreenchido.setText("");
            emailField.setText("");
            moradaField.setText("");
            telefoneField.setText("");
            JOptionPane.showMessageDialog(null,"Editado com sucesso!");
            ((AdicionarClientes)(painelFundo.mapaPaineis.get("AdicionarClientes"))).atualizar();
            painelFundo.mudaEcra("AdicionarClientes");


        }
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
            ((Login)painelFundo.mapaPaineis.get("Login")).sair();
            painelFundo.mudaEcra("Login");
        }

    }
}
