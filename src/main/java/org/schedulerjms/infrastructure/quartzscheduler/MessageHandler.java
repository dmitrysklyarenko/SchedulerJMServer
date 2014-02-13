package org.schedulerjms.infrastructure.quartzscheduler;

import org.json.JSONObject;

/**
 * Created by dSklyarenko on 13.02.14.
 */
public interface MessageHandler {

    public void handleMessage(JSONObject jsonObject);

}
