package khd.Serialization;



import java.io.FileOutputStream; 

import java.io.IOException; 

import java.io.ObjectOutputStream; 

 
//
public class FileEx { 

 

    public static void main(String[] args) { 

        // TODO Auto-generated method stub 
        ObjectOutputStream oos = null; 

        try { 
            oos = new ObjectOutputStream(new FileOutputStream("E:/_Project/_KHD/eclipse/temp/FileEx/object.dat")); 

            Person p1 = new Person("Baek", 26); 
            Person p2 = new Person("Kim", 35); 
            oos.writeObject(p1); 
            oos.writeObject(p2); 

            System.out.println("출력 완료"); 

        } catch (IOException e) { 
            // TODO Auto-generated catch block 
            e.printStackTrace(); 
        } finally { 
            if(oos != null) try { oos.close(); } catch(Exception e) {} 
        } 
    } 

 

} 

