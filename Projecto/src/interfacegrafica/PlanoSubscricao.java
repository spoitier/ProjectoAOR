package interfacegrafica;

import programa.Aor_Autocarro;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

public class PlanoSubscricao extends JPanel implements ActionListener {

    PainelFundo painelFundo;
    JButton retrocessoButton;

    JCheckBox premiumCheck;
    JCheckBox normalCheck;

    Aor_Autocarro aor_autocarro;

    public PlanoSubscricao(PainelFundo painelFundo,Aor_Autocarro aor_autocarro) {
        this.aor_autocarro = aor_autocarro;
        this.painelFundo = painelFundo;
        this.setLayout(null);
        // Titulo
        JPanel mainPanel = new JPanel();
        mainPanel.setBounds(-10, 30, 900, 60);
        mainPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        JLabel tituloPrincipal = new JLabel("Aor-Autocarros");
        tituloPrincipal.setBounds(10, 30, 900, 30);
        tituloPrincipal.setHorizontalAlignment(JLabel.CENTER);
        tituloPrincipal.setVerticalAlignment(JLabel.CENTER);
        mainPanel.add(tituloPrincipal);

        // Titulo Secundario
        JLabel tituloSecundario = new JLabel("Selecione o Plano de Subscrição:");
        tituloSecundario.setBounds(0,100,900,30);
        tituloSecundario.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        this.add(tituloSecundario);
        this.add(mainPanel);

        retrocessoButton = new JButton("Retrocesso");
        retrocessoButton.setBounds(750, 100, 100, 30);
        this.add(retrocessoButton);

        //Painel de subscrição Normal
        JPanel normalPanel = new JPanel();
        normalPanel.setLayout(null);
        normalPanel.setBounds(170,200,200,200);
        normalPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        //Labels pertencentes ao painel normal
        JLabel normalLabel = new JLabel("NORMAL");
        normalLabel.setBounds(0,0,200,20);
        normalLabel.setHorizontalAlignment(JLabel.CENTER);
        JLabel normalLabel1 = new JLabel("Penalização de 50% até 7 dias");
        normalLabel1.setBounds(0,40,200,20);
        normalLabel1.setHorizontalAlignment(JLabel.CENTER);
        JLabel normalLabel2 = new JLabel("Sem prioridade na reserva");
        normalLabel2.setBounds(0,70,200,20);
        normalLabel2.setHorizontalAlignment(JLabel.CENTER);
        JLabel normalLabel3 = new JLabel("Mensalidade: gratuito");
        normalLabel3.setBounds(0,100,200,20);
        normalLabel3.setHorizontalAlignment(JLabel.CENTER);

        //Checkbox no painel normal
        normalCheck = new JCheckBox();
        normalCheck.setBounds(100,125,50,50);

        //Adicionar elementos ao painel normal
        normalPanel.add(normalLabel);
        normalPanel.add(normalLabel1);
        normalPanel.add(normalLabel2);
        normalPanel.add(normalLabel3);
        normalPanel.add(normalCheck);
        this.add(normalPanel);



        // Painel de subscrição Premium
        JPanel premiumPanel = new JPanel();
        premiumPanel.setLayout(null);
        premiumPanel.setBounds(500,200,200,200);
        premiumPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        //Labels pertencentes ao painel premium
        JLabel premiumLabel = new JLabel("  PREMIUM ");
        premiumLabel.setBounds(0,0,200,20);
        premiumLabel.setHorizontalAlignment(JLabel.CENTER);
        JLabel premiumLabel1 = new JLabel("  Penalização até 2 dias");
        premiumLabel1.setBounds(0,40,200,20);
        premiumLabel1.setHorizontalAlignment(JLabel.CENTER);
        JLabel premiumLabel2 = new JLabel("Prioridade na reserva");
        premiumLabel2.setBounds(0,70,200,20);
        premiumLabel2.setHorizontalAlignment(JLabel.CENTER);
        JLabel premiumLabel3 = new JLabel("Mensalidade: 10€");
        premiumLabel3.setBounds(0,100,200,20);
        premiumLabel3.setHorizontalAlignment(JLabel.CENTER);

        //Checkbox no painel premium
        premiumCheck = new JCheckBox();
        premiumCheck.setBounds(100,125,50,50);

        //Adicionar elementos ao painel premium
        premiumPanel.add(premiumLabel);
        premiumPanel.add(premiumLabel1);
        premiumPanel.add(premiumLabel2);
        premiumPanel.add(premiumLabel3);
        premiumPanel.add(premiumCheck);
        this.add(premiumPanel);


        //Botao registar
        JButton registarbutton = new JButton("Registar");
        registarbutton.setBounds(330,450,200,50);
        this.add(registarbutton);

        //Adicionar botoes ao ActionListener
        retrocessoButton.addActionListener(this);
        registarbutton.addActionListener(this);
        premiumCheck.addActionListener(this);
normalCheck.addActionListener(this);


    }
    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getActionCommand().equals("Retrocesso")) {
            painelFundo.mudaEcra("RegistarUtilizador");
        }
        if(e.getActionCommand().equals("Registar")) {
            if(premiumCheck.isSelected()){
                JOptionPane.showMessageDialog(null,"Subscreveu o plano premium.\n" +
                        "Para manter as vantagens deste pacote, deverá proceder ao pagamento mensal de 10 euros.\n" +
                        "O prazo da sua subscrição atual é de 30 dias.\n");

            }
            else if(normalCheck.isSelected())
                JOptionPane.showMessageDialog(null,"Subscreveu o plano normal");
            painelFundo.mudaEcra("ReservaViagem");
        }

    }
}
