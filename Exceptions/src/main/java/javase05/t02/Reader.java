package javase05.t02;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Reader {

    private Map<String, String> map;
    private String inPath;

    public Reader(String inPath) throws FileNotFoundException, KeyNotFoundException {
        this.inPath = inPath;
        this.map = getMap(this.inPath);
    }

    public String getValue(String key) throws KeyNotFoundException {
        for (String s : map.keySet()) {
            if (!s.equals(key)) {
                throw new KeyNotFoundException("Can't find key");
            }
        }
        return map.get(key);
    }

    private Map<String, String> getMap(String inPath) throws FileNotFoundException, KeyNotFoundException {
        String line = null;
        String[] splitLine;
        map = new HashMap<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(inPath))) {
            while ((line = reader.readLine()) != null) {
                splitLine = line.split("=");
                if (splitLine[0].equals("")) {
                    throw new KeyNotFoundException("Can't find key");
                }
                map.put(splitLine[0], splitLine[1]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return map;
    }
}
