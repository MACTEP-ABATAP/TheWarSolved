package com.ivs.tws.systems;

import com.artemis.systems.EntityProcessingSystem;



import com.artemis.Aspect;
import com.artemis.ComponentMapper;
import com.artemis.Entity;
import com.artemis.annotations.Wire;
import com.artemis.systems.EntityProcessingSystem;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.MathUtils;
import com.ivs.tws.components.Health;
import com.ivs.tws.components.Position;

@Wire
public class HealthRenderSystem extends EntityProcessingSystem {
    private ComponentMapper<Position> positionMapper;
    private ComponentMapper<Health> healthMapper;

    private SpriteBatch batch;
    private OrthographicCamera camera;
    private BitmapFont font;

    @SuppressWarnings("unchecked")
    public HealthRenderSystem(OrthographicCamera camera) {
        super(Aspect.all(Position.class, Health.class));
        this.camera = camera;
    }

    @Override
    protected void initialize() {
        batch = new SpriteBatch();

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
    protected void process(Entity e) {
        Position position = positionMapper.get(e);
        Health health = healthMapper.get(e);

        int percentage = MathUtils.round(health.health/health.maximumHealth*100f);

        font.draw(batch, percentage+"%", position.x, position.y);
    }

    @Override
    protected void end() {
        batch.end();
    }
}
