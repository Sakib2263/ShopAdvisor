
package ui;

import data.User;

public class CurrentState {
    
    private static User loggedinUser;
    private static String serverIP;

    public static User getLoggedinUser() {
        return loggedinUser;
    }

    public static void setLoggedinUser(User loggedinUser) {
        CurrentState.loggedinUser = loggedinUser;
    }

    public static String getServerIP() {
        return serverIP;
    }

    public static void setServerIP(String serverIP) {
        CurrentState.serverIP = serverIP;
    }
    
    public static void setServerIP() {
        CurrentState.serverIP = "127.0.0.1";
    }
       
}
