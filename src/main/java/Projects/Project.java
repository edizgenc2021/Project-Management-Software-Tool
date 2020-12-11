package Projects;

import java.util.ArrayList;
import java.util.List;

import Menus.ownerMenu;
import Tools.randomID;

public class Project {

    randomID randID = randomID.getInstance();

    private String projectName;
    private int weeks;
    private String projectMilestones;
    private String task;
    private ArrayList<Integer> memberKey;
    private int projectKey;
    private int ownerKey;
    private String startDate;
    private String endDate;
    private ArrayList<task> tasks = new ArrayList<>();

    public Project(String projectName, int weeks, String milestones, String task, int ownerKey, String startDate, String endDate, ArrayList<task>tasks){
        this.projectName=projectName;
        this.weeks=weeks;
        this.projectMilestones = milestones;
        this.task = task;
        this.projectKey=randID.getRandom();
        this.ownerKey = ownerKey;
        this.startDate = startDate;
        this.endDate = endDate;
        this.tasks = tasks;
    }

    public Project(){
    }

    public String getProjectName() {
        return projectName;
    }

    public int getWeeks() {
        return weeks;
    }

    public String getProjectMilestones() {
        return projectMilestones;
    }

    public void addMemberKey(int key){
        memberKey.add(key);
    }

    public String getStartDate() { return startDate; }

    public String getEndDate() { return endDate; }

    public int getProjectKey() {
        return projectKey;
    }

    public ArrayList<task> getTasks() {
        return tasks;
    }

    public void addTask(Object o){
        tasks.add((task) o);
    }
}