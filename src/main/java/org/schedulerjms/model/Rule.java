package org.schedulerjms.model;

import org.json.JSONObject;

import java.io.Serializable;

/**
 * Created by dSklyarenko on 25.02.14.
 */
public class Rule implements Serializable{

    private static final long serialVersionUID = -7788619177798333712L;

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
