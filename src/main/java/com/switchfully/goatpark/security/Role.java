package com.switchfully.goatpark.security;

import com.google.common.collect.Lists;

import java.util.List;

import static com.switchfully.goatpark.security.Feature.*;

public enum Role {
    // replace nulls with features
    MANAGER("manager", CREATE_DIVISION, GET_ALL_MEMBERS, GET_ALL_DIVISIONS, CREATE_PARKING_LOT,GET_ALL_PARKING_LOTS),
    MEMBER("member", DEFAULT);

    private final String label;
    private final List<Feature> featureList;

    Role(String label, Feature... featureList) {
        this.label = label;
        this.featureList = Lists.newArrayList(featureList);
    }

    public List<Feature> getFeatures() {
        return featureList;
    }

    public String getLabel() {
        return label;
    }
}
