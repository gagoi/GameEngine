package fr.game_engine.graphics.elements;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

import fr.game_engine.graphics.IRenderable;
import fr.game_engine.utils.PolygonD;
import fr.game_engine.utils.VectD;

public class ParticleGenerator implements IRenderable {

	private static final Random rand = new Random();
	private PolygonD startingBox; // Position du générateur
	private ArrayList<LifeLimitedParticle> particles;
	private final int nbParticlesPerGen;
	private final int nbUpdateBetweenGen;
	private final VectD speed;
	private final LifeLimitedParticle source;

	private int counter = 0;

	public ParticleGenerator(final VectD speed, final PolygonD startingBox,
			final int nbParticlesPerGen, final int nbUpdateBetweenGen, final LifeLimitedParticle source) {
		this.speed = speed;
		this.startingBox = startingBox;
		this.nbParticlesPerGen = nbParticlesPerGen;
		this.nbUpdateBetweenGen = nbUpdateBetweenGen;
		this.source = source;
		this.particles = new ArrayList<LifeLimitedParticle>(nbParticlesPerGen);
	}

	@Override
	public void draw(Graphics g) {
		//if (counter == 0)
			//for (int i = 0; i < nbParticlesPerGen; i++)
				//particles.add(new LifeLimitedParticle(rand.nextInt()source))
				
	}

	@Override
	public int getLayer() {
		// TODO Auto-generated method stub
		return 0;
	}

}
