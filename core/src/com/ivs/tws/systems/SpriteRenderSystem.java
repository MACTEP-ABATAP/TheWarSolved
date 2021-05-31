package com.ivs.tws.systems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;



import com.artemis.Aspect;
import com.artemis.BaseEntitySystem;
import com.artemis.ComponentMapper;
import com.artemis.Entity;
import com.artemis.EntitySystem;
import com.artemis.utils.Bag;
import com.artemis.utils.ImmutableBag;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.ivs.tws.components.Position;
import com.ivs.tws.components.Sprite;

public class SpriteRenderSystem extends EntitySystem {
	ComponentMapper<Position> pm;
	ComponentMapper<Sprite> sm;

	private HashMap<String, AtlasRegion> regions;
	private TextureAtlas textureAtlas;
	private SpriteBatch batch;
	private OrthographicCamera camera;
	private BitmapFont font;

	private Bag<AtlasRegion> regionsByEntity;
	private List<Entity> sortedEntities;

	@SuppressWarnings("unchecked")
	public SpriteRenderSystem(OrthographicCamera camera, SpriteBatch batch) {
		super(Aspect.all(Position.class, Sprite.class));
		this.camera = camera;
		this.batch = batch;
	}

	@Override
	protected void initialize() {
		regions = new HashMap<String, AtlasRegion>();
		textureAtlas = new TextureAtlas(Gdx.files.internal("images-packed/pack.atlas"));
		for (AtlasRegion r : textureAtlas.getRegions()) {
			regions.put(r.name, r);
		}
		regionsByEntity = new Bag<AtlasRegion>();

		batch = new SpriteBatch();

		sortedEntities = new ArrayList<Entity>();

		Texture fontTexture = new Texture(Gdx.files.internal("fonts/normal_0.png"));
		fontTexture.setFilter(TextureFilter.Linear, TextureFilter.MipMapLinearLinear);
		TextureRegion fontRegion = new TextureRegion(fontTexture);
		font = new BitmapFont(Gdx.files.internal("fonts/normal.fnt"), fontRegion, false);
		font.setUseIntegerPositions(false);
	}

	@Override
	protected void begin() {
		batch.setProjectionMatrix(camera.combined);
		batch.begin();
	}

	@Override
	protected void processSystem() {

	}

	@Override
	protected boolean checkProcessing() {
		return true;
	}


	protected void processEntities(ImmutableBag<Entity> entities) {
		for (int i = 0; sortedEntities.size() > i; i++) {
			process(sortedEntities.get(i));
		}
	}

	protected void process(Entity e) {
		if (pm.has(e)) {
			Position position = pm.get(e);
			Sprite sprite = sm.get(e);

			AtlasRegion spriteRegion = regionsByEntity.get(e.getId());
			batch.setColor(sprite.r, sprite.g, sprite.b, sprite.a);

			float posX = position.x - (spriteRegion.getRegionWidth() / 2 * sprite.scaleX);
			float posY = position.y - (spriteRegion.getRegionHeight() / 2 * sprite.scaleX);
			batch.draw(spriteRegion, posX, posY, 0, 0, spriteRegion.getRegionWidth(), spriteRegion.getRegionHeight(), sprite.scaleX, sprite.scaleY, sprite.rotation);

		}
	}

	protected void end() {
		batch.end();
	}


	public void inserted(Entity e) {
		Sprite sprite = sm.get(e);
		regionsByEntity.set(e.getId(), regions.get(sprite.name));

		sortedEntities.add(e);

		Collections.sort(sortedEntities, new Comparator<Entity>() {
			@Override
			public int compare(Entity e1, Entity e2) {
				Sprite s1 = sm.get(e1);
				Sprite s2 = sm.get(e2);
				return s1.layer.compareTo(s2.layer);
			}
		});
	}


	public void removed(Entity e) {
		regionsByEntity.set(e.getId(), null);
		sortedEntities.remove(e);
	}

}
