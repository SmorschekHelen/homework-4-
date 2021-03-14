package domain.tasks;

import domain.TaskService;

import java.util.Objects;
import java.util.Scanner;

abstract public class Tasks implements TaskService, Comparable<Tasks> {

    Scanner scanner = new Scanner(System.in);

    private String description;
    private String date;
    private TaskType taskType;
    private Priority priority;
    private boolean complete;
    private String endDate;
    private static int id = 1;

    public Tasks() {

    }

    public Tasks(String description, String beginDate, TaskType taskType, Priority priority, boolean complete, String endDate) {
        this.description = description;
        this.date = beginDate;
        this.taskType = taskType;
        this.priority = priority;
        this.complete = complete;
        this.endDate = endDate;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Tasks)) return false;
        Tasks tasks = (Tasks) obj;
        return getDescription().equals(tasks.getDescription());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getDescription());
    }

    @Override
    public int compareTo(Tasks tasks) {
        int result;

        System.out.println("сортировка по типу - нажми 1, " +
                "           сортировка по дате - нажми 2" +
                "           сортировка по важности - нажми 3 " +
                "           ничего не сортировать - нажми 0");
        String scan = scanner.nextLine();

        switch (scan) {

            case "1":
                result = this.getTaskType().compareTo(tasks.getTaskType());
                if (result == 0) {
                    result = this.getBeginDate().compareTo(tasks.getBeginDate());
                }
                break;
            case "2":
                result = this.getBeginDate().compareTo(tasks.getBeginDate());
                if (result == 0) {
                    result = this.getTaskType().compareTo(tasks.getTaskType());
                }
                break;
            case "3":
                result = this.getPriority().compareTo(tasks.getPriority());
                if (result == 0) {
                    result = this.getTaskType().compareTo(tasks.getTaskType());
                }
                break;

            default:
                result = 0;
                break;
        }
        return result;

    }

    //Создание задачи
   // @Override
    public void newTask(String description, String beginDate, TaskType type, Priority priority, boolean complete, String endDate){
        setDescription(description);
        setBeginDate(beginDate);
        setTaskType(type);
        setPriority(priority);
        setComplete(complete);
        setEndDate(endDate);
    }

    @Override
    public String toString(){
        final StringBuffer sb = new StringBuffer("\n");
        sb.append("Description:").append(getDescription()).append(".\n");
        sb.append("BeginDate:").append(getBeginDate()).append(".\n");
        sb.append("Type:").append(getTaskType()).append(".\n");
        sb.append("Priority:").append(getPriority()).append(".\n");
        sb.append("EndDate:").append(getEndDate()).append(".\n");
        sb.append("Complete:").append(isComplete()).append(".\n");
        return sb.toString();

    }
    public static void printTask(Tasks tasks){
        System.out.println(tasks);
    }

    public String getDescription(){
        return description;
    }

    public void setDescription(String description){
        this.description = description;
    }

    public String getBeginDate(){
        return date;
    }

    public void setBeginDate(String date){
        this.date = date;
    }

    public TaskType getTaskType(){
        return taskType;
    }

    public void setTaskType(TaskType taskType){
        this.taskType = taskType;
    }

    public boolean isComplete(){
        return complete;
    }

    public void setComplete(boolean complete){
        this.complete = complete;
    }

    public String getEndDate(){
        return endDate;
    }

    public void setEndDate(String endDate){
        this.endDate = endDate;
    }

    public Priority getPriority(){
        return priority;
    }

    public void setPriority(Priority priority){
        this.priority = priority;
    }



}
