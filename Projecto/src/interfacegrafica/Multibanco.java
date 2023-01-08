package interfacegrafica;

import programa.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Multibanco extends JPanel implements ActionListener {

    private Aor_Autocarro aor_autocarro;


    private Multibanco multibanco1;
    private Reserva reserva;
    private PainelFundo painelFundo;

    private JButton opcao1;
    private JButton opcao2 ;
    private JButton opcao3 ;
    private JButton opcao4 ;
    private JButton opcao5 ;
    private JButton multibanco;
    private JButton botaoConfirmar;
    private JButton mudarPagamentoButton;
    private JButton sairBotao;

    private JLabel entidade;
    private JLabel referencia;
    private JLabel valor;
    private JLabel entidadeInfo;
    private JLabel referenciaInfo;
    private JLabel valorInfo;
    private JLabel valorViagem;
    private JLabel clienteNome;

    public  Multibanco (PainelFundo painelFundo,Aor_Autocarro aor_autocarro) {
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
        clienteNome = new JLabel("Nome do Cliente");
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
        //Custo da viagem
        JPanel custoViagem = new JPanel();
        custoViagem.setLayout(null);
        custoViagem.setBounds(625, 250, 200, 200);
        JLabel tituloCusto = new JLabel("CUSTO DA VIAGEM");
        tituloCusto.setBounds(45, 30, 200, 10);
        valorViagem = new JLabel("Valor");
        valorViagem.setBounds(75, 100, 200, 10);
        custoViagem.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        custoViagem.add(tituloCusto);
        custoViagem.add(valorViagem);
        this.add(custoViagem);

        //===========================================
        //programa.Paypal

        JPanel pagamentoPanel = new JPanel(new GridLayout(2, 1, 0, 15));
        pagamentoPanel.setBounds(200, 200, 350, 100);
        JLabel tipoPagamento = new JLabel("TIPO DE PAGAMENTO");
        multibanco = new JButton("Multibanco");
        pagamentoPanel.add(tipoPagamento);
        pagamentoPanel.add(multibanco);
        this.add(pagamentoPanel);

        //================================================================
        //Painel de referencia multibanco

        /*
        JPanel referenciaMultibanco = new JPanel(new GridLayout(3, 2, 0, 0));
        referenciaMultibanco.setBounds(200, 300, 300, 200);
        entidade = new JLabel("Entidade:");
        referencia = new JLabel("Referencia:");
        valor = new JLabel("Valor");
        entidadeInfo = new JLabel("12345");
        referenciaInfo = new JLabel(programa.Multibanco.gerarRefMultibanco());;
        referenciaMultibanco.add(entidade);
        referenciaMultibanco.add(entidadeInfo);
        referenciaMultibanco.add(referencia);
        referenciaMultibanco.add(referenciaInfo);
        referenciaMultibanco.add(valor);
        this.add(referenciaMultibanco);


         */


        //Botão de auntenticar
        botaoConfirmar = new JButton("Confirmar");
        botaoConfirmar.setBounds(200, 500, 350, 50);
        this.add(botaoConfirmar);
        mudarPagamentoButton = new JButton("Mudar Pagamento");
        mudarPagamentoButton.setBounds(225, 600, 300, 50);
        this.add(mudarPagamentoButton);

        opcao1.addActionListener(this);
        opcao2.addActionListener(this);
        opcao3.addActionListener(this);
        opcao4.addActionListener(this);
        opcao5.addActionListener(this);
        botaoConfirmar.addActionListener(this);
        mudarPagamentoButton.addActionListener(this);
        sairBotao.addActionListener(this);

    }

    public void custoAutocarro(Reserva reserva) {
        if (!(reserva == null)) {
            this.reserva = reserva;
            clienteNome.setText(reserva.getCliente().getNome());
            valorViagem.setText(String.valueOf(reserva.getCusto()));

        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Cliente logado=(Cliente) aor_autocarro.getUserLogado();
        Pagamento pagamento;
        Reserva reserva;

        if(e.getActionCommand().equals("Confirmar")){
            reserva=aor_autocarro.identificarReservaPagamento(logado);
            //Adicionado reserva à lista de Reservas da Empresa
            aor_autocarro.addReserva(reserva);
            String referenciaMB= MB.gerarRefMultibanco();
            pagamento=new MB(reserva,12345,referenciaMB, reserva.getCusto());
            //Adicionado pagamento da reserva à lista de Reservas
            aor_autocarro.addPagamento(pagamento);
                JOptionPane.showMessageDialog(null, "O pagamento da sua reserva" +
                        " nº"+reserva.getId()+" deverá ser efetuada por Multibanco:\n" +
                        "Entidade: 12345\nReferência:"+referenciaMB+"\nValor:"+reserva.getCusto()+"€");
                FicheiroDeObjectos.escreveObjeto(aor_autocarro);
            painelFundo.mudaEcra("ConsultarReservas");
            }

        int resultado;
        if(e.getActionCommand().equals("ReservaViagem")) {
            resultado = JOptionPane.showConfirmDialog(null, "A sua reserva ainda não está paga." +
                    "Tem a certeza que quer cancelar?", "Escolha uma opção", JOptionPane.YES_NO_OPTION);
            if (resultado == JOptionPane.YES_OPTION) {
                painelFundo.mudaEcra("ReservaViagem");
            }else{
                reserva=aor_autocarro.identificarReservaPagamento(logado);
                aor_autocarro.getReservas().remove(reserva);
            }
        }

        if(e.getActionCommand().equals("Histórico Reservas")) {
            resultado = JOptionPane.showConfirmDialog(null, "A sua reserva ainda não está paga." +
                    "Tem a certeza que quer cancelar?", "Escolha uma opção", JOptionPane.YES_NO_OPTION);
            if (resultado == JOptionPane.YES_OPTION) {
                painelFundo.mudaEcra("HistoricoReservas");
            }else{
                reserva=aor_autocarro.identificarReservaPagamento(logado);
                aor_autocarro.getReservas().remove(reserva);
            }
        }

        if(e.getActionCommand().equals("Consultar Reservas")) {
            resultado = JOptionPane.showConfirmDialog(null, "A sua reserva ainda não está paga." +
                    "Tem a certeza que quer cancelar?", "Escolha uma opção", JOptionPane.YES_NO_OPTION);
            if (resultado == JOptionPane.YES_OPTION) {
                painelFundo.mudaEcra("ConsultarReservas");
            }else{
                reserva=aor_autocarro.identificarReservaPagamento(logado);
                aor_autocarro.getReservas().remove(reserva);
            }
        }

        if(e.getActionCommand().equals("Cancelar Reservas")) {
            resultado = JOptionPane.showConfirmDialog(null, "A sua reserva ainda não está paga." +
                    "Tem a certeza que quer cancelar?", "Escolha uma opção", JOptionPane.YES_NO_OPTION);
            if (resultado == JOptionPane.YES_OPTION) {
                painelFundo.mudaEcra("CancelarReserva");
            }else{
                reserva=aor_autocarro.identificarReservaPagamento(logado);
                aor_autocarro.getReservas().remove(reserva);
            }
        }
        if(e.getActionCommand().equals("Dados Pessoais")) {
            resultado = JOptionPane.showConfirmDialog(null, "A sua reserva ainda não está paga." +
                    "Tem a certeza que quer cancelar?", "Escolha uma opção", JOptionPane.YES_NO_OPTION);
            if (resultado == JOptionPane.YES_OPTION) {
                painelFundo.mudaEcra("DadosPessoaisClientes");
            }else{
                reserva=aor_autocarro.identificarReservaPagamento(logado);
                aor_autocarro.getReservas().remove(reserva);
            }
        }
        if(e.getActionCommand().equals("Sair")) {
            resultado = JOptionPane.showConfirmDialog(null, "A sua reserva ainda não está paga." +
                    "Tem a certeza que quer cancelar?", "Escolha uma opção", JOptionPane.YES_NO_OPTION);
            if (resultado == JOptionPane.YES_OPTION) {
                ((Login)painelFundo.mapaPaineis.get("Login")).sair();
                painelFundo.mudaEcra("Login");
            }else{
                reserva=aor_autocarro.identificarReservaPagamento(logado);
                aor_autocarro.getReservas().remove(reserva);
            }
        }
        if(e.getActionCommand().equals("Mudar Pagamento")){
            painelFundo.mudaEcra("Pagamentos");

        }





    }
}
