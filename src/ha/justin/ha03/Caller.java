package ha.justin.ha03;

public class Caller {

    public static void main(String[] args) {

        SimpleList simpleList = new SimpleList();
        simpleList.insertAt(0, 3);
        simpleList.insertAt(13, 465);
        simpleList.insertAt(3, 5);
        SimpleList simpleList2 = new SimpleList();
        simpleList2.insertAt(3, 6);

        LinkedList linkedList = new LinkedList(simpleList);
        LinkedList linkedList2 = new LinkedList(simpleList2);
        linkedList.nextLinked(linkedList2);

        System.out.println(linkedList.getLinked().getList());
    }
}
