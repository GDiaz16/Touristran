
import DataAccess.Create;
import DataAccess.Delete;
import DataAccess.Select;
import DataAccess.Update;
import Views.Home;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {
//        Select select = new Select();
//        Create create = new Create();
//        Update update = new Update();
//        Delete delete = new Delete();

        System.out.println("Hola mundo");
        //        System.out.println(create.createToDo(new ToDoEntity("Tarea 1", true)).getStatus());
        //        System.out.println(select.getToDo(1));
        //        System.out.println(update.updateToDo(new ToDoEntity(1, "Tarea 1", true), 1).getStatus());
        //        try {
        //            delete.deleteToDo(7);
        //            System.out.println("200 Success");
        //        }catch (NotFoundException err){
        //            System.out.println("404 Not Found");
        //        }
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
