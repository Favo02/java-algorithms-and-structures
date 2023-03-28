## Utilities to work with graphs in `Java`

Available shit:

- **`Vertex<TKey>`**: _vertex with generic key (unique identifier). Extend to add fields_
  - Fields:
    - `TKey key`
  - Methods:
    - `Vertex(TKey key)`
    - `getKey() --> TKey`
    - `hashCode() --> int`
    - `equals(Object obj) --> boolean`
    - `toString() --> String`

- **`Edge<TKey>`**: _unweighted edge_
  - Fields:
    - `Vertex<TKey> vertexFrom`
    - `Vertex<TKey> vertexTo`
  - Methods:
    - `Edge(Vertex<TKey> vertexFrom, Vertex<TKey> vertexTo)`
    - `getVertexFrom() --> Vertex<TKey>`
    - `getVertexTo() --> Vertex<TKey>`
    - `hashCode() --> int`
    - `equals(Object obj) --> boolean`
    - `toString() --> String`

- **`WeightedEdge<TKey> extends Edge<TKey>`**: _weighted edge_
  - Fields:
    - `long weight`
  - Methods:
    - `WeightedEdge(Vertex<TKey> vertexFrom, Vertex<TKey> vertexTo, long weight)`
    - `hashCode() --> int`
    - `equals(Object obj) --> boolean`
    - `toString() --> String`

- _INTERFACE_ **`Graph<TKey>`**: _unweighted graph_
  - Methods:
    - `getVertexesIterator() --> Iterator<Vertex<TKey>>`
    - `getEdgesIterator() --> Iterator<Edge<TKey>>`
    - `findVertex(TKey key) --> Vertex<TKey>`
    - `findEdge(TKey keyFrom, TKey keyTo) --> Edge<TKey>`

- _INTERFACE_ **`WeightedGraph<TKey> extends Graph<TKey>`**: _weighted graph_
  - Methods:
    - `getWeightedEdgesIterator() --> Iterator<WeightedEdge<TKey>>`

