import java.util.Objects;

public class VertexBuilder<T> {

    private int x, y;
    private T value;
    private String tag;

    public void flush() {
        x = 0;
        y = 0;
        value = null;
        tag = null;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setValue(T value) {
        Objects.requireNonNull(value);
        this.value = value;
    }

    public void setTag(String tag) {
        Objects.requireNonNull(value);
        this.tag = tag;
    }

    public Vertex<T> build() {
        var outVert = new Vertex<T>(x, y, value, tag);
        flush();
        return outVert;
    }
}
