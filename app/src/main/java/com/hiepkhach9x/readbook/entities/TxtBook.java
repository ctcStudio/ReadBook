package com.hiepkhach9x.readbook.entities;

import android.provider.MediaStore;
import android.text.TextUtils;

import com.hiepkhach9x.readbook.utils.SettingBookPreferences;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

/**
 * Created by HungHN on 2/1/2016.
 */
public class TxtBook implements Books {

    private EBook eBook;

    public TxtBook(EBook eBook) {
        this.eBook = eBook;
    }

    public TxtBook() {

    }

    public EBook getEBook() {
        return eBook;
    }

    public void setEBook(EBook eBook) {
        this.eBook = eBook;
    }

    @Override
    public EBook read() {
        File file = new File(eBook.getPath());
        StringBuilder stringBuilder = new StringBuilder();
        try {
            FileReader reader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(reader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (!TextUtils.isEmpty(stringBuilder)) {
            eBook.setContent(stringBuilder);
        }
        return eBook;
    }

    @Override
    public List<String> getPage(EBook book) {
        return null;
    }
}
