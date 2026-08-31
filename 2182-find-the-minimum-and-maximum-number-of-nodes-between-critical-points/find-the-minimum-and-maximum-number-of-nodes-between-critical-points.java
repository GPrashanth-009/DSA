/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return new int[]{-1, -1};
        }

        int firstIdx = -1;
        int prevIdx = -1;
        int minDist = Integer.MAX_VALUE;
        int currentIndex = 1;

        ListNode prev = head;
        ListNode curr = head.next;

        while (curr.next != null) {
            boolean isMax = curr.val > prev.val && curr.val > curr.next.val;
            boolean isMin = curr.val < prev.val && curr.val < curr.next.val;

            if (isMax || isMin) {
                if (firstIdx == -1) {
                    firstIdx = currentIndex;
                } else {
                    minDist = Math.min(minDist, currentIndex - prevIdx);
                }
                prevIdx = currentIndex;
            }

            prev = curr;
            curr = curr.next;
            currentIndex++;
        }

        if (firstIdx == prevIdx) {
            return new int[]{-1, -1};
        }

        return new int[]{minDist, prevIdx - firstIdx};
    }
}
