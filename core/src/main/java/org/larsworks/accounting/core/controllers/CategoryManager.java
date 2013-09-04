package org.larsworks.accounting.core.controllers;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import lombok.extern.slf4j.Slf4j;
import org.larsworks.accounting.core.exceptions.CategoryManagerException;
import org.larsworks.accounting.core.exceptions.TextFileReaderException;
import org.larsworks.accounting.core.io.FileWriter;
import org.larsworks.accounting.core.io.FileWriterCallable;
import org.larsworks.accounting.core.io.TextFileReader;
import org.larsworks.accounting.core.model.Categories;

import javax.inject.Inject;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author Lars Kleen
 * @since 0.0.1
 *        Date: 25.08.13
 *        Time: 12:05
 */
@Slf4j
public class CategoryManager {

    private final String filename = "categories.gson";

    @Inject
    private TextFileReader fileReader;

    @Inject
    private FileWriter fileWriter;

    @Inject
    private Gson gson;

    private Categories categories = null;

    public Categories getCategories() {
        if(categories == null) {
            categories = load();
        }
        return categories;
    }

    private Categories load() {
        String text = readFile();
        if (text == null) {
            return new Categories();
        } else {
            try {
                return gson.fromJson(text, Categories.class);
            } catch (JsonSyntaxException e) {
                log.warn("could not parse json: " + text + " returning empty categories");
                return new Categories();
            }
        }
    }

    public void save(Categories categories) {
        File file = new File(filename);
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
            FileOutputStream fos = new FileOutputStream(file);
            FileWriterCallable callable = new FileWriterCallable(fos, gson.toJson(categories));
            fileWriter.write(callable);
        } catch (IOException e1) {
            throw new CategoryManagerException("could not save categories", e1);
        }
    }

    private String readFile() {
        try {
            return fileReader.read(filename).getText();
        } catch (TextFileReaderException e) {
            return null;
        }
    }


}
