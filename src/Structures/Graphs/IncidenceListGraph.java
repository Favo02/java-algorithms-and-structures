package Structures.Graphs;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class IncidenceListGraph<TKey> implements Graph<TKey> {

  private Map<Vertex<TKey>, Set<Edge<TKey>>> incidenceList;

  public IncidenceListGraph() {
    this.incidenceList = new HashMap<>();
  }

  public void addAdjacent(Vertex<TKey> from, Edge<TKey> edge) {

    if (!incidenceList.containsKey(from)) {
      incidenceList.put(from, new HashSet<>());
    }

    incidenceList.get(from).add(edge);
  }

  public void removeAdjacent(Vertex<TKey> from, Edge<TKey> edge) {
    // TODO: check if from exists (?)
    incidenceList.get(from).remove(edge);
  }

  @Override
  public Iterator<Vertex<TKey>> getVertexesIterator() {
    return incidenceList.keySet().iterator();
  }

  @Override
  public Iterator<Edge<TKey>> getEdgesIterator() {
    
    Set<Edge<TKey>> edges = new HashSet<>();

    for (Vertex<TKey> from : incidenceList.keySet()) {
      for (Edge<TKey> edge : incidenceList.get(from)) {
        edges.add(edge);
      }
    }

    return Collections.unmodifiableCollection(edges).iterator();
  }

  @Override
  public Vertex<TKey> findVertex(Object key) {

    for (Vertex<TKey> vertex : incidenceList.keySet()) {
      if (vertex.getKey().equals(key)) {
        return vertex;
      }
    }

    return null;
  }

  @Override
  public Edge<TKey> findEdge(Object keyFrom, Object keyTo) {

    for (Vertex<TKey> from : incidenceList.keySet()) {
      if (from.getKey().equals(keyFrom)) {
        for (Edge<TKey> edge : incidenceList.get(from)) {
          if (edge.getVertexTo().getKey().equals(keyTo)) {
            return edge;
          }
        }
      }
    }

    return null;
  }
  
}
