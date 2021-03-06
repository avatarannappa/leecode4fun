import java.util.HashSet;
import java.util.Set;

/**
 * 160. 相交链表.
 *
 * @author avatarannappa
 * @version 1.1, 2021/6/7
 */
public class GetIntersectionNode160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        Set<ListNode> setA = new HashSet<>();
        while (headA != null) {
            setA.add(headA);
            headA = headA.next;
        }
        while (headB != null) {
            if (setA.contains(headB)) {
                return headB;
            }
            headB = headB.next;
        }
        return null;
    }

    public ListNode getIntersectionNodeMe(ListNode headA, ListNode headB) {
        ListNode indexA = headA;
        while (indexA != null) {
            ListNode indexB = headB;
            while (indexB != null) {
                if (indexA == indexB) {
                    return indexA;
                }
                indexB = indexB.next;
            }
            indexA = indexA.next;
        }
        return null;
    }

    public ListNode getIntersectionNodeDoublePointer(ListNode headA, ListNode headB) {
        ListNode A = headA;
        ListNode B = headB;
        while (A != B) {
            A = A == null ? headB : A.next;
            B = B == null ? headA : B.next;
        }
        return A;
    }
}
