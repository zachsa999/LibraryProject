package com.javalearners.libraryapp.data;

import org.apache.logging.log4j.Logger;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public abstract class FileDAO<T> {
    private Logger logger;
    private List<T> list;
    private String fileLocation;
    private FileUtils fileUtils;

    public FileDAO(Logger logger, String fileLocation){
        this.logger = logger;
        this.fileLocation = fileLocation;
        this.fileUtils = new FileUtils(this.logger);
        this.list = initializeList(this.fileLocation);
    }

    abstract Optional<T> getObject(String ...args);
    abstract void update(T t, String[] params);
    abstract void delete(T t);
    abstract void add(T t);

    // NEED TO TEST THIS METHOD IF IT PRODUCES THE CORRECT TYPE OF LIST
    private List<T> initializeList(String fileLocation){
        File file = new File(fileLocation);
        List<T> list = new ArrayList<T>();
        if(file.exists()){
            return this.fileUtils.createListOfObjectFromFile(fileLocation);
        }
        else{
            return list;
        }
    }

    public List<T> getList(){
        return this.list;
    }

    public FileUtils getFileUtils(){
        return this.fileUtils;
    }

}
