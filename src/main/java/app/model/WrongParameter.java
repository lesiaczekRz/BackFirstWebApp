package app.model;

public class WrongParameter extends RuntimeException {

    public WrongParameter(String errorMessage) {
        super(errorMessage);
    }
}