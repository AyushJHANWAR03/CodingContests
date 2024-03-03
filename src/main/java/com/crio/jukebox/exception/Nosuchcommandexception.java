package com.crio.jukebox.exception;

public class Nosuchcommandexception extends RuntimeException {
    public Nosuchcommandexception(){
        super();
    }
    public Nosuchcommandexception(String msg){
        super(msg);
    }
}
