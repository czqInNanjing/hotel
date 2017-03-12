package cn.edu.nju.controller;

import cn.edu.nju.service.FileService;
import cn.edu.nju.util.SystemDefault;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author Qiang
 * @since 03/03/2017
 */
@Controller
public class FileController {
    private final FileService fileService;
    @Autowired
    public FileController(FileService fileService) {
        this.fileService = fileService;
    }

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> uploadHandler(@RequestParam("file")MultipartFile file){
//        System.out.println(file.getSize());
//        String path = request.getServletContext().getRealPath("/static/img");
        String savedPath = fileService.saveFile(file);


        Map<String, Object> result = new TreeMap<>();
        result.put(SystemDefault.HTTP_RESULT, true);
        result.put("path", savedPath);
        result.put("name", file.getOriginalFilename());
        return result;
    }
}
