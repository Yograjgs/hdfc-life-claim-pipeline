package com.hdfclife.list;

public class DigitListAdder {

    public static ClaimLinkedList add(
            ClaimLinkedList first,
            ClaimLinkedList second) {

        ClaimNode a = first.getHead();

        ClaimNode b = second.getHead();

        ClaimLinkedList result =
                new ClaimLinkedList();

        int carry = 0;

        while (a != null ||
                b != null ||
                carry != 0) {

            int x = 0;
            int y = 0;

            if (a != null) {

                x = a.amount;

                a = a.next;
            }

            if (b != null) {

                y = b.amount;

                b = b.next;
            }

            int sum = x + y + carry;

            result.addLast(sum % 10);

            carry = sum / 10;
        }

        return result;
    }
}