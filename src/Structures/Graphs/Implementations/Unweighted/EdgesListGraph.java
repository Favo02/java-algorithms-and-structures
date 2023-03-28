package Structures.Graphs.Implementations.Unweighted;

import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import Structures.Graphs.Edge;
import Structures.Graphs.Graph;
import Structures.Graphs.Vertex;

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

  public Iterator<Edge<TKey>> getEdgesFromVertexIterator(Vertex<TKey> from) {

    Set<Edge<TKey>> filteredEdges = new HashSet<>();

    for (Edge<TKey> edge : edges) {
      if (edge.getVertexFrom().equals(from)) {
        filteredEdges.add(edge);
      }
    }

    return Collections.unmodifiableCollection(filteredEdges).iterator();
  }

  public Iterator<Edge<TKey>> getEdgesToVertexIterator(Vertex<TKey> to) {

    Set<Edge<TKey>> filteredEdges = new HashSet<>();

    for (Edge<TKey> edge : edges) {
      if (edge.getVertexTo().equals(to)) {
        filteredEdges.add(edge);
      }
    }

    return Collections.unmodifiableCollection(filteredEdges).iterator();
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
    return Collections.unmodifiableCollection(edges).iterator();
  }

  @Override
  public Vertex<TKey> findVertex(TKey key) {
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
  public Edge<TKey> findEdge(TKey keyFrom, TKey keyTo) {
    for (Edge<TKey> edge : edges) {
      if (edge.getVertexFrom().getKey().equals(keyFrom) && edge.getVertexTo().getKey().equals(keyTo)) {
        return edge;
      }
    }

    return null;
  }

}
