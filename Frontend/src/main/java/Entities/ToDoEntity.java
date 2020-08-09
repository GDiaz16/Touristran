package Entities;

public class ToDoEntity {
    private String title;

    private Boolean completed;

    private int id;

    public int getId() {
        return id;
    }
    public ToDoEntity(){}

    public ToDoEntity(int id, String title, Boolean completed){
        this.completed = completed;
        this.title = title;
        this.id = id;
    }

    public ToDoEntity(String title, Boolean completed){
        this.completed = completed;
        this.title = title;
    }
    public String getTitle() {
        return title;
    }

    public Boolean getCompleted() {
        return completed;
    }

    public String toString(){
        return id + "   "+title+"   "+completed;
    }
}
