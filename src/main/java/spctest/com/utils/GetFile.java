package spctest.com.utils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

public class  GetFile {

	public static String getFileContent(String styleName){
		String content ="";
	String projectNameAddress="E:\\Data\\"+styleName+"name.txt";
	File file = new File(projectNameAddress);
    try {
       content = FileUtils.readFileToString(file);
    } catch (IOException e) {
        e.printStackTrace();
    }
    return content;
	}
}
