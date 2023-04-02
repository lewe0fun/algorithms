public class Lin2List {

    private Node head;
    private Node tail;

    private class Node {
        private int value;
        private Node next;
        private Node previous;
    }


    public void revert(){
        Node node = head;
        while(node!=null){
            Node n = node.next;
            Node p = node.previous;
            node.next=p;
            node.previous=n;
            if(p==null)tail=node;
            if(n==null)head=node;
            node=n;
        }
    }
    public void sort(){
        for (Node i = head; i!=null ; i=i.next) {
            for (Node j = head; j!=null ; j=j.next) {
                if(i.value<j.value){
                    int temp= i.value;
                    i.value=j.value;
                    j.value=temp;
                }
            }
        }
    }
/*    public void sort2(){
        Node node = head;
        boolean isSorted=false;
        while(!isSorted){
            isSorted=true;
            while(node != null && node.next != null){

                if(node.value<node.next.value)
                {
                    int temp= node.value;
                    node.value=node.next.value;
                    node.next.value=temp;
                    isSorted=false;
                }
                node=node.next;
            }

        }
    }*/

/*    public void revert2(){
        Node node=head;
        while(node!=null){
            Node swap=node;
            node.next=swap.previous;
            node.previous=swap.next;
            if(node.previous==null)tail=node;
            if(node.next==null)head=node;
            node=swap.next;
        }
    }*/
    public void print()
    {
        Node node =head;
        while (node!=null)
        {
            System.out.print(node.value);
            if(node.next!=null) System.out.print(" -> ");
            node=node.next;
        }
        System.out.println();
    }

    public void addFirst(int value) {
        Node node = new Node();
        node.value = value;
        if (head != null) {
            node.next = head;
            head.previous = node;
        } else {
            tail = node;
        }
        head = node;
    }

    public void removeFirst() {
        if (head != null && head.next != null) {
            head.next.previous = null;
            head = head.next;
        } else  {
            head = null;
            tail = null;
        }
    }

    public void addLast(int value) {
        Node node = new Node();
        node.value = value;
        if (tail != null) {
            node.previous = tail;
            tail.next = node;
        } else {
            head = node;
        }
        tail = node;
    }

    public void removeLast() {
        if (tail != null && tail.previous != null) {
            tail.previous.next = null;
            tail = tail.previous;
        } else  {
            head = null;
            tail = null;
        }
    }

}

