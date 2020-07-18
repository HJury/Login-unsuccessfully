package interactions;

import org.json.simple.parser.ParseException;
import org.openqa.selenium.TimeoutException;

import java.io.IOException;

/**
 * this class contains all the exceptions and a corresponding message for each one of them
 */
public class Exceptions implements Thread.UncaughtExceptionHandler {


    public static void exceptionMessage(TimeoutException e) {
        System.err.println("The element didn't get displayed or couldn't be reach in the time: " + e.getMessage());
    }

    public static void exceptionMessage(IOException e) {
        System.out.println("The Json Parse actions couldn't be done : \n" + e.getMessage());
    }

    public static void exceptionMessage(AssertionError e) {
        System.out.println("The Assertion didn't pass: \n" + e.getMessage());
    }

    public static void exceptionMessage(ParseException e) {
        System.out.println("The Json Parse actions couldn't be done : \n" + e.getMessage());
    }

    public static void exceptionMessage(java.text.ParseException e) {
        System.out.println("The Text Parse actions couldn't be done: \n" + e.getMessage());
    }

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        System.out.println(t.getName() + "An UncaughtException");
    }
}
