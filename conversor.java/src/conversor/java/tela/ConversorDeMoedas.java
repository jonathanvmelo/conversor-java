package conversor.java.tela;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Atxy2k.CustomTextField.RestrictedTextField;

import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.border.BevelBorder;
import java.awt.SystemColor;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class ConversorDeMoedas extends JFrame {

	private JPanel contentPane;
	private JTextField txtBox1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConversorDeMoedas frame = new ConversorDeMoedas();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ConversorDeMoedas() {

		setFont(new Font("Dialog", Font.PLAIN, 12));
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(ConversorDeMoedas.class.getResource("/image/currency.png")));
		setTitle("Conversor de Moedas");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(700, 400, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Converter de:");
		lblNewLabel.setBounds(33, 76, 118, 19);
		contentPane.add(lblNewLabel);

		JComboBox comboBoxMoedaInicial = new JComboBox();
		comboBoxMoedaInicial.setBackground(Color.WHITE);
		comboBoxMoedaInicial.setModel(new DefaultComboBoxModel(new String[] {"Selecione", "Real", "Dólar", "Euro", "Libras Esterlinas", "Peso Argentino"}));
		comboBoxMoedaInicial.setSelectedIndex(0);
		comboBoxMoedaInicial.setBounds(33, 94, 165, 22);
		contentPane.add(comboBoxMoedaInicial);

		JComboBox comboBoxMoedaFinal = new JComboBox();
		comboBoxMoedaFinal.setModel(new DefaultComboBoxModel(new String[] {"Selecione", "Real", "Dólar", "Euro", "Libras Esterlinas", "Peso Argentino"}));
		comboBoxMoedaFinal.setSelectedIndex(0);
		comboBoxMoedaFinal.setBackground(Color.WHITE);
		comboBoxMoedaFinal.setBounds(236, 94, 165, 22);
		contentPane.add(comboBoxMoedaFinal);

		JLabel lblNewLabel_1 = new JLabel("Para:");
		lblNewLabel_1.setBounds(237, 78, 46, 14);
		contentPane.add(lblNewLabel_1);

		txtBox1 = new JTextField();
		txtBox1.setBounds(236, 140, 165, 28);
		contentPane.add(txtBox1);
		txtBox1.setColumns(10);

		JButton btnNewButton = new JButton("Converter");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (txtBox1.getText().equals(""))   {
					erroCampo();
					txtBox1.requestFocus();
				}
				else if( comboBoxMoedaInicial.equals("Selecione") || comboBoxMoedaFinal.equals("Selecione")) {
					erroOpcao();
					txtBox1.requestFocus();
				}
				else {

					String box1 = (String) comboBoxMoedaInicial.getSelectedItem();
					String box2 = (String) comboBoxMoedaFinal.getSelectedItem();
					double valor = Double.parseDouble(txtBox1.getText());

					// Real(Brl) para:
					if (box1.equals("Real") && box2.equals("Dólar")) {
						double moedaDolar = valor / 5.19;
						moedaDolar = (double) Math.round(moedaDolar * 100d) / 100;
						JOptionPane.showMessageDialog(null, "Você tem $" + moedaDolar +  " dólares.");

					} else if (box1.equals("Real") && box2.equals("Euro")) {
						double moedaEuro = valor / 5.57;
						moedaEuro = (double) Math.round(moedaEuro * 100d) / 100;
						JOptionPane.showMessageDialog(null, "Você tem €" + moedaEuro +  " euros.");
						
					} else if (box1.equals("Real") && box2.equals("Libras Esterlinas")) {
						double moedaLibra = valor / 6.37;
						moedaLibra = (double) Math.round(moedaLibra * 100d) / 100;
						JOptionPane.showMessageDialog(null, "Você tem £" + moedaLibra +  " libras.");

					} else if (box1.equals("Real") && box2.equals("Peso Argentino")) {
						double moedaPesoArg = valor / 0.028;
						moedaPesoArg = (double) Math.round(moedaPesoArg * 100d) / 100;
						JOptionPane.showMessageDialog(null, "Você tem $" + moedaPesoArg + " pesos.");

						
						// Dólar(US) para:
					} else if (box1.equals("Dólar") && box2.equals("Peso Argentino")) {
						double moedaPesoArg = valor / 35.34;
						moedaPesoArg = (double) Math.round(moedaPesoArg * 100d) / 100;
						JOptionPane.showMessageDialog(null, "Você tem $" + moedaPesoArg + " pesos.");

					} else if (box1.equals("Dólar") && box2.equals("Euro")) {
						double moedaPesoArg = valor / 0.94;
						moedaPesoArg = (double) Math.round(moedaPesoArg * 100d) / 100;
						JOptionPane.showMessageDialog(null, "Você tem $" + moedaPesoArg + " euros.");

					} else if (box1.equals("Dólar") && box2.equals("Libras Esterlinas")) {
						double moedaPesoArg = valor / 0.8307;
						moedaPesoArg = (double) Math.round(moedaPesoArg * 100d) / 100;
						JOptionPane.showMessageDialog(null, "Você tem $" + moedaPesoArg + " libras.");

					} else if (box1.equals("Dólar") && box2.equals("Real")) {
						double moedaPesoArg = valor / 0.1935;
						moedaPesoArg = (double) Math.round(moedaPesoArg * 100d) / 100;
						JOptionPane.showMessageDialog(null, "Você tem R$" + moedaPesoArg + " reais.");

					}

					// Euro(EU) para:
					else if (box1.equals("Euro") && box2.equals("Peso Argentino")) {
						double moedaPesoArg = valor / 0.0048;
						moedaPesoArg = (double) Math.round(moedaPesoArg * 100d) / 100;
						JOptionPane.showMessageDialog(null, "Você tem $" + moedaPesoArg + " pesos.");

					} else if (box1.equals("Euro") && box2.equals("Dólar")) {
						double moedaPesoArg = valor / 0.9361;
						moedaPesoArg = (double) Math.round(moedaPesoArg * 100d) / 100;
						JOptionPane.showMessageDialog(null, "Você tem $" + moedaPesoArg + " dólares.");

					} else if (box1.equals("Euro") && box2.equals("Libras Esterlinas")) {
						double moedaPesoArg = valor / 1.1270;
						moedaPesoArg = (double) Math.round(moedaPesoArg * 100d) / 100;
						JOptionPane.showMessageDialog(null, "Você tem $" + moedaPesoArg + " libras.");

					} else if (box1.equals("Euro") && box2.equals("Real")) {
						double moedaPesoArg = valor / 0.1811;
						moedaPesoArg = (double) Math.round(moedaPesoArg * 100d) / 100;
						JOptionPane.showMessageDialog(null, "Você tem R$" + moedaPesoArg + " reais.");
					
					}
					
					
					// Libra Esterlina(LE) para:
					else if (box1.equals("Libras Esterlinas") && box2.equals("Peso Argentino")) {
						double moedaPesoArg = valor / 0.0048;
						moedaPesoArg = (double) Math.round(moedaPesoArg * 100d) / 100;
						JOptionPane.showMessageDialog(null, "Você tem $" + moedaPesoArg + " pesos.");

					} else if (box1.equals("Libras Esterlinas") && box2.equals("Dólar")) {
						double moedaPesoArg = valor / 0.9361;
						moedaPesoArg = (double) Math.round(moedaPesoArg * 100d) / 100;
						JOptionPane.showMessageDialog(null, "Você tem $" + moedaPesoArg + " dólares.");

					} else if (box1.equals("Libras Esterlinas") && box2.equals("Euro")) {
						double moedaPesoArg = valor / 1.1270;
						moedaPesoArg = (double) Math.round(moedaPesoArg * 100d) / 100;
						JOptionPane.showMessageDialog(null, "Você tem $" + moedaPesoArg + " libras.");

					} else if (box1.equals("Libras Esterlinas") && box2.equals("Real")) {
						double moedaPesoArg = valor / 0.1811;
						moedaPesoArg = (double) Math.round(moedaPesoArg * 100d) / 100;
						JOptionPane.showMessageDialog(null, "Você tem R$" + moedaPesoArg + " reais.");
					
					}
					
					// Peso Argentino(PA) para:
					else if (box1.equals("Peso Argentino") && box2.equals("Euro")) {
						double moedaPesoArg = valor / 206.2768;
						moedaPesoArg = (double) Math.round(moedaPesoArg * 100d) / 100;
						JOptionPane.showMessageDialog(null, "Você tem $" + moedaPesoArg + " libras.");

					} else if (box1.equals("Peso Argentino") && box2.equals("Dólar")) {
						double moedaPesoArg = valor / 193.102;
						moedaPesoArg = (double) Math.round(moedaPesoArg * 100d) / 100;
						JOptionPane.showMessageDialog(null, "Você tem $" + moedaPesoArg + " dólares.");

					} else if (box1.equals("Peso Argentino") && box2.equals("Libras Esterlinas")) {
						double moedaPesoArg = valor / 232.467;
						moedaPesoArg = (double) Math.round(moedaPesoArg * 100d) / 100;
						JOptionPane.showMessageDialog(null, "Você tem $" + moedaPesoArg + " libras.");

					} else if (box1.equals("Peso Argentino") && box2.equals("Real")) {
						double moedaPesoArg = valor / 37.3634;
						moedaPesoArg = (double) Math.round(moedaPesoArg * 100d) / 100;
						JOptionPane.showMessageDialog(null, "Você tem R$" + moedaPesoArg + " reais.");
					
					}

				}

			}

			private void erroOpcao() {
				String mensagem = "Favor escolher uma opção a ser convertida!";
				String titulo = "Erro";
				JOptionPane.showMessageDialog(null, mensagem, titulo, JOptionPane.ERROR_MESSAGE);
				
			}

			private void erroCampo() {
				String mensagem = "Favor digitar um valor!";
				String titulo = "Erro - Campo não preenchido";
				JOptionPane.showMessageDialog(null, mensagem, titulo, JOptionPane.ERROR_MESSAGE);

			}
		});

		// Validação com a bibliotéca Atxy2k
		RestrictedTextField validar = new RestrictedTextField(txtBox1);
		validar.setOnlyNums(true);

		btnNewButton.setBounds(33, 208, 102, 23);
		contentPane.add(btnNewButton);

		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				txtBox1.setText("");
				comboBoxMoedaFinal.nextFocus();
			}
		});
		btnLimpar.setBounds(174, 208, 96, 23);
		contentPane.add(btnLimpar);

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				voltar();
			}

			private void voltar() {
				String msg = "Deseja realmente voltar?";
				int voltar = JOptionPane.showConfirmDialog(btnLimpar, msg, null, JOptionPane.YES_NO_OPTION);
				if (voltar == JOptionPane.YES_OPTION) {
					Main conversor = new Main();
					conversor.setVisible(true);

				}

			}

		});

		btnVoltar.setBounds(305, 208, 96, 23);
		contentPane.add(btnVoltar);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(30, 144, 255));
		panel_1.setBounds(0, 0, 434, 64);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblNewLabel_2 = new JLabel(" Conversor de Moedas");
		lblNewLabel_2.setIcon(
				new ImageIcon(ConversorDeMoedas.class.getResource("/image/icons8-dollar-euro-exchange-32.png")));
		lblNewLabel_2.setForeground(SystemColor.text);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(71, 11, 272, 42);
		panel_1.add(lblNewLabel_2);

		JLabel lblMsg = new JLabel("Digite o valor a ser convertido:");
		lblMsg.setBounds(42, 140, 173, 28);
		contentPane.add(lblMsg);

	}

}
