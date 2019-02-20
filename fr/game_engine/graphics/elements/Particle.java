package fr.game_engine.graphics.elements;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import fr.game_engine.graphics.IRenderable;
import fr.game_engine.utils.IMovable;
import fr.game_engine.utils.RectD;

public class Particle implements IRenderable, IMovable {

	private final int layer; // Plan sur lequel est affiché la particule.
	private RectD box;
	private final BufferedImage texture; // Texture de la particule.

	/*
	 * Créer une particule par défaut.
	 * 
	 * @param x : Position en x.
	 * 
	 * @param y : Position en ordonnée.
	 */
	public Particle(final int x, final int y) {
		this.layer = 0;
		this.box = new RectD(x, y, 16, 16);
		this.texture = new BufferedImage(16, 16, BufferedImage.TYPE_INT_RGB); // Image par défaut
		Graphics g = this.texture.getGraphics();
		g.setColor(new Color(255, 255, 0));
		g.fillRect(0, 0, 16, 16);
	}

	/*
	 * Créer une particule par défaut.
	 * 
	 * @param x : Position en x.
	 * 
	 * @param y : Position en ordonnée.
	 * 
	 * @param layer : Plan sur lequel on veut dessiner la texture.
	 * 
	 * @param texture : Image de la particule.
	 */
	public Particle(final int x, final int y, final int layer, final BufferedImage texture) {
		this.layer = layer;
		if (texture == null)
			throw new NullPointerException();
		this.texture = texture;
		this.box = new RectD(x, y, texture.getWidth(), texture.getHeight());
	}

	@Override
	public void draw(Graphics g) {
		if (texture == null) { // Si l'image n'existe pas, on dessine un rectangle rose.
			g.setColor(new Color(255, 0, 255));
			g.fillRect((int) box.getX(), (int) box.getY(), (int) box.getWidth(), (int) box.getWidth());
		} else { // Sinon on dessine l'image aux bonnes coordonnées.
			g.drawImage(texture, (int) box.getX(), (int) box.getY(), null);
		}
	}

	@Override
	public int getLayer() {
		return this.layer;
	}

	@Override
	public void move(double dx, double dy) {
		box.move(dx, dy);
	}
}
