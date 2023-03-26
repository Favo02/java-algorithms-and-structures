package Structures.Graphs;

import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

// TODO: UnweightedGraph and WeightedGraph can implement an interface or an abstract class Graph

public class WeightedGraph<T, Y extends Number> {

  // TODO: Set or Map?
  //    Set: can be really expensive to retreive a Vertex in a Set
  //    Map: more space needed and each vertex needs a unique identifier
  private Set<AdjacencyWeightedListVertex<T, Y>> vertexes;

  public WeightedGraph() {
    this.vertexes = new HashSet<>();
  }

  public Set<AdjacencyWeightedListVertex<T, Y>> getVertexes() {
    return Collections.unmodifiableSet(vertexes);
  }

  // TODO: unmodifiableSet or modifiable? remove could be useful
  public Iterator<AdjacencyWeightedListVertex<T, Y>> getVertexesIterator() {
    return Collections.unmodifiableSet(vertexes).iterator();
  }

  public void addVertex(AdjacencyWeightedListVertex<T, Y> v) {
    this.vertexes.add(v);
  }

  public void removeVertex(AdjacencyWeightedListVertex<T, Y> v) {
    this.vertexes.remove(v);
  }
  
}
