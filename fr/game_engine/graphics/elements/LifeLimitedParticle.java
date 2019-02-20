package fr.game_engine.graphics.elements;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class LifeLimitedParticle extends Particle {

	public static final int IMMORTAL = -1;

	private final int lifeTime; // Durée de vie en nombre d'update (équivalent au nombre de déplacementà faire).
								// (-1 pour immortelle).
	private int life = 0; // Temps de vie (équivalen au nombre de déplacements fait).

	public LifeLimitedParticle(final int x, final int y, final int lifeTime) {
		super(x, y);
		this.lifeTime = lifeTime;
	}

	public LifeLimitedParticle(final int x, final int y, final int lifeTime, final int layer,
			final BufferedImage texture) {
		super(x, y, layer, texture);
		this.lifeTime = lifeTime;
	}

	public LifeLimitedParticle(final int x, final int y, final LifeLimitedParticle particle) {
		this(x, y, particle.lifeTime, particle.layer, particle.texture);
	}

	@Override
	public void move(double dx, double dy) {
		if (isAlive()) { // Si la particule est en vie.
			super.move(dx, dy);
			if (lifeTime != -1) // Si la vie n'est pas immortelle.
				life++; // Incrémentation du temps de vie à chaque déplacement.
		}
	}

	@Override
	public void draw(Graphics g) {
		if (isAlive()) // On ne dessine la particule que si elle est encore en vie.
			super.draw(g);
	}

	public boolean isAlive() {
		return life < lifeTime || lifeTime == -1; // Renvoie True si la particule est en vie ou immortelle.
	}

}
