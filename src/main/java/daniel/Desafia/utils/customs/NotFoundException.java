package daniel.Desafia.utils.customs;

public class NotFoundException extends RuntimeException{
    public NotFoundException(String msg){
        super(msg);
    }

    public NotFoundException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
