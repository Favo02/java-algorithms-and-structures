public class MutableVertex<T> extends Vertex<T> {

    public MutableVertex(int x, int y, T valore, String etichetta) {
        super(x, y, valore, etichetta);
    }

    public void setLocked(boolean locked) {
        this.locked = locked;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

}
