package interfacegrafica;

import programa.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.OptionalDataException;

public class Motoristas extends JPanel implements ActionListener {

    PainelFundo painelFundo;
    Aor_Autocarro aor_autocarro;

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
    JTable tabela;
    JLabel nomeLabel;
    JLabel emailLabel;
    JLabel adminNome;
    TextField nomeField;

    TextField emailField;
    JTextField removerField;
    JTextField editarField;



    public Motoristas(PainelFundo painelFundo, Aor_Autocarro aor_autocarro) {
        this.aor_autocarro = aor_autocarro;
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
        adminNome = new JLabel("Nome do Admin");
        adminNome.setBounds(700, 0, 100, 30);
        cabecalho.add(adminNome);

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
        loginPanel.setBounds(10, 150, 300, 100);

        //Label do nomeLabel
        nomeLabel = new JLabel("Nome:");
        nomeLabel.setBounds(0, 0, 80, 30);

        //Label da palavra chave
        emailLabel = new JLabel("Email");
        emailLabel.setBounds(0, 50, 80, 30);

        // Textofield do nomeLabel
        nomeField = new TextField();
        nomeField.setBounds(100, 0, 170, 30);

        emailField = new TextField();
        emailField.setBounds(100, 50, 170, 30);
        ;
        // Adicionar componentes ao painel
        loginPanel.add(nomeLabel);
        loginPanel.add(emailLabel);
        loginPanel.add(nomeField);
        loginPanel.add(emailField);
        this.add(loginPanel);


        JPanel removerPanel = new JPanel();
        removerPanel.setLayout(null);
        removerPanel.setBounds(10,300,300,100);
        JLabel removerLabel = new JLabel("Email:");
        removerLabel.setBounds(0, 0, 80, 30);
        removerField = new JTextField();
        removerField.setBounds(100,0,170,30);
        removerPanel.add(removerLabel);
        removerPanel.add(removerField);
        this.add(removerPanel);

        JPanel editarPanel = new JPanel();
        editarPanel.setLayout(null);
        editarPanel.setBounds(10,450,300,100);
        JLabel editarLabel = new JLabel("Email:");
        editarLabel.setBounds(0, 0, 80, 30);
        editarField = new JTextField();
        editarField.setBounds(100,0,170,30);
        editarPanel.add(editarLabel);
        editarPanel.add(editarField);
        this.add(editarPanel);









        //==========================================
        // Painel botoes


        adicionarButton = new JButton("Adicionar");
        adicionarButton.setBounds(350, 200, 100, 30);
        removerButton = new JButton("Remover");
        removerButton.setBounds(350, 300, 100, 30);
        editarButton = new JButton("Editar");
        editarButton.setBounds(350, 450, 100, 30);


        this.add(adicionarButton);
        this.add(removerButton);
        this.add(editarButton);

        //========================================
        // Tabela

        JPanel tabelaPainel = new JPanel();
        tabelaPainel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        tabelaPainel.setBounds(550, 250, 250, 200);
        setLayout(null);

        String[] colunas = {"Nome", "Email"};
        String[][] data = new String[aor_autocarro.getMotoristas().size()][2];

        for (int i =0;i<aor_autocarro.getMotoristas().size();i++) {
            data[i][0]=aor_autocarro.getMotoristas().get(i).getNome();
            data[i][1]=aor_autocarro.getMotoristas().get(i).getEmail();

        }


        tabela = new JTable(data, colunas);
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
            if ((Utilizador.validarNome(nomeField.getText())) &&
                    (Utilizador.validarEmail(emailField.getText())) &&
                    (!aor_autocarro.verificarDuplicaçãoEmailMotorista(emailField.getText()))) {
                aor_autocarro.getMotoristas().add(new Motorista(nomeField.getText(), emailField.getText()));
                JOptionPane.showMessageDialog(null, "Adicionado com sucesso!");
                FicheiroDeObjectos.escreveObjeto(aor_autocarro);


            } else if (aor_autocarro.verificarDuplicaçãoEmailMotorista(emailField.getText())) {
                JOptionPane.showMessageDialog(null, "Email duplicado!");

            } else if (!Utilizador.validarNome(nomeField.getText())) {
                JOptionPane.showMessageDialog(null, "Nome com carateres inválidos");
            } else if (!Utilizador.validarEmail(emailField.getText())) {
                JOptionPane.showMessageDialog(null, "Email inválido");
            }
        }


        if (e.getActionCommand().equals("Remover")) {
            if (aor_autocarro.removerMotorista(removerField.getText())==null) {
                JOptionPane.showMessageDialog(null, "Não existe nenhum motorista");
            } else {
                try {
                    Motorista removido = aor_autocarro.removerMotorista(removerField.getText());
                    JOptionPane.showMessageDialog(null,"Removido com sucesso!");
                    aor_autocarro.getMotoristas().remove(removido);
                } catch (NullPointerException n) {
                    JOptionPane.showMessageDialog(null, "Não existe nenhum motorista com esse email");
                }
                FicheiroDeObjectos.escreveObjeto(aor_autocarro);

            }


        }


    }
}