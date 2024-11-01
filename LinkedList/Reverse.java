package LinkedList;

public class Reverse {
    public static void main(String[] args) {
        ListNode head=new ListNode(1);
        head.next=new ListNode(2);
        head.next.next=new ListNode(3);
        head.next.next.next=new ListNode(4);
        head.next.next.next.next=new ListNode(5);
        System.out.println("Linked List ::");
        printList(head);
        ListNode ansNode=reverseList(head);
        printList(ansNode);
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static ListNode reverseList(ListNode head) {
        if(head==null || head.next==null){
            return head;
        }
        ListNode ptr1=head;
        ListNode ptr2=head.next;
        ListNode temp=ptr1;

        while(ptr1.next!=null){
            if(ptr2.next==null){
                ptr1.next=null;
            }else{
                ptr1.next=ptr2.next;
            }
            ptr2.next=temp;

            temp=ptr2;
            if(ptr1.next!=null){
            ptr2=ptr1.next;
            }
            head=temp;
        }

        return head;
    }

    static void printList(ListNode head){
        while(head!=null){
            System.out.print(head.val+" => ");
            head=head.next;
        }
        System.out.println();
    }
}