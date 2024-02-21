package models.Exceptions;

public class InvalidResponse extends RuntimeException{
    public InvalidResponse(String message){
        super(message);
    }
}
