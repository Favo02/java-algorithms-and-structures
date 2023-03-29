package Algorithms;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import Structures.FibonacciHeap;
import Structures.Graphs.Vertex;
import Structures.Graphs.WeightedEdge;
import Structures.Graphs.Implementations.Weighted.IncidenceListGraph;

public class ShortestPaths {
  
  public static <TKey> Map<Vertex<TKey>, Long> dijkstra(IncidenceListGraph<TKey> graph, Vertex<TKey> start) {
    
    Map<Vertex<TKey>, Long> distances = new HashMap<>();

    FibonacciHeap<Vertex<TKey>> queueHeap = new FibonacciHeap<>();

    Iterator<Vertex<TKey>> vertexesIterator = graph.getVertexesIterator();
    while (vertexesIterator.hasNext()) {
      queueHeap.enqueue(vertexesIterator.next(), Long.MAX_VALUE);
    }

    distances.put(start, Long.valueOf(0));

    while (queueHeap.size() != 0) {

      FibonacciHeap.Entry<Vertex<TKey>> entry = queueHeap.dequeueMin();
      Vertex<TKey> closest = entry.getValue();
      long closestDistance = entry.getPriority();

      Iterator<WeightedEdge<TKey>> incidentIterator = graph.getAdjacentByVertexIterator(closest);
      while (incidentIterator.hasNext()) {
        WeightedEdge<TKey> incident = incidentIterator.next();

        long oldDistance = distances.get(incident.getVertexTo());
        long newDistance = closestDistance + incident.getWeight();
        
        if (newDistance < oldDistance) {
          distances.put(incident.getVertexTo(), newDistance);
        }
      }
    }

    return distances;
  }

}
