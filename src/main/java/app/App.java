package app;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        App app = new App();
        app.run();
    }

    public void run() {
        char[] box = {'1', '2', '3', '4', '5', '6', '7', '8', '9'};

        boolean boxAvailable;
        boolean boxEmpty = false;

        byte winner = 0;

        System.out.println("Enter box number to select. Enjoy!\n");

        while (winner == 0) {
            printQuiz(box);
            if (!boxEmpty) {
                boxEmpty = toEmptyQuiz(box);
            }
            addInputIntoQuiz(box);
            boxAvailable = isBoxAvaialble(box);
            if (boxAvailable) {
                addRandomInputIntoQuiz(box);
            }
            winner = checkWhoIsTheWinner(box, boxAvailable);
        }
        informGameOutcome(winner, box);
    }

    public void printQuiz(char[] box) {
        System.out.println("\n\n " + box[0] + " | " + box[1] + " | " + box[2] + " ");
        System.out.println("-----------");
        System.out.println(" " + box[3] + " | " + box[4] + " | " + box[5] + " ");
        System.out.println("-----------");
        System.out.println(" " + box[6] + " | " + box[7] + " | " + box[8] + " \n");
    }

    public byte checkWhoIsTheWinner(char[] box, boolean boxAvailable) {
        if (hasWinningCombination(box, 'X')) {
            return 1;
        } else if (hasWinningCombination(box, 'O')) {
            return 2;
        } else if (!boxAvailable) {
            return 3;
        }
        return 0;
    }

    public void informGameOutcome(byte winner, char[] box) {
        App app = new App();
        switch (winner) {
            case 1:
                app.printQuiz(box);
                System.out.println("You won the game!\nCreated by Shreyas Saha. Thanks for playing!");
                break;
            case 2:
                app.printQuiz(box);
                System.out.println("You lost the game!\nCreated by Shreyas Saha. Thanks for playing!");
                break;
            case 3:
                app.printQuiz(box);
                System.out.println("It's a draw!\nCreated by Shreyas Saha. Thanks for playing!");
                break;
            default:
                System.out.println("Error");
        }
    }

    public void addInputIntoQuiz(char[] box) {
        while (true) {
            Scanner scan = new Scanner(System.in);
            byte input;
            input = scan.nextByte();
            if (input > 0 && input < 10) {
                if (box[input - 1] == 'X' || box[input - 1] == 'O')
                    System.out.println("That one is already in use. Enter another.");
                else {
                    box[input - 1] = 'X';
                    break;
                }
            } else {
                System.out.println("Invalid input. Enter again.");
            }
        }
    }

    public void addRandomInputIntoQuiz(char[] box) {
        while (true) {
            byte rand = (byte) (Math.random() * (9) + 1);
            if (box[rand - 1] != 'X' && box[rand - 1] != 'O') {
                box[rand - 1] = 'O';
                break;
            }
        }
    }

    public boolean toEmptyQuiz(char[] box) {
        for (byte i = 0; i < box.length; i++) {
            box[i] = ' ';
        }
        return true;
    }

    public boolean isBoxAvaialble(char[] box) {
        for (int i = 0; i < box.length; i++) {
            if (box[i] != 'X' && box[i] != 'O') {
                return true;
            }
        }
        return false;
    }

    public boolean hasWinningCombination(char[] box, char xOr0) {
        return (box[0] == xOr0 && box[1] == xOr0 && box[2] == xOr0) ||
                (box[3] == xOr0 && box[4] == xOr0 && box[5] == xOr0) ||
                (box[6] == xOr0 && box[7] == xOr0 && box[8] == xOr0) ||
                (box[0] == xOr0 && box[3] == xOr0 && box[6] == xOr0) ||
                (box[1] == xOr0 && box[4] == xOr0 && box[7] == xOr0) ||
                (box[2] == xOr0 && box[5] == xOr0 && box[8] == xOr0) ||
                (box[0] == xOr0 && box[4] == xOr0 && box[8] == xOr0) ||
                (box[2] == xOr0 && box[4] == xOr0 && box[6] == xOr0);
    }
}
