package lk.ijse.gdse68.aad.assignment.s_and_d;
import java.io.*;
public class DeserializationExample implements java.io.Serializable{
    public int a;
    public String b;

    public DeserializationExample(int a, String b) {
        this.a = a;
        this.b = b;
    }

}

class Test {
    public static void main(String[] args) {
        DeserializationExample object = new DeserializationExample(1, "Test01");
        String filename = "file.ser";

        try {
            FileOutputStream file = new FileOutputStream(filename);
            ObjectOutputStream out = new ObjectOutputStream(file);

            out.writeObject(object);

            out.close();
            file.close();

            System.out.println("Object has been serialized");
        } catch(IOException e) {
            e.printStackTrace();
        }

        DeserializationExample object1 = null;

        try {
            FileInputStream file = new FileInputStream(filename);
            ObjectInputStream in = new ObjectInputStream(file);

            object1 = (DeserializationExample)in.readObject();

            in.close();
            file.close();

            System.out.println("Object has been Deserialized ");
            System.out.println("a = " + object1.a);
            System.out.println("b = " + object1.b);
        } catch(IOException e) {
            e.printStackTrace();
        } catch(ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}

