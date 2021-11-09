package test;

import util.JsonTransformation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class JsonTest {
    public static void main(String[] args) {
        JsonTransformation jt = new JsonTransformation();
        Map<String, Integer> stringIntegerHashMap = new HashMap<>();
        stringIntegerHashMap.put("key1",1);
        stringIntegerHashMap.put("key2",2);
        stringIntegerHashMap.put("key3",3);
        stringIntegerHashMap.put("key4",4);
        System.out.println(jt.MapToJson(stringIntegerHashMap));
    }
}
