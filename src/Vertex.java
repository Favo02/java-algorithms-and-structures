public class Vertex<T> {

    private boolean locked;
    private int x;
    private int y;
    private T value;
    private String tag;

    public Vertex(int x, int y, T valore, String tag) {
        locked = false;
        this.x = x;
        this.y = y;
        this.value = valore;
        this.tag = tag;
    }

    public boolean isLocked() {
        return locked;
    }

    public void lock() {
        locked = true;
    }

    public void unlock() {
        locked = false;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public String getTag() {
        return tag;
    }    

    public void setTag(String tag) {
        this.tag = tag;
    }

    // TODO: hashcode
    // TODO: equals

}
