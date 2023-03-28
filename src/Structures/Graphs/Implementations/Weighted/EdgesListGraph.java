package Structures.Graphs.Implementations.Weighted;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import Structures.Graphs.WeightedEdge;
import Structures.Graphs.Edge;
import Structures.Graphs.Vertex;
import Structures.Graphs.WeightedGraph;

public class EdgesListGraph<TKey> implements WeightedGraph<TKey> {

  private Set<WeightedEdge<TKey>> edges;

  public EdgesListGraph() {
    this.edges = new HashSet<>();
  }

  public void addEdge(WeightedEdge<TKey> edge) {
    this.edges.add(edge);
  }

  public void removeEdge(WeightedEdge<TKey> edge) {
    this.edges.remove(edge);
  }

  public Iterator<WeightedEdge<TKey>> getEdgesFromVertexIterator(Vertex<TKey> from) {

    Set<WeightedEdge<TKey>> filteredEdges = new HashSet<>();

    for (WeightedEdge<TKey> edge : edges) {
      if (edge.getVertexFrom().equals(from)) {
        filteredEdges.add(edge);
      }
    }

    return Collections.unmodifiableCollection(filteredEdges).iterator();
  }

  public Iterator<WeightedEdge<TKey>> getEdgesToVertexIterator(Vertex<TKey> to) {

    Set<WeightedEdge<TKey>> filteredEdges = new HashSet<>();

    for (WeightedEdge<TKey> edge : edges) {
      if (edge.getVertexTo().equals(to)) {
        filteredEdges.add(edge);
      }
    }

    return Collections.unmodifiableCollection(filteredEdges).iterator();
  }

  @Override
  public Iterator<Vertex<TKey>> getVertexesIterator() {

    Set<Vertex<TKey>> vertexes = new HashSet<>();

    for (WeightedEdge<TKey> edge : edges) {
      vertexes.add(edge.getVertexFrom());
      vertexes.add(edge.getVertexTo());
    }

    return Collections.unmodifiableCollection(vertexes).iterator();
  }

  @Override
  public Iterator<Edge<TKey>> getEdgesIterator() {
    Collection<Edge<TKey>> internalCollection = Collections.unmodifiableCollection(edges);
    return internalCollection.iterator();
  }

  @Override
  public Vertex<TKey> findVertex(TKey key) {
    for (WeightedEdge<TKey> edge : edges) {
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
  public WeightedEdge<TKey> findEdge(TKey keyFrom, TKey keyTo) {
    for (WeightedEdge<TKey> edge : edges) {
      if (edge.getVertexFrom().getKey().equals(keyFrom) && edge.getVertexTo().getKey().equals(keyTo)) {
        return edge;
      }
    }

    return null;
  }

  @Override
  public Iterator<WeightedEdge<TKey>> getWeightedEdgesIterator() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'getWeightedEdgesIterator'");
  }

}
