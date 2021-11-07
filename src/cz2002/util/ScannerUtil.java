package cz2002.util;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ScannerUtil {

    public static int CustomPrompt(Scanner scanner, String prompt, String... options) {
        System.out.println();
        System.out.println(prompt);
        for(int i = 1; i <= options.length; i++)
            System.out.printf("%d) %s\n", i, options[i-1]);
        System.out.print("> ");

        try {
            int option = scanner.nextInt();
            if(option > options.length)
                throw new Exception();

            return option;
        } catch (Exception e) {
            // Clear buffer if there's an error
            if(e instanceof InputMismatchException)
                scanner.next();

            System.out.println("You have selected an invalid option..");
            return CustomPrompt(scanner, prompt, options);
        }
    }
    public static int Prompt(Scanner scanner, String... options) {
        return CustomPrompt(scanner, "Please select one of the following options: ", options);
    }
}