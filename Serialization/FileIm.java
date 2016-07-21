package khd.Serialization;


import java.io.File; 
import java.io.FileInputStream; 
import java.io.FileNotFoundException; 
import java.io.IOException; 
import java.io.ObjectInputStream; 

 
public class FileIm { 

 
    public static void main(String[] args) { 

        // TODO Auto-generated method stub 
        ObjectInputStream ois = null; 

         

        try { 

            File f = new File("E:/_Project/_KHD/eclipse/temp/FileEx","object.dat"); 

            ois = new ObjectInputStream(new FileInputStream(f)); 

            Person p = (Person)ois.readObject(); 

            System.out.println(p.getName() + " " + p.getAge()); 

            Person p2 = (Person)ois.readObject(); 

            System.out.println(p2.getName() + " " + p2.getAge()); 

             

        } catch (FileNotFoundException e) { 

            // TODO Auto-generated catch block 

            e.printStackTrace(); 

        } catch (ClassNotFoundException e) { 

            // TODO Auto-generated catch block 

            e.printStackTrace(); 

        } catch (IOException e) { 

            // TODO Auto-generated catch block 

            e.printStackTrace(); 

        } finally { 

            if(ois != null) try { ois.close(); } catch(Exception e) {} 

        } 

    } 

 

} 

