package com.hhhxiao.debug;

import java.io.FileWriter;
import java.io.IOException;

public class Utils {
    public static void WriteJson(String fileName,String json) throws IOException {
        FileWriter fileWriter = new FileWriter(fileName);
        fileWriter.write("");
        fileWriter.write(json);
        fileWriter.flush();
        fileWriter.close();
    }
}
