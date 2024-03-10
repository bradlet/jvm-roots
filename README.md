# jvm-roots
A multi-language coding interview suite intended for use with potentially any JVM language.

## LICENSE
This project is licensed under the terms of the MIT license.

Copyright (c) 2024 Bradley Thompson

## Usage
The coding interview test suite is used in two ways:
1. As a command line application
2. In unit tests

To use it as a command line application, either take advantage of the gradle `application` plugin and do:
```shell
gradle :forestry:run --args="arg1 arg2"
```

Or interact with the command line app directly using `kotlinc` and `kotlin`.
Note that this approach takes more configuration when the command line app pulls in additional packages.
Using the gradle plugin is easier.

1. Compile the `forestry` application
    ```shell
    kotlinc ./forestry/src/main/kotlin/jvm/roots/forestry/App.kt
    ```
2. Note that unless you specified a target package in the above with `-d`, the built module is now in `META-INF`
3. Run the application
    ```shell
    kotlin jvm.roots.forestry.AppKt arg1 arg2
    ```