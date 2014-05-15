package org.schedulerjms.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.DateSerializer;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by dSklyarenko on 08.05.14.
 */
public class PeriodicRule implements Serializable{

    private static final long serialVersionUID = -7788619177798333712L;

    private String uniqueId;
    private int ID;
    private String category;
    private Date startDate;
    private int period;
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

    public int getPeriod() {
        return period;
    }

    public void setPeriod(int period) {
        this.period = period;
    }

    public String getDestinationName() {
        return destinationName;
    }

    public void setDestinationName(String destinationName) {
        this.destinationName = destinationName;
    }

    public boolean equals(PeriodicRule periodicRule) {
        if(
                !this.category.equals(periodicRule.getCategory()) ||
                        this.ID != periodicRule.getID() ||
                        this.period != periodicRule.period ||
                        !this.startDate.equals(periodicRule.getStartDate()) ||
                        !this.destinationName.equals(periodicRule.getDestinationName()) ||
                        !this.uniqueId.equals(periodicRule.getUniqueId())
                ) {
            return false;
        }
        return true;
    }

}
