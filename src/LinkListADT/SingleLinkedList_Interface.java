package LinkListADT;

public interface SingleLinkedList_Interface<E> {

    void insertNode(E data);
    E removeFromLastPos();
    int searchNodeInLinkedList(E data);
    void printLinkedList();

}