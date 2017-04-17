
package ui;

import data.User;

public class CurrentState {
    
    private static User loggedinUser;

    public static User getLoggedinUser() {
        return loggedinUser;
    }

    public static void setLoggedinUser(User loggedinUser) {
        CurrentState.loggedinUser = loggedinUser;
    }
       
}
