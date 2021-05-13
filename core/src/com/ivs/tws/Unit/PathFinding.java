package com.ivs.tws.Unit;

import com.badlogic.gdx.ai.msg.PriorityQueue;
import com.ivs.tws.Map.MapTools;
import com.ivs.tws.Map.Model.Map.MapPosition;
import com.ivs.tws.Map.Model.Map.Terrain;
import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;

import java.util.ArrayList;
import java.util.Collections;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

public class PathFinding {

    private static final Logger log = LoggerFactory.getLogger(PathFinding.class);

    private final com.ivs.tws.Map.Model.Map.Map map;

    public PathFinding(com.ivs.tws.Map.Model.Map.Map map) {
        this.map = map;
    }

    private static int heuristic(MapPosition a, MapPosition b) {
        return MapTools.distance(a, b) * Terrain.FOREST.moveCost();
    }

    private static final class Pos implements Comparable<Pos> {

        private final MapPosition p;

        private final int s;

        public Pos(MapPosition p, int s) {
            this.p = p;
            this.s = s;
        }

        @Override
        public int compareTo(Pos o) {
            return Integer.compare(s, o.s);
        }

        @Override
        public String toString() {
            return p.toString() + '=' + s;
        }
    }

    public List<MapPosition> aStarSearch(MapPosition start, MapPosition goal, Predicate<MapPosition> canMoveTo) {
        PriorityQueue<Pos> frontier = new PriorityQueue<Pos>();
        frontier.add(new Pos(start, 0));
        Map<MapPosition, MapPosition> cameFrom = new HashMap<>();
        Map<MapPosition, Integer> costSoFar = new HashMap<>();
        cameFrom.put(start, null);
        costSoFar.put(start, 0);

        return path(cameFrom, start, goal);
    }

    private int cost(MapPosition p, MapPosition next) {
        int cost = map.getTerrainAt(next).moveCost();
        if (map.getEntityAt(p) != null)
            // will block if other entity do not move
            return cost * 2;
        else
            return cost;
    }

    private Iterable<MapPosition> neighbors(MapPosition p, Predicate<MapPosition> canMoveTo) {
        List<MapPosition> list = new ArrayList<>();
        for (MapPosition n : map.getNeighbors(p))
            if (canMoveTo.test(n))
                list.add(n);
        return list;
    }

    private static List<MapPosition> path(Map<MapPosition, MapPosition> cameFrom, MapPosition start, MapPosition goal) {
        List<MapPosition> path = new ArrayList<>();
        MapPosition current = goal;
        while (!current.equals(start)) {
            path.add(current);
            current = cameFrom.get(current);
            if (current == null) {
                log.debug("Cannot compute path from {} to {}.", start, goal);
                return null;
            }
        }
        Collections.reverse(path);
        return path;
    }
}
