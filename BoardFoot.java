import java.util.Scanner;

/**
* This program receives input of width and height,
* then calculates the length for a board foot of
* those dimensions.
*
* @author Logan S
* @version 1.0
*
* @since   2023-03-08
*/

public final class BoardFoot {

    /**
    * This is a private constructor.
    *
    * @exception IllegalStateException Utility class.
    * @see IllegalStateException
    */
    private BoardFoot() {
        throw new IllegalStateException("Utility class");
    }

    /**
     * This is the main method.
     *
     * @param args Unused.
     */
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        try {
            // Prompt the user to enter the width in inches
            System.out.print("Enter the width of the board in inches: ");
            final double width = scanner.nextDouble();

            // Prompt the user to enter the height in inches
            System.out.print("Enter the height of the board in inches: ");
            final double height = scanner.nextDouble();

            // Call the calculateLength method to calculate the length
            final double length = calculateLength(width, height);

            // Print the length to the console
            System.out.printf("The length required is %.2f inches.%n", length);
        } catch (NumberException exception) {
            // Catch any exceptions and print an error message
            System.out.println("Error: Invalid input. Please enter a valid "
                    + "number.");
        } finally {
            // Close the Scanner to release system resources
            scanner.close();
        }
    }

    public static double calculateLength(double width, double height)
            throws IllegalArgumentException {
        // Calculate the volume of 1 board foot in cubic inches
        final double volume = 144f;

        // Calculate the length using the input width and height
        final double length = volume / (width * height);

        // If the calculated length is less or equal to zero, throw an exception
        if (length <= 0) {
            throw new IllegalArgumentException("Invalid dimensions: cannot "
                + "calculate length.");
        }

        // Return the length required to make 1 board foot
        return length;
    }
}
