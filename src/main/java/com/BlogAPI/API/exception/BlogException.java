package com.BlogAPI.API.exception;

public class BlogException extends Exception{
    public BlogException(String message){
        super(message);
    }

    public static String NotFoundException(String id){
        return "The blog is not found!!";
    }
    public static String AlreadyExists(){
        return "Blog with that ID or title already exists";
    }

}
