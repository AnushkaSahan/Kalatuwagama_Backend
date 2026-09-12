package com.kalatuwagama.service.impl;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.kalatuwagama.dto.CloudinaryUploadResult;
import com.kalatuwagama.exception.BadRequestException;
import com.kalatuwagama.service.CloudinaryService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CloudinaryServiceImpl implements CloudinaryService {

    private static final Logger log = LoggerFactory.getLogger(CloudinaryServiceImpl.class);

    // Images only — matches what the admin panel's file picker already
    // restricts to (accept="image/*"), enforced again server-side.
    private static final Set<String> ALLOWED_CONTENT_TYPES = Set.of(
            "image/jpeg", "image/jpg", "image/png", "image/webp", "image/gif"
    );

    private final Cloudinary cloudinary;

    @Value("${cloudinary.upload-folder:kalatuwagama/gallery}")
    private String uploadFolder;

    @Value("${app.upload.max-file-size-mb:10}")
    private long maxFileSizeMb;

    @Override
    public CloudinaryUploadResult upload(MultipartFile file) {
        validate(file);
        try {
            @SuppressWarnings("unchecked")
            Map<String, Object> result = cloudinary.uploader().upload(
                    file.getBytes(),
                    ObjectUtils.asMap(
                            "folder", uploadFolder,
                            "resource_type", "image",
                            "unique_filename", true,
                            "overwrite", false
                    )
            );
            String url = (String) result.get("secure_url");
            String publicId = (String) result.get("public_id");
            return new CloudinaryUploadResult(url, publicId, file.getOriginalFilename());
        } catch (IOException e) {
            log.error("Cloudinary upload failed for file '{}': {}", file.getOriginalFilename(), e.getMessage());
            throw new BadRequestException("Failed to upload image. Please try again.");
        }
    }

    @Override
    public List<CloudinaryUploadResult> uploadAll(List<MultipartFile> files) {
        if (files == null || files.isEmpty()) {
            throw new BadRequestException("At least one image file is required");
        }
        // Validate every file up-front so we fail fast instead of partially
        // uploading a batch when only the last file is invalid.
        files.forEach(this::validate);
        return files.stream().map(this::upload).collect(Collectors.toList());
    }

    @Override
    public void deleteByUrl(String imageUrl) {
        String publicId = extractPublicId(imageUrl);
        if (publicId == null) {
            return;
        }
        try {
            cloudinary.uploader().destroy(publicId, ObjectUtils.emptyMap());
        } catch (Exception e) {
            // Never let a Cloudinary hiccup block a gallery delete/update —
            // log it so it can be cleaned up manually if needed.
            log.warn("Failed to delete Cloudinary asset '{}': {}", publicId, e.getMessage());
        }
    }

    @Override
    public String extractPublicId(String secureUrl) {
        if (secureUrl == null || !secureUrl.contains("res.cloudinary.com")) {
            return null;
        }
        try {
            String marker = "/upload/";
            int idx = secureUrl.indexOf(marker);
            if (idx == -1) {
                return null;
            }
            String afterUpload = secureUrl.substring(idx + marker.length());
            String[] segments = afterUpload.split("/");

            int start = 0;
            // Skip transformation and/or version segments, e.g. "v1700000000".
            // Version is always the last non-transformation segment before
            // the folder/public_id path, and always matches v<digits>.
            for (int i = 0; i < segments.length; i++) {
                if (segments[i].matches("v\\d+")) {
                    start = i + 1;
                    break;
                }
            }

            String pathWithExt = String.join("/", Arrays.copyOfRange(segments, start, segments.length));
            int dotIdx = pathWithExt.lastIndexOf('.');
            return dotIdx > 0 ? pathWithExt.substring(0, dotIdx) : pathWithExt;
        } catch (Exception e) {
            log.warn("Could not extract Cloudinary public_id from url '{}': {}", secureUrl, e.getMessage());
            return null;
        }
    }

    private void validate(MultipartFile file) {
        if (file == null || file.isEmpty()) {
            throw new BadRequestException("File is required");
        }
        String contentType = file.getContentType();
        if (contentType == null || !ALLOWED_CONTENT_TYPES.contains(contentType.toLowerCase())) {
            throw new BadRequestException(
                    "Unsupported image type '" + contentType + "'. Allowed types: JPEG, PNG, WEBP, GIF");
        }
        long maxBytes = maxFileSizeMb * 1024 * 1024;
        if (file.getSize() > maxBytes) {
            throw new BadRequestException("Image '" + file.getOriginalFilename()
                    + "' exceeds the maximum size of " + maxFileSizeMb + "MB");
        }
    }
}
