import com.sun.source.tree.Tree;
import data.Country;
import utils.FileHandler;
import utils.UserInteraction;

import java.io.FileNotFoundException;
import java.util.Map;
import java.util.TreeMap;

public class Tester {

    public static void main(String[] args) throws FileNotFoundException {
        Map<String, Country> countriesDataCollection;

        countriesDataCollection = FileHandler.readFileToMap("countriesData.csv");

        UserInteraction.userAction(countriesDataCollection);
    }
}
