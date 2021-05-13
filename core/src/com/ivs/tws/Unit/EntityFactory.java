package com.ivs.tws.Unit;

import com.artemis.Entity;
import com.artemis.EntityEdit;
import com.artemis.World;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Colors;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.ivs.tws.Map.Model.Map.MapPosition;
import com.ivs.tws.Unit.component.ColorAnimation;
import com.ivs.tws.Unit.component.Counter;
import com.ivs.tws.Unit.component.Description;
import com.ivs.tws.Unit.component.Destination;
import com.ivs.tws.Unit.component.Empire;
import com.ivs.tws.Unit.component.Name;
import com.ivs.tws.Unit.component.ScaleAnimation;
import com.ivs.tws.Unit.component.Sprite;
import com.ivs.tws.Unit.component.TextBox;
import com.ivs.tws.Unit.component.Unit;
import com.ivs.tws.Unit.component.UnitCommand;
import com.ivs.tws.Unit.system.ExpiringSystem;

//public class EntityFactory {
//
//    public static Entity createClick(World world, int x, int y, float startScale, float speed) {
//        Entity e = world.createEntity();
//        EntityEdit edit = e.edit();
//
//        MutablePosition pos = edit.create(MutablePosition.class);
//        pos.x = x;
//        pos.y = y;
//
//        Sprite sprite = new Sprite();
//        sprite.name = "click";
//        sprite.color = new Color(1f, 1f, 1f, 0.5f);
//        sprite.rotation = 0f;
//        sprite.scaleX = startScale;
//        sprite.scaleY = startScale;
//        edit.add(sprite);
//
//        ExpiringSystem.Expires expires = edit.create(ExpiringSystem.Expires.class);
//        expires.delay = 1f;
//
//        ScaleAnimation scaleAnimation = edit.create(ScaleAnimation.class);
//        scaleAnimation.speed = speed;
//
//        ColorAnimation colorAnimation = edit.create(ColorAnimation.class);
//        colorAnimation.alphaAnimate = true;
//        colorAnimation.alphaSpeed = -1f;
//
//        return e;
//    }
//
//    public static Entity createEmpire(World world, int x, int y, String name, Empire empire) {
//        Entity e = world.createEntity();
//
//        EntityEdit edit = e.edit();
//
//        UnitCommand command = new UnitCommand();
//
//        Sprite sprite = new Sprite();
//        sprite.name = "camp";
//        sprite.rotation = 0f;
//        sprite.scaleX = 1f;
//        sprite.scaleY = 1f;
//        edit.add(sprite);
//
//        edit.add(new Name(name)).add(new Description("Tribe of " + name));
//
//
//
//
//        return e;
//    }
//
//    public static Entity createArmy(World world, MapPosition pos, String name, Empire empire, Entity source,
//                                    int militaryPower) {
//        Entity e = world.createEntity();
//        EntityEdit edit = e.edit();
//
//        edit.add(new Counter(Colors.contrast(empire.color), empire.color, militaryPower));
//
//        edit.add(pos).add(new Name(name)).add(new Description(name))
//                .add(new Destination(source.getComponent(ArmyCommand.class).forbiddenTiles, 1))
//                .add(new Unit(source, militaryPower)).add(empire);
//
//        if (empire.isComputerControlled())
//            edit.add(new AIControlled());
//
//        return e;
//    }
//
//    public static Entity createFadingTileLabel(World world, String label, Color color, float x, float y, float duration) {
//        Entity e = world.createEntity();
//        EntityEdit edit = e.edit();
//
//        MutableMapPosition position = edit.create(MutableMapPosition.class);
//        position.x = x;
//        position.y = y;
//
//        FadingMessage fading = edit.create(FadingMessage.class);
//        fading.label = label;
//        fading.color = color;
//        fading.duration = duration;
//        fading.vx = 0f;
//        fading.vy = 1.3f;
//
//        return e;
//    }
//
//    public static Entity createFadingTileIcon(World world, TextureRegion icon, Color color, float x, float y,
//                                              float duration) {
//        Entity e = world.createEntity();
//        EntityEdit edit = e.edit();
//
//        MutableMapPosition position = edit.create(MutableMapPosition.class);
//        position.x = x;
//        position.y = y;
//
//        FadingMessage fading = edit.create(FadingMessage.class);
//        fading.icon = icon;
//        fading.color = color;
//        fading.duration = duration;
//        fading.vx = 0f;
//        fading.vy = 1.3f;
//
//        return e;
//    }
//}
