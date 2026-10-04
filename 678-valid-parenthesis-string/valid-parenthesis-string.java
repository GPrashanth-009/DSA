// class Solution {
//     public boolean checkValidString(String s) {
//         Stack<Integer> stack=new Stack<>();
//         Stack<Integer> starstack =new Stack<>();
//         for(int i=0;i<s.length();i++){
            
//             char c = s.charAt(i);
//             if(c=='('){
//                 stack.push(i);
//             }
//             else if(c=='*'){
//                 starstack.push(i);
//             }
//             else{
                
//                 if(!stack.isEmpty()){
//                     stack.pop();
//                 }
//                 else if(!starstack.isEmpty()){
//                     starstack.pop();
//                 }
//                 else{
//                     return false;
//                 }
//             }
//         }
//         while(!stack.isEmpty() && !starstack.isEmpty()){
//             if(stack.peek()>starstack.peek()){
//                 return false;
//             }
//             stack.pop();
//             starstack.pop();
//         }
//         return stack.isEmpty();
//     }
// }

class Solution {
    public boolean checkValidString(String s) {
        int cmin = 0, cmax = 0;
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            
            if (c == '(') {
                cmin++;
                cmax++;
            } else if (c == ')') {
                cmin--;
                cmax--;
            } else { // c == '*'
                cmin--;
                cmax++;
            }
            
            if (cmax < 0) return false;
            cmin = Math.max(cmin, 0);
        }
        
        return cmin == 0;
    }
}
