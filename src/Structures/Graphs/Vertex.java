package Structures.Graphs;

import java.util.Objects;

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

    /**
     * hashCode and equals based on:
     *   x
     *   y
     *   value
     *   tag  
     */

    @Override
    public int hashCode() {
        return Objects.hash(x, y, value, tag);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Vertex other = (Vertex) obj;
        if (x != other.x)
            return false;
        if (y != other.y)
            return false;
        if (value == null) {
            if (other.value != null)
                return false;
        } else if (!value.equals(other.value))
            return false;
        if (tag == null) {
            if (other.tag != null)
                return false;
        } else if (!tag.equals(other.tag))
            return false;
        return true;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Vertex [locked=");
        sb.append(locked);
        sb.append(", x=");
        sb.append(x);
        sb.append(", y=");
        sb.append(y);
        sb.append(", value=");
        sb.append(value);
        sb.append(", tag=");
        sb.append(tag);
        sb.append("]");
        return sb.toString();
    }

    public String toStringCoordinates() {
        StringBuilder sb = new StringBuilder();
        sb.append(x);
        sb.append(',');
        sb.append(y);
        return sb.toString();
    }

}
