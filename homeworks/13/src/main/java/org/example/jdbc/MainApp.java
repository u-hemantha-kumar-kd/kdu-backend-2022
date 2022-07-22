package org.example.jdbc;

import org.example.jdbc.service.FilmService;
import org.example.jdbc.service.FilmServiceImpl;
import org.example.jdbc.utils.ObjectUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApp {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        FilmService service = context.getBean(FilmServiceImpl.class);
        System.out.println("\n==================================================================================================================================================\n");
        System.out.println("Display Actor By ID");
        System.out.println(ObjectUtils.convertToJson(service.getActorbyID(36L)));
        System.out.println("\n==================================================================================================================================================\n");
        System.out.println("Get All Actors with the given first Name");
        System.out.println(ObjectUtils.convertToJson(service.getActorByActorName("Tom")));
        System.out.println("\n==================================================================================================================================================\n");
        System.out.println("Get all movie names by actor name");
        System.out.println(ObjectUtils.convertToJson(service.getMoviesByActorName("John")));
        System.out.println("\n==================================================================================================================================================\n");
    }
}
