package com.company;

import java.util.Random;
import java.util.Scanner;

public class Main {

    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        Start();
    }

    public static void Start() {
        boolean flag = true;
        while (flag) {
            System.out.println("[P]lay");
            System.out.println("E[x]it");

            String choose = input.nextLine().toUpperCase();
            switch (choose) {
                case "P":
                    int dif = Difficulty();
                    boolean mod = Mode();
                    MainGame(dif, mod);
                    break;
                case "X":
                    System.out.println("Bye, bye!");
                    flag = false;
                    break;
                default:
                    System.out.println("Enter P or X:");
            }
        }
    }

    public static int Difficulty() {
        System.out.println("Choose a game difficulty:");
        System.out.println("[E]asy (1 - 10)");
        System.out.println("[M]edium (1 - 100)");
        System.out.println("[H]ard (1 - 1000)");

        boolean flag = true;
        String choose = "";
        int dif = 0;
        while (flag) {
            choose = input.nextLine().toUpperCase();
            switch (choose) {
                case "E":
                    flag = false;
                    dif = 10;
                    break;
                case "M":
                    flag = false;
                    dif = 100;
                    break;
                case "H":
                    flag = false;
                    dif = 1000;
                    break;
                default:
                    System.out.println("Enter E, M or H:");
            }
        }
        return dif;
    }

    private static boolean Mode() {
        System.out.println("Choose a game mode:");
        System.out.println("[L]imited number of attempts (10 attempts)");
        System.out.println("[U]nlimited number of attempts");

        boolean flag = true;
        String choose = "";
        boolean mode = false;
        while (flag) {
            choose = input.nextLine().toUpperCase();
            switch (choose) {
                case "L":
                    flag = false;
                    mode = true;
                    break;
                case "U":
                    flag = false;
                    mode = false;
                    break;
                default:
                    System.out.println("Enter L or U:");
            }
        }
        return mode;
    }

    public static void MainGame(int difficulty, boolean mode) {

        boolean flag = false;

        Random rnd = new Random();
        int number = rnd.nextInt(difficulty) + 1;

        int numOfAttempts;
        if (mode)
            numOfAttempts = 10;
        else
            numOfAttempts = 0;
        int counter = 0;
        int run = -1;
        System.out.println("Choose number from 1 to " + difficulty);

        while (run <= numOfAttempts) {
            counter++;
            if (mode)
                numOfAttempts--;

            try {
                flag = false;
                int choose = Integer.parseInt(input.nextLine());

                if (choose == number) {
                    System.out.println("You reached the aim after " + counter + " attempts! The imagined number was " + number +
                            "\nPress ENTER to get back to the main menu");
                    break;
                } else if (choose < number) {
                    System.out.println("Entered number is smaller than imagined number");
                    if (!mode) {
                        System.out.println("If you want to quit the game, press any letter key and then press Enter");
                    }

                } else {
                    System.out.println("Entered number is bigger than imagined number");
                    if (!mode) {
                        System.out.println("If you want to quit the game, press any letter key and then press Enter");
                    }
                }

                if (mode) {
                    System.out.println("The remaining number of attempts is: " + numOfAttempts);
                }
            } catch (Exception ex) {
                numOfAttempts = -2;
                flag = false;
                break;
            }
        }
        if (mode && flag) {
            System.out.println("You used all ten attempts and you didn't hit the imagined number: " + number);
        }
    }
}