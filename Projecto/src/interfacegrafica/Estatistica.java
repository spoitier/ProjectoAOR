package interfacegrafica;

import javax.swing.*;
import java.awt.*;

public class Estatistica  extends JPanel {
    PainelFundo painelFundo;

    public Estatistica(PainelFundo painelFundo) {
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
        JLabel segundoTitulo =new JLabel("Estatística");
        segundoTitulo.setBounds(50,100,900,30);
        this.add(segundoTitulo);

        //======================================================================
        // Abas
        JTabbedPane abasPanel = new JTabbedPane();
        abasPanel.setTabPlacement(JTabbedPane.LEFT);
        abasPanel.setBounds(0,125,880,530);


        //==========================================================
        //Aba Total Clientes
        JPanel totalClientesPanel = new JPanel();
        totalClientesPanel.setLayout(null);
        totalClientesPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        // Botoes de filtragem
        JPanel botoesFiltro =  new JPanel(new GridLayout(1,4,10,5));
        botoesFiltro.setBounds(200,300,200,30);
        JLabel anoLabel = new JLabel("Ano:");
        JLabel mesLabel = new JLabel("Mes:");
        JTextField anoField = new JTextField();
        JTextField mesField = new JTextField();
        botoesFiltro.add(anoLabel);
        botoesFiltro.add(anoField);
        botoesFiltro.add(mesLabel);
        botoesFiltro.add(mesField);
        JPanel totalClientes = new JPanel(new GridLayout(1,2,0,0));
        totalClientes.setBounds(200,350,250,15);
        JLabel totalClientesLabel = new JLabel("Total Clientes:");
        JLabel totalClientesPreenchidoLabel = new JLabel("Preenchido");
        totalClientes.add(totalClientesLabel);
        totalClientes.add(totalClientesPreenchidoLabel);

        totalClientesPanel.add(totalClientes);
        totalClientesPanel.add(botoesFiltro);
        abasPanel.add("Total Clientes",totalClientesPanel);
        this.add(abasPanel);

        //==============================================================
        //Aba total Motoristas
        JPanel totalMotoristasPanel = new JPanel();
        totalMotoristasPanel.setLayout(null);

        // Botoes de filtragem
        JPanel botoesFiltroMotoristas =  new JPanel(new GridLayout(1,4,10,5));
        botoesFiltroMotoristas.setBounds(200,300,200,30);
        JLabel anoLabelMotoristas = new JLabel("Ano:");
        JLabel mesLabelMotoristas = new JLabel("Mes:");
        JTextField anoFieldMotoristas = new JTextField();
        JTextField mesFieldMotoristas = new JTextField();
        botoesFiltroMotoristas.add(anoLabelMotoristas);
        botoesFiltroMotoristas.add(anoFieldMotoristas);
        botoesFiltroMotoristas.add(mesLabelMotoristas);
        botoesFiltroMotoristas.add(mesFieldMotoristas);
        JPanel totalMotoristas = new JPanel(new GridLayout(1,2,0,0));
        totalMotoristas.setBounds(200,350,250,15);
        JLabel totalMotoristasLabel = new JLabel("Total Motoristas:");
        JLabel totalMotoristasPreenchidoLabel = new JLabel("Preenchido");
        totalMotoristas.add(totalMotoristasLabel);
        totalMotoristas.add(totalMotoristasPreenchidoLabel);

        totalMotoristasPanel.add(totalMotoristas);
        totalMotoristasPanel.add(botoesFiltroMotoristas);
        abasPanel.add("Total Motoristas",totalMotoristasPanel);

        //===============================================================
        //Aba total Autocarros
        JPanel totalAutocarrosPanel = new JPanel();
        totalAutocarrosPanel.setLayout(null);

        // Botoes de filtragem
        JPanel botoesFiltroAutocarros =  new JPanel(new GridLayout(1,4,10,5));
        botoesFiltroAutocarros.setBounds(200,300,200,30);
        JLabel anoLabelAutocarros = new JLabel("Ano:");
        JLabel mesLabelAutocarros = new JLabel("Mes:");
        JTextField anoFieldAutocarros = new JTextField();
        JTextField mesFieldAutocarros = new JTextField();
        botoesFiltroAutocarros.add(anoLabelAutocarros);
        botoesFiltroAutocarros.add(anoFieldAutocarros);
        botoesFiltroAutocarros.add(mesLabelAutocarros);
        botoesFiltroAutocarros.add(mesFieldAutocarros);
        JPanel totalAutocarros = new JPanel(new GridLayout(1,2,0,0));
        totalAutocarros.setBounds(200,350,250,15);
        JLabel totalAutocarrosLabel = new JLabel("Total Autocarros:");
        JLabel totalAutocarrosPreenchidoLabel = new JLabel("Preenchido");
        totalAutocarros.add(totalAutocarrosLabel);
        totalAutocarros.add(totalAutocarrosPreenchidoLabel);

        totalAutocarrosPanel.add(totalAutocarros);
        totalAutocarrosPanel.add(botoesFiltroAutocarros);
        abasPanel.add("Total Autocarros",totalAutocarrosPanel);

        //===============================================================
        //Aba total Autocarro mais Requisitado
        JPanel autocarroMaisRequisitado = new JPanel();
        autocarroMaisRequisitado.setLayout(null);

        // Botoes de filtragem
        JPanel botoesFiltroRequisitado =  new JPanel(new GridLayout(1,4,0,5));
        botoesFiltroRequisitado.setBounds(200,300,200,30);;
        JLabel anoLabelRequisitado = new JLabel("Ano:");
        JLabel mesLabelRequisitado = new JLabel("Mes:");
        JTextField anoFieldRequisitado = new JTextField();
        JTextField mesFieldRequisitado = new JTextField();
        botoesFiltroRequisitado.add(anoLabelRequisitado);
        botoesFiltroRequisitado.add(anoFieldRequisitado);
        botoesFiltroRequisitado.add(mesLabelRequisitado);
        botoesFiltroRequisitado.add(mesFieldRequisitado);
        JPanel totalRequisitado = new JPanel(new GridLayout(1,2,0,0));
        totalRequisitado.setBounds(200,350,400,15);
        JLabel totalRequisitadoLabel = new JLabel("Autocarro mais requisitado");
        JLabel totalRequisitadoPreenchidoLabel = new JLabel("Preenchido");
        totalRequisitado.add(totalRequisitadoLabel);
        totalRequisitado.add(totalRequisitadoPreenchidoLabel);

        autocarroMaisRequisitado.add(totalRequisitado);
        autocarroMaisRequisitado.add(botoesFiltroRequisitado);

        abasPanel.add("Autocarro mais requisitado",autocarroMaisRequisitado);


        //===================================================
        //Cliente com mais viagens

        JPanel totalViagensPanel = new JPanel();
        totalViagensPanel.setLayout(null);

        // Botoes de filtragem
        JPanel botoesFiltroViagens =  new JPanel(new GridLayout(1,4,0,5));
        botoesFiltroViagens.setBounds(200,300,200,30);
        JLabel anoLabelViagens = new JLabel("Ano:");
        JLabel mesLabelViagens= new JLabel("Mes:");
        JTextField anoFieldViagens = new JTextField();
        JTextField mesFieldViagens = new JTextField();
        botoesFiltroViagens.add(anoLabelViagens);
        botoesFiltroViagens.add(anoFieldViagens);
        botoesFiltroViagens.add(mesLabelViagens);
        botoesFiltroViagens.add(mesFieldViagens);
        JPanel totalViagens = new JPanel(new GridLayout(1,2,0,0));
        totalViagens.setBounds(150,350,400,15);
        JLabel totalViagensLabel = new JLabel("Cliente com mais viagens");
        JLabel totalViagensPreenchidoLabel = new JLabel("Preenchido");
        totalViagens.add(totalViagensLabel);
        totalViagens.add(totalViagensPreenchidoLabel);

        totalViagensPanel.add(totalViagens);
        totalViagensPanel.add(botoesFiltroViagens);
        abasPanel.add("Cliente com mais viagens",totalViagensPanel);

        //==========================================================================
        //Autocarros Reservados
        JPanel autocarrosReservados = new JPanel();
        autocarrosReservados.setLayout(null);

        //Botoes
        JPanel botoesFiltroReservados =  new JPanel(new GridLayout(1,4,0,5));
        botoesFiltroReservados.setBounds(225,50,200,30);
        JLabel anoLabelReservados = new JLabel("Ano:");
        JLabel mesLabelReservados= new JLabel("Mes:");
        JTextField anoFieldReservados = new JTextField();
        JTextField mesFieldReservados = new JTextField();
        botoesFiltroReservados.add(anoLabelReservados);
        botoesFiltroReservados.add(anoFieldReservados);
        botoesFiltroReservados.add(mesLabelReservados);
        botoesFiltroReservados.add(mesFieldReservados);

        //Tabela
        String [] colunas = {"Matricula","Data Partida","Data Chegada"};

        String [][] data = {{"","",""}
                ,{"","",""}};

        JTable tabela = new JTable(data,colunas);
        JScrollPane sp = new JScrollPane(tabela);
        sp.setBounds(200,100,300,400);
        autocarrosReservados.add(botoesFiltroReservados);
        autocarrosReservados.add(sp);
        abasPanel.add("Autocarros reservados",autocarrosReservados);

        //=======================================================
        //Requisições Canceladas

        JPanel autocarrosCanceladas = new JPanel();
        autocarrosCanceladas.setLayout(null);

        //Botoes
        JPanel botoesFiltroCanceladas =  new JPanel(new GridLayout(1,4,0,5));
        botoesFiltroCanceladas.setBounds(225,50,200,30);
        JLabel anoLabelCanceladas = new JLabel("Ano:");
        JLabel mesLabelCanceladas= new JLabel("Mes:");
        JTextField anoFieldCanceladas = new JTextField();
        JTextField mesFieldCanceladas = new JTextField();
        botoesFiltroCanceladas.add(anoLabelCanceladas);
        botoesFiltroCanceladas.add(anoFieldCanceladas);
        botoesFiltroCanceladas.add(mesLabelCanceladas);
        botoesFiltroCanceladas.add(mesFieldCanceladas);

        //Tabela
        String [] colunasCanceladas = {"Matricula","Data Partida","Data Chegada","Cliente","Motorista"};

        String [][] dataCanceladas = {{"","","","",""}
                ,{"","","","",""}};

        JTable canceladasTable = new JTable(dataCanceladas,colunasCanceladas);
        JScrollPane spCanceladas = new JScrollPane(canceladasTable);
        spCanceladas.setBounds(100,100,500,400);
        autocarrosCanceladas.add(botoesFiltroCanceladas);
        autocarrosCanceladas.add(spCanceladas);
        abasPanel.add("Requisições Canceladas",autocarrosCanceladas);

        //========================================================================
        //Reservas em Espera

        JPanel autocarrosReservas = new JPanel();
        autocarrosReservas.setLayout(null);

        //Botoes
        JPanel botoesFiltroReservas=  new JPanel(new GridLayout(1,4,0,5));
        botoesFiltroReservas.setBounds(225,50,200,30);
        JLabel mesLabelReservas= new JLabel("Mes:");
        JTextField mesFieldReservas = new JTextField();
        botoesFiltroReservas.add(mesLabelReservas);
        botoesFiltroReservas.add(mesFieldReservas);

        //Tabela
        String [] colunasReservas = {"Cliente","Data Partida","Data Chegada","Passageiros","Autocarro"};

        String [][] dataReservas = {{"","","","",""}
                ,{"","","","",""}};

        JTable reservasTable = new JTable(dataCanceladas,colunasCanceladas);
        JScrollPane spReservas = new JScrollPane(reservasTable);
        spReservas.setBounds(100,100,500,400);
        autocarrosReservas.add(botoesFiltroReservas);
        autocarrosReservas.add(spReservas);
        abasPanel.add("Reservas em Espera",autocarrosReservas);

        //============================================
        //Volume de reservas

        JPanel volumeReservas = new JPanel();
        volumeReservas.setLayout(null);

        //Botoes
        JPanel botoesFiltroVolume=  new JPanel(new GridLayout(1,4,0,5));
        botoesFiltroVolume.setBounds(225,25,200,30);
        JLabel anoLabelVolume= new JLabel("Ano:");
        JTextField anoFieldVolume = new JTextField();
        botoesFiltroVolume.add(anoLabelVolume);
        botoesFiltroVolume.add(anoFieldVolume);
        volumeReservas.add(botoesFiltroVolume);

        //Tabela
        String [] colunasVolume = {"Mês","Volume"};

        String [][] dataVolume = {{"",""}
                ,{"",""}};

        JTable volumeTable = new JTable(dataVolume,colunasVolume);
        JScrollPane spvolume = new JScrollPane(volumeTable);
        spvolume.setBounds(100,80,500,300);
        volumeReservas.add(spvolume);

        //Label
        JPanel volumePreenchidoPanel=  new JPanel(new GridLayout(1,2,40,5));
        volumePreenchidoPanel.setBounds(150,300,400,300);
        JLabel  volumePreenchido = new JLabel("Dias com mais reservas:");
        JLabel volumePreenchidoLabel = new JLabel("Preenchido automaticamente");
        volumePreenchidoPanel.add(volumePreenchido);
        volumePreenchidoPanel.add(volumePreenchidoLabel);
        volumeReservas.add(volumePreenchidoPanel);
        abasPanel.add("Volume de Reservas",volumeReservas);

































        this.add(abasPanel);




























    }

}
