package Users;

import Menus.ownerMenu;
import Tools.randomID;

import java.util.ArrayList;

public class createMember {

    randomID randID = randomID.getInstance();

    private String name;
    private String username;
    private String password;
    private int level;
    private int memberKey;

    public createMember(String name, String username, String password, int level){
        this.name = name;
        this.username=username;
        this.password=password;
        this.level=level;
        this.memberKey = randID.getRandom();

    }

    public String getName() {
        return name;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public int getLevel() {
        return level;
    }

    public int getMemberKey() {
        return memberKey;
    }
}
