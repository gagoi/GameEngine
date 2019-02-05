package fr.game_engine.graphics;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.VolatileImage;

import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Window extends JFrame {

	private Dimension d;

	public Window(final int nbLayers) {
		getContentPane().add(new Renderer(nbLayers));
	}

	/*
	 * Classe interne utilisée pour créer l'objet s'occupant du rendu de l'image.
	 */
	class Renderer extends JPanel {
		/*
		 * Tableau contenant les images dont on doit faire le rendu de la 1ère (indice
		 * 1) à la dernière (indice nbLayers-1) sur une même image de fond (indice 0) qui sera
		 * celle affichée par le jeu.
		 * 
		 * To-Do : optimisation en parallélisant le rendu des images (1 .. nbLayers-1) puis une fois tout finis, faire les rendus 1 par 1 sur l'image d'indice 0.
		 */
		VolatileImage img[];

		public Renderer(final int nbLayers) {
			// Création du tableau à la bonne taille.
			img = new VolatileImage[nbLayers];

			// L'image du fond est crée sans transparence (celle sur laquelle tout sera dessiné).
			img[0] = getGraphicsConfiguration().createCompatibleVolatileImage(d.width, d.height, VolatileImage.OPAQUE);

			// Pour chaque image restante, on la créé transparente.
			for (int i = 1; i < img.length; i++) {
				img[i] = getGraphicsConfiguration().createCompatibleVolatileImage(d.width, d.height,
						VolatileImage.TRANSLUCENT);
			}
		}

		/*
		 * Fonction débutant le rendu, et affichant le résultat sur l'écran.
		 */
		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g); // On laisse faire la classe mère en priorité.
			render(); // On fait le rendu de nos plans (layers).
			g.drawImage(img[0], 0, 0, null); // On affiche le résultat sur l'écran.

		}
		
		/*
		 * Fonction faisant le rendu des éléments, sur le bon plan (layer).
		 */
		public void render() {
			
		}
	}
}
