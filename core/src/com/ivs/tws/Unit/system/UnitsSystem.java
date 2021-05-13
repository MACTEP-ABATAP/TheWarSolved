package com.ivs.tws.Unit.system;

import com.artemis.Aspect;
import com.artemis.ComponentMapper;
import com.artemis.Entity;
import com.artemis.EntitySystem;
import com.artemis.utils.ImmutableBag;
import com.badlogic.gdx.scenes.scene2d.ui.List;
import com.ivs.tws.Map.Model.Map.Map;
import com.ivs.tws.Map.Model.Map.MapPosition;
import com.ivs.tws.Unit.component.Counter;
import com.ivs.tws.Unit.component.Name;
import com.ivs.tws.Unit.component.TextBox;
import com.ivs.tws.Unit.component.Unit;
import com.ivs.tws.Unit.component.UnitCommand;
import com.ivs.tws.screens.Screen;
import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;

import java.util.Iterator;

import javax.swing.Icon;

//public class UnitsSystem extends EntitySystem {
//
//
//    private static final Logger log = LoggerFactory.getLogger(UnitSystem.class);
//
//    private ComponentMapper<Counter> counters;
//
//
//    private ComponentMapper<UnitCommand> commands;
//
//    private ComponentMapper<Unit> unit;
//
//
//
//    private ComponentMapper<MapPosition> positions;
//
//    private ComponentMapper<Name> names;
//
//    private ComponentMapper<TextBox> boxes;
//
//    private DestinationSystem destinationSystem;
//
//
//
//    private final Map map;
//
//    private final Screen screen;
//
//    @SuppressWarnings("unchecked")
//    public UnitsSystem(Map map, Screen screen) {
//
//        this.map = map;
//        this.screen = screen;
//    }
//
//    @Override
//    protected void processEntities(ImmutableBag<Entity> entities) {
//        for (Entity city : entities) {
//            for (Iterator<Entity> it = .secondarySources.iterator(); it.hasNext();) {
//                Entity s = it.next();
//                Unit army = unit.get(s);
//                counters.get(s).value = army.currentHealthPoint;
//            }
//        }
//    }
//
//
//
//    public List<Entity> getArmies(Entity empire) {
//        return source.secondarySources;
//    }
//
//    public Entity createNewArmy(Entity empire, int power) {
//        MapPosition pos = emptyPositionNextTo(empire);
//        if (pos != null) {
//            power = getArmyPowerIncrease(empire, power);
//            UnitCommand command = commands.get(empire);
//            Entity army = EntityFactory.createArmy(world, pos, armyName(command, empire), empires.get(empire), empire, power);
//            sources.get(empire).secondarySources.add(army);
//            command.usedPower += power;
//
//            map.setEntity(army, pos);
//            return army;
//        } else {
//            log.warn("Cannot create an army near {}, no empty tile.", descriptions.get(empire));
//            return null;
//        }
//    }
//
//    private int getArmyPowerIncrease(Entity empire, int increase) {
//        InfluenceSource source = sources.get(empire);
//        increase = min(increase, source.power());
//        source.addToPower(-increase);
//
//        // update power displayed on screen
//        TextBox box = boxes.get(empire);
//        box.text = box.generator.get();
//
//        return increase;
//    }
//
//    private String armyName(ArmyCommand command, Entity empire) {
//        int nb = ++command.counter;
//        return "Army of " + names.get(empire).name + " " + RomanNumbers.toRoman(nb);
//    }
//
//    private MapPosition emptyPositionNextTo(Entity empire) {
//        MapPosition pos = positions.get(empire);
//        for (int dist = 1; dist < 4; dist++) {
//            for (MapPosition neighbor : map.getNeighbors(pos.x, pos.y, dist))
//                if (!map.hasEntity(neighbor) && map.getInfluenceAt(neighbor).isMainInfluencer(empire))
//                    return neighbor;
//        }
//        // should rarely happen
//        return null;
//    }
//}
