package by.it.yurtsevich.videoCourse2.lesson14;

import java.util.Stack;

public class Test1 {
    public static void main(String[] args) {
        Stack <Integer> stack = new Stack<>();
        // 5 <- 3 <- 2 . First elements 2, second 3 i td.

        // метод пуш заталкивает элементы, похож на метод эдд
        stack.push(5);
        stack.push(3);
        stack.push(1);

        // Method pop достает элементы, в обратном порядке, с конца (1, 3, 5)
        System.out.println(stack.pop());


        // Method peek показывает елемент не извлекая его
        System.out.println(stack.peek());
        System.out.println(stack.pop());

    }
}
