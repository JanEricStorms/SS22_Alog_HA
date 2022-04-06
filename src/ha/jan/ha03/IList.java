import java.util.ArrayList;

public interface IList<T> {

    public boolean insertAt(T x,int p);

    public boolean removeAt(int p);

    public T getAt(int p);

    public int search(T x);

    public boolean clear();

    public int getCount();
}
