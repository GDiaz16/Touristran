
import DataAccessObjects.TouristDAO;
import DataAccessObjects.toDo.Create;
import DataAccessObjects.toDo.Delete;
import DataAccessObjects.toDo.Select;
import DataAccessObjects.toDo.Update;
import Entities.ToDoEntity;
import Entities.TouristEntity;
import Views.Home;

import javax.swing.*;
import javax.ws.rs.NotFoundException;

public class Main {

    public static void main(String[] args) {
        Select select = new Select();
        Create create = new Create();
        Update update = new Update();
        Delete delete = new Delete();
        
        TouristDAO touristDAO = new TouristDAO();
        
        System.out.println(touristDAO.createTourist(new TouristEntity()));

        System.out.println("Hola mundo");
        System.out.println(create.createToDo(new ToDoEntity("Tarea 1", true)).getStatus());
        //System.out.println(update.updateToDo(new ToDoEntity(1, "Tarea 1", true), 1).getStatus());
        //System.out.println(select.getToDo(1));

        try {
            delete.deleteToDo(7);
            System.out.println("200 Success");
        } catch (NotFoundException err) {
            System.out.println("404 Not Found");
        }

        JFrame frame = new JFrame("Touristran");
        try {
            JFrame.setDefaultLookAndFeelDecorated(true);
            JDialog.setDefaultLookAndFeelDecorated(true);
            UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
        } catch (Exception e) {
            e.printStackTrace();
        }

        Home home = new Home();
        frame.setContentPane(home);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 800);
        frame.setLocation(200, 100);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.pack();

    }
}
