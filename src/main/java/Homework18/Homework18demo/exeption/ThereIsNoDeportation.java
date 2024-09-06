package Homework18.Homework18demo.exeption;

public class ThereIsNoDeportation extends  RuntimeException {
    public ThereIsNoDeportation() {
    }

    public ThereIsNoDeportation(String message) {
        super(message);
    }

    public ThereIsNoDeportation(String message, Throwable cause) {
        super(message, cause);
    }
}
