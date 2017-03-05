package cn.edu.nju.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * @author Qiang
 * @since 03/03/2017
 */
public interface FileService {

    /**
     * Return pic url
     * @param file
     * @return
     */
    String saveFile(MultipartFile file);


}
