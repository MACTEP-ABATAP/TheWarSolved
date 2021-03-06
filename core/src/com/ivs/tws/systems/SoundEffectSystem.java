package com.ivs.tws.systems;



import com.artemis.Aspect;
import com.artemis.ComponentMapper;
import com.artemis.Entity;
import com.artemis.annotations.Wire;
import com.artemis.systems.EntityProcessingSystem;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.ivs.tws.components.SoundEffect;

@Wire
public class SoundEffectSystem extends EntityProcessingSystem {

	private ComponentMapper<SoundEffect> se;

	Sound pew = Gdx.audio.newSound(Gdx.files.internal("sounds/pew.wav"));
	Sound asplode = Gdx.audio.newSound(Gdx.files.internal("sounds/asplode.wav"));
	Sound smallasplode = Gdx.audio.newSound(Gdx.files.internal("sounds/smallasplode.wav"));

	@SuppressWarnings("unchecked")
	public SoundEffectSystem() {
		super(Aspect.all(SoundEffect.class));
	}

	@Override
    protected void process(Entity e) {

		SoundEffect soundEffect = se.get(e);
		
		switch (soundEffect.effect) {
		case PEW:
			pew.play();
			break;
		case ASPLODE:
			asplode.play();
			break;
		case SMALLASPLODE:
			smallasplode.play();
			break;
		default:
			break;
		}

		e.edit().remove(soundEffect);

    }
}
