package com.ivs.tws.core;



import com.artemis.Entity;
import com.artemis.World;
import com.artemis.managers.GroupManager;
import com.badlogic.gdx.math.MathUtils;
import com.ivs.tws.components.Bounds;
import com.ivs.tws.components.ColorAnimation;
import com.ivs.tws.components.Expires;
import com.ivs.tws.components.Health;
import com.ivs.tws.components.ParallaxStar;
import com.ivs.tws.components.Player;
import com.ivs.tws.components.Position;
import com.ivs.tws.components.ScaleAnimation;
import com.ivs.tws.components.SoundEffect;
import com.ivs.tws.components.Sprite;
import com.ivs.tws.components.Velocity;
import com.ivs.tws.core.Constants;

import static com.ivs.tws.components.SoundEffect.EFFECT.PEW;

public class EntityFactory {
	
	public static Entity createPlayer(World world, float x, float y) {
		Entity e = world.createEntity();
		
		Position position = new Position();
		position.x = x;
		position.y = y;
		e.edit().add(position);
		
		Sprite sprite = new Sprite();
		sprite.name = "fighter";
		sprite.r = 93/255f;
		sprite.g = 255/255f;
		sprite.b = 129/255f;
		sprite.layer = Sprite.Layer.ACTORS_3;
		e.edit().add(sprite);
		
		Velocity velocity = new Velocity();
		velocity.vectorX = 0;
		velocity.vectorY = 0;
		e.edit().add(velocity);
		
		Bounds bounds = new Bounds();
		bounds.radius = 43;
		e.edit().add(bounds);
		
		e.edit().add(new Player());
		
		world.getRegistered(GroupManager.class).add(e, Constants.Groups.PLAYER_SHIP);
		
		return e;
	}
	
	public static Entity createPlayerBullet(World world, float x, float y) {
		Entity e = world.createEntity();
		
		Position position = new Position();
		position.x = x;
		position.y = y;
		e.edit().add(position);
		
		Sprite sprite = new Sprite();
		sprite.name = "bullet";
		sprite.layer = Sprite.Layer.PARTICLES;
		e.edit().add(sprite);
		
		Velocity velocity = new Velocity();
		velocity.vectorY = 800;
		e.edit().add(velocity);
		
		Bounds bounds = new Bounds();
		bounds.radius = 5;
		e.edit().add(bounds);
		
		Expires expires = new Expires();
		expires.delay = 5;
		e.edit().add(expires);
		
		SoundEffect sf = new SoundEffect();
		sf.effect = PEW;
		e.edit().add(sf);
		
		world.getRegistered(GroupManager.class).add(e, Constants.Groups.PLAYER_BULLETS);
		
		return e;
	}
	
	public static Entity createEnemyShip(World world, String name, Sprite.Layer layer, float health, float x, float y, float velocityX, float velocityY, float boundsRadius) {
		Entity e = world.createEntity();
		
		Position position = new Position();
		position.x = x;
		position.y = y;
		e.edit().add(position);
		
		Sprite sprite = new Sprite();
		sprite.name = name;
		sprite.r = 255/255f;
		sprite.g = 0/255f;
		sprite.b = 142/255f;
		sprite.layer = layer;
		e.edit().add(sprite);
		
		Velocity velocity = new Velocity();
		velocity.vectorX = velocityX;
		velocity.vectorY = velocityY;
		e.edit().add(velocity);
		
		Bounds bounds = new Bounds();
		bounds.radius = boundsRadius;
		e.edit().add(bounds);
		
		Health h = new Health();
		h.health = h.maximumHealth = health;
		e.edit().add(h);
		
		//world.getRegistered(GroupManager.class).add(e, Constants.Groups.ENEMY_SHIPS);
		
		return e;
	}
	
