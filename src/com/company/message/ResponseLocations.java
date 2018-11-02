package com.company.message;

public class ResponseLocations {
    private String[] locations;

    /**
     *
     * @param locations the location list
     */
    public ResponseLocations(String[] locations) {
        this.locations = locations;
    }

    /**
     * get the locations
     * @return list of locations
     */
    public String[] getLocations() {
        return locations;
    }
}
