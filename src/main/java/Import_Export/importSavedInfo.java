package Import_Export;


import Tools.InputClass;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import Users.addedMembers;
import Users.createMember;
import Projects.Project;
import java.io.IOException;
import Projects.allProjects;
import com.google.gson.Gson;
import java.io.Reader;

public class importSavedInfo {

    InputClass input = new InputClass();
    addedMembers addedmembers = addedMembers.getInstance();
    ArrayList<createMember> allMembers = new ArrayList<createMember>();



    public void loadUser() throws IllegalStateException{

    Gson gson = new Gson();

    try (Reader reader = new FileReader("/Users/hagosaraya/IdeaProjects/eficaza/src/main/java/SavedInfo/savedUsersObjects.json")) {

        Type type = new TypeToken<ArrayList<createMember>>(){}.getType();
        allMembers = gson.fromJson(reader,type);
        try {
            int secondsToSleep = 2;
            input.printLine("Loading saved data...");
            Thread.sleep(secondsToSleep * 1000);
            addedmembers.loadFromFile(allMembers);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }

    } catch (IOException e) {
        input.printLine("fyi no saved data was loaded... :/");
        e.printStackTrace();
    }







    }
}