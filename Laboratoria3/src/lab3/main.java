package lab3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import lab2.Person;
import lab2.Student;
import lab2.Teacher;

public class main 
{
    public static void main(String[] args) 
    {
        // zadanie 1
        Set<String> zbiorDni = new TreeSet<>();
        zbiorDni.add("poniedziałek");
        zbiorDni.add("wtorek");
        zbiorDni.add("środa");
        zbiorDni.add("czwartek");
        zbiorDni.add("piątek");
        zbiorDni.add("sobota");
        zbiorDni.add("niedziela");
        System.out.println(zbiorDni);
        for(String dzien : zbiorDni)
        {
            System.out.println(dzien);
        }
        
        //odp1 treeset jest posortowany, hashset nie zapewnia
        //odp2 treeset
        //odp3 nie
        
        
        // zadanie 2
        Map<String,Person> przedmioty = new HashMap<>();
        Person t1 = new Teacher("Michał", "Kramarczyk", "mkramarczyk@zut.edu.pl", "Technologie programowania systemów internetowych");
        Person t2 = new Teacher("Maciej", "Roszkowski", "mroszkowski@zut.edu.pl", "Projektowanie aplikacji internetowych");
        Person t3 = new Teacher("Anton", "Smoliński", "asmolinski@zut.edu.pl", "Programowanie aplikacji dla technologii mobilnych");
        przedmioty.put("Technologie programowania systemów internetowych",t1);
        przedmioty.put("Projektowanie aplikacji internetowych",t2);
        przedmioty.put("Programowanie aplikacji dla technologii mobilnych",t3);
        Person przedmiot = przedmioty.get("Technologie programowania systemów internetowych");
        System.out.println("'Technologie programowania systemów internetowych' prowadzi: " + przedmiot);
        
        List<Person> grupaA = new ArrayList<>();
        Person s1 = new Student("Paweł","Kowalski","pako@zut.edu.pl","A");
        Person s2 = new Student("Marcin","Nowak","mano@zut.edu.pl","A");
        grupaA.add(s1);
        grupaA.add(s2);
        List<Person> grupaB = new ArrayList<>();
        Person s3 = new Student("Adam","Głowa","adglo@zut.edu.pl","B");
        Person s4 = new Student("Szymon","Jankowski","szja@zut.edu.pl","B");
        grupaB.add(s3);
        grupaB.add(s4);
        
        Map<String,List<Person>> grupy = new HashMap<>();
        grupy.put("A",grupaA);
        grupy.put("B",grupaB);
        List<Person> grupa = grupy.get("B");
        System.out.println("GrupaB: " + grupa);
        
        // zadanie 3
        List<Product> produkty = new ArrayList<>();  
        Map<Integer,Product> mapID = new HashMap<>();
        Set<String> zbiorKategorii = new HashSet<>();
        try(BufferedReader in = new BufferedReader(new FileReader("plik.txt"))) 
        {
            while(true) 
            {
                String s = in.readLine();
                if(s==null) break;
                String[] pola = s.split(";");
                produkty.add(new Product(Integer.parseInt(pola[0]),pola[1],pola[2],Float.parseFloat(pola[3])));
                mapID.put(Integer.parseInt(pola[0]),produkty.get(produkty.size()-1));   
                zbiorKategorii.add(produkty.get(produkty.size()-1).getCategory());
                System.out.println(s);              
            }
        } 
        catch (IOException ex) 
        {
            ex.printStackTrace();
        }
        Map<Integer, Product> mappedId = new HashMap<>();
        Map<String, List<Product>> mappedCategory = new HashMap<>();

        for (Product p : produkty) {
            mappedId.put(p.getID(), p);
            
            if(mappedCategory.containsKey(p.getCategory())) {
                List<Product> l = mappedCategory.get(p.getCategory());
                l.add(p);
                mappedCategory.replace(p.getCategory(), l);
            } else {
                mappedCategory.put(p.getCategory(), new ArrayList<Product>());
                List<Product> l = mappedCategory.get(p.getCategory());
                l.add(p);
                mappedCategory.replace(p.getCategory(), l);
            }
        }
        System.out.println("==============================================");
        System.out.println(mappedId.get(102));
        System.out.println(mappedCategory.get("oprogramowanie"));


    }
    
}
