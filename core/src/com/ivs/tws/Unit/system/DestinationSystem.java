package com.ivs.tws.Unit.system;

import com.artemis.Aspect;
import com.artemis.ComponentMapper;
import com.artemis.Entity;
import com.artemis.EntitySystem;
import com.artemis.utils.ImmutableBag;
import com.ivs.tws.Map.Model.Map.MapPosition;
import com.ivs.tws.Map.Model.Map.Terrain;
import com.ivs.tws.Unit.PathFinding;
import com.ivs.tws.Unit.component.Destination;
import com.ivs.tws.Unit.component.Name;
import com.ivs.tws.Unit.component.Unit;
import com.ivs.tws.screens.Screen;
import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.swing.Icon;

//public final class DestinationSystem extends EntitySystem {

//    private static final Logger log = LoggerFactory.getLogger(DestinationSystem.class);
//
//    private ComponentMapper<Destination> destinations;
//
//    private ComponentMapper<MapPosition> positions;
//
//
//
//
//    private ComponentMapper<Unit> unit;
//
//    private ComponentMapper<Name> names;
//
//
//    private final com.ivs.tws.Map.Model.Map.Map map;
//
//    private final PathFinding astar;
//
//    private final Screen screen;
//
//    @SuppressWarnings("unchecked")
//    public DestinationSystem(com.ivs.tws.Map.Model.Map.Map map, Screen screen) {
//        super(Aspect.all(Destination.class, MapPosition.class));
//        this.map =  map;
//        this.screen = screen;
//        this.astar = new PathFinding(map);
//    }
//
//    @Override
//    public void inserted(Entity e) {
//        super.inserted(e);
//    }
//
//    private boolean needDestination(Entity e) {
//        Destination d = destinations.get(e);
//        if (d == null)
//            return false;
//        else
//            return d.target == null || d.path == null || d.path.isEmpty();
//    }
//
//    @Override
//    protected void processEntities(ImmutableBag<Entity> entities) {
//        for (Entity e : entities) {
//            Destination destination = destinations.get(e);
//            // Destination component might have been removed during this turn
//            if (destination != null && destination.path != null && !destination.path.isEmpty())
//                moveToNext(e, destination);
//            // else no current destination
//        }
//    }
//
//    private void moveToNext(Entity e, Destination dest) {
//        MapPosition current = positions.get(e);
//        MapPosition next = dest.path.get(0);
//        if (canMoveTo(e, dest, next)) {
//            if (++dest.progress >= dest.turnsToMove) {
//                dest.progress = 0;
//                dest.path.remove(0);
//                e.edit().remove(current).add(next);
//                map.moveEntity(e, current, next);
//                if (dest.path.isEmpty()) {
//                    dest.target = null;
//                    dest.path = null;
//
//                    log.debug("Moved {} to {}", names.get(e), next);
//                }
//            }
//        }
//    }
//
//    public void moveTo(Entity e, MapPosition target) {
//        MapPosition current = positions.get(e);
//        e.edit().remove(current).add(target);
//        map.moveEntity(e, current, target);
//        if (destinations.has(e)) {
//            Destination dest = destinations.get(e);
//            dest.path = null;
//            dest.target = null;
//            dest.progress = 0;
//        }
//    }
//
//    private boolean canMoveTo(Entity e, Destination dest, MapPosition next) {
//        Terrain terrain = map.getTerrainAt(next);
//        if (terrain.moveBlock() || dest.forbiddenTiles.contains(terrain) || map.hasEntity(next))
//            return false;
//
//        if (unit.has(e))
//            return map.getTerrainAt(next).canStart();
//        else
//            return map.getTerrainAt(next).canStart();
//    }
//
//    public Collection<MapPosition> getTargetTiles(Entity e) {
//        Destination dest = destinations.get(e);
//        Entity empire = unit.has(e) ? unit.get(e).source : e;
//        Set<MapPosition> set = new HashSet<>();
//
//        return set;
//    }
//
//    @Override
//    protected void processSystem() {
//
//    }
//

//    public List<MapPosition> computePath(Entity e, MapPosition target) {
//        final Destination dest = destinations.get(e);
//        MapPosition start = positions.get(e);
//        List<MapPosition> path = astar.aStarSearch(start, target, !dest.forbiddenTiles.contains(canMoveTo(e, dest, map.getPositionAt(dest))));
//        if (path == null)
//           return null;
//
//        dest.target = target;
//        dest.path = path;
//        dest.progress = 0;
//        return path;
//    }

//}
