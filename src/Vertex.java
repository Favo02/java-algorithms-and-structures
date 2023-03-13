public class Vertex<T> {
    protected boolean locked;
    protected int x, y;
    protected T value;
    protected String tag;

    public Vertex(int x, int y, T valore, String etichetta) {
        locked = false;
        this.x = x;
        this.y = y;
        this.value = valore;
        this.tag = etichetta;
    }

    public void lock() {
        locked = true;
    }

    public boolean isLocked() {
        return locked;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public T getValue() {
        return value;
    }

    public String getTag() {
        return tag;
    }

    
}
