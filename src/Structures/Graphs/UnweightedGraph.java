package Structures.Graphs;

import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

// TODO: UnweightedGraph and WeightedGraph can implement an interface or an abstract class Graph

public class UnweightedGraph<T> {
  
  // TODO: Set or Map?
  //    Set: can be really expensive to retreive a Vertex in a Set
  //    Map: more space needed and each vertex needs a unique identifier
  private Set<AdjacencyUnweightedListVertex<T>> vertexes;

  public UnweightedGraph() {
    this.vertexes = new HashSet<>();
  }

  public Set<AdjacencyUnweightedListVertex<T>> getVertexes() {
    return Collections.unmodifiableSet(vertexes);
  }

  // TODO: unmodifiableSet or modifiable? remove could be useful
  public Iterator<AdjacencyUnweightedListVertex<T>> getVertexesIterator() {
    return Collections.unmodifiableSet(vertexes).iterator();
  }

  public void addVertex(AdjacencyUnweightedListVertex<T> v) {
    this.vertexes.add(v);
  }

  public void removeVertex(AdjacencyUnweightedListVertex<T> v) {
    this.vertexes.remove(v);
  }

}
