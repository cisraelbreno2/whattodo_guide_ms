package br.com.guide_ms.domain.exceptions;

public class GuideCreateException extends RuntimeException{
    public GuideCreateException(String msg){
        super(msg);
    }
}
