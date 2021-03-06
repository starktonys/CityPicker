package com.tony.stark.citypickerview.utils;

import android.content.Context;
import java.io.IOException;
import java.io.InputStream;

/**
 * 读取Assets目录下面的json文件
 * Created by Stark.Tony
 */
public class JAssetsUtils {

  /**
   * 读取Assets目录下面指定文件并返回String数据
   */
  public static String getJsonDataFromAssets(Context context, String fileName) {
    StringBuilder stringBuilder = new StringBuilder();
    InputStream inputStream =
        context.getClass().getClassLoader().getResourceAsStream("assets/" + fileName);
    try {
      byte[] buffer = new byte[inputStream.available()];
      inputStream.read(buffer);
      String json = new String(buffer, "utf-8");
      stringBuilder = stringBuilder.append(json);
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      try {
        inputStream.close();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
    return stringBuilder.toString();
  }
}
