# ED-Lab2

## Table of Contents
1. [Description](#description)
2. [Installation](#installation)
3. [Tests](#tests)
4. [Usage](#usage)
    - [LinkedStack](#linkedstack)
    - [Partitions2](#partitions2)
5. [Authors](#authors)


## Description

This project implements a stack in Java called `LinkedStack<E>` using nodes. You can check it in [LinkedStack](src/main/java/cat/udl/eps/ed/practica2/stack/LinkedStack.java) file. <br>
It also calculates partitions of a number in [Partition2](src/main/java/cat/udl/eps/ed/practica2/partitions/Partitions2.java) file.

## Installation
Clone the repo:

````shell
git clone https://github.com/Aniol0012/ED-Lab2.git
````


## Tests

There are 2 type of tests, one for `LinkedStack<E>` and the other one for `Partitions2`:

- [LinkedStackTest](src/test/java/cat/udl/eps/ed/practica2/stack/LinkedStackTest.java)
- [Partitions2Test](src/test/java/cat/udl/eps/ed/practica2/partitions/Partitions2Test.java)

## Usage
### LinkedStack
To utilize the `LinkedStack<E>`, you should import the class first and then you can create an instance of the stack and use its methods to add and remove elements.

````java
import cat.udl.eps.ed.practica2.stack.LinkedStack;

public class LinkedStackExample {

    public static void main(String[] args) {
        // Create an instance of LinkedStack
        LinkedStack<Integer> stack = new LinkedStack<>();

        // Add elements
        stack.push(1);
        stack.push(2);

        // Remove and view the top element
        int topElement = stack.pop();
        System.out.println("Top element is: " + topElement);
    }
}
````

### Partitions2
To calculate the partitions of a number, you can use the `Partitions2` class. This class provides two methods: one recursive and one iterative.

````java
import cat.udl.eps.ed.practica2.partitions.Partitions2;

public class Partitions2Example {

    public static void main(String[] args) {
        // Calculate partitions recursively
        int partitionsRec = Partitions2.partitionsRec(5);
        System.out.println("Recursive partitions of 5: " + partitionsRec);

        // Calculate partitions iteratively
        int partitionsIter = Partitions2.partitionsIter(5);
        System.out.println("Iterative partitions of 5: " + partitionsIter);
    }
}
````


## Authors
- [Aniol Serrano Ortega](https://github.com/Aniol0012)
- [Hamza Boulhani](https://github.com/Jamshaa)
