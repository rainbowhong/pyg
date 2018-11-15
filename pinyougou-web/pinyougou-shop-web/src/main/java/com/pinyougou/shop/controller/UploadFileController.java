package com.pinyougou.shop.controller;

import org.apache.commons.io.FilenameUtils;
import org.csource.common.MyException;
import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.StorageClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Author: rainbow
 * Description:
 * Date:Create in 21:26 2018/11/6
 * Modified By:
 */
@RestController
public class UploadFileController {


    @Value("${fileServerUrl}")
    private String fileServerUrl;

    @PostMapping("/upload")
    public Map<String, String> uploadFile(@RequestParam("file") MultipartFile multipartFile) {
        Map<String, String> data = new HashMap<>();
        data.put("status", "500");
        try {
            String conf_filename = this.getClass().getResource("/fastdfs_client.conf").getPath();
            ClientGlobal.init(conf_filename);
            StorageClient storageClient = new StorageClient();
            String originalFileName = multipartFile.getOriginalFilename();
            String[] arr = storageClient.upload_file(multipartFile.getBytes(), FilenameUtils.getExtension(originalFileName), null);
            StringBuilder url = new StringBuilder(fileServerUrl);
            for (String s : arr) {
                url.append("/" + s);
            }
            data.put("url", url.toString());
            data.put("status", "200");
        } catch (Exception e) {
            e.printStackTrace();
        }

        return data;
    }
}
