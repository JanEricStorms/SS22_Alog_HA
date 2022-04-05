package ha.justin.ha03;

import java.util.Arrays;

public class SimpleList implements IList {

    private Integer[] array;
    private int defaultSize = 10;


    public SimpleList(){
        this.array = new Integer[this.defaultSize];
    }

    /**
     * inserts a given value at the given key
     *
     * @param key
     * @param value
     */
    @Override
    public void insertAt(int key, int value)
    {
        if (this.array.length < key){
            this.increaseSize(key);
        }
        this.array[key] = value;
    }

    /**
     * removes a value at the given key
     *
     * @param key
     */
    @Override
    public boolean removeAt(int key)
    {
        this.ExistOrThrowKey(key);
        this.array[key] = null;

        return true;
    }

    /**
     * Returns the value of the given key
     *
     * @param key
     */
    @Override
    public int getAt(int key)
    {
        this.ExistOrThrowKey(key);

        return this.array[key];
    }

    /**
     * Returns the key of the given value
     *
     * @param value
     */
    @Override
    public Integer search(int value)
    {
        for (int i = 0; i < this.array.length; i++) {
            if (this.array[i] != null && this.array[i] == value) {
                return i;
            }
        }
        return null;
    }

    /**
     * Clears all values
     */
    @Override
    public void clear()
    {
        Arrays.fill(this.array, null);
    }

    /**
     * Returns the amount of values
     */
    @Override
    public int getCount()
    {
        int count = 0;
        for (Integer value : array){
            if (value != null){
                count++;
            }
        }

        return count;
    }

    /**
     * increases the size of the array by given key
     */
    private void increaseSize(int key)
    {
        Integer[] array = new Integer[key+1];

        for(int i = 0; i < this.array.length; i++){
            array[i] = this.array[i];
        }
        this.array = array;
    }

    /**
     * Checks if given key is inside arrays boundaries
     * @throws ArrayIndexOutOfBoundsException = key outside boundaries
     */
    private void ExistOrThrowKey(int key)
    {
        if (this.array.length < key) {
            throw new ArrayIndexOutOfBoundsException(String.format("The index %d is out of boundary.", key));
        }
    }

    @Override
    public String toString()
    {
        return Arrays.toString(this.array);
    }
}
