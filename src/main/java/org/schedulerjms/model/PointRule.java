package org.schedulerjms.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.DateSerializer;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by dSklyarenko on 08.05.14.
 */
public class PointRule implements Serializable{

    private static final long serialVersionUID = -7788619177798333712L;

    private int ID;
    private String category;
    private Date startDate;
    private String destinationName;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @JsonSerialize(using=DateSerializer.class)
    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(long startDate) {
        this.startDate = new Date(startDate);
    }

    public String getDestinationName() {
        return destinationName;
    }

    public void setDestinationName(String destinationName) {
        this.destinationName = destinationName;
    }

}
