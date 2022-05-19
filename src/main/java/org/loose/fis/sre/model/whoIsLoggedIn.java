package org.loose.fis.sre.model;

public class whoIsLoggedIn {
    public static String loggedUsername;

    public static String getLoggedUsername() {
        return loggedUsername;
    }

    public static void setLoggedUsername(String loggedUsername) {
        whoIsLoggedIn.loggedUsername = loggedUsername;
    }
}