	public static Entity createSmallExplosion(World world, float x, float y) {
		Entity e = createExplosion(world, x, y, 0.1f);
		
		SoundEffect sf = new SoundEffect();
		sf.effect = SoundEffect.EFFECT.SMALLASPLODE;
		e.edit().add(sf);
		
		
		return e;
	}
	public static Entity createBigExplosion(World world, float x, float y) {
		Entity e = createExplosion(world, x, y, 0.5f);
		
		SoundEffect sf = new SoundEffect();
		sf.effect = SoundEffect.EFFECT.ASPLODE;
		e.edit().add(sf);
		
		return e;
	}
	
	public static Entity createExplosion(World world, float x, float y, float scale) {
		Entity e = world.createEntity();
		
		Position position = new Position();
		position.x = x;
		position.y = y;
		e.edit().add(position);
		
		Sprite sprite = new Sprite();
		sprite.name = "explosion";
		sprite.scaleX = sprite.scaleY = scale;
		sprite.r = 1;
		sprite.g = 216/255f;
		sprite.b = 0;
		sprite.a = 0.5f;
		sprite.layer = Sprite.Layer.PARTICLES;
		e.edit().add(sprite);
		
		Expires expires = new Expires();
		expires.delay = 0.5f;
		e.edit().add(expires);
		
		ScaleAnimation scaleAnimation = new ScaleAnimation();
		scaleAnimation.active = true;
		scaleAnimation.max = scale;
		scaleAnimation.min = scale/100f;
		scaleAnimation.speed = -3.0f;
		scaleAnimation.repeat = false;
		e.edit().add(scaleAnimation);
		
		return e;
	}	
	
	public static Entity createStar(World world) {
		Entity e = world.createEntity();
		
		Position position = new Position();
		position.x = MathUtils.random(-Constants.FRAME_WIDTH/2, Constants.FRAME_WIDTH/2);
		position.y = MathUtils.random(-Constants.FRAME_HEIGHT/2, Constants.FRAME_HEIGHT/2);
		e.edit().add(position);
		
		Sprite sprite = new Sprite();
		sprite.name = "particle";
		sprite.scaleX = sprite.scaleY = MathUtils.random(0.5f, 1f);
		sprite.a = MathUtils.random(0.1f, 0.5f);
		sprite.layer = Sprite.Layer.BACKGROUND;
		e.edit().add(sprite);
		
		Velocity velocity = new Velocity();
		velocity.vectorY = MathUtils.random(-10f, -60f);
		e.edit().add(velocity);
		
		e.edit().add(new ParallaxStar());
		
		ColorAnimation colorAnimation = new ColorAnimation();
		colorAnimation.alphaAnimate = true;
		colorAnimation.repeat = true;
		colorAnimation.alphaSpeed = MathUtils.random(0.2f, 0.7f);
		colorAnimation.alphaMin = 0.1f;
		colorAnimation.alphaMax = 0.5f;
		e.edit().add(colorAnimation);
		
		return e;
	}
	
	public static Entity createParticle(World world, float x, float y) {
		Entity e = world.createEntity();
		
		Position position = new Position();
		position.x = x;
		position.y = y;
		e.edit().add(position);
		
		Sprite sprite = new Sprite();
		sprite.name = "particle";
		sprite.scaleX = sprite.scaleY = MathUtils.random(0.5f, 1f);
		sprite.r = 1;
		sprite.g = 216/255f;
		sprite.b = 0;
		sprite.a = 1f;
		sprite.layer = Sprite.Layer.PARTICLES;
		e.edit().add(sprite);
		
		float radians = MathUtils.random(2*MathUtils.PI);
		float magnitude = MathUtils.random(400f);
		 
		Velocity velocity = new Velocity();
		velocity.vectorX = magnitude * MathUtils.cos(radians);
		velocity.vectorY = magnitude * MathUtils.sin(radians);
		e.edit().add(velocity);

		Expires expires = new Expires();
		expires.delay = 1;
		e.edit().add(expires);

		ColorAnimation colorAnimation = new ColorAnimation();
		colorAnimation.alphaAnimate = true;
		colorAnimation.alphaSpeed = -1f;
		colorAnimation.alphaMin = 0f;
		colorAnimation.alphaMax = 1f;
		colorAnimation.repeat = false;
		e.edit().add(colorAnimation);

		return e;
	}

}
