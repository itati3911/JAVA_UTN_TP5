package ventanas;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import peliculas.Categoria;
import peliculas.Pelicula;

import javax.swing.JComboBox;

import java.awt.Font;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class pAgregarPeliculas extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField txtId;
	private JTextField txtNombre;
	private JComboBox<String> cbGenero;
	private JButton btnAceptar;
	
	//declaro la lista
	private static ArrayList<Pelicula> listaPeliculas = new ArrayList<>();


	public pAgregarPeliculas() {
		dibujarControles();
	}
	
	public void dibujarControles() {
		
		Font fuenteComun = new Font("Verdana", Font.PLAIN, 11);
		
		setLayout(null);
		
		JLabel lblId = new JLabel("ID");
		lblId.setFont(fuenteComun);
		lblId.setBounds(85, 60, 50, 20);
		add(lblId);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setFont(fuenteComun);
		lblNombre.setBounds(85, 95, 50, 20);
		add(lblNombre);
		
		JLabel lblGenero = new JLabel("Genero");
		lblGenero.setFont(fuenteComun);
		lblGenero.setBounds(85, 130, 50, 20);
		add(lblGenero);
		
		txtId = new JTextField();
		txtId.setFont(fuenteComun);
		txtId.setEditable(false);
		txtId.setBounds(155, 60, 40, 20);
		add(txtId);
		txtId.setColumns(10);
		
		txtNombre = new JTextField();
		txtNombre.setFont(fuenteComun);
		txtNombre.setBounds(155, 95, 110, 20);
		add(txtNombre);
		txtNombre.setColumns(10);
		
		cbGenero = new JComboBox<String>();
		cbGenero.setFont(fuenteComun);
		cbGenero.setBounds(155, 130, 110, 20);
		add(cbGenero);
		
		// Agrego los géneros al ComboBox
		cbGenero.addItem("Seleccione un género");
		cbGenero.addItem("Terror");
		cbGenero.addItem("Acción");
		cbGenero.addItem("Suspenso");
		cbGenero.addItem("Romántica");

		//Función en btnAceptr para agregar a la lista validando
		btnAceptar = new JButton("Aceptar");
		btnAceptar.setFont(fuenteComun);
		btnAceptar.setBounds(85, 165, 89, 25);
		add(btnAceptar);
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nombre = txtNombre.getText().trim();
				String generoSeleccionado = (String) cbGenero.getSelectedItem();

				if (nombre.isEmpty() || generoSeleccionado.equals("Seleccione un género")) {
					JOptionPane.showMessageDialog(null, "Por favor ingrese el nombre de la película y seleccione un género válido.", "Error", JOptionPane.ERROR_MESSAGE);
					return;
				}

				int nuevoId = listaPeliculas.size() + 1;
				Categoria categoria = new Categoria(nuevoId, generoSeleccionado);
				Pelicula pelicula = new Pelicula(nuevoId, nombre, categoria);

				listaPeliculas.add(pelicula);

				JOptionPane.showMessageDialog(null, "Película agregada correctamente.");

				txtNombre.setText("");
				cbGenero.setSelectedIndex(0);
			}
		});
	}
		
	public static ArrayList<Pelicula> getListaPeliculas() {
		return listaPeliculas;
	}
	
}
