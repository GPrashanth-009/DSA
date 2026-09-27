class Solution {
    public String reverseParentheses(String s) {
        Stack<StringBuilder> stack = new Stack<>();
        StringBuilder curr = new StringBuilder();

        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(curr);
                curr = new StringBuilder();
            } else if (c == ')') {
                curr.reverse();
                curr = stack.pop().append(curr);
            } else {
                curr.append(c);
            }
        }

        return curr.toString();
    }
}


// import java.util.*;

// class SolutionRecursive {
//     private int idx = 0;

//     public String reverseParentheses(String s) {
//         return helper(s);
//     }

//     private String helper(String s) {
//         StringBuilder sb = new StringBuilder();
//         while (idx < s.length()) {
//             char c = s.charAt(idx);
//             if (c == ')') {
//                 idx++;
//                 return sb.reverse().toString();
//             } else if (c == '(') {
//                 idx++;
//                 String inner = helper(s);
//                 sb.append(inner);
//             } else {
//                 sb.append(c);
//                 idx++;
//             }
//         }
//         return sb.toString();
//     }
// }
