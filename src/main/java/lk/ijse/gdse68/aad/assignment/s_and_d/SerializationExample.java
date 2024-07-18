package lk.ijse.gdse68.aad.assignment.s_and_d;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.*;

public class SerializationExample {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Student student = new Student("Ravindu", 22,"ravindu01@gmail.com","Galle");

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(baos);
        oos.writeObject(student);
        byte[] serializedData = baos.toByteArray();

        ByteArrayInputStream bais = new ByteArrayInputStream(serializedData);
        ObjectInputStream ois = new ObjectInputStream(bais);
        Student deserializedStudent = (Student) ois.readObject();

        System.out.println("Deserialized Person: " + "Name:" + deserializedStudent.getName()  + ", " +"Age:" + deserializedStudent.getAge() +", " +"Email:" + deserializedStudent.getEmail() + ", " +"City:" + deserializedStudent.getCity());
    }
}

@AllArgsConstructor
@NoArgsConstructor
@Data
class Student implements Serializable {
    private String name;
    private int age;
    private String email;
    private String city;

}