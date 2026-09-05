package com.hdfclife.list;

public class CycleDetector {

    public static boolean hasCycle(
            ClaimLinkedList list) {

        ClaimNode slow = list.getHead();

        ClaimNode fast = list.getHead();

        while (fast != null &&
                fast.next != null) {

            slow = slow.next;

            fast = fast.next.next;

            if (slow == fast) {
                return true;
            }
        }

        return false;
    }

    public static ClaimNode findCycleStart(
            ClaimLinkedList list) {

        ClaimNode slow = list.getHead();

        ClaimNode fast = list.getHead();

        while (fast != null &&
                fast.next != null) {

            slow = slow.next;

            fast = fast.next.next;

            if (slow == fast) {

                slow = list.getHead();

                while (slow != fast) {

                    slow = slow.next;

                    fast = fast.next;
                }

                return slow;
            }
        }

        return null;
    }

    public static ClaimNode findMiddle(
            ClaimLinkedList list) {

        ClaimNode slow = list.getHead();

        ClaimNode fast = list.getHead();

        while (fast != null &&
                fast.next != null) {

            slow = slow.next;

            fast = fast.next.next;
        }

        return slow;
    }
}