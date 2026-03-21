package daniel.Desafia.utils.customs;

public class AlreadyExistException extends RuntimeException {
    public AlreadyExistException(String msg){
        super(msg);
    }

    public AlreadyExistException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
