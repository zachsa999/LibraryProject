package com.javalearners.libraryapp.data;

import org.apache.logging.log4j.Logger;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileUtils {
    private Logger logger;

    public FileUtils(Logger logger){
        this.logger = logger;
    }


    private FileInputStream createFileInputStream(String fileLocation){
        File file = new File(fileLocation);
        try{
            file.createNewFile();
            return new FileInputStream(file);
        } catch (FileNotFoundException e) {
            logger.error("Unable to create the file, user may not have permission", e);
        } catch (IOException e) {
            logger.error("Threw a IOException full stack trace follows:", e);
        }
        return null;
    }

    private FileOutputStream createFileOutputStream(String fileLocation){
        File file = new File(fileLocation);
        try{
            file.createNewFile();
            return new FileOutputStream(file, true);
        } catch (FileNotFoundException e) {
            logger.error("Unable to create the file, user may not have permission", e);
        } catch (IOException e) {
            logger.error("Threw a IOException full stack trace follows:", e);
        }
        return null;

    }

    public ObjectInputStream createObjectInputStream(String fileLocation){
        try (ObjectInputStream objectInputStream = new ObjectInputStream(createFileInputStream(fileLocation))){
            return objectInputStream;
        }   catch(IOException ioe){
            logger.error("Threw a IOException; full stack trace as follows:", ioe);
        }
        return null;
    }

    public ObjectOutputStream createObjectOutputStream(String fileLocation){
        try(ObjectOutputStream objectOutputStream = new ObjectOutputStream(createFileOutputStream(fileLocation))){
            return objectOutputStream;
        } catch(IOException ioe){
            logger.error("Threw a IOException; full stack trace as follows:", ioe);
        }
        return null;
    }

    public <T> List<T> createListOfObjectFromFile(String fileLocation){
        List<T> list = new ArrayList<>();
        try{
            return (List<T>) createObjectInputStream(fileLocation).readObject();
        } catch (IOException ioe) {
            logger.error("Threw a IOException; full stack trace as follows:", ioe);
        } catch (ClassNotFoundException cnfe) {
            logger.error("Threw a ClassNotFoundException; full stack trace as follows:", cnfe);
        }
        return list;
    }

    public <T> void saveListToFile(List<T> list, String fileLocation){
        try{
            createObjectOutputStream(fileLocation).writeObject(list);
        } catch(IOException ioe){
            logger.error("Threw a IOException; full stack trace as follows:", ioe);
        }
    }
}
