package com.pinyougou.manager.controller;

import org.apache.commons.io.FilenameUtils;
import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.StorageClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.Map;

@RestController
public class UploadFileController {

    @Value("${fileServerUrl}")
    private String fileServerUrl;

    @PostMapping("/upload")
    public Map<String, String> uploadFile(@RequestParam("file") MultipartFile multipartFile) {
        Map<String, String> data = new HashMap<>();
        try {
            String conf_fileName = this.getClass().getResource("/fastdfs_client.conf").getPath();
            ClientGlobal.init(conf_fileName);
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
