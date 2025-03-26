package lec16;

public class MainStack {
    public static void main(String[] args){
        Stack<Integer> stack = new Stack<>();
        stack.push(5);
        stack.push(6);
        stack.push(8);
        stack.replace(5, 9);
    }
}

