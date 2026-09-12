package com.kalatuwagama.service;

import com.kalatuwagama.dto.CloudinaryUploadResult;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface CloudinaryService {

    /**
     * Validates and uploads a single image to Cloudinary.
     * Throws BadRequestException on invalid type/size or upload failure.
     */
    CloudinaryUploadResult upload(MultipartFile file);

    /**
     * Validates and uploads multiple images in one call. All files are
     * validated up-front so a bad file fails fast without wasting uploads.
     */
    List<CloudinaryUploadResult> uploadAll(List<MultipartFile> files);

    /**
     * Best-effort delete of the Cloudinary asset backing the given image
     * URL. Silently does nothing if the URL isn't a Cloudinary URL, and
     * never throws — deletion failures are logged, not propagated, so a
     * Cloudinary outage never blocks removing a gallery record.
     */
    void deleteByUrl(String imageUrl);

    /**
     * Extracts the Cloudinary public_id from a secure delivery URL, or
     * null if the URL isn't a Cloudinary URL (e.g. an external/Drive link).
     */
    String extractPublicId(String secureUrl);
}
