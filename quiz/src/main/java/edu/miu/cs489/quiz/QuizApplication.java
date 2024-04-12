package edu.miu.cs489.quiz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@SpringBootApplication
public class QuizApplication {

    public static void main(String[] args) {
        List<Contact> contacts = new ArrayList<>();
        contacts.add(new Contact("David", "Sanger", "Argos LLC", "Sales Manager",
                List.of(new PhoneNumber("240-133-0011", "Home")),
                List.of(new EmailAddress("dave.sang@gmail.com", "Home"),
                        new EmailAddress("dsanger@argos.com", "Work"))));
        contacts.add(new Contact("Carlos", "Jimenez", "Zappos", "Director", Collections.emptyList(), Collections.emptyList()));
        contacts.add(new Contact("Ali", "Gafar", "BMI Services", "HR Manager",
                List.of(new PhoneNumber("412-116-9988", "Work")),
                List.of(new EmailAddress("ali@bmi.com", "Work"))));

        Collections.sort(contacts, (c1, c2) -> c1.getLastName().compareToIgnoreCase(c2.getLastName()));


    }

    }

}



