package cn.edu.nju.service.impl;

import cn.edu.nju.service.FileService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * @author Qiang
 * @since 03/03/2017
 */
@Service
public class FileServiceImpl implements FileService {
    @Override
    public String saveFile(MultipartFile file) {

        String resultPath = "/Users/czq/Development/j2ee_hotel/src/main/resources/static/img/upload/";
        if(!file.isEmpty()){
            String picUrl = System.currentTimeMillis()+ file.getOriginalFilename();

//            String filePath = request.getSession().getServletContext().getRealPath("/static/img/");
//            System.out.println(path+picUrl);
            try {
                File image = new File(resultPath,picUrl);
                if (!image.exists()) {
                    image.createNewFile();
                }
                file.transferTo(image);
                resultPath += picUrl;

//                return image;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return resultPath.substring(resultPath.indexOf("/img"));

    }
}
