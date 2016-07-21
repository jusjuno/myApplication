package khd.Serialization;

import java.io.Serializable;

//객체 직렬화를 하지 않으면 파일로 저장시 에러남 당연 네트웍 통신시 전달로 안 되겠징...
public class Person implements Serializable { 

    private String name; 
    private int age;     

    public Person(String name, int age) { 
        this.name = name; 
        this.age = age; 
    } 
    public String getName() { 
        return name; 
    } 
    public void setName(String name) { 
        this.name = name; 
    } 
    public int getAge() { 
        return age; 
    } 
    public void setAge(int age) { 
        this.age = age; 
    } 

} 


