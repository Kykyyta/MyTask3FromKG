package math.model.interfaces;

public interface Point<T extends Point<T>> {
    T add(T other);
    T subtract(T other);
    float distance(T other);

    boolean equals(Object obj);
    int hashCode();
    String toString();
}
