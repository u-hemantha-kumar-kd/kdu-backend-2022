package com.homework14part1;

import com.homework14part1.services.FilmService;
import com.homework14part1.utilities.DriverUtility;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.IOException;
import java.util.Scanner;

public class Driver {
    public static void main(String[] args) throws IOException {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        FilmService filmService = applicationContext.getBean("filmService", FilmService.class);

        Scanner sc = new Scanner(System.in);
        int choice;
        while(true)
        {
            System.out.println("\n1.Get Films acted by Actor using Actor Name \n2.Get Actors with first or last Name \n3.Get Actor by their ID");
            System.out.println("Enter your choice!");
            choice = sc.nextInt();
            switch (choice)
            {
                case 1: DriverUtility.getFilmNamesByActorName(filmService);
                        break;
                case 2: DriverUtility.getActorsByActorName(filmService);
                        break;
                case 3: DriverUtility.getActorByActorId(filmService);
                        break;
                default:
                    System.out.println("Enter a valid choice between 1 - 3");
            }
        }
    }
}
