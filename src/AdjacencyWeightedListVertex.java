import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

// Vertex with list of adjacent vertexes in a weighted graph
public class AdjacencyWeightedListVertex<T, Y extends Number> extends Vertex<T> {

  private Map<Vertex<T>, Y> adjacentVertexes;

  public AdjacencyWeightedListVertex(int x, int y, T valore, String tag) {
    super(x, y, valore, tag);
    this.adjacentVertexes = new HashMap<>();
  }

  /**
   * Returns true if @param v is adjacent to this
   * @param v Vertex whose adjacence to this is to be tested
   * @return returns true if @param v is adjacent to this
   */
  public boolean isAdjacent(Vertex<T> v) {
    return adjacentVertexes.containsKey(v);
  }

  /**
   * Returns the weight of edge to @param v Vertex
   * @param v
   * @return the weight of edge to @param v Vertex
   * @throws IllegalArgumentException if @param v is not adjacent to this
   */
  public Y getWeight(Vertex<T> v) {
    if (adjacentVertexes.containsKey(v)) {
      throw new IllegalArgumentException("This vertex is not adjacent to v");
    }

    return adjacentVertexes.get(v);
  }

  /**
   * Adds @param v to adjacent vertexes of this
   * @param v Vertex to be added to adjacent
   * @param w weight of the edge
   * @throws IllegalArgumentException if @param v is equal to this
   */
  public void addAdjacent(Vertex<T> v, Y w) {
    if (this.equals(v)) {
      throw new IllegalArgumentException("This Vertex cannot be adjacent to self");
    }

    adjacentVertexes.put(v, w);
  }

  /**
   * Removes @param v from adjacent vertexes
   * @param v Vertex to be removed from adjacent
   */
  public void removeAdjacent(Vertex<T> v) {
    adjacentVertexes.remove(v);
  }

  /**
   * Returns the Set of adjacent Vertexes to this
   * @return the Set of adjacent Vertexes to this
   */
  public Set<Vertex<T>> getAdjacent() {
    return Collections.unmodifiableSet(adjacentVertexes.keySet());
  }

  // TODO: unmodifiableSet or modifiable? remove could be useful
  /**
   * Retuns an iterator over adjacent Vertexes to this
   * @return an iterator over adjacent Vertexes to this
   */
  public Iterator<Vertex<T>> getAdjacentIterator() {
    return Collections.unmodifiableSet(adjacentVertexes.keySet()).iterator();
  } 

  public String toStringAdjacent() {
    return adjacentVertexes.toString();
  }
  
}
