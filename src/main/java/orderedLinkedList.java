/**
 * Created by nikitos on 13.10.16.
 */
public class orderedLinkedList {
    private orderElement first;
    private orderElement last;

    public orderedLinkedList() {
        first = null;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public void add(char c) {
        orderElement oe;
        if (isEmpty()) {
            oe = new orderElement(c);
            first = oe;
            last = oe;
        } else {
            if ((oe = found(c)) != null) {
                oe.countIncr();
                while (setPos(oe)){}
            } else {
                oe = new orderElement(c);
                last.next = oe;
                oe.prev = last;
                last = oe;
            }
        }
    }

    public boolean setPos(orderElement el1) {//true если произвёл рокеровку
        if (el1.prev != null) {//для ласт
            if (el1.getCount() > el1.prev.getCount()) { //рокеровка el1 и el1.prev
                orderElement oe = el1.prev;
                if (el1.prev.prev != null) {
                    el1.prev.prev.next = el1;
                }
                if (el1.next != null) {
                    el1.next.prev = el1.prev;
                } else {
                    last = oe;
                }
                el1.prev.next = el1.next;
                if (el1.prev.prev != null) {
                    el1.prev = el1.prev.prev;
                } else {
                    el1.prev = null;
                    first = el1;
                }
                el1.next = oe;
                oe.prev = el1;

                return true;
            }
        }
        return false;
    }

    public orderElement found(char c) {
        orderElement oe = first;
        while (oe != null) {
            if (oe.getVal() == c) {
                return oe;
            }
            oe = oe.next;
        }
        return null;
    }

    public void showList() {
        orderElement oe = first;
        char r;
        for (int i = 1; oe != null; ++i) {
            if(oe.getVal()=='\n') {
                System.out.println(i + ") Символ '\\n' встретился " + oe.getCount() + " раз.");
            }
            else {
                System.out.println(i + ") Символ '" + oe.getVal() + "' встретился " + oe.getCount() + " раз.");
            }
            oe = oe.next;
        }
    }

    public void removeAll() {
        orderElement oe = first;
        while (first != null) {
            first = oe.next;
            oe.next = null;
            oe.prev = null;
        }
        last = null;
    }
}
