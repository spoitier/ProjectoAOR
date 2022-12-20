package interfacegrafica;

import javax.swing.*;
import java.awt.*;

public class AutocarrosEditar extends JPanel {

    PainelFundo painelFundo;

    public AutocarrosEditar (PainelFundo painelFundo) {
        this.painelFundo = painelFundo;
        this.setLayout(null);

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
        formulario.setBounds(10, 100, 350, 250);


        //Labels
        JLabel matriculaEditarLabel = new JLabel("Matricula");
        matriculaEditarLabel.setBounds(50, 40, 200, 30);
        JLabel matriculaPreenchida = new JLabel("Matricula preenchida");
        matriculaPreenchida.setBounds(150, 40, 200, 30);

        JLabel matriculaLabel = new JLabel("Matricula:");
        matriculaLabel.setBounds(50, 90, 200, 30);
        JLabel marcaLabel = new JLabel("Marca:");
        marcaLabel.setBounds(50, 130, 200, 30);
        JLabel modeloLabel = new JLabel("Modelo:");
        modeloLabel.setBounds(50, 170, 200, 30);
        JLabel lotacaoLabel = new JLabel("Lotação:");
        lotacaoLabel.setBounds(50, 210, 200, 30);

        //Fields
        JTextField matriculaField = new JTextField();
        matriculaField.setBounds(150, 90, 200, 30);
        JTextField marcaField = new JTextField();
        marcaField.setBounds(150, 130, 200, 30);
        JTextField modeloField = new JTextField();
        modeloField.setBounds(150, 170, 200, 30);
        JTextField lotacaoField = new JTextField();
        lotacaoField.setBounds(150, 210, 200, 30);

        //Adicionar ao formulario
        formulario.add(matriculaLabel);
        formulario.add(matriculaPreenchida);
        formulario.add(marcaLabel);
        formulario.add(modeloLabel);
        formulario.add(lotacaoLabel);
        formulario.add(matriculaEditarLabel);
        formulario.add(matriculaField);
        formulario.add(marcaField);
        formulario.add(modeloField);
        formulario.add(lotacaoField);
        this.add(formulario);

        JButton editar = new JButton("Editar");
        editar.setBounds(275,375,100,30);
        this.add(editar);
    }
}
