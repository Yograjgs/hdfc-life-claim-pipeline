package com.hdfclife.queue;

import com.hdfclife.model.Claim;
import com.hdfclife.model.Urgency;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class ClaimPriorityDesk {

    public static List<String> process(
            List<Claim> claims) {

        PriorityQueue<Claim> queue =new PriorityQueue<>((a, b) -> {int aPriority = priority(a.getUrgency());

        int bPriority =priority(b.getUrgency());

         if (aPriority !=bPriority) {

            return bPriority - aPriority;
                            
         }

        return b.getAmount() -
        a.getAmount();
        }
        );

        for (Claim claim : claims) {

            queue.offer(claim);
        }

        List<String> result =new ArrayList<>();

        while (!queue.isEmpty()) {

            result.add(queue.poll().getClaimId());
        }

        return result;
    }

    private static int priority(
            Urgency urgency) {

        if (urgency == Urgency.HIGH) {
            return 3;
        }

        if (urgency == Urgency.MEDIUM) {
            return 2;
        }

        return 1;
    }
}
