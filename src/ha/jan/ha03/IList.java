package ha03;

public interface IList<T> {

    /**
     * Methode ist fuer das Einfuegen eines Elementes zustaenig. </br>
     * @param x > Value das eingefuegt werden soll </br>
     * @param p > Position an der das Value eingefuegt werden soll </br>
     * @return boolean > "true", wenn das Element erfolgreich eingefuegt wurde, anstonsten "false" </br>
     */
    public boolean insertAt(T x,int p);

    /**
     * Methode ist fuer das Entfernen eines Elementes zustaendig. </br>
     * @param p > position an der das Element entfernt werden soll. </br>
     * @return boolean > "true", wenn das Element erfolgreich entfertnt wurde, anstonsten "false" </br>
     */
    public boolean removeAt(int p);

    /**
     * Methode gibt der Wert aus. </br>
     * @param p > Position an der das Element ausgegeben werden soll. </br>
     * @return T > returns the element for given Position </br>
     */
    public T getAt(int p);

    /**
     * Methode ist fuer die Suche nach einem Element zustaendig
     * @param x > Das Element das gesucht wird
     * @return int > Die Position an der das Element steht. </br>
     * -1 fuer den Fall, dass das Element nicht existiert. </br>
     */
    public int search(T x);

    /**
     * Methode cleart die Liste. </br>
     * @return boolean > Gibt true zurueck wenn die Liste geleert worden ist. </br>
     */
    public boolean clear();

    /**
     * Methode gibt die Anzahl der Elemente der Liste zurueck. </br>
     * @return int > Anzahl der Elemente </br>
     */
    public int getCount();
}
