package com.example.btnm.quicknotes;

public class Note {
    private String title;
    private int typeIconImageId;
    private String typeIcon;
    private String description;

    public Note(String title, int typeIconImageId, String typeIcon, String description) {
        this.title = title;
        this.typeIconImageId = typeIconImageId;
        this.typeIcon = typeIcon;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getTypeIconImageId() {
        return typeIconImageId;
    }

    public void setTypeIconImageId(int typeIconImageId) {
        this.typeIconImageId = typeIconImageId;
    }

    public String getTypeIcon() {
        return typeIcon;
    }

    public void setTypeIcon(String typeIcon) {
        this.typeIcon = typeIcon;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
