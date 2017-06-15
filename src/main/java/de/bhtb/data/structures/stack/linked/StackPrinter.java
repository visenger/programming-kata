package de.bhtb.data.structures.stack.linked;

/**
 * Created by visenger on 14.06.17.
 */
public class StackPrinter {

    public static void main(String... args) {
        MyStack<String> stringMyStack = new MyStack<>();

        stringMyStack.push("a - first");
        stringMyStack.push("b - second");
        stringMyStack.push("c - third");

        printStack(stringMyStack);
    }

    private static void printStack(MyStack<String> stringMyStack) {
        if (stringMyStack.isEmpty()) {
            System.out.println("empty stack");
        } else {
            String topElement = stringMyStack.pop();
            System.out.println(topElement);
            printStack(stringMyStack);
        }
    }
}
