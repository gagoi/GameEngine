package fr.game_engine.graphics.elements;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import fr.game_engine.graphics.IRenderable;

public class Particle implements IRenderable, IMovable {

	private final int layer; // Plan sur lequel est affiché la particule.
	private final int width, height; // Taille de la particule.
	private double x, y; // Position de la particule.
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
		this.width = 16;
		this.height = 16;
		this.x = x;
		this.y = y;
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
		this.width = texture.getWidth();
		this.height = texture.getHeight();
		this.x = x;
		this.y = y;
	}

	@Override
	public void draw(Graphics g) {
		if (texture == null) { // Si l'image n'existe pas, on dessine un rectangle rose.
			g.setColor(new Color(255, 0, 255));
			g.fillRect((int) x, (int) y, width, height);
		} else { // Sinon on dessine l'image aux bonnes coordonnées.
			g.drawImage(texture, (int) x, (int) y, null);
		}
	}

	@Override
	public int getLayer() {
		return this.layer;
	}

	@Override
	public void moove(double dx, double dy) {
		this.x += dx;
		this.y += dy;
	}

}
