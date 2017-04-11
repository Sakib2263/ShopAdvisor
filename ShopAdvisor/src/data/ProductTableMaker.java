package data;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ProductTableMaker {

    public static ObservableList<Product> getProduct(String fileName) throws FileNotFoundException, IOException {

        ObservableList<Product> products = FXCollections.observableArrayList();

        FileReader CSVFile = new FileReader("data/" + fileName + ".csv");
        Scanner sc = new Scanner(CSVFile);

        while (sc.hasNext()) {
            String dataRow = sc.nextLine();
            String[] dataArray = dataRow.split(",");
            if (dataArray.length != 2) {
                continue;
            }
            //System.out.println(dataArray[0] + " " + dataArray[1]);
            products.add(new Product(fileName, dataArray[0], Double.parseDouble(dataArray[1])));
        }

        return products;
    }
}
