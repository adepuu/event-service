package com.adepuu.eventservice.helpers;

import com.cloudinary.Cloudinary;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Service
public class CloudinaryUploader {

    @Resource
    private Cloudinary cloudinary;

    public String uploadFile(MultipartFile file, String folderName) {
        try {
            byte[] bytes = file.getBytes();
            HashMap<String, Object> options = new HashMap<>();
            options.put("folder", folderName);
            Map<String, Object> uploadedFile = cloudinary.uploader().upload(bytes, options);
            String publicId = (String) uploadedFile.get("public_id");
            return publicId;
        } catch (IOException e) {
            throw new RuntimeException("Failed to read file bytes", e);
        } catch (Exception e) {
            throw new RuntimeException("Failed to upload file to Cloudinary", e);
        }
    }

    public String generateUrl(String publicId) {
        return cloudinary.url().secure(true).generate(publicId);
    }

    public void deleteImage(String publicId) throws IOException {
        try {
            Map<String, Object> result = cloudinary.uploader().destroy(publicId, Map.of());
            System.out.println(result);
        } catch (IOException e) {
            throw new IOException("Failed to delete image from Cloudinary", e);
        } catch (Exception e) {
            throw new RuntimeException("Unexpected error occurred while deleting image", e);
        }
    }
}