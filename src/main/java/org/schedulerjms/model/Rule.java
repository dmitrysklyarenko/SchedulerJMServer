package org.schedulerjms.model;

import org.json.JSONObject;

/**
 * Created by dSklyarenko on 25.02.14.
 */
public class Rule{

    private String category;
    private int ID;

    public Rule(String category, int ID) {
        this.category = category;
        this.ID = ID;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }
}
