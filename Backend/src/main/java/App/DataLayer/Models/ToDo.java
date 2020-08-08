package App.DataLayer.Models;

import com.sun.org.apache.xpath.internal.operations.Bool;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class ToDo {

    public ToDo(){

    }
    public ToDo(String title, Boolean completed){
        this.title = title;
        this.completed = completed;
    }
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;

    private String title;

    private Boolean completed;

}
