package com.appmojo.sdk.events;


import android.support.annotation.IntDef;

import org.json.JSONObject;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public abstract class AMEvent {

    @IntDef({SESSION, CLICK, IMPRESSION})
    @Retention(RetentionPolicy.SOURCE)
    public @interface Type {}
    public static final int SESSION = 0;
    public static final int CLICK = 1;
    public static final int IMPRESSION = 2;

    protected long id = -1;
    private static final int []  TYPE = new int[]{SESSION, CLICK, IMPRESSION};

    @Type
    public abstract int getType();

    public static int[] getTypes() {
        return TYPE;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    public abstract JSONObject getJsonObject();

}
