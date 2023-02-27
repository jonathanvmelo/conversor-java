package conversor.java.tela;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Toolkit;
import java.net.URI;
import java.awt.SystemColor;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class About extends JDialog {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					About dialog = new About();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the dialog.
	 */
	public About() {
		setModal(true);
		setResizable(false);
		setTitle("Sobre");
		setIconImage(Toolkit.getDefaultToolkit().getImage(About.class.getResource("/image/home.png")));
		setBounds(750, 450, 450, 300);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Saiba mais:");
		lblNewLabel.setBounds(73, 183, 72, 14);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Conversor versão 1.0");
		lblNewLabel_1.setBounds(73, 45, 134, 14);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("@Author - Jonathan Volpato de Melo");
		lblNewLabel_2.setBounds(73, 82, 222, 14);
		getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("WEB Service:");
		lblNewLabel_3.setBounds(73, 120, 82, 14);
		getContentPane().add(lblNewLabel_3);
		
		JLabel lblWebService = new JLabel("https://dadosabertos.bcb.gov.br");
		lblWebService.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				link("https://dadosabertos.bcb.gov.br/dataset/dolar-americano-usd-todos-os-boletins-diarios");
			}
		});
		lblWebService.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblWebService.setForeground(SystemColor.textHighlight);
		lblWebService.setBounds(160, 120, 216, 14);
		getContentPane().add(lblWebService);
		
		JButton btnLinkedin = new JButton("");
		btnLinkedin.setBackground(SystemColor.control);
		btnLinkedin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				link("https://www.linkedin.com/in/jonathanvmelo/");
			}
		});
		btnLinkedin.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnLinkedin.setBorder(null);
		btnLinkedin.setIcon(new ImageIcon(About.class.getResource("/image/linkedin.png")));
		btnLinkedin.setBounds(145, 164, 48, 48);
		getContentPane().add(btnLinkedin);
		
		JButton btnGitHub = new JButton("");
		btnGitHub.setBackground(SystemColor.control);
		btnGitHub.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				link("https://github.com/jonathanvmelo/Conversor-Java");
			}
		});
		btnGitHub.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnGitHub.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnGitHub.setIcon(new ImageIcon(About.class.getResource("/image/icons8-github-48.png")));
		btnGitHub.setBorder(null);
		btnGitHub.setBounds(200, 164, 48, 48);
		getContentPane().add(btnGitHub);

	}
	
	//Método para abrir site externo no navegador padrão do sistema operacional
	private void link(String site) {
		Desktop desktop = Desktop.getDesktop();
		try {
			URI uri = new URI(site);
			desktop.browse(uri);
		}catch(Exception e) {
			System.out.println(e);
		}
	}
}
