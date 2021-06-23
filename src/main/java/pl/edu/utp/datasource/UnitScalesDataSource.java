package pl.edu.utp.datasource;

import java.util.HashMap;
import java.util.Map;

public class UnitScalesDataSource {

    public Map<String, Map<String,Double>> measuresTypesEntries = new HashMap<String, Map<String,Double>>();
    public Map<String, String> baseMeasures = new HashMap<String, String>();


    public UnitScalesDataSource(){
        initializeUnits();
    }

    void initializeUnits(){
        //Base Unit Measures
        baseMeasures.put("length","m");
        baseMeasures.put("time","s");
        baseMeasures.put("temperature","K");
        baseMeasures.put("weight","kg");

        //Length
        Map<String,Double> lengthMeasures = new HashMap<String, Double>();
        lengthMeasures.put("mm",0.001);
        lengthMeasures.put("cm",0.01);
        lengthMeasures.put("dm",0.1);
        lengthMeasures.put("m",1.0);
        lengthMeasures.put("km",1000.0);

        measuresTypesEntries.put("length",lengthMeasures);

        //time
        Map<String,Double> timeMeasures = new HashMap<String, Double>();
        timeMeasures.put("h",3600.0);
        timeMeasures.put("m",60.0);
        timeMeasures.put("s",1.0);
        timeMeasures.put("ss",0.01);
        timeMeasures.put("ms",0.001);
        timeMeasures.put("ss",0.01);

        measuresTypesEntries.put("time",timeMeasures);

        //   ...

        Map<String,Double> temperatureMeasures = new HashMap<String, Double>();
        temperatureMeasures.put("K",1.0);
        temperatureMeasures.put("C",-272.2);
        temperatureMeasures.put("F",-457.9);
        temperatureMeasures.put("R",1.8);
        temperatureMeasures.put("N",-89.81);

        measuresTypesEntries.put("temperature",temperatureMeasures);

        Map<String,Double> weightMeasures = new HashMap<String, Double>();

        weightMeasures.put("Kilogram",1.0);
        weightMeasures.put("Gram",1.0);
        weightMeasures.put("Deka gram",1.0);
        weightMeasures.put("Milligram",1.0);
        weightMeasures.put("dalton",1.0);
        weightMeasures.put("slug",1.0);
        weightMeasures.put("pound",1.0);
        weightMeasures.put("ounce",1.0);
        weightMeasures.put("quarter (US)",1.0);
        weightMeasures.put("Quarter (UK)",1.0);
        weightMeasures.put("Carat",1.0);
        weightMeasures.put("Gamma",1.0);
        weightMeasures.put("Planck mass",1.0);
        weightMeasures.put("Atomic mass unit",1.0);
        weightMeasures.put("Electron mass",1.0);
        weightMeasures.put("Proton mass",1.0);
        weightMeasures.put("Neutron mass",1.0);
        weightMeasures.put("Deutron mass",1.0);
        weightMeasures.put("Tona",1.0);



    }
}
