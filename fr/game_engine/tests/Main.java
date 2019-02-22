package fr.game_engine.tests;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import fr.game_engine.graphics.IRenderable;
import fr.game_engine.graphics.elements.LifeLimitedParticle;
import fr.game_engine.graphics.elements.ParticleGenerator;
import fr.game_engine.main.Game;
import fr.game_engine.utils.RectD;
import fr.game_engine.utils.VectD;

public class Main {

	// Test pour l'interface graphique
	public static void main(String[] args) {
		System.out.println("Hello World");
		Game g = new Game(new Dimension(1280, 720), 2, 240);

		testParticuleGen(g);
		
		g.resume();

	}

	private static void testIRenderable(Game g) {
		IRenderable render = new IRenderable() {
			int i = 0;

			@Override
			public int getLayer() {
				return 0;
			}

			@Override
			public void draw(Graphics g) {
				Graphics2D g2d = (Graphics2D) g;
				g2d.setColor(Color.RED);
				g2d.fillRect(i / 120, i / 120, 50, 50);
				++i;
			}
		};

		IRenderable render2 = new IRenderable() {
			int i = 660;

			@Override
			public int getLayer() {
				// TODO Auto-generated method stub
				return 1;
			}

			@Override
			public void draw(Graphics g) {

				Graphics2D g2d = (Graphics2D) g;
				g2d.setColor(Color.GREEN);
				g2d.fillRect(i / 10, 20 + 20, 20, 20);
				i++;

			}
		};

		g.addIRenderable(render);
		g.addIRenderable(render2);
	}

	private static void testParticuleGen(Game g) {
		ParticleGenerator gen = new ParticleGenerator(new VectD(1, 1), new RectD(200, 200, 100, 100), 10, 120,
				new LifeLimitedParticle(50, 50, 30000000));
		g.addIRenderable(gen);
	}
}