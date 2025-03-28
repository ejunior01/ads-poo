package br.senac.sp.livraria.view;

import br.senac.sp.livraria.enumeration.Escolaridade;
import br.senac.sp.livraria.enumeration.EstadoCivil;
import br.senac.sp.livraria.model.Cliente;

import javax.swing.*;
import javax.swing.text.MaskFormatter;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class ViewCliente extends JFrame {
    JLabel lbId, lbCpf, lbNome, lbNascimento, lbTelefone, lbEmail,
            lbEndereco, lbEstadoCivil, lbEscolaridade;
    JTextField tfId, tfCpf, tfNome, tfTelefone, tfEmail;
    JFormattedTextField tfNascimento;
    MaskFormatter mskNascimento;
    Font fontePadrao;
    JTextArea taEndereco;
    JComboBox<Escolaridade> cbEscolaridade;
    JComboBox<EstadoCivil> cbEstadoCivil;
    JButton btSalvar;
    Cliente cliente;

    public ViewCliente() {
        initComponents();
        actions();
    }

    public static void main(String[] args) {
        new ViewCliente();
    }

    // neste método "construíremos a tela"
    private void initComponents() {
        fontePadrao = new Font("Tahoma", Font.PLAIN, 12);

        // lbId
        lbId = new JLabel("ID: ");
        lbId.setBounds(20, 20, 30, 25);
        lbId.setFont(fontePadrao);

        // tfId
        tfId = new JTextField();
        tfId.setBounds(60, 20, 40, 25);
        tfId.setEnabled(false);
        tfId.setFont(fontePadrao);
        tfId.setHorizontalAlignment(SwingConstants.CENTER);

        // lbNome
        lbNome = new JLabel("Nome: ");
        lbNome.setBounds(110, 20, 50, 25);
        lbNome.setFont(fontePadrao);

        // tfNome
        tfNome = new JTextField();
        tfNome.setBounds(170, 20, 250, 25);
        tfNome.setFont(fontePadrao);

        // lbCpf
        lbCpf = new JLabel("CPF: ");
        lbCpf.setBounds(430, 20, 40, 25);
        lbCpf.setFont(fontePadrao);

        // tfCpf
        tfCpf = new JTextField();
        tfCpf.setBounds(480, 20, 150, 25);
        tfCpf.setFont(fontePadrao);

        // lbNascimento
        lbNascimento = new JLabel("Nascimento:");
        lbNascimento.setBounds(20, 55, 70, 25);
        lbNascimento.setFont(fontePadrao);

        // mskNascimento
        try {
            mskNascimento = new MaskFormatter("##/##/####");
            mskNascimento.setPlaceholderCharacter('_');
        } catch (ParseException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }

        // tfNascimento
        tfNascimento = new JFormattedTextField(mskNascimento);
        tfNascimento.setBounds(100, 55, 90, 25);
        tfNascimento.setFont(fontePadrao);
        tfNascimento.setHorizontalAlignment(SwingConstants.CENTER);

        // lbTelefone:
        lbTelefone = new JLabel("Tel:");
        lbTelefone.setBounds(200, 55, 30, 25);
        lbTelefone.setFont(fontePadrao);

        // tfTelefone
        tfTelefone = new JTextField();
        tfTelefone.setBounds(230, 55, 90, 25);
        tfTelefone.setFont(fontePadrao);

        // lbEmail:
        lbEmail = new JLabel("E-mail:");
        lbEmail.setBounds(330, 55, 50, 25);
        lbEmail.setFont(fontePadrao);

        // tfEmail
        tfEmail = new JTextField();
        tfEmail.setBounds(380, 55, 250, 25);
        tfEmail.setFont(fontePadrao);

        // lbEscolaridade
        lbEscolaridade = new JLabel("Escolaridade: ");
        lbEscolaridade.setBounds(20, 90, 90, 25);
        lbEscolaridade.setFont(fontePadrao);

        // cbEscolaridade
        cbEscolaridade = new JComboBox<>(Escolaridade.values());
        cbEscolaridade.setBounds(100, 90, 170, 25);
        cbEscolaridade.setFont(fontePadrao);
        cbEscolaridade.setSelectedIndex(-1);

        // lbEstadoCivil
        lbEstadoCivil = new JLabel("Estado civil: ");
        lbEstadoCivil.setBounds(20, 125, 90, 25);
        lbEstadoCivil.setFont(fontePadrao);

        // cbEstadoCivil
        cbEstadoCivil = new JComboBox<>(EstadoCivil.values());
        cbEstadoCivil.setBounds(100, 125, 170, 25);
        cbEstadoCivil.setFont(fontePadrao);
        cbEstadoCivil.setSelectedIndex(-1);

        // lbEndereco
        lbEndereco = new JLabel("Endereço:");
        lbEndereco.setBounds(280, 90, 60, 25);
        lbEndereco.setFont(fontePadrao);

        //taEndereco
        taEndereco = new JTextArea();
        taEndereco.setBounds(350, 90, 280, 60);
        taEndereco.setFont(fontePadrao);


        btSalvar = new JButton("Salvar");
        btSalvar.setBounds(20, 200, 100, 36);
        btSalvar.setFont(fontePadrao);


        // adicionar componentes
        Container base = getContentPane();
        base.setLayout(null);
        base.setBackground(Color.lightGray);
        base.add(lbId);
        base.add(tfId);
        base.add(lbNome);
        base.add(tfNome);
        base.add(lbCpf);
        base.add(tfCpf);
        base.add(lbNascimento);
        base.add(tfNascimento);
        base.add(lbTelefone);
        base.add(tfTelefone);
        base.add(lbEmail);
        base.add(tfEmail);
        base.add(lbEscolaridade);
        base.add(cbEscolaridade);
        base.add(lbEstadoCivil);
        base.add(cbEstadoCivil);
        base.add(lbEndereco);
        base.add(taEndereco);
        base.add(btSalvar);

        // parâmetros do frame
        setSize(670, 500);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

    }

    private void actions() {

        btSalvar.addActionListener(p -> {
            if (this.validateFormFields()) {
                Calendar dtNascimento = Calendar.getInstance();
                SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");

                try {
                    dtNascimento.setTime(fmt.parse(tfNascimento.getText()));
                } catch (ParseException e) {
                    JOptionPane.showMessageDialog(this, "Erro ao converter a data", "Erro", JOptionPane.WARNING_MESSAGE);
                }

                cliente = new Cliente(1,
                        tfNome.getText(),
                        tfCpf.getText(),
                        dtNascimento,
                        tfTelefone.getText(),
                        tfEmail.getText(),
                        taEndereco.getText(),
                        (EstadoCivil) cbEstadoCivil.getSelectedItem(),
                        (Escolaridade) cbEscolaridade.getSelectedItem());
            }
        });

        tfCpf.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (!Character.isDigit(e.getKeyChar()) || tfCpf.getText().length() > 11) {
                    e.consume();
                }
            }
        });
    }


    private boolean validateFormFields() {

        if (tfNome.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Informe o nome", "Erro", JOptionPane.WARNING_MESSAGE);
            tfNome.requestFocus();
            return false;
        }
        if (tfCpf.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Informe o CPF", "Erro", JOptionPane.WARNING_MESSAGE);
            tfCpf.requestFocus();
            return false;
        }
        if (tfEmail.getText().length() != 11) {
            JOptionPane.showMessageDialog(this, "Informe o Email", "Erro", JOptionPane.WARNING_MESSAGE);
            tfEmail.requestFocus();
            return false;
        }
        if (tfNascimento.getValue() == null) {
            JOptionPane.showMessageDialog(this, "Informe a Data de nascimento", "Erro", JOptionPane.WARNING_MESSAGE);
            tfNascimento.requestFocus();
            return false;
        }
        if (cbEscolaridade.getSelectedItem() == null) {
            JOptionPane.showMessageDialog(this, "Informe a escolaridade", "Erro", JOptionPane.WARNING_MESSAGE);
            cbEscolaridade.requestFocus();
            return false;
        }
        if (cbEstadoCivil.getSelectedItem() == null) {
            JOptionPane.showMessageDialog(this, "Informe o Estado civil", "Erro", JOptionPane.WARNING_MESSAGE);
            cbEstadoCivil.requestFocus();
            return false;
        }

        return true;
    }
}
