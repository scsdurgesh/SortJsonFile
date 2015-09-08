

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.json.simple.JSONObject;

public class FileWritewithUTF8 {

	public void fileWrite(String path, List<JSONObject> arr, String filename)
	{
		String[] rmExt=filename.split("\\.");
		System.out.println("op path "+path);
		File file=new File(path+"/"+rmExt[0]+".json");
		try {
			FileUtils.writeStringToFile(file, arr.toString(), "utf-8");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.exit(0);
		}
	}
}
