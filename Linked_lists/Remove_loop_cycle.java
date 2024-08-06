import java.util.Scanner;

public class Remove_loop_cycle {
    public static class Node{
        int data;
        Node next;

        // here we will create constructor
        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }
    public static Node head;
    public static Node tail;
    public static int size  = 0;

    public static class CycleDetecData{
        boolean isCycle = false;
        Node fast;
        Node slow;

        public CycleDetecData(boolean isCycle, Node fast, Node slow){
            this.isCycle  = isCycle;
            this.fast = fast;
            this.slow = slow;
        }
    }

    // add element in a linked list
    public static void addElementInLinkedList(int linked_list_size){
        if(linked_list_size == 0){
            System.out.println("Please enter linked list size greater than zero");
        }
        int i =0;
        while (i < linked_list_size) {
            System.out.print("Please enter element to add in a Linked list ");
            Scanner sc = new Scanner(System.in);
            int data = sc.nextInt();
            Node newNode = new Node(data);
            if(head == null){
                head = tail = newNode;
                i++;
                size++;
            }
            else{
                tail.next = newNode;
                tail = newNode;
                i++;
                size++;
            }
        }
        // here we are making our list as cycle
        tail.next = head;
    }
    public static CycleDetecData isLoopCycleDetected(Node slow, Node fast){
        while(fast != null && fast.next != null){
            System.out.print(fast.data);
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast){
                CycleDetecData newcycle = new CycleDetecData(true, fast, slow);
                return newcycle;
            }
        }
        CycleDetecData newcycle = new CycleDetecData(false, fast, slow);
        return newcycle;
    }
    public static void removeCycleFromLinkedList(){
        Node slow = head;
        Node fast =  head;
        System.out.println(fast.data);
        // here we will check linked is having loop cycle
        CycleDetecData cycleDetect_obj = isLoopCycleDetected(slow, fast);
        if(cycleDetect_obj.isCycle){
            // here we will move slow pointer to head and introduce a new variable called prev
            System.out.print("Loop is detcted in your Linked" + cycleDetect_obj.fast.data);
            slow = head;
            Node prev = null;
            fast = cycleDetect_obj.fast;
            System.out.println(fast.data);
            // here we will run a loop untill slow and fast are not equal
            while( slow != fast){
                slow = slow.next;
                prev = fast;
                fast = fast.next;
            }
            // here we will update our prev to null
            prev.next = null;
        }else{
            System.out.println("Cycle not detected");
        }


    }
    public static void main(String arags[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("Please Enter a size for linked list");
        int linked_list_size = sc.nextInt();

        // here we will add element in a linked list
        addElementInLinkedList(linked_list_size);

        // here we will remove cycle
        removeCycleFromLinkedList();
    }
}
