package Structures.Graphs;

import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class EdgesListGraph<TKey> implements Graph<TKey> {

  private Set<Edge<TKey>> edges;

  public EdgesListGraph() {
    this.edges = new HashSet<>();
  }

  public void addEdge(Edge<TKey> edge) {
    this.edges.add(edge);
  }

  public void removeEdge(Edge<TKey> edge) {
    this.edges.remove(edge);
  }

  @Override
  public Iterator<Vertex<TKey>> getVertexesIterator() {

    Set<Vertex<TKey>> vertexes = new HashSet<>();

    for (Edge<TKey> edge : edges) {
      vertexes.add(edge.getVertexFrom());
      vertexes.add(edge.getVertexTo());
    }

    return Collections.unmodifiableCollection(vertexes).iterator();
  }

  @Override
  public Iterator<Edge<TKey>> getEdgesIterator() {
    return edges.iterator();
  }

  @Override
  public Vertex<TKey> findVertex(Object key) {
    for (Edge<TKey> edge : edges) {
      if (edge.getVertexFrom().getKey().equals(key)) {
        return edge.getVertexFrom();
      }
      if (edge.getVertexTo().getKey().equals(key)) {
        return edge.getVertexTo();
      }
    }

    return null;
  }

  @Override
  public Edge<TKey> findEdge(Object keyFrom, Object keyTo) {
    for (Edge<TKey> edge : edges) {
      if (edge.getVertexFrom().getKey().equals(keyFrom) && edge.getVertexTo().getKey().equals(keyTo)) {
        return edge;
      }
    }

    return null;
  }

}
