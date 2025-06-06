package ventanas;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class vPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public vPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 350);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnPeliculas = new JMenu("Películas");
		mnPeliculas.setFont(new Font("Verdana", Font.PLAIN, 12));
		menuBar.add(mnPeliculas);
		
		JMenuItem mnItAgregarPeliculas = new JMenuItem("Agregar");
		mnItAgregarPeliculas.setFont(new Font("Verdana", Font.PLAIN, 12));
		
		mnItAgregarPeliculas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contentPane.removeAll();
				pAgregarPeliculas panel = new pAgregarPeliculas();
				contentPane.add(panel);
				contentPane.repaint();
				contentPane.revalidate();
			}
		});
		mnPeliculas.add(mnItAgregarPeliculas);
		
		JMenuItem mnItListarPeliculas = new JMenuItem("Listar");
		mnItListarPeliculas.setFont(new Font("Verdana", Font.PLAIN, 12));
		
		mnItListarPeliculas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		mnPeliculas.add(mnItListarPeliculas);
		
		mnItListarPeliculas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contentPane.removeAll();
				pListarPeliculas panel = new pListarPeliculas();
				contentPane.add(panel);
				contentPane.repaint();
				contentPane.revalidate();
			}
		});
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
	}
}
