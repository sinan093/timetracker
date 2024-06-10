package timetracker.project.exception;

public class SpentHoursNegativeException extends RuntimeException {

    @Override
    public String getMessage() {
        return "spent hours can't be negative";
    }
}
