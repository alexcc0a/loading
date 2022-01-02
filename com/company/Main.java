package com.company;

public class Main {

    public static void main(String[] args) {

        GameProgress gameProgressJhon = new GameProgress(15, 5, 3, 123.34);
        GameProgress gameProgressMike = new GameProgress(55, 9, 18, 178.24);
        GameProgress gameProgressTony = new GameProgress(100, 15, 43, 345.12);

        System.out.println("Идёт сохранение...");
        GameProgress.saveGame("C:/Users/User/IdeaProjects/Установка/src/Games/savegames/save1.dat", gameProgressJhon);
        GameProgress.saveGame("C:/Users/User/IdeaProjects/Установка/src/Games/savegames/save2.dat", gameProgressMike);
        GameProgress.saveGame("C:/Users/User/IdeaProjects/Установка/src/Games/savegames/save3.dat", gameProgressTony);
        System.out.println("Сохранение успешно");

        System.out.println("Идёт архивация сохраняемых файлов...");
        GameProgress.zipFiles("C:/Users/User/IdeaProjects/Установка/src/Games/savegames/save1.zip",
                "C:/Users/User/IdeaProjects/Установка/src/Games/savegames/save1.dat");
        GameProgress.zipFiles("C:/Users/User/IdeaProjects/Установка/src/Games/savegames/save2.zip",
                "C:/Users/User/IdeaProjects/Установка/src/Games/savegames/save2.dat");
        GameProgress.zipFiles("C:/Users/User/IdeaProjects/Установка/src/Games/savegames/save3.zip",
                "C:/Users/User/IdeaProjects/Установка/src/Games/savegames/save3.dat");

        GameProgress.openZip("C:/Users/User/IdeaProjects/Установка/src/Games/savegames/", "save1.zip");
        GameProgress.openZip("C:/Users/User/IdeaProjects/Установка/src/Games/savegames/", "save2.zip");
        GameProgress.openZip("C:/Users/User/IdeaProjects/Установка/src/Games/savegames/", "save3.zip");

        GameProgress.openProgress("C:/Users/User/IdeaProjects/Установка/src/Games/savegames/save1.dat");
        GameProgress.openProgress("C:/Users/User/IdeaProjects/Установка/src/Games/savegames/save2.dat");
        GameProgress.openProgress("C:/Users/User/IdeaProjects/Установка/src/Games/savegames/save3.dat");


    }
}