package cinema;

import java.util.Scanner;

public class Cinema {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int numberOfRows;
        int numberOfSeatsInRow;
        int totalSeats;
        int rowNumber;
        int seatNumber;
        int ticketCost;

        System.out.println("Enter the number of rows:");
        numberOfRows = scanner.nextInt();
        System.out.println("Enter the number of seats in each row:");
        numberOfSeatsInRow = scanner.nextInt();

        totalSeats = numberOfSeatsInRow * numberOfRows;
        System.out.print("Cinema:\n ");
        for (int i = 1; i <= numberOfSeatsInRow; i++) {
            System.out.print(" " + i);
        }
        System.out.println();
        for (int i = 1; i <= numberOfRows; i++) {
            System.out.print(i + " ");
            for (int j = 1; j <= numberOfSeatsInRow; j++) {
                System.out.print("S ");
            }
            System.out.println();
        }

        System.out.println();
        System.out.println("Enter a row number:");
        rowNumber = scanner.nextInt();
        System.out.println("Enter a seat number in that row:");
        seatNumber = scanner.nextInt();

        System.out.println();
        if (totalSeats <= 60) {
            ticketCost = 10;
        } else {
            ticketCost = numberOfRows / 2.0 > rowNumber ? 10 : 8;
        }
        System.out.println("Ticket price: $" + ticketCost);
        System.out.println();

        System.out.print("Cinema:\n ");
        for (int i = 1; i <= numberOfSeatsInRow; i++) {
            System.out.print(" " + i);
        }
        System.out.println();
        for (int i = 1; i <= numberOfRows; i++) {
            System.out.print(i + " ");
            for (int j = 1; j <= numberOfSeatsInRow; j++) {

                    System.out.print(i == rowNumber
                            && j == seatNumber ? "B " : "S ");
            }
            System.out.println();
        }
    }
}