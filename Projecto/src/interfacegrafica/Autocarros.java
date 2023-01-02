package interfacegrafica;

import programa.Aor_Autocarro;
import programa.Autocarro;
import programa.FicheiroDeObjectos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Autocarros extends JPanel implements ActionListener {

    PainelFundo painelFundo;
    JScrollPane sp;
    Aor_Autocarro aor_autocarro;

    JTable tabela;

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

    JLabel adminNome;

    public JTextField matriculaField;

    private JTextField marcaField;
    private JTextField modeloField;

    private JTextField lotacaoField;


    JTextField matriculaFieldRemover;

    public JTextField matriculaFieldEditar;


    public Autocarros(PainelFundo painelFundo, Aor_Autocarro aor_autocarro) {
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
        matriculaField = new JTextField();
        matriculaField.setBounds(150, 50, 200, 30);
        marcaField = new JTextField();
        marcaField.setBounds(150, 90, 200, 30);
        modeloField = new JTextField();
        modeloField.setBounds(150, 130, 200, 30);
        lotacaoField = new JTextField();
        lotacaoField.setBounds(150, 170, 200, 30);
        matriculaFieldRemover = new JTextField();
        matriculaFieldRemover.setBounds(150, 300, 200, 30);
        matriculaFieldEditar = new JTextField();
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

        String[][] data = new String[aor_autocarro.getAutocarros().size()][4];

        for (int i = 0; i < aor_autocarro.getAutocarros().size(); i++) {
            data[i][0] = aor_autocarro.getAutocarros().get(i).getMatricula();
            data[i][1] = aor_autocarro.getAutocarros().get(i).getMarca();
            data[i][2] = aor_autocarro.getAutocarros().get(i).getModelo();
            data[i][3] = String.valueOf(aor_autocarro.getAutocarros().get(i).getLotacao());
        }
        tabela = new JTable(data, colunas);
        sp = new JScrollPane(tabela);
        sp = new JScrollPane(tabela);
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



    public void atualizar() {
        FicheiroDeObjectos.escreveObjeto(aor_autocarro);
        String[] colunas = {"Matricula", "Marca", "Modelo", "Lotação"};

        String[][] data = new String[aor_autocarro.getAutocarros().size()][4];
        this.remove(sp);
        for (int i = 0; i < aor_autocarro.getAutocarros().size(); i++) {
            data[i][0] = aor_autocarro.getAutocarros().get(i).getMatricula();
            data[i][1] = aor_autocarro.getAutocarros().get(i).getMarca();
            data[i][2] = aor_autocarro.getAutocarros().get(i).getModelo();
            data[i][3] = String.valueOf(aor_autocarro.getAutocarros().get(i).getLotacao());

        }
        tabela = new JTable(data, colunas);
        JScrollPane sp = new JScrollPane(tabela);
        sp.setBounds(550, 150, 300, 400);
        this.add(sp);
        revalidate();
        repaint();

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getActionCommand().equals("Adminstradores")) {
            painelFundo.mudaEcra("RegistarNovoAdministrador");
        }

        if (e.getActionCommand().equals("Motoristas")) {
            painelFundo.mudaEcra("Motoristas");
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
            boolean validar = true;
            if (matriculaField.getText().isBlank() && marcaField.getText().isBlank() &&
                    matriculaField.getText().isBlank() && lotacaoField.getText().isBlank()) {
                JOptionPane.showMessageDialog(null, "Há campos de preenchimento obrigatório que não foram preenchidos");
                validar = false;
            }
            if (!Autocarro.validarMatricula(matriculaField.getText())) {
                JOptionPane.showMessageDialog(null, "Matricula invalida.");
                validar = false;
            }
            if (aor_autocarro.verificarDuplicacaoMatricula(matriculaField.getText())) {
                JOptionPane.showMessageDialog(null, "Matricula Duplicada.");
                validar = false;
            }
            if (Autocarro.validarMarca(marcaField.getText())) {
                JOptionPane.showMessageDialog(null, "Marca invalida");
                validar = false;
            }

            if (Integer.parseInt(lotacaoField.getText()) > 50) {
                JOptionPane.showMessageDialog(null, "Lotação maxima é 50 passageiros");
                validar = false;
            }
            if (validar == false) {
            } else {
                aor_autocarro.getAutocarros().add(new Autocarro(matriculaField.getText(), marcaField.getText(), modeloField.getText(), lotacaoField.getText()));
                JOptionPane.showMessageDialog(null, "Autocarro Adicionado com Sucesso");
                atualizar();
                matriculaField.setText("");
                marcaField.setText("");
                modeloField.setText("");
                lotacaoField.setText("");

            }

        }
        if (e.getActionCommand().equals("Remover")) {
            if (matriculaFieldRemover.getText() == null) {
                JOptionPane.showMessageDialog(null, "Falta preencher");
            } else if ((aor_autocarro.removerAutocarro(matriculaFieldRemover.getText())) == null) {
                JOptionPane.showMessageDialog(null, "Não existe nenhum autocarro com essa matricula");
            } else {
                try {
                    JOptionPane.showMessageDialog(null, "Removido com sucesso!");
                    Autocarro removido = aor_autocarro.removerAutocarro(matriculaFieldRemover.getText());
                    aor_autocarro.getAutocarros().remove(removido);
                    atualizar();
                    matriculaField.setText("");
                } catch (NullPointerException n) {
                    JOptionPane.showMessageDialog(null, "Não existe nenhum autocarro com essa matricula");
                }


            }

        }

        if (e.getActionCommand().equals("Editar")) {
            if (matriculaFieldEditar.getText() == null) {
                JOptionPane.showMessageDialog(null, "Falta preencher");
            } else if ((aor_autocarro.removerAutocarro(matriculaFieldEditar.getText())) == null) {
                JOptionPane.showMessageDialog(null, "Não existe nenhum autocarro com essa matricula");
            } else {
                painelFundo.mudaEcra("AutocarrosEditar");

            }

        }
    }
}