import java.util.*;

class Solution {
    public List<String> braceExpansionII(String expression) {
        Stack<Object> stack = new Stack<>();
        int i = 0;
        int n = expression.length();

        while (i < n) {
            char ch = expression.charAt(i);

            if (Character.isLetter(ch)) {
                StringBuilder sb = new StringBuilder();
                while (i < n && Character.isLetter(expression.charAt(i))) {
                    sb.append(expression.charAt(i));
                    i++;
                }
                Set<String> set = new HashSet<>();
                set.add(sb.toString());
                
                if (!stack.isEmpty() && stack.peek() instanceof Set) {
                    stack.push(mergeProduct((Set<String>) stack.pop(), set));
                } else {
                    stack.push(set);
                }
                continue;
            } else if (ch == '{') {
                stack.push(ch);
            } else if (ch == ',') {
                stack.push(ch);
            } else if (ch == '}') {
                List<Set<String>> currentGroup = new ArrayList<>();
                while (!stack.isEmpty() && !stack.peek().equals('{')) {
                    Object top = stack.pop();
                    if (top instanceof Set) {
                        currentGroup.add((Set<String>) top);
                    }
                }
                stack.pop();

                Set<String> unionSet = new HashSet<>();
                for (Set<String> s : currentGroup) {
                    unionSet.addAll(s);
                }

                if (!stack.isEmpty() && stack.peek() instanceof Set) {
                    stack.push(mergeProduct((Set<String>) stack.pop(), unionSet));
                } else {
                    stack.push(unionSet);
                }
            }
            i++;
        }

        Set<String> resultSet = new HashSet<>();
        while (!stack.isEmpty()) {
            Object top = stack.pop();
            if (top instanceof Set) {
                resultSet.addAll((Set<String>) top);
            }
        }

        List<String> sortedList = new ArrayList<>(resultSet);
        Collections.sort(sortedList);
        return sortedList;
    }

    private Set<String> mergeProduct(Set<String> set1, Set<String> set2) {
        Set<String> result = new HashSet<>();
        for (String s1 : set1) {
            for (String s2 : set2) {
                result.add(s1 + s2);
            }
        }
        return result;
    }
}
