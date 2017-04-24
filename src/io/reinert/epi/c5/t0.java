package io.reinert.epi.c5;

public class t0 {
    public static void main(String[] args) {
        System.out.println(turnOn(0b00, 0) == 0b01);
        System.out.println(turnOn(0b00, 1) == 0b10);
        System.out.println(turnOn(0b000, 2) == 0b100);
        System.out.println(turnOn(0b1011, 0) == 0b1011);
        System.out.println(turnOn(0b1011, 1) == 0b1011);
        System.out.println(turnOn(0b1011, 2) == 0b1111);
        System.out.println(turnOn(0b1011, 3) == 0b1011);
        System.out.println((turnOn(0b000, 2) | turnOn(0b000, 0)) == 0b101);

        System.out.println(turnOff(0b01, 0) == 0b00);
        System.out.println(turnOff(0b10, 1) == 0b00);
        System.out.println(turnOff(0b101, 2) == 0b001);
        System.out.println(turnOff(0b1011, 0) == 0b1010);
        System.out.println(turnOff(0b1011, 1) == 0b1001);
        System.out.println(turnOff(0b1011, 2) == 0b1011);
        System.out.println(turnOff(0b1011, 3) == 0b0011);
        System.out.println((turnOff(0b100, 2) | turnOff(0b001, 0)) == 0b000);

        System.out.println(toggle(0b00, 0) == 0b01);
        System.out.println(toggle(0b10, 1) == 0b00);
        System.out.println(toggle(0b101, 2) == 0b001);
        System.out.println(toggle(0b1011, 0) == 0b1010);
        System.out.println(toggle(0b1011, 1) == 0b1001);
        System.out.println(toggle(0b1011, 2) == 0b1111);
        System.out.println(toggle(0b1011, 3) == 0b0011);
        System.out.println((toggle(0b100, 2) | toggle(0b000, 0)) == 0b001);
    }

    public static long turnOn(long x, int i) {
        return x | (1L << i);
    }

    public static long turnOff(long x, int i) {
        return x & ~(1L << i);
    }

    public static long toggle(long x, int i) {
        return x ^ (1L << i);
    }
}
