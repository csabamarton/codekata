package com.csmarton.rest;

import com.csmarton.rest.service.MovieTitleService;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("Hello world!");

        MovieTitleService movieTitleService = new MovieTitleService();

        movieTitleService.makeRequest();
    }
}