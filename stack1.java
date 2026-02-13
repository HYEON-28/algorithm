class Solution {
    public boolean isValid(String s) {
           Deque<Character> stack = new ArrayDeque<>();
        

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                if(stack.isEmpty()) return false;
                char pair = stack.pop();
                if(!checkPair(pair, c)) return false;
            }
        }
        if(stack.isEmpty()) return true;
        return false;
    }

    public static boolean checkPair(char start, char end) {
        boolean result = false;
        if(start == '(') {
            result = end == ')' ? true : false;
        }
        if(start == '[') {
            result = end == ']' ? true : false;
        }
        if(start == '{') {
            result = end == '}' ? true : false;
        }
        return result;
    }
}

// 개선점
// return stack.isEmpty();


// public static boolean checkPair(char start, char end) {
//     if (start == '(') return end == ')';
//     if (start == '[') return end == ']';
//     if (start == '{') return end == '}';
//     return false;
// }

// Map<Character, Character> map = new HashMap<>();
// map.put(')', '(');
// map.put(']', '[');
// map.put('}', '{');