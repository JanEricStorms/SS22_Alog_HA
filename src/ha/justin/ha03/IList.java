package ha.justin.ha03;

public interface IList {

    /**
     * inserts a given value at the given key
     */
    void insertAt(int key, int value);

    /**
     * removes a value at the given key
     */
    boolean removeAt(int key);

    /**
     * Returns the value of the given key
     */
    int getAt(int key);

    /**
     * Returns the key of the given value
     */
    Integer search(int value);

    /**
     * Clears all values
     */
    void clear();

    /**
     * Returns the amount of values
     */
    int getCount();
}