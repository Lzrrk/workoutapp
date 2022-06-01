package com.example.WorkOUT.Class;

import com.programmerare.sweden_crs_transformations_4jvm.CrsCoordinate;

public class GymObject {

    // Gym variables
    private final String name;
    private final CrsCoordinate coordinate;
    private final String imageID;

    // Gym constructor
    public GymObject(String name, CrsCoordinate coordinate, String imageID) {
        this.name = name;
        this.coordinate = coordinate;
        this.imageID = imageID;
    }

    //Getters
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

    // toString method for GymObject
    @Override
    public String toString() {
        return "Gym {" +
                "name = " + name +
                ", latitude = " + getLat() +
                ", longitude = " + getLong() +
                ", imageID = " + imageID + "}\n";
    }
}
