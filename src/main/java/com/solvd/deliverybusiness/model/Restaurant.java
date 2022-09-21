package com.solvd.deliverybusiness.model;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlTransient;

@XmlRootElement(name="restaurant")
public class Restaurant {
    private int id;
    private String name;
    private boolean isActive;
    private String description;
    private int cityID;

    public Restaurant() {
    }

    public Restaurant(int id, String name, boolean isActive, String description, int cityID) {
        this.id = id;
        this.name = name;
        this.isActive = isActive;
        this.description = description;
        this.cityID = cityID;
    }

    public int getId() {
        return id;
    }
    @XmlElement (name="ID")
    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    @XmlElement (name="Name")
    public void setName(String name) {
        this.name = name;
    }

    public boolean isActive() {
        return isActive;
    }
    @XmlTransient
    public void setActive(boolean active) {
        isActive = active;
    }

    public String getDescription() {
        return description;
    }
    @XmlTransient
    public void setDescription(String description) {
        this.description = description;
    }

    public int getCityID() {
        return cityID;
    }
    @XmlElement (name="City_ID")
    public void setCityID(int cityID) {
        this.cityID = cityID;
    }

    @Override
    public String toString() {
        return "Restaurant{" +
                "ID=" + id +
                ", name='" + name + '\'' +
                ", isActive=" + isActive +
                ", description='" + description + '\'' +
                ", cityID=" + cityID +
                '}';
    }
}
