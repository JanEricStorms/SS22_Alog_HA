package ha.svenja.ha03;

public interface IList {

    /**
     * Fuegt einen Integer-Wert in die einfach verkette Liste ein.
     *
     * @param index		Position, an die der Wert eingefuegt werden soll
     * @param value 	Wert, der eingefuegt werden soll
     */
    public void insertAt(int index, int value);

    /**
     * Methode zum Entfernen eines Elements.
     *
     * @param index
     */
    public void removeAt(int index);

    /**
     * Methode gibt den Wert des Elements an einer bestimmten Stelle zurueck.
     *
     * @param index
     * @return
     */
    public int getAt(int index);

    /**
     * Methode gibt den Index zurueck, an dem der Wert gefunden wurde.
     *
     * @param value	Wert, der gesucht wird
     * @return		Index, an dem der Wert gefunden wird
     */
    public int search(int value);

    /**
     * Methode loescht alle Elemente der Liste.
     */
    public void clear();

    /**
     * Methode gibt Anzahl der Elemente in der verketteten Liste zurueck
     * @return 	Anzahl der Elemente
     */
    public int getCount();

}


