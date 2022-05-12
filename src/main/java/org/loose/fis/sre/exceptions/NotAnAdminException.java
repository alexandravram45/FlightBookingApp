package org.loose.fis.sre.exceptions;

public class NotAnAdminException extends Exception{

    private String username, role;

    public NotAnAdminException(String username, String role){
        super(String.format("You are not allowed to be an admin!"));
        this.username = username;
        this.role = role;
    }

    public String getUsername(){
        return username;
    }

    public String getRole() {
        return role;
    }
}
