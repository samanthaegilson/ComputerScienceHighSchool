/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package cs40s.unitproblems.unit0problem1;

import javax.swing.JOptionPane;

/**
 * Unit0Problem1.java - This program calculates the circumference, the area, and
 * the volume of a circle based on the radius that the user enters.
 *
 * @author Samantha Egilson
 * @since 8-Sep-2023
 */
public class Unit0Problem1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        final String TITLE = "Unit Circle Calculator";
        start(TITLE);
        calculate(TITLE);
        end(TITLE);
    }

    /**
     * Starts the application and welcomes user with a dialog
     *
     * @param title the title of the application
     */
    private static void start(String title) {
        output("Welcome to " + title, title);
    }

    /**
     * Asks the user for a string input in a input dialog box
     *
     * @param title the title of the application
     * @return the answer
     */
    private static double input(String title) {
        String response = JOptionPane.showInputDialog(
                null,
                "Enter the radius of the circle:",
                title,
                JOptionPane.PLAIN_MESSAGE);
        double answer = Double.parseDouble(response);
        return answer;
    }

    /**
     * Ends the application with a dialog and terminates the application
     *
     * @param title the title of the application
     */
    private static void end(String title) {
        output("Thanks for using " + title, title);
    }

    /**
     * Calculates the radius, the area and the volume of a circle
     *
     * @param title the title of the application
     */
    private static void calculate(String title) {
        double radius = input(title);
        double circumference = 2 * Math.PI * radius;
        double area = Math.PI * radius * radius;
        double volume = (4 * Math.PI / 3) * radius * radius * radius;
        String text = "The circumference of a circle is: " + circumference
                + "\nThe area of a circle is: " + area
                + "\nThe volume of a circle is: " + volume;
        output(text, title);
    }

    /**
     * Outputs text in a dialog box
     *
     * @param text the text to display
     * @param title the title of the application
     */
    private static void output(String text, String title) {
        JOptionPane.showMessageDialog(
                null,
                text,
                title,
                JOptionPane.PLAIN_MESSAGE
        );
    }

}
