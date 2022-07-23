package com.homework14part1.utilities;

import com.homework14part1.services.FilmService;
import com.homework14part1.models.Actor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class DriverUtility {
    private static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));


    public static void getFilmNamesByActorName(FilmService filmService) throws IOException {
        String actorName;
        System.out.println("Enter actor name");
        actorName = bufferedReader.readLine();
        List<String> filmNamesByActorName = filmService.getFilmNamesByActorName(actorName);
        String filmNamesByActorNameJson = ObjectUtility.convertToJson(filmNamesByActorName);
        System.out.println(filmNamesByActorNameJson);
        ;
    }

    public static void getActorsByActorName(FilmService filmService) throws IOException {
        String actorName;
        System.out.println("Enter actor name");
        actorName = bufferedReader.readLine();
        List<Actor> actorsByActorName = filmService.getActorsByActorName(actorName);
        String actorsByActorNameJson = ObjectUtility.convertToJson(actorsByActorName);
        System.out.println(actorsByActorNameJson);
    }

    public static void getActorByActorId(FilmService filmService) throws IOException {
        int actorId;
        System.out.println("Enter actor Id");
        actorId = Integer.parseInt(bufferedReader.readLine());
        List<Actor> actorByActorId = filmService.getActorByActorId(actorId);
        String actorByActorIdJson = ObjectUtility.convertToJson(actorByActorId);
        System.out.println(actorByActorIdJson);
    }
}
