package com.neo.mapper;

import com.neo.model.Individual;

import java.util.List;
import java.util.Map;

public interface QueryMapper {
    int getUserId(Map map_getUserId);

    Map getindividualprofile(Map map);

    List<Individual> getUserindividual(Map map_getUserindividual);

    Map getindividualShortTalent(Map map);

    Map getExampleFigure(Map map);
}


