package learn.course;

import logger.CustomLogger;

import java.util.Scanner;

public class PasswordValidator {

    private static Scanner scanner = new Scanner(System.in);
    // long 8 chars or bigger
    // contains an uppercase letter
    // contain a special character
    // not contain the username
    // not the same as the old password
    private String userName;
    private String currentPasswd;
    private boolean valid = false;
    private String errorMessage;

    public PasswordValidator(String userName, String currentPasswd) {
        this.userName = userName;
        this.currentPasswd = currentPasswd;
    }

    public static void main(String[] args) {
        PasswordValidator validator = login();
        validator.printPasswordRules();

        do {
            String proposedPassword = validator.getNewPassword();
            validator.changePassword(proposedPassword);
            if (!validator.isValid()) {
                CustomLogger.logger.info(validator.getErrorMessage());
            }
        } while (!validator.isValid());
        validator.closeScanner();
    }

    public static PasswordValidator login() {
        CustomLogger.logger.info("Enter your username: ");
        String username = scanner.nextLine();

        CustomLogger.logger.info("Enter your password: ");
        String password = scanner.nextLine();

        return new PasswordValidator(username, password);
    }

    public void closeScanner() {
        scanner.close();
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public boolean isValid() {
        return valid;
    }

    public void printPasswordRules() {
        CustomLogger.logger.info("Your new password must meet the following requirements:");
        CustomLogger.logger.info("* at least 8 characters long");
        CustomLogger.logger.info("* contain an uppercase letter");
        CustomLogger.logger.info("* contain a special character");
        CustomLogger.logger.info("* not contain the username");
        CustomLogger.logger.info("* not the same as the old password");
        CustomLogger.logger.info("");
    }

    public String getNewPassword() {
        CustomLogger.logger.info("Enter your new password:");
        return scanner.nextLine();
    }

    public void changePassword(String newPassword) {
        valid = true;
        errorMessage = "";

        if (newPassword.length() < 8) {
            valid = false;
            errorMessage += "\n Your password must be at least 8 characters.";
        }

        if (newPassword.equals(newPassword.toLowerCase())) {
            valid = false;
            errorMessage += "\n Your password must include an uppercase letter.";
        }

        if (newPassword.matches("[a-zA-Z0-9 ]*")) {
            valid = false;
            errorMessage += "\n Your password must include a special character (e.g. %,$[:).";
        }

        if (newPassword.toUpperCase().contains(userName.toUpperCase())) {
            valid = false;
            errorMessage += "\n Your password cannot contain your username.";
        }

        if (newPassword.equals(currentPasswd)) {
            valid = false;
            errorMessage += "\n Your password must be different from your current password.";
        }
    }
}
