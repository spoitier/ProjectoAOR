package interfacegrafica;

import programa.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static javax.swing.JOptionPane.YES_OPTION;

public class ReservaViagem extends JPanel implements ActionListener {

    PainelFundo painelFundo;
    Aor_Autocarro aor_autocarro;
    Reserva reservaNova;

    JButton prosseguirButton;
    JButton opcao1;
    JButton opcao2;
    JButton opcao3;
    JButton opcao4;
    JButton opcao5;
    JButton sairBotao;

    JLabel dataAluguer;
    JLabel numeroDias;
    JLabel numeroPessoas;
    JLabel partida;
    JLabel destino;
    JLabel numeroKmTotal;

    JLabel valorViagem;
    JTextField dataAluguerField;
    JTextField numeroDiasField;
    JTextField numeroPessoasField;
    JTextField partidaField;
    JTextField destinoField;
    JTextField numeroKmTotalField;
    JLabel clienteNome;
    JButton atualizar;


    public ReservaViagem(PainelFundo painelFundo, Aor_Autocarro aor_autocarro) {
        this.painelFundo = painelFundo;
        this.aor_autocarro = aor_autocarro;
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
        clienteNome = new JLabel("");
        clienteNome.setBounds(700, 0, 100, 30);
        cabecalho.add(clienteNome);

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

        opcao1 = new JButton("ReservaViagem");
        opcao2 = new JButton("Histórico Reservas");
        opcao3 = new JButton("Consultar Reservas");
        opcao4 = new JButton("Cancelar Reservas");
        opcao5 = new JButton("Dados Pessoais");

        opcaoPainel.add(opcao1);
        opcaoPainel.add(opcao2);
        opcaoPainel.add(opcao3);
        opcaoPainel.add(opcao4);
        opcaoPainel.add(opcao5);

        this.add(opcaoPainel);

        //=====================================================================
        //Segundo titulo
        JLabel segundoTitulo = new JLabel("Realizar reserva de Autocarro:\n");
        segundoTitulo.setBounds(50, 100, 900, 30);
        this.add(segundoTitulo);

        //=====================================================================

        JPanel formulario = new JPanel();
        formulario.setLayout(null);
        formulario.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        formulario.setBounds(150, 200, 450, 350);


        //Labels
        dataAluguer = new JLabel("Data do Aluguer (dd/mm/AAAA):");
        dataAluguer.setBounds(20, 50, 200, 30);
        numeroDias = new JLabel("Numero de dias:");
        numeroDias.setBounds(20, 90, 200, 30);
        numeroPessoas = new JLabel("Numero de Pessoas:");
        numeroPessoas.setBounds(20, 130, 200, 30);
        partida = new JLabel("Local de Partida:");
        partida.setBounds(20, 170, 200, 30);
        destino = new JLabel("Local de Destino:");
        destino.setBounds(20, 210, 200, 30);
        numeroKmTotal = new JLabel("Numero Km total:");
        numeroKmTotal.setBounds(20, 250, 200, 30);

        //Fields
        dataAluguerField = new JTextField();
        dataAluguerField.setBounds(225, 50, 150, 30);
        numeroDiasField = new JTextField();
        numeroDiasField.setBounds(225, 90, 150, 30);
        numeroPessoasField = new JTextField();
        numeroPessoasField.setBounds(225, 130, 150, 30);
        partidaField = new JTextField();
        partidaField.setBounds(225, 170, 150, 30);
        destinoField = new JTextField();
        destinoField.setBounds(225, 210, 150, 30);
        numeroKmTotalField = new JTextField();
        numeroKmTotalField.setBounds(225, 250, 150, 30);

        formulario.add(dataAluguer);
        formulario.add(numeroDias);
        formulario.add(numeroPessoas);
        formulario.add(partida);
        formulario.add(destino);
        formulario.add(numeroKmTotal);
        formulario.add(dataAluguerField);
        formulario.add(numeroDiasField);
        formulario.add(numeroPessoasField);
        formulario.add(partidaField);
        formulario.add(destinoField);
        formulario.add(numeroKmTotalField);
        this.add(formulario);

        //==========================================================

        //Botão para registar
        prosseguirButton = new JButton("Prosseguir");
        prosseguirButton.setBounds(340, 575, 200, 70);
        this.add(prosseguirButton);

        //============================================
        //Custo da viagem
        JPanel custoViagem = new JPanel();
        custoViagem.setLayout(null);
        custoViagem.setBounds(625, 250, 200, 200);
        JLabel tituloCusto = new JLabel("CUSTO DA VIAGEM");
        tituloCusto.setBounds(45, 30, 200, 10);


        valorViagem = new JLabel("custoViagem");
        valorViagem.setBounds(75, 100, 200, 10);
        atualizar = new JButton("Atualizar");
        atualizar.setBounds(50,150,100,30);
        custoViagem.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        custoViagem.add(tituloCusto);
        custoViagem.add(valorViagem);
        custoViagem.add(atualizar);
        this.add(custoViagem);


        opcao1.addActionListener(this);
        opcao2.addActionListener(this);
        opcao3.addActionListener(this);
        opcao4.addActionListener(this);
        opcao5.addActionListener(this);
        prosseguirButton.addActionListener(this);
        sairBotao.addActionListener(this);
        atualizar.addActionListener(this);
    }

