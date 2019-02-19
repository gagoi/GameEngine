package fr.game_engine.graphics;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.VolatileImage;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Window extends JFrame {

	private Dimension d; // Taille de la fenêtre.

	private List<IRenderable> enabledEelements; // Liste des éléments dont on doit faire le rendu.

	public Window(final int nbLayers, final Dimension d) {
		getContentPane().add(new Renderer(nbLayers));
		this.d = d;
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(d);
		enabledEelements = new ArrayList<IRenderable>();
	}

	/*
	 * Classe interne utilisée pour créer l'objet s'occupant du rendu de l'image.
	 */
	class Renderer extends JPanel {
		/*
		 * Tableau contenant les images dont on doit faire le rendu de la 1ère (indice
		 * 1) à la dernière (indice nbLayers-1) sur une même image de fond (indice 0)
		 * qui sera celle affichée par le jeu.
		 * 
		 * To-Do : optimisation en parallélisant le rendu des images (1 .. nbLayers-1)
		 * puis une fois tout finis, faire les rendus 1 par 1 sur l'image d'indice 0.
		 */
		VolatileImage img[];

		public Renderer(final int nbLayers) {
			// Création du tableau à la bonne taille.
			img = new VolatileImage[nbLayers];
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
			Graphics2D g2d; // Permet de dessiner sur chaque image.
			// Si l'image du fond n'existe pas, elle est crée sans transparence (celle sur
			// laquelle tout sera
			// dessiné).
			if (img[0] == null)
				img[0] = getGraphicsConfiguration().createCompatibleVolatileImage(d.width, d.height,
						VolatileImage.OPAQUE);
			g2d = (Graphics2D) img[0].getGraphics(); // Permet de dessiner sur l'image n°0.
			g2d.setBackground(Color.BLACK); // Couleur de fond noir
			g2d.clearRect(0, 0, d.width, d.height); // Reset de l'image n°0 avec la couleur de fond.

			// Pour chaque image restante, si elle n'exite pas on la créé transparente. On
			// reset l'affichage (en transparent), puis on fais le rendu.
			for (int i = 1; i < img.length; i++) {
				if (img[i] == null)
					img[i] = getGraphicsConfiguration().createCompatibleVolatileImage(d.width, d.height,
							VolatileImage.TRANSLUCENT);
				g2d = (Graphics2D) img[i].getGraphics();// Permet de dessiner sur l'image n°i.
				g2d.setBackground(new Color(0, 0, 0, 0)); // Couleur de fond transparente
				g2d.clearRect(0, 0, d.width, d.height); // Reset de l'image n°i avec la couleur de fond.
			}

			// Faire le rendu de chaque élément sur l'image qu'il demande.
			for (IRenderable iRenderable : enabledEelements) {
				iRenderable.draw(img[iRenderable.getLayer()].getGraphics());
			}

		}
	}
	
	/*
	 * Ajoute un élément à la liste des éléments à dessiner (seulement si il n'est pas déjà dedans.
	 */
	public void addIRenderable(IRenderable iRenderable) {
		if (!this.enabledEelements.contains(iRenderable))
			this.enabledEelements.add(iRenderable);
	}
	
	/*
	 * Retire un élément de la liste des éléments à dessiner.
	 */
	public void removeIRenderable(IRenderable iRenderable) {
		this.enabledEelements.remove(iRenderable);
	}
}
