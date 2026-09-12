package com.kalatuwagama.controller;

import com.kalatuwagama.dto.CloudinaryUploadResult;
import com.kalatuwagama.service.CloudinaryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Generic image upload endpoint used by the admin panel (gallery "Add
 * Photos" modal, single image fields, etc). Images are uploaded straight
 * to Cloudinary — nothing is written to the local filesystem — and only
 * the resulting secure URL (and public_id) is returned to the caller.
 */
@RestController
@RequestMapping("/api/uploads")
@RequiredArgsConstructor
@Tag(name = "Uploads", description = "Upload images to Cloudinary")
public class UploadController {

	private final CloudinaryService cloudinaryService;

	/**
	 * Single-file upload. Kept byte-for-byte compatible with the previous
	 * contract: multipart field name "file", response body has a "url"
	 * key. A "publicId" field is added on top (existing clients that only
	 * read "url" are unaffected).
	 */
	@PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	@Operation(summary = "Upload a single image to Cloudinary")
	public ResponseEntity<Map<String, String>> upload(@RequestParam("file") MultipartFile file) {
		CloudinaryUploadResult result = cloudinaryService.upload(file);
		return ResponseEntity.status(HttpStatus.CREATED).body(Map.of(
				"url", result.url(),
				"publicId", result.publicId()
		));
	}

	/**
	 * Multi-file upload in a single request — lets a gallery batch of
	 * photos be uploaded in one HTTP round-trip instead of one per image.
	 */
	@PostMapping(value = "/multiple", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	@Operation(summary = "Upload multiple images to Cloudinary in one request")
	public ResponseEntity<List<Map<String, String>>> uploadMultiple(
			@RequestParam("files") List<MultipartFile> files) {
		List<CloudinaryUploadResult> results = cloudinaryService.uploadAll(files);
		List<Map<String, String>> body = results.stream()
				.map(r -> Map.of(
						"url", r.url(),
						"publicId", r.publicId(),
						"originalFilename", r.originalFilename() == null ? "" : r.originalFilename()
				))
				.collect(Collectors.toList());
		return ResponseEntity.status(HttpStatus.CREATED).body(body);
	}
}
