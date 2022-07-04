package AssignmentJava5.utils;

import java.io.File;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class UploadFileUtils {
	public File handleUpLoadFile(MultipartFile uploadFile, String uuid){
		String folderPath="D:\\SpringBoot\\AssignmentJava5\\src\\main\\resources\\static\\images";
		File myUploadFolder=new File(folderPath);
		
		if(!myUploadFolder.exists()) {
			myUploadFolder.mkdirs();
		}
		
		File saveFile=null;
		try {
		
			String fileName=uuid+"_"+uploadFile.getOriginalFilename();
			 saveFile=new File(myUploadFolder,fileName);
			uploadFile.transferTo(saveFile);
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return saveFile;
	}
}