package edu.miu.cs489;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
public class Main {
    public static void main(String[] args) {
     List<Person> people=new ArrayList<>();
     people.add(new Person("teke","beye",30));
     people.add(new Person("abe","dere",32));
     Collections.sort(people,(p1,p2)->Integer.compare(p1.Age(), p2.Age()));
     for(Person p:people){
         System.out.println(p.Age()+" "+p.fName());
     }



    }
}