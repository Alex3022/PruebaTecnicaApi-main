package co.com.projectBase.utils;

public class TestFailure extends AssertionError {
    public TestFailure(String message, Throwable cause) {
        super(message, cause);
    }

    public TestFailure(String message) {
        super(message);
    }
}
