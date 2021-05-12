package com.ivs.tws.Model.Map.Iso;


import com.badlogic.gdx.ai.msg.PriorityQueue;
import com.ivs.tws.Model.Map.GridPosition;
import com.ivs.tws.Model.components.MapComponent;

import java.util.AbstractMap;
import java.util.ArrayList;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

public class Pathfinder {
//    public static List<GridPosition> getPath(MapComponent map, GridPosition from, GridPosition to) {
//        List<GridPosition> path = new ArrayList<GridPosition>();
//
//
//        PriorityQueue<AbstractMap.SimpleEntry<GridPosition,Integer>> frontier = new PriorityQueue<AbstractMap.SimpleEntry<GridPosition,Integer>>(
//                1, new Comparator<AbstractMap.SimpleEntry<GridPosition, Integer>>() {
//            @Override
//            public int compare(AbstractMap.SimpleEntry<GridPosition, Integer> o1, AbstractMap.SimpleEntry<GridPosition, Integer> o2) {
//                return o1.getValue() - o2.getValue();
//            }
//        }
//        );
//        frontier.add(new AbstractMap.SimpleEntry<GridPosition, Integer>(from, 0));
//
//        HashMap<GridPosition, GridPosition> cameFrom = new HashMap<GridPosition, GridPosition>();
//        HashMap<GridPosition, Integer> costSoFar = new HashMap<GridPosition, Integer>();
//
//        cameFrom.put(from, null);
//        costSoFar.put(from, 0);
//
//        while (!frontier.) {
//            GridPosition current = frontier.poll().getKey();
//
//            if (current.equals(to)) {
//                break;
//            }
//
//            for (GridPosition neighbor : IsoHelper.getNeighbors(current)) {
//                int newCost = costSoFar.get(current) + map.getCost(current, neighbor);
//                if (!costSoFar.containsKey(neighbor) || newCost < costSoFar.get(neighbor)) {
//                    costSoFar.put(neighbor, newCost);
//                    int priority = newCost + getDistance(neighbor, to);
//                    frontier.add(new AbstractMap.SimpleEntry<GridPosition, Integer>(neighbor, priority));
//                    cameFrom.put(neighbor, current);
//                }
//            }
//        }
//
//        GridPosition current = to;
//        while(current != null){
//            path.add(0,current);
//            current = cameFrom.get(current);
//        }
//
//        return path;
//    }

    public static int getDistance(GridPosition from, GridPosition to) {
        return (Math.abs(from.xGrid - to.xGrid)
                + Math.abs(from.yGrid + from.xGrid - to.yGrid - to.xGrid)
                + Math.abs(from.yGrid - to.yGrid)) / 2;
    }
}
