package com.ivs.tws.systems;



import com.artemis.Aspect;
import com.artemis.ComponentMapper;
import com.artemis.Entity;
import com.artemis.annotations.Wire;
import com.artemis.systems.IntervalEntityProcessingSystem;
import com.ivs.tws.components.Bounds;
import com.ivs.tws.components.Health;
import com.ivs.tws.components.Player;
import com.ivs.tws.components.Position;
import com.ivs.tws.components.Velocity;
import com.ivs.tws.core.Constants;

@Wire
public class RemoveOffscreenShipsSystem extends IntervalEntityProcessingSystem {
	private ComponentMapper<Position> positionMapper;
	private ComponentMapper<Bounds> boundsMapper;

	@SuppressWarnings("unchecked")
    public RemoveOffscreenShipsSystem() {
		super(Aspect.all(Velocity.class, Position.class, Health.class, Bounds.class).exclude(Player.class), 5);
	}

	@Override
	protected void process(Entity e) {
		Position position = positionMapper.get(e);
		Bounds bounds = boundsMapper.get(e);
		
		if(position.y < -Constants.FRAME_HEIGHT/2-bounds.radius) {
			e.deleteFromWorld();
		}
	}

}
