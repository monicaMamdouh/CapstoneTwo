package com.example.monica.capstonetwo.model; ;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ChildrenList {

    @SerializedName("kind")
    @Expose
    private String kind;
    @SerializedName("data")
    @Expose
    private Data data;

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public ChildrenList withKind(String kind) {
        this.kind = kind;
        return this;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public ChildrenList withData(Data data) {
        this.data = data;
        return this;
    }

}