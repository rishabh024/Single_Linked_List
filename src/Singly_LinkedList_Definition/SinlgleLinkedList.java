package Singly_LinkedList_Definition;

import LinkListADT.SingleLinkedList_Interface;


public class SinlgleLinkedList<E> implements SingleLinkedList_Interface<E> {

    private Node<E> head = null;
    private int size = 0;

    private void insertAtFirstPos(E data){

        head=new Node (data,head);
        size++;

    }


    private Node<E> getNode(int position) {
        Node<E> response = head;
        for (int i = 0; i < position; i++) {
            response = response.getNext();
        }
        return response;

    }

    @Override
    public void insertNode(E data) {
        insertNodeAtPosition(data, size);
    }


    private void insertNodeAtPosition(E data, int pos){
        if(pos < 0 || pos > size)
            throw new IndexOutOfBoundsException(Integer.toString(pos));
        else if (pos == 0)
            insertAtFirstPos(data);
        else {
            Node<E> n = getNode(pos-1);

            n.next = new Node (data, n.next);
            size++;
        }
    }

    private E removeFirstNode (){
        E response = null;

        if(head!= null) {
            head = head.getNext();
            size--;
            response = head.getData();
        }
        return response;
    }

    private E removeNodeAfterThis(Node<E> n){
        E response = null;
        Node<E> temp = n.getNext();
        if (temp != null) {
            n.next = temp.getNext();
            size--;
            response = temp.getData();
        }
        return response;
    }

    private E removeNode(int index){
        E response = null;
        if(index < 0 || index > size)
            throw new IndexOutOfBoundsException(Integer.toString(index));

        if(index == 0)
            response = removeFirstNode();

        else {
            Node<E> n = getNode(index-1);
            response = removeNodeAfterThis(n);
        }
        return response;
    }



    @Override
    public E removeFromLastPos() {
        return removeNode(size-1);
    }

    @Override
    public int searchNodeInLinkedList(E data) {
        int response = -1;
        int index=0;
        for(Node d=head; d != null; d=d.getNext()){
            index+=1;
            if(d.getData()==  data){
                response =index;
                break;
            }
        }
        return response;
    }

    @Override
    public void printLinkedList() {
        System.out.print("[");
        for(Node d=head; d != null; d=d.getNext()){
            System.out.print(d.getData() +", " );
        }
        System.out.println("]");
    }





    private class Node<E> {
        private E data;
        private Node<E> next;

        private Node(E data) {
            this.data = data;
        }

        private Node(E data, Node<E> next) {
            this.data = data;
            this.next = next;
        }

        private E getData() {
            return data;
        }

        private Node<E> getNext() {
            return next;
        }
    }
}
