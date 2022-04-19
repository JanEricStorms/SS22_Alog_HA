package uebungen.jan.übung3jan;

public class LastElementException extends RuntimeException{

    public LastElementException(){
        super("You tried to remove the last element. This is not allowed!");
    }
}
