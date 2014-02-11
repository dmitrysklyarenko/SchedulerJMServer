package org.schedulerjms.infrastructure.json;

import org.json.JSONObject;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by dSklyarenko on 07.02.14.
 */
public class JSONObjectFactory extends JSONObject{

    public JSONObject addPointJob(String category, Integer id, Date runDate) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("category", category);
        jsonObject.put("id", id);
        jsonObject.put("command", "add");
        jsonObject.put("jobType", "point");
        jsonObject.put("runDate", runDate);
        return jsonObject;
    }

    public JSONObject addPeriodicJob(String category, Integer id, Date runDate) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("category", category);
        jsonObject.put("id", id);
        jsonObject.put("command", "add");
        jsonObject.put("jobType", "periodic");
        jsonObject.put("runDate", runDate);
        return jsonObject;
    }

    public JSONObject deleteJob(String category, Integer id) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("category", category);
        jsonObject.put("id", id);
        jsonObject.put("command", "delete");
        return jsonObject;
    }

}
