package jvm.roots.forestry;

import jvm.roots.branches.LinkedList;

import java.util.Objects;

public class JavaApp {

    private static void doSomethingForExample(final ExampleInterface e) {
        System.out.println("Running an example...");
        e.example();
    }


    public static void main(String[] args) {
        // Make a dummy app that subtracts elements in second list from the first provided
        if (args.length != 2) {
            doSomethingForExample(
                    () -> System.out.println("Usage: gradle :forestry:run -Pmain=java --args='1234 23'")
            );
            return;
        }
        LinkedList<Integer> linkedList = new LinkedList<>();

        // Assume: usage is correct and a list of numbers is provided
        for (char c: args[0].toCharArray()) {
            Integer i = Integer.parseInt(String.valueOf(c));
            linkedList.add(i);
        }

        System.out.println("Your starting list: " + linkedList);

        LinkedList.Node<Integer> prev = linkedList.getHead();
        LinkedList.Node<Integer> cur = linkedList.getHead();

        // TODO: confirm if this is O(n * log(m)), O(n + m), or something else

        // Assume: same as last, but also order matches first list
        for (char c: args[1].toCharArray()) {
            Integer i = Integer.parseInt(String.valueOf(c));
            boolean removed = false;
            do {
                if (cur != null) {
                    if (Objects.equals(cur.getData(), i)) {
                        // Handle front of list case:
                        if (cur == linkedList.getHead()) {
                            linkedList.setHead(cur.getNext());
                        }
                        cur = cur.getNext();
                        if (prev != null) {
                            // In the head removal case, we have to adjust prev handling slightly
                            if (Objects.equals(prev.getData(), i)) {
                                prev = null;
                            } else {
                                prev.setNext(cur);
                            }
                        }
                        removed = true;
                    } else {
                        prev = cur;
                        cur = cur.getNext();
                    }
                } else {
                    // Make sure we exit if cur doesn't exist
                    removed = true;
                }
            } while (!removed);
        }


        System.out.println("Hello Java! " + String.join(" ", args) + "\nAfter removal: " + linkedList);
    }
}
