package ha.justin.ha03;

public class LinkedList {

    private IList list;
    private LinkedList nextLinked;

    public LinkedList(IList list)
    {
        this.list = list;
    }

    public boolean nextLinked(LinkedList linkedList)
    {
        if (this.nextLinked == null){
            this.nextLinked = linkedList;
            return false;
        }
        return false;
    }

    public LinkedList getLinked()
    {
        if (this.nextLinked != null){
            return this.nextLinked;
        }
        return null;
    }

    public IList getList()
    {
        if (this.list != null){
            return this.list;
        }
        return null;
    }
}
