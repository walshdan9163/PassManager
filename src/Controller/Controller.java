package Controller;

import Model.Model;
import javax.swing.JFrame;
import view.Add;
import view.Delete;
import view.PopUpError;
import view.Update;
import view.View;
import view.Welcome;

/**
 *
 * @author Daniel
 */
public class Controller {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
        start();
        
    }
    
  
    
    public static void addNew(String website, String user, String pass){
        Model.setAccount(website);
        Model.setUser(user);
        Model.setPass(pass);
    }
    
    public static void delete(String website){
        int x;
        x = Model.delete(website);
        if(x == 1){
            start();
        }
        else{
            
        }
    }
    
    public static void update(String website, String username, String password){
        int x;
        x = Model.update(website, username, password);
        if(x == 1){
            start();
        }
        else{
            
        }
        
    }
    
    public static void showError(){
        PopUpError er = new PopUpError();
        er.setVisible(true);
    }
    
    public static void start(){
        Welcome w = new Welcome();
        w.setVisible(true);
    }
    
    public static void createDelete(JFrame aThis){
        aThis.setVisible(false);
        Delete d = new Delete();
        d.setVisible(true);
    }
    
    public static void createAdd(JFrame aThis){
        aThis.setVisible(false);
        Add a = new Add();
        a.setVisible(true);
    }
    
    public static void createView(JFrame aThis){
        aThis.setVisible(false);
        View v = new View();
        v.addElement(Model.getAccount());
        v.addElement2(Model.getUser());
        v.addElement3(Model.getPass());
        v.setVisible(true);
    }

    public static void save() {
        System.exit(0);
    }

    public static void createUpdate() {
        Update u = new Update();
        u.setVisible(true);
    }
    
}
