package Algorithms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import Structures.UnionFind;
import Structures.Graphs.Vertex;
import Structures.Graphs.WeightedEdge;
import Structures.Graphs.WeightedGraph;
import Structures.Graphs.Implementations.Weighted.IncidenceListGraph;

public class SpanningTree {

  // Algorithm based on implementaion by Keith Schwarz (htiek@cs.stanford.edu)
  // (http://keithschwarz.com/interesting)
  public static <TKey> WeightedGraph<TKey> kruskal(WeightedGraph<TKey> InputGraph) {
    /* Build up the graph that will hold the result. */
    IncidenceListGraph<TKey> result = new IncidenceListGraph<TKey>();

    /* Edge case - if the input graph has zero or one nodes, we're done. */
    int numOfEdges = 0;
    int graphSize;
    Set<Vertex<TKey>> vertices = new HashSet<>();
    var edgesIterator = InputGraph.getEdgesIterator();
    while (edgesIterator.hasNext()) {
      numOfEdges++;
      var edge = edgesIterator.next();
      vertices.add(edge.getVertexFrom());
      vertices.add(edge.getVertexTo());
    }
    graphSize = vertices.size();
    if (graphSize <= 1)
      return result;

    /*
     * Begin by building up a collection of all the edges of the graph.
     * Because we are given the edges via bidirectional adjacency lists,
     * we need to do some processing for this step.
     */
    List<WeightedEdge<TKey>> edges = new ArrayList<>(numOfEdges);
    var weightedEdgesIterator = InputGraph.getWeightedEdgesIterator();
    while (weightedEdgesIterator.hasNext()) {
      edges.add(weightedEdgesIterator.next());
    }

    /* Sort the edges in ascending order of size. */
    Collections.sort(edges);

    /* Set up the partition of nodes in a union-find structure. */
    UnionFind<Vertex<TKey>> unionFind = new UnionFind<>();
    var verticesIterator = InputGraph.getVertexesIterator();
    while (verticesIterator.hasNext()) {
      unionFind.add(verticesIterator.next());
    }

    /*
     * Count how many edges have been added; when this hits n - 1,
     * we're done.
     */
    int numEdges = 0;

    /*
     * Now, sweep over the edges, adding each edge if its endpoints aren't
     * in the same partition.
     */
    weightedEdgesIterator = InputGraph.getWeightedEdgesIterator();
    while (weightedEdgesIterator.hasNext()) {
      var edge = weightedEdgesIterator.next();
      /* If the endpoints are connected, skip this edge. */
      if (unionFind.find(edge.getVertexFrom()) == unionFind.find(edge.getVertexTo()))
        continue;

      /* Otherwise, add the edge. */
      result.addEdge(new WeightedEdge<>(edge.getVertexFrom(), edge.getVertexTo(), edge.getWeight()));
      result.addEdge(new WeightedEdge<>(edge.getVertexTo(), edge.getVertexFrom(), edge.getWeight()));

      /* Link the endpoints together. */
      unionFind.union(edge.getVertexFrom(), edge.getVertexTo());

      /* If we've added enough edges already, we can quit. */
      if (++numEdges == graphSize)
        break;
    }

    /* Hand back the generated graph. */
    return result;
  }

}
