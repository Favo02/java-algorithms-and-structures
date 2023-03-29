package Algorithms;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import Structures.Graphs.Vertex;
import Structures.Graphs.WeightedEdge;
import Structures.Graphs.Implementations.Weighted.IncidenceListGraph;

public class ShortestPaths {
  
  public static <TKey> Map<Vertex<TKey>, Long> dijkstra(IncidenceListGraph<TKey> graph, Vertex<TKey> start) {
    
    Map<Vertex<TKey>, Long> distances = new HashMap<>();

    Set<Vertex<TKey>> unvisited = new HashSet<>(); // TODO use minheap

    Iterator<Vertex<TKey>> vertexesIterator = graph.getVertexesIterator();
    while (vertexesIterator.hasNext()) {
      unvisited.add(vertexesIterator.next());
    }

    distances.put(start, Long.valueOf(0));

    while (unvisited.size() != 0) {

      // TODO poll from minheap
      Vertex<TKey> closest = null;
      for (Vertex<TKey> vertex : unvisited) {
        if (closest == null || distances.get(vertex) < distances.get(closest)) {
          closest = vertex;
        }
      }

      unvisited.remove(closest);

      Iterator<WeightedEdge<TKey>> incidentIterator = graph.getAdjacentByVertexIterator(closest);
      while (incidentIterator.hasNext()) {
        WeightedEdge<TKey> incident = incidentIterator.next();

        long oldDistance = distances.get(incident.getVertexTo());
        long newDistance = distances.get(closest) + incident.getWeight();
        
        if (newDistance < oldDistance) {
          distances.put(incident.getVertexTo(), newDistance);
        }
      }
    }

    return distances;
  }

}
