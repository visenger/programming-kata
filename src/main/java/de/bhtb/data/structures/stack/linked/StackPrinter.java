package de.bhtb.data.structures.stack.linked;

/**
 * Created by visenger on 14.06.17.
 */
public class StackPrinter {

    public static void main(String... args) {
        LinkedStack<String> stringLinkedStack = new LinkedStack<>();

        stringLinkedStack.push("a");
        stringLinkedStack.push("b");
        stringLinkedStack.push("c");

        printStack(stringLinkedStack);
    }

    private static void printStack(LinkedStack<String> stringLinkedStack) {
        if (stringLinkedStack.isEmpty()) {
            System.out.println("empty stack");
        } else {
            String topElement = stringLinkedStack.pop();
            System.out.println(topElement);
            printStack(stringLinkedStack);
        }
    }
}
