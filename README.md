## Utilities to work with graphs in `Java`

Available shit:

---

- **`Vertex<T>`**: _graph mutable vertex_
  - `bool locked` GETTER, SETTER (`lock()`, `unlock()`)
  - `int x` GETTER, SETTER
  - `int y` GETTER, SETTER
  - `T value` GETTER, SETTER (generic)
  - `String tag` GETTER, SETTER

- **`AdjacencyUnweightedListVertex<T>` extends `Vertex`**: _vertex with a list of adjacent vertexes with unweighted edges_
  - _Work in progress..._
  
- **`AdjacencyWeightedListVertex<T, Y>` extends `Vertex`**: _vertex with a list of adjacent vertexes with weighted edges_
  - _Work in progress..._
  
---
 
- ~~**`Graph`**: _graph (container of vertexes)_~~
  - _Work in progress..._

- **`UnweightedGraph<T>` ~~extends `Graph`~~**: _unweighted graph (container of unweighted vertexes)_
  - _Work in progress..._

- **`WeightedGraph<T, Y>` ~~extends `Graph`~~**: _weighted graph (container of weighted vertexes)_
  - _Work in progress..._
