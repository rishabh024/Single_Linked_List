package Execution;

import Singly_LinkedList_Definition.SinlgleLinkedList;


public class MainClass {
    public static void main(String[] args) {
        SinlgleLinkedList<Integer> list = new SinlgleLinkedList<>();

        list.printLinkedList();
        list.insertNode(4);
        list.printLinkedList();
        list.insertNode(9);
        list.printLinkedList();
        list.insertNode(7);
        list.printLinkedList();
        list.removeFromLastPos();
        list.printLinkedList();
        list.removeFromLastPos();
        list.printLinkedList();
    }
}
