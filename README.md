## Utilities to work with graphs in `Java`

Available shit:

- **`Vertex<T>`**: _graph mutable vertex (can only be locked)_
  - `bool locked` GETTER, SETTER (`lock()`, `unlock()`)
  - `int x` GETTER, SETTER
  - `int y` GETTER, SETTER
  - `T value` GETTER, SETTER (generic)
  - `String tag` GETTER, SETTER

- **`VertexBuilder<T>`**: _builder to create a `Vertex`_

