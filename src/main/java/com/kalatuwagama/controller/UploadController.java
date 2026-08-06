package com.kalatuwagama.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/api/uploads")
public class UploadController {

	@PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity<Map<String, String>> upload(@RequestParam("file") MultipartFile file) throws IOException {
		if (file.isEmpty()) {
			return ResponseEntity.badRequest().body(Map.of("message", "File is required"));
		}

		String contentType = file.getContentType();
		if (contentType == null || !contentType.startsWith("image/")) {
			return ResponseEntity.badRequest().body(Map.of("message", "Please upload an image file"));
		}

		Path uploadDir = Paths.get(System.getProperty("user.dir"), "uploads").toAbsolutePath().normalize();
		Files.createDirectories(uploadDir);

		String originalName = StringUtils.cleanPath(file.getOriginalFilename() == null ? "image" : file.getOriginalFilename());
		String extension = "";
		int dotIndex = originalName.lastIndexOf('.');
		if (dotIndex >= 0) {
			extension = originalName.substring(dotIndex);
		}

		String filename = UUID.randomUUID() + extension;
		Path target = uploadDir.resolve(filename);
		Files.copy(file.getInputStream(), target);

		String url = ServletUriComponentsBuilder.fromCurrentContextPath()
				.path("/uploads/")
				.path(filename)
				.toUriString();

		return ResponseEntity.status(HttpStatus.CREATED).body(Map.of("url", url));
	}
}
