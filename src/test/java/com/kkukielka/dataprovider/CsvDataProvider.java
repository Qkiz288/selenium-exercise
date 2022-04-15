package com.kkukielka.dataprovider;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import org.testng.annotations.DataProvider;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.*;

public class CsvDataProvider {

    @DataProvider(name = "CsvDataProvider")
    public static Iterator<Object[]> provideData(Method method) {
        List<Object[]> list = new ArrayList<>();
        String pathName = "src" + File.separator + "test" + File.separator + "resources" + File.separator
                + "test_data" + File.separator + method.getDeclaringClass().getSimpleName()
                + "_" +method.getName() + ".csv";

        File file = new File(pathName);
        try {
            CSVReader reader = new CSVReader(new FileReader(file));
            String[] keys = reader.readNext();
            if (Objects.nonNull(keys)) {
                String[] dataParts;
                while (Objects.nonNull((dataParts = reader.readNext()))) {
                    Map<String, String> testData = new HashMap<>();
                    for (int i = 0; i < keys.length; i++) {
                        testData.put(keys[i], dataParts[i]);
                    }
                    list.add(new Object[] { testData });
                }
            }
        } catch (CsvValidationException | IOException e) {
            e.printStackTrace();
        }

        return list.iterator();
    }
}
