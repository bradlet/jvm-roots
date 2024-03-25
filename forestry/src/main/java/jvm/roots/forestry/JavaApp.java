package jvm.roots.forestry;

public class JavaApp {

    private static void doSomethingForExample(final ExampleInterface e) {
        System.out.println("Running an example...");
        e.example();
    }


    public static void main(String[] args) {
        doSomethingForExample(
                () -> CommandLineApps.removeSublist(args)
        );
    }
}
