package fr.game_engine.graphics.elements;

import fr.game_engine.utils.IUpdatable;
import fr.game_engine.utils.VectD;

public class SelfManagedParticle extends LifeLimitedParticle implements IUpdatable {

	private VectD speed;
	
	public SelfManagedParticle(final int x, final int y, final VectD speed, final LifeLimitedParticle particle) {
		super(x, y, particle);
		this.speed = speed;
	}

	@Override
	public void update() {
		move(speed.getX(), speed.getY());
	}
}
