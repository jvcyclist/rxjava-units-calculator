package pl.edu.utp;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {

         Converter converter = new Converter();

        try {
            converter.getParametersFromUserInput();
        }
        catch(IOException error){
            System.out.println("Error error: " + error.getLocalizedMessage());

        }

        System.out.println("Unit Type: " + converter.unitType.toUpperCase()
                + ", Unit of measure: " + converter.unitOfMeasure
                + ", Value: " + converter.measureValue
        );

        converter.initialize();

        converter.observable.subscribe(e -> {e.forEach((unitName, convertedValue) ->{
            System.out.println("Unit name: " + unitName + " Value: " + convertedValue);
        } );});


    }

}
