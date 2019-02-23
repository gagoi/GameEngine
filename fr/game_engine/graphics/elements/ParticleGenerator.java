package fr.game_engine.graphics.elements;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

import fr.game_engine.graphics.IRenderable;
import fr.game_engine.utils.RectD;
import fr.game_engine.utils.VectD;

public class ParticleGenerator implements IRenderable {

	private static final Random rand = new Random();
	private RectD startingBox; // Position du générateur
	private ArrayList<LifeLimitedParticle> particles;
	private final int nbParticlesPerGen;
	private final int nbUpdateBetweenGen;
	private VectD speed;
	private final LifeLimitedParticle source;

	private int counter = 0;

	public ParticleGenerator(final VectD speed, final RectD startingBox, final int nbParticlesPerGen,
			final int nbUpdateBetweenGen, final LifeLimitedParticle source) {
		this.speed = speed;
		this.startingBox = startingBox;
		this.nbParticlesPerGen = nbParticlesPerGen;
		this.nbUpdateBetweenGen = nbUpdateBetweenGen;

		if (source == null)
			throw new NullPointerException();

		this.source = source;
		this.particles = new ArrayList<LifeLimitedParticle>(nbParticlesPerGen);
	}

	public ParticleGenerator(final RectD startingBox, final int nbParticlesPerGen, final int nbUpdateBetweenGen,
			final SelfManagedParticle source) {
		this.source = source;
		this.startingBox = startingBox;
		this.nbParticlesPerGen = nbParticlesPerGen;
		this.nbUpdateBetweenGen = nbUpdateBetweenGen;
	}

	@Override
	public void draw(Graphics g) {
		for (LifeLimitedParticle lifeLimitedParticle : particles) {
			lifeLimitedParticle.draw(g);
		}
		update();
	}

	private void update() {
		if (counter == 0)
			for (int i = 0; i < nbParticlesPerGen; i++)
				particles.add(
						new LifeLimitedParticle((int) startingBox.getX() + rand.nextInt((int) startingBox.getWidth()),
								(int) startingBox.getY() + rand.nextInt((int) startingBox.getHeight()), source));
		counter = (counter + 1) % nbUpdateBetweenGen;

		for (int i = 0; i < particles.size(); i++) {
			particles.get(i).move(speed.getX(), speed.getY());
			if (!particles.get(i).isAlive())
				particles.remove(i);
		}
	}

	@Override
	public int getLayer() {
		return source.layer;
	}

}
