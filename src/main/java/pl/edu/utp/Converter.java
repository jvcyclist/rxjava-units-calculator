package pl.edu.utp;

import io.reactivex.Observable;
import pl.edu.utp.datasource.UnitScalesDataSource;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.*;

public class Converter {

    String unitType = getUnitType();
    String unitOfMeasure = getUnitOfMeasure();
    double measureValue = getMeasureValue();
    Map<String, Double> resultList = new HashMap<>();
    UnitScalesDataSource usds;
    double scale;
    Observable<Map<String, Double>> observable;

    void getParametersFromUserInput() throws IOException {

        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in));

        //For user input
        /*
        System.out.println("Provide unit type: ");
        String unitType = reader.readLine();

        System.out.println("Provide unit of measure: ");
        String unitOfMeasure = reader.readLine();

        System.out.println("Provide value of measure to convert: ");
        String measureValue = reader.readLine();

        System.out.println("Summary - UnitType: " + unitType + ", unit of measure: " + unitOfMeasure + " , measure value: " + measureValue);
        */

        unitType = getUnitType();
        unitOfMeasure = getUnitOfMeasure();
        measureValue = getMeasureValue();
    }

    void initialize() {

        usds = new UnitScalesDataSource();

        scale = usds.measuresTypesEntries
                .get(unitType)
                .get(unitOfMeasure);

        observable = Observable.just(calculateAndReturnResult());

    }

    Map<String, Double> calculateAndReturnResult(){

        if (!usds.baseMeasures.get(unitType).equals(unitOfMeasure)) {

            if(unitType.equals("temperature")){
                measureValue = measureValue / scale;
            }
            else{
                measureValue = measureValue * scale;
            }

        }
        double baseOfCalculation = measureValue;


        usds.measuresTypesEntries.get(unitType)
                .entrySet()
                .forEach(e -> {

                    if(unitType.equals("temperature")){
                        resultList.put(e.getKey(), baseOfCalculation * e.getValue());
                    }
                    else {
                        resultList.put(e.getKey(), baseOfCalculation / e.getValue());
                    }
                });

        return resultList;

    }

    //Mocks of User Input
    String getUnitType(){
       // return "temperature";
        return "length";
    }

    String getUnitOfMeasure(){
        return "mm";
    }

    double getMeasureValue(){
        return 1000.0;
    }

}
