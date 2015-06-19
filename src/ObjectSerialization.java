import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;


public class ObjectSerialization {
	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		
		Person pe;
//		Create a binary file to store our Person object
		File file = new File("objects.txt");
//		Create an arraylist of our objects
		ArrayList<Person> list = new ArrayList<Person>();
//		add few objects in the list to store
		list.add(new Person("John",22));
		list.add(new Person("Alice",20));
		list.add(new Person("Ron",30));
		
//		serialize the objects into the file
		FileOutputStream fo = new FileOutputStream(file);
		ObjectOutputStream ob = new ObjectOutputStream(fo);
		
		for (Person p: list) {
			ob.writeObject(p);
		}
		
		ob.close();
		fo.close();
		
//		de serialize the objects from file.
		FileInputStream fi = new FileInputStream(file);
		ObjectInputStream oi = new ObjectInputStream(fi);
		try {
			while(true) {
				pe = (Person)oi.readObject();
				System.out.println(pe.getName() + " " + pe.getAge());
			}	 
		} catch(EOFException ex) {
			System.out.println("File ended.");
		}
		
		
	}
}
