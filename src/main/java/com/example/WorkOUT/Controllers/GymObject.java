package com.example.WorkOUT.Controllers;

import com.programmerare.sweden_crs_transformations_4jvm.CrsCoordinate;

public class GymObject {
    private String name;
    private CrsCoordinate coordinate;
    private String imageID;

    public GymObject(String name, CrsCoordinate coordinate, String imageID){
        this.name = name;
        this.coordinate = coordinate;
        this.imageID = imageID;
    }

    public String getName() {
        return name;
    }

    public double getLat() {
        return coordinate.getLatitudeY();
    }

    public double getLong() {
        return coordinate.getLongitudeX();
    }

    public String getImageID() {
        return imageID;
    }

    @Override
    public String toString() {
        return "com.example.gymtest.GymObjekt{" +
                "name='" + name + '\'' +
                ", lattitude=" + getLat() +
                ", longitude=" + getLong() +
                ", imageID='" + imageID + '\'' +
                '}';
    }
}
