package org.schedulerjms.infrastructure.domain;

import org.json.JSONObject;

import java.io.Serializable;

/**
 * Created by dSklyarenko on 07.02.14.
 */
public class JSONMessage extends JSONObject implements Serializable{

    public JSONMessage() {
        this.put("testkey", "testtext");
    }

}
