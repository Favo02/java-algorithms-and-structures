package Algorithms;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import Structures.FibonacciHeap;
import Structures.Graphs.Vertex;
import Structures.Graphs.WeightedEdge;
import Structures.Graphs.Implementations.Weighted.IncidenceListGraph;

public class ShortestPaths {

  // Algorithm based on implementaion by Keith Schwarz (htiek@cs.stanford.edu) (http://keithschwarz.com/interesting)
  public static <TKey> Map<Vertex<TKey>, Long> dijkstra(IncidenceListGraph<TKey> graph, Vertex<TKey> start) {

    FibonacciHeap<Vertex<TKey>> priorityQueue = new FibonacciHeap<>();
    Map<Vertex<TKey>, FibonacciHeap.Entry<Vertex<TKey>>> priorityQueueEntries = new HashMap<>();
    Map<Vertex<TKey>, Long> distances = new HashMap<>();

    Iterator<Vertex<TKey>> vertexesIterator = graph.getVertexesIterator();
    while (vertexesIterator.hasNext()) {
      var vertex = vertexesIterator.next();
      priorityQueueEntries.put(vertex, priorityQueue.enqueue(vertex, Long.MAX_VALUE));
    }

    priorityQueue.decreaseKey(priorityQueueEntries.get(start), 0);

    while (!priorityQueue.isEmpty()) {
      FibonacciHeap.Entry<Vertex<TKey>> curr = priorityQueue.dequeueMin();

      distances.put(curr.getValue(), curr.getPriority());

      Iterator<WeightedEdge<TKey>> incidentIterator = graph.getAdjacentByVertexIterator(curr.getValue());
      while (incidentIterator.hasNext()) {

        WeightedEdge<TKey> edge = incidentIterator.next();

        if (distances.containsKey(edge.getVertexTo())) {
          continue;
        }

        long newDist = curr.getPriority() + edge.getWeight();

        FibonacciHeap.Entry<Vertex<TKey>> dest = priorityQueueEntries.get(edge.getVertexTo());
        if (newDist < dest.getPriority()) {
          priorityQueue.decreaseKey(dest, newDist);
        }
      }
    }

    return distances;
  }

}
