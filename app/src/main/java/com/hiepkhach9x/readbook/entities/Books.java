package com.hiepkhach9x.readbook.entities;

import java.util.List;

/**
 * Created by HungHN on 2/1/2016.
 */
public interface Books {

    public EBook read();
    public List<String> getPage(EBook book);

}
