import java.util.Scanner;
public class UserInfoLab {


    public static void main(String[] args) {
        // Part 1
        // Create a Scanner for keyboard input
        Scanner input = new Scanner(System.in);
        // Ask the user to enter their first and last name and pass these
        System.out.println("Enter your first name");
        String first_name = input.nextLine();
        System.out.println("Enter your last name");
        String last_name = input.nextLine();
        // values to the generateUsername method and save the returned result.
        String username = generateUsername(first_name, last_name);
        System.out.println("Username: " + username);

        // Part 2
        // Ask the user to enter a password and pass this value to the validatePassword method.
        System.out.println("Enter your password");
        String password = input.nextLine();
        if(validatePassword(password)) {
            System.out.println("Valid Password. Checking Credit Card");
            System.out.println("Enter your credit card number");
            String creditCard = input.nextLine();
            String masked_creditcard = maskCreditCard(creditCard);
            if(masked_creditcard.equals("N/A")) {
                System.out.println("Invalid Credit Card number");
            } else {
                System.out.println("Username: " + username);
                System.out.println("Credit Card: " + masked_creditcard);
            }
        }
        // The validatePassword method will check if the password meets the criteria:

        // Part 3
        // If the user entered a valid password in step 2, then ask the user to enter their
        // credit card number and pass this value to the maskCreditCard method.

        // Part 4
        // If the user entered a valid password AND valid credit card number, display the output
        // as shown in the demo video
        // https://drive.google.com/file/d/1sMOw5wkOgSfuUcvQhFyZ5flnv_d9qQd3/view?usp=sharing

    }

    public static String generateUsername(String firstName, String lastName) {
        // Fill in this method and return an appropriate username
        String first = "";
        String last = "";
        if(firstName.length() <= 3 || lastName.length() <= 3) {
            if(firstName.length() <= 3) {
                first = firstName;
            }
            if(lastName.length() <= 3) {
                last = lastName;
            }
        } else {
            first = firstName.substring(0, 3);
            last = lastName.substring(0, 3);
        }
            String username = first + last;
        return username.toLowerCase();
    }
    public static boolean validatePassword(String password) {
        // Fill in this method and return true/false if the password is valid
        if(password.length() >= 8) {
            if(!password.equals(password.toLowerCase())) {
                if (containsDigit(password)) {
                    return true;
                } else {
                    System.out.print("You must contain at least one digit");
                }
            } else {
                System.out.print("You must contain at least one uppercase letter");
            }
        } else {
                System.out.print("The password must be at least 8 characters long.");

        }
        return false;
    }
    public static String maskCreditCard(String creditCardNumber) {
        String output = "";
        // Fill in this method and if the credit card is valid, return a masked CC
        if(creditCardNumber.length() == 16 && allDigits(creditCardNumber)) {
            for (int i = 0; i < 3; i++) {
                output += "**** ";
            }
            output += creditCardNumber.substring(12, 16);
            return output;
        } else {
            return "N/A";
        }
    }

    /**
     This method verifies that the string contains at least one numeric digit
     @param str The string to check
     @return true or false if a digit is present
     */
    public static boolean containsDigit(String str) {
        char[] chars = str.toCharArray();
        for (char c: chars) {
            if (Character.isDigit(c))
                return true;
        }
        return false;
    }

    /**
     * Checks if the entire String is all numerical
     * @param str The string to check
     * @return true or false if the string is ALL digits
     */
    public static boolean allDigits(String str) {
        char[] chars = str.toCharArray();
        for (char c: chars) {
            if (!Character.isDigit(c))
                return false;
        }
        return true;
    }

}
