package utils;

public class PayloadUtils {
    public static String commentsEndpoint(String message) {

        return "{\"name\": \"name lastName\",\"gender\": \"gender\",\"email\": \"email@15ce.com\",\"status\": \"Active\"}";
    }
    public static String getPayLoad(){

return "{\n" +
        "\"name\": \"Bejan\"\n" +
        ",\n" +
        "\"gender\": \"Male\"\n" +
        ",\n" +
        "\"email\": \"gbejan31@yahoo.com\"\n" +
        ",\n" +
        "\"status\": \"Active\"\n" +
        "}";
    }
    public static String updatePayload(){

        return "{\n" +
                "\"name\": \"Bejan\"\n" +
                ",\n" +
                "\"gender\": \"Male\"\n" +
                ",\n" +
                "\"email\": \"gbejan31@gmail.com\"\n" +
                ",\n" +
                "\"status\": \"Active\"\n" +
                "}";
    }
}