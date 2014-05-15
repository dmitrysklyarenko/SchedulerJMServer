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

    private String uniqueId;
    private int ID;
    private String category;
    private Date startDate;
    private String destinationName;

    public void setUniqueId() {
        this.uniqueId = this.category + this.ID;
    }

    public String getUniqueId() {
        return this.uniqueId;
    }

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

    public boolean equals(PointRule pointRule) {
        if(
                !this.category.equals(pointRule.getCategory()) ||
                this.ID != pointRule.getID() ||
                !this.startDate.equals(pointRule.getStartDate()) ||
                !this.destinationName.equals(pointRule.getDestinationName()) ||
                !this.uniqueId.equals(pointRule.getUniqueId())
        ) {
            return false;
        }
        return true;
    }
}
