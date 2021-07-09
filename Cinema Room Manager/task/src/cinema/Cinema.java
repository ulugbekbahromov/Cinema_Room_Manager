package cinema;

import java.util.Scanner;

public class Cinema {

    private static final Scanner scanner = new Scanner(System.in);
    private static int numberOfRows;
    private static int numberOfSeatsInRow;
    private static int totalIncome;
    private static int numberOfPurchasedTickets;
    private static int currentIncome;

    private static char[][] seats;
    private static final int PRICE_FOR_LESS_THAN_60 = 10;
    private static final int PRICE_FOR_FRONT_HALF = 10;
    private static final int PRICE_FOR_BACK_HALF = 8;
    private static final char EMPTY_SEAT = 'S';
    private static final char BUSY_SEAT = 'B';
    private static final double hundredPercent = 100;

    public static void main(String[] args) {


        createTheSeats();

        int option;
        do {
            System.out.println("1. Show the seats");
            System.out.println("2. Buy a ticket");
            System.out.println("3. Statistics");
            System.out.println("0. Exit");
            option = scanner.nextInt();


            switch (option) {
                case 1:
                    showTheSeats(seats);
                    break;
                case 2:
                    buyTicket();
                    break;
                case 3:
                    showStatistics();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Wrong Command!");
            }
        } while (option != 0);
    }

    public static void createTheSeats() {

        System.out.println("Enter the number of rows:");
        numberOfRows = scanner.nextInt();
        System.out.println("Enter the number of seats in each row:");
        numberOfSeatsInRow = scanner.nextInt();

        if (numberOfRows <= 9 && numberOfSeatsInRow <= 9) {

            seats = new char[numberOfRows][numberOfSeatsInRow];

            for (int i = 0; i < numberOfRows; i++) {
                for (int j = 0; j < numberOfSeatsInRow; j++) {
                    seats[i][j] = EMPTY_SEAT;
                }
            }
        } else {
            System.out.println("Error! Some number greater than 9!");
            System.exit(-1);
        }

        int totalNumOfSeats = numberOfRows * numberOfSeatsInRow;
        if (totalNumOfSeats <= 60) {
            totalIncome = totalNumOfSeats * PRICE_FOR_LESS_THAN_60;
        } else {
            int frontHalfOfRows = numberOfRows / 2;
            int totalFrontHalf = frontHalfOfRows * numberOfSeatsInRow * PRICE_FOR_FRONT_HALF;
            int totalBackHalf = (numberOfRows - frontHalfOfRows) * numberOfSeatsInRow * PRICE_FOR_BACK_HALF;
            totalIncome = totalFrontHalf + totalBackHalf;
        }
    }

    public static void showTheSeats(char[][] seats) {

        System.out.print("Cinema:\n ");
        for (int i = 1; i <= seats[0].length; i++) {
            System.out.print(" " + i);
        }
        System.out.println();

        for (int i = 0; i < seats.length; i++) {
            System.out.print(i + 1);
            for (int j = 0; j < seats[0].length; j++) {
                System.out.print(" " + seats[i][j]);
            }
            System.out.println();
        }

        System.out.println();
    }






    public static void buyTicket() {
        int totalNumOfSeats = numberOfRows * numberOfSeatsInRow;

        int rowNumber;
        int seatNumber;
        while (true) {
            System.out.println("Enter a row number:");
            rowNumber = scanner.nextInt();
            System.out.println("Enter a seat number in that row:");
            seatNumber = scanner.nextInt();

            if (rowNumber > numberOfRows || seatNumber > numberOfSeatsInRow) {
                System.out.println("Wrong input!\n");
            } else {
                if (seats[rowNumber - 1][seatNumber - 1] == BUSY_SEAT) {
                    System.out.println("That ticket has already been purchased!\n");
                } else {
                    break;
                }
            }
        }

        System.out.println();

        int ticketCost;

        if (totalNumOfSeats <= 60) {
            ticketCost = PRICE_FOR_LESS_THAN_60;
        } else {
            int frontHalfOfRows = numberOfRows / 2;
            if (rowNumber <= frontHalfOfRows) {
                ticketCost = PRICE_FOR_FRONT_HALF;
            } else {
                ticketCost = PRICE_FOR_BACK_HALF;
            }
        }


        System.out.println("Ticket price: $" + ticketCost + "\n");
        seats[rowNumber - 1][seatNumber - 1] = BUSY_SEAT;

        currentIncome += ticketCost;
        numberOfPurchasedTickets++;
    }


    public static void showStatistics() {

        int totalNumOfSeats = numberOfRows * numberOfSeatsInRow;
        double roughPercentage = 0;
        try {

            roughPercentage = hundredPercent / totalNumOfSeats * numberOfPurchasedTickets;
        } catch (Exception e) {
            System.out.println("Division by zero!");
        }
        String percentageStr = String.format("%.2f", roughPercentage);

        System.out.println("Number of purchased tickets: " + numberOfPurchasedTickets);
        System.out.println("Percentage: " + percentageStr + "%");
        System.out.println("Current income: $" + currentIncome);
        System.out.println("Total income: $" + totalIncome);
        System.out.println();
    }
}