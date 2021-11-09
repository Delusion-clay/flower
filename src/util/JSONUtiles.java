package util;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.List;
import java.util.Map;

/**
 * @describe json工具类
 */
public class JSONUtiles {
    public static Gson gson;
    static {
        gson = new Gson();
    }

    /**
     * javaBean转换成json
     * @param obj javaBean类
     * @return 返回一个json字符串
     */
    public static String toJson(Object obj){
        return gson.toJson(obj);
    }

    /**
     * json字符串转换成javaBean对象
     * @param jsonString json字符串
     * @param type 返回的javaBean类型
     * @param <T> javaBean的泛型
     * @return 返回一个javaBean
     */
    public static <T> T jsonToBean(String jsonString,Class<T> type){
        return gson.fromJson(jsonString,type);
    }

    /**
     * json字符串转换成List集合
     * @param jsonString json字符串
     * @param type 返回集合元素的javaBean类型
     * @param <T>  返回集合元素的javaBean的泛型
     * @return 返回一个List集合
     */
    public static <T> List<T> jsonToList(String jsonString,Class<T> type){
        return gson.fromJson(jsonString,new TypeToken<List<T>>(){}.getType());
    }

    /**
     * json字符串转换成Map集合
     * @param jsonString json字符串
     * @param keyType Map键的类型
     * @param valueType Map值的类型
     * @param <T> Map键的泛型
     * @param <Y> Map值的泛型
     * @return 返回一个Map集合
     */
    public static <T,Y> Map<T,Y> jsonToMap(String jsonString , Class<T> keyType , Class<Y> valueType){
        return gson.fromJson(jsonString,new TypeToken<Map<T,Y>>(){}.getType());
    }
}
