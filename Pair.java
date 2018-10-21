package com.dcp;

public class Pair {

    public static int car(Cons cons) {
        return cons.getA();
    }

    public static int cdr(Cons cons) {
        return cons.getB();
    }

    public static void main(String[] args) {
        Cons cons = new Cons(3, 4);
        System.out.println(car(cons));
        System.out.println(cdr(cons));
    }
}

class Cons {
    int a, b;

    public Cons(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public int getA() {
        return a;
    }

    public int getB() {
        return b;
    }
}


