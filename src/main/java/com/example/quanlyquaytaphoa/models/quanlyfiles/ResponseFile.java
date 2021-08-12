package com.example.quanlyquaytaphoa.models.quanlyfiles;

public class ResponseFile {
    private String id;
    private String name;
    private String url;
    private String type;
    private long size;
    private String path;

    public ResponseFile() {
    }

    public ResponseFile(String id, String name, String url, String type, long size, String path) {
        this.id = id;
        this.name = name;
        this.url = url;
        this.type = type;
        this.size = size;
        this.path = path;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
