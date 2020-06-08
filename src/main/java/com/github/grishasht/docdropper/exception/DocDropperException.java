package com.github.grishasht.docdropper.exception;

public class DocDropperException extends RuntimeException
{
    public DocDropperException()
    {
    }

    public DocDropperException(String message)
    {
        super(message);
    }

    public DocDropperException(String message, Throwable cause)
    {
        super(message, cause);
    }

    public DocDropperException(Throwable cause)
    {
        super(cause);
    }
}
