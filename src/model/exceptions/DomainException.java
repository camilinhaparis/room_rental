package model.exceptions;
//RuntimeException não sou obrigada a tratar essa exception
public final class DomainException extends RuntimeException{
    private static final long serialVersionUID = 1L;

    public DomainException(String msg){
        super(msg);
    }
}
