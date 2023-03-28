package Structures.Graphs.Implementations.Weighted;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import Structures.Graphs.WeightedEdge;
import Structures.Graphs.Edge;
import Structures.Graphs.Vertex;
import Structures.Graphs.WeightedGraph;

public class IncidenceListGraph<TKey> implements WeightedGraph<TKey> {

  private Map<Vertex<TKey>, Set<WeightedEdge<TKey>>> incidenceList;

  public IncidenceListGraph() {
    this.incidenceList = new HashMap<>();
  }

  public void addAdjacent(Vertex<TKey> from, WeightedEdge<TKey> edge) {

    if (!incidenceList.containsKey(from)) {
      incidenceList.put(from, new HashSet<>());
    }

    incidenceList.get(from).add(edge);
  }

  public void removeAdjacent(Vertex<TKey> from, WeightedEdge<TKey> edge) {
    var fromSet = incidenceList.get(from);
    if (fromSet == null) {
      throw new NullPointerException("from does not exist in the graph");
    }
    fromSet.remove(edge);
  }

  public Iterator<WeightedEdge<TKey>> getAdjacentByVertexIterator(Vertex<TKey> from) {
    return Collections.unmodifiableCollection(incidenceList.get(from)).iterator();
  }

  @Override
  public Iterator<Vertex<TKey>> getVertexesIterator() {
    return Collections.unmodifiableCollection(incidenceList.keySet()).iterator();
  }

  @Override
  public Iterator<Edge<TKey>> getEdgesIterator() {

    Set<WeightedEdge<TKey>> edges = new HashSet<>();

    for (Vertex<TKey> from : incidenceList.keySet()) {
      for (WeightedEdge<TKey> edge : incidenceList.get(from)) {
        edges.add(edge);
      }
    }

    Collection<Edge<TKey>> internalCollection = Collections.unmodifiableCollection(edges);
    return internalCollection.iterator();
  }

  @Override
  public Vertex<TKey> findVertex(TKey key) {

    for (Vertex<TKey> vertex : incidenceList.keySet()) {
      if (vertex.getKey().equals(key)) {
        return vertex;
      }
    }

    return null;
  }

  @Override
  public WeightedEdge<TKey> findEdge(TKey keyFrom, TKey keyTo) {

    for (Vertex<TKey> from : incidenceList.keySet()) {
      if (from.getKey().equals(keyFrom)) {
        for (WeightedEdge<TKey> edge : incidenceList.get(from)) {
          if (edge.getVertexTo().getKey().equals(keyTo)) {
            return edge;
          }
        }
      }
    }

    return null;
  }

  @Override
  public Iterator<WeightedEdge<TKey>> getWeightedEdgesIterator() {
    Set<WeightedEdge<TKey>> edges = new HashSet<>();

    for (Vertex<TKey> from : incidenceList.keySet()) {
      for (WeightedEdge<TKey> edge : incidenceList.get(from)) {
        edges.add(edge);
      }
    }

    return Collections.unmodifiableCollection(edges).iterator();
  }

}
