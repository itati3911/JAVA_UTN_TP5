package ventanas;

import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;

import peliculas.Pelicula;
import java.util.ArrayList;

public class pListarPeliculas extends JPanel {

	private static final long serialVersionUID = 1L;

	public pListarPeliculas() {
		setLayout(null);

		JTextArea textArea = new JTextArea();
		textArea.setEditable(false);
		JScrollPane scrollPane = new JScrollPane(textArea);
		scrollPane.setBounds(20, 20, 340, 250);
		add(scrollPane);

		ArrayList<Pelicula> peliculas = pAgregarPeliculas.getListaPeliculas();

		if (!peliculas.isEmpty()) {
			// Ordeno las películas
			Pelicula aux = new Pelicula(); // para usar el método ordenarPeliculas
			peliculas = aux.ordenarPeliculas(new ArrayList<>(peliculas)); // copia para no modificar original

			for (Pelicula p : peliculas) {
				textArea.append(p.toString() + "\n");
			}
		} else {
			textArea.setText("No hay películas cargadas.");
		}
	}
}
