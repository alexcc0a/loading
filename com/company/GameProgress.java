package com.company;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public class GameProgress implements Serializable {

    private static final long serialVersionUID = 1L;

    private int health;
    private int weapons;
    private int lvl;
    private double distance;

    public GameProgress(int health, int weapons, int lvl, double distance) {
        this.health = health;
        this.weapons = weapons;
        this.lvl = lvl;
        this.distance = distance;
    }

    @Override
    public String toString() {
        return "GameProgress: " +
                "health=" + health +
                ", weapons=" + weapons +
                ", lvl=" + lvl +
                ", distance=" + distance;
    }

    public static void saveGame(String savePath, GameProgress gameProgress) {
        try (FileOutputStream fos = new FileOutputStream(savePath);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(gameProgress);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void zipFiles(String zipPath, String filePath) {
        File fileSave = new File(filePath);
        try (ZipOutputStream zout = new ZipOutputStream(new
                FileOutputStream(zipPath));
             FileInputStream fis = new FileInputStream(filePath)) {
            String name = fileSave.getName();
            ZipEntry entry = new ZipEntry(name);
            zout.putNextEntry(entry);

            byte[] buffer = new byte[fis.available()];
            fis.read(buffer);

            zout.write(buffer);

            zout.closeEntry();
        } catch (
                Exception e) {
            System.out.println(e.getMessage());
        }
        if (fileSave.delete()) {
            System.out.println("Временный файл " + fileSave.getName() + " успешно удален");
        } else {
            System.out.println("Временный файл " + fileSave.getName() + " не найден");
        }
    }

    public static void openZip(String path, String zipName) {
        try (ZipInputStream zin = new ZipInputStream(new FileInputStream(path + zipName))) {
            ZipEntry entry;
            String fileName;
            while ((entry = zin.getNextEntry()) != null) {
                fileName = entry.getName();
                FileOutputStream fout = new FileOutputStream(path + fileName);
                for (int c = zin.read(); c != -1; c = zin.read()) {
                    fout.write(c);
                }
                fout.flush();
                zin.closeEntry();
                fout.close();
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void openProgress(String filePath) {
        GameProgress gameProgress = null;
        try (FileInputStream fis = new FileInputStream(filePath);
             ObjectInputStream ois = new ObjectInputStream(fis)) {
            gameProgress = (GameProgress) ois.readObject();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println(gameProgress);
    }
}

