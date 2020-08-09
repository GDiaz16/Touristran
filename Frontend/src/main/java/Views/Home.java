package Views;

import DataAccess.Create;
import DataAccess.Delete;
import DataAccess.Select;
import DataAccess.Update;
import Entities.ToDoEntity;

import javax.swing.*;

public class Home {
    private JPanel panel1;
    private JButton button1;

    public void createUIComponents() {
        // TODO: place custom component creation code here
    }

    public static void main(String[] args){
        Select select = new Select();
        Create create = new Create();
        Update update = new Update();
        Delete delete = new Delete();

        System.out.println(select.getToDo(1));
        System.out.println(create.createToDo(new ToDoEntity("Tarea 1", true)).getStatus());
        System.out.println(update.updateToDo(new ToDoEntity(1, "Tarea 1", true), 1).getStatus());
        System.out.println(delete.deleteToDo(2));
        JFrame frame = new JFrame("Touristran");
        frame.setContentPane(new Home().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(800,600);
        frame.setVisible(true);
    }
}
