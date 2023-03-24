import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

// Vertex with list of adjacent vertexes in an unweighted graph
public class AdjacencyUnweightedListVertex<T> extends Vertex<T> {

  private Set<Vertex<T>> adjacentVertexes;

  public AdjacencyUnweightedListVertex(int x, int y, T valore, String tag) {
    super(x, y, valore, tag);
    this.adjacentVertexes = new HashSet<>();
  }

  /**
   * Returns true if @param v is adjacent to this
   * @param v Vertex whose adjacence to this is to be tested
   * @return returns true if @param v is adjacent to this
   */
  public boolean isAdjacent(Vertex<T> v) {
    return adjacentVertexes.contains(v);
  }

  /**
   * Adds @param v to adjacent vertexes of this
   * @param v Vertex to be added to adjacent
   * @throws IllegalArgumentException if @param v is equal to this
   */
  public void addAdjacent(Vertex<T> v) {
    if (this.equals(v)) {
      throw new IllegalArgumentException("This Vertex cannot be adjacent to self");
    }

    adjacentVertexes.add(v);
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
    return Collections.unmodifiableSet(adjacentVertexes);
  }

  // TODO: unmodifiableSet or modifiable? remove could be useful
  /**
   * Retuns an iterator over adjacent Vertexes to this
   * @return an iterator over adjacent Vertexes to this
   */
  public Iterator<Vertex<T>> getAdjacentIterator() {
    return Collections.unmodifiableSet(adjacentVertexes).iterator();
  } 

  public String toStringAdjacent() {
    return adjacentVertexes.toString();
  }
  
}
