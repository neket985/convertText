/**
 * Created by nikitos on 13.10.16.
 */
public class orderElement {
    private char a;
    private int count;
    public orderElement next;
    public orderElement prev;

    public orderElement(char c) {
        this.a = c;
        count = 1;
    }

    public char getVal() {
        return a;
    }

    public int getCount() {
        return count;
    }

    public void setVal(char c) {
        this.a = c;
    }

    public void countIncr() {
        ++count;
    }


}
