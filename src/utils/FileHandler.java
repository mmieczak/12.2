package utils;

import data.Country;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class FileHandler {
    public static final String SEPARATOR = ";";
    public static final byte READ_SEPARATED_VALUES_FROM_LINE = 3;

    public static Map<String, Country> readFileToMap(String fileName) throws FileNotFoundException {
        Map<String, Country> countriesData = new TreeMap<>();
        Country country;
        int linesNumber = 0;

        File file = new File(fileName);
        Scanner scan = new Scanner(file);

        while (scan.hasNext()) {
            linesNumber++;
            try {
                String[] lineValues = scan.nextLine().split(SEPARATOR);
                if (lineValues.length < READ_SEPARATED_VALUES_FROM_LINE) throw new IllegalArgumentException("Unrecognized separator");
                createMapForCountries(lineValues, countriesData);
            } catch (IllegalArgumentException ex) {
                System.err.println("Wrong data format in line " + linesNumber);
            }
        }
        scan.close();
        return countriesData;
    }

    private static void createMapForCountries(String[] lineValues, Map<String, Country> countriesCollection) {
        String countryCode = lineValues[0];
        String countryName = lineValues[1];
        if (!StringUtils.isNumeric(lineValues[2])) throw new IllegalArgumentException("Unable to parse population :");
        long population = Long.parseLong(lineValues[2]);
        Country country = new Country(countryCode, countryName, population);
        countriesCollection.put(countryCode, country);
    }

}
