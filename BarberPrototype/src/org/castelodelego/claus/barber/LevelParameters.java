package org.castelodelego.claus.barber;

import java.util.Map;


/**
 * Loads, serves, saves the parameters for a barbershop level. Can be used to create new "levels" or "difficulties" by 
 * setting up the parameters correctly. I probably want to make this serializable and save/load it from XML accordingly.
 * 
 * @author caranha
 */


public class LevelParameters {
	
	Map<String,Double> params;
	
	static String paramname[] = {"HairDistance","HairDistanceVar","HitZoneSize","HitZoneScore",
							      "HitZone2Size","HitZone2Score","BladeSpeed","TimeLimit"};
	static Double paramdefault[] = {};
	

	/**
	 * Get the value of parameter "name"
	 * @param name
	 * @return
	 */
	double getParam(String name)
	{
		return params.get(name);
	}
}