    public void nomeLogado() {

        if (aor_autocarro.getUserLogado() == null) {
            clienteNome.setText("");
        } else
            clienteNome.setText(aor_autocarro.getUserLogado().getNome());
        revalidate();
        repaint();

    }

    @Override

    public void actionPerformed(ActionEvent e) {
        boolean validar = true;
        Reserva reservaNova;
        Cliente logado = (Cliente) aor_autocarro.getUserLogado();
        String numeroDias = numeroDiasField.getText();
        String numeroPessoas = numeroPessoasField.getText();
        String localPartida = partidaField.getText();
        String localDestino = destinoField.getText();
        String distancia = numeroKmTotalField.getText();


        if (e.getActionCommand().equals("Prosseguir")) {
            //verificar se todos os campos estão preenchidos
            if (dataAluguerField.getText().equals("") || numeroDiasField.getText().equals("") ||
                    numeroPessoasField.getText().equals("") || partidaField.getText().equals("") ||
                    destinoField.getText().equals("") || numeroKmTotalField.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Há campos de preenchimento obrigatório que não foram preenchidos");
                validar = false;
            }

            //Verificar se data Aluguer é válida
                if (!Reserva.validarDataFormato(dataAluguerField.getText())) {
                JOptionPane.showMessageDialog(null, "Por favor,preencha a data com o formato dd/mm/AAAA");
                validar = false;
            } else if (!Reserva.validarDataValida(dataAluguerField.getText())) {
                JOptionPane.showMessageDialog(null, "Data com mês ou dia inválidos");
                validar = false;
            } else if (!Reserva.validarDataAluguer(dataAluguerField.getText())) {
                JOptionPane.showMessageDialog(null, "Data de Aluguer não pode ser inferior à data atual");
                validar = false;
            }

            //Verificar se é constituído só por números
            if (!Reserva.validarNumeros(numeroDiasField.getText())) {
                JOptionPane.showMessageDialog(null, "Número de dias inválido");
                validar = false;}

            //Verificar se é constituído só por números
            if (!Reserva.validarNumeros(numeroPessoasField.getText())) {
                JOptionPane.showMessageDialog(null, "Número de Pessoas inválido");
                validar = false;}

            //Verificar se é constituído só por letras
            if (!Reserva.validarLocal(partidaField.getText())) {
                JOptionPane.showMessageDialog(null, "Uso de carateres inválidos no local Partida");
                validar = false;}

            //Verificar se é constituído só por letras
            if (!Reserva.validarLocal(destinoField.getText())) {
                JOptionPane.showMessageDialog(null, "Uso de carateres inválidos no local Destino");
                validar = false;}

            //Verificar se é constituído só por números
            if (!Reserva.validarNumeros(numeroKmTotalField.getText())) {
                JOptionPane.showMessageDialog(null, "Número de km inválido");
                validar = false;}

            if (!aor_autocarro.verificarAutocarroLotaçao(numeroPessoas)) {
                JOptionPane.showMessageDialog(null, "Lamentamos, mas não existem disponíveis na nossa " +
                        "Empresa autocarros com capacidade para " + numeroPessoas);
                validar = false;
                dataAluguerField.setText("");
                numeroDiasField.setText("");
                numeroPessoasField.setText("");
                partidaField.setText("");
                destinoField.setText("");
                numeroKmTotalField.setText("");

            }
            if (validar) {
                LocalDate dataAluguer = LocalDate.parse(dataAluguerField.getText(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                reservaNova = aor_autocarro.efetuarReservaAutocarro(logado, dataAluguer, numeroDias,
                        numeroPessoas, localPartida, localDestino, distancia);

                if (reservaNova.getAutocarro() != null) {
                 //Adicionado reserva à lista de Reservas da Empresa
                    aor_autocarro.getReservas().add(reservaNova);
                    FicheiroDeObjectos.escreveObjeto(aor_autocarro);
                    //Autocarro autocarro = aor_autocarro.identificarAutocarroReservado(reservaNova);
                    JOptionPane.showMessageDialog(null, "A sua reserva nº" + reservaNova.getId() + " está disponível para pagamento.");
                    ((TipoDePagamentos)painelFundo.mapaPaineis.get("Pagamentos")).custoAutocarro(reservaNova);

                    dataAluguerField.setText("");
                    numeroDiasField.setText("");
                    numeroPessoasField.setText("");
                    partidaField.setText("");
                    destinoField.setText("");
                    numeroKmTotalField.setText("");

                    painelFundo.mudaEcra("Pagamentos");

                } else {
                    int resultado = JOptionPane.showConfirmDialog(null, "A sua reserva ficou em lista de espera" +
                            ".Pretende prosseguir?", "Escolha uma opção", JOptionPane.YES_NO_OPTION);
                    if (resultado == JOptionPane.YES_OPTION) {
                        //Adiciona reserva à lista de Espera
                        aor_autocarro.getReservasemEspera().add(reservaNova);
                        JOptionPane.showMessageDialog(null, "A sua reserva ficou em lista de espera.\nCaso surja " +
                                        "um autocarro disponível, receberá uma notificação ao efetuar o seu login.");

                        dataAluguerField.setText("");
                        numeroDiasField.setText("");
                        numeroPessoasField.setText("");
                        partidaField.setText("");
                        destinoField.setText("");
                        numeroKmTotalField.setText("");

                        FicheiroDeObjectos.escreveObjeto(aor_autocarro);

                    } else {
                        //Cancela reserva na lista de espera
                        aor_autocarro.cancelarReservaemEspera(reservaNova);
                        dataAluguerField.setText("");
                        numeroDiasField.setText("");
                        numeroPessoasField.setText("");
                        partidaField.setText("");
                        destinoField.setText("");
                        numeroKmTotalField.setText("");

                        FicheiroDeObjectos.escreveObjeto(aor_autocarro);
                    }
                }
            }

        }
        if(e.getActionCommand().equals("Atualizar")) {
            boolean validarAtualizar= true;
            //Verificar se é constituído só por números
            if (!Reserva.validarNumeros(numeroDiasField.getText())) {
                JOptionPane.showMessageDialog(null, "Número de dias inválido");
                validarAtualizar = false;
            }
            //Verificar se é constituído só por números
            if (!Reserva.validarNumeros(numeroPessoasField.getText())) {
                JOptionPane.showMessageDialog(null, "Número de Pessoas inválido");
                validarAtualizar = false;
            }
            if(validarAtualizar) {

                double custoReserva =0;
                custoReserva=0.55*Integer.parseInt(distancia)+1.2*Integer.parseInt(numeroPessoas);
                valorViagem.setText(String.valueOf(custoReserva));
            }



        }

        if (e.getActionCommand().equals("Histórico Reservas")) {
            ((HistoricoReservas) (painelFundo.mapaPaineis.get("HistoricoReservas"))).nomeLogado();
            painelFundo.mudaEcra("HistoricoReservas");
        }

        if (e.getActionCommand().equals("Consultar Reservas")) {
            ((ConsultarReservas) (painelFundo.mapaPaineis.get("ConsultarReservas"))).nomeLogado();
            painelFundo.mudaEcra("ConsultarReservas");
        }

        if (e.getActionCommand().equals("Cancelar Reservas")) {
            ((CancelarReserva) (painelFundo.mapaPaineis.get("CancelarReserva"))).nomeLogado();
            painelFundo.mudaEcra("CancelarReserva");
        }
        if (e.getActionCommand().equals("Dados Pessoais")) {
            ((DadosPessoaisCliente) (painelFundo.mapaPaineis.get("DadosPessoaisCliente"))).nomeLogado();
            painelFundo.mudaEcra("DadosPessoaisCliente");
        }
        if (e.getActionCommand().equals("Sair")) {
            ((Login)painelFundo.mapaPaineis.get("Login")).sair();
            painelFundo.mudaEcra("Login");
        }
    }
}


