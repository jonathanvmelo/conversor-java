package conversor.java.tela;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.Font;
import javax.swing.DefaultComboBoxModel;

public class ConversorDeVelocidade extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConversorDeVelocidade frame = new ConversorDeVelocidade();
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
	public ConversorDeVelocidade() {
		setTitle("Conversor de Velocidade");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Converter de:");
		lblNewLabel_1.setBounds(33, 77, 118, 19);
		contentPane.add(lblNewLabel_1);
		
		JComboBox jcombobox1 = new JComboBox();
		jcombobox1.setModel(new DefaultComboBoxModel(new String[] {"Selecione", "km/h", "m/s", "km/s", "Milha por hora (mph)", "Nó", "Velocidade da luz", "Velocidade do som", "Velocidade de um caracol comum"}));
		jcombobox1.setSelectedIndex(0);
		jcombobox1.setBackground(Color.WHITE);
		jcombobox1.setBounds(33, 95, 165, 22);
		contentPane.add(jcombobox1);
		
		JLabel lblPara = new JLabel("Para:");
		lblPara.setVerticalAlignment(SwingConstants.TOP);
		lblPara.setBounds(33, 125, 118, 22);
		contentPane.add(lblPara);
		
		JComboBox jcombobox2 = new JComboBox();
		jcombobox2.setModel(new DefaultComboBoxModel(new String[] {"Selecione", "km/h", "m/s", "km/s", "Milha por hora (mph)", "Nó", "Velocidade da luz", "Velocidade do som", "Velocidade de um caracol comum"}));
		jcombobox2.setSelectedIndex(0);
		jcombobox2.setBackground(Color.WHITE);
		jcombobox2.setBounds(33, 142, 165, 22);
		contentPane.add(jcombobox2);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(232, 97, 165, 22);
		contentPane.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		textField_1.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		textField_1.setBounds(232, 141, 165, 24);
		contentPane.add(textField_1);
		
		JButton btnNewButton = new JButton("Converter");
		btnNewButton.setBounds(33, 206, 97, 23);
		contentPane.add(btnNewButton);
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.setBounds(165, 206, 97, 23);
		contentPane.add(btnLimpar);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setBounds(300, 206, 97, 23);
		contentPane.add(btnVoltar);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(30, 144, 255));
		panel.setBounds(0, 0, 434, 64);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Conversor de Velocidade");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setForeground(SystemColor.text);
		lblNewLabel.setBounds(0, 0, 434, 64);
		panel.add(lblNewLabel);
	}
}
