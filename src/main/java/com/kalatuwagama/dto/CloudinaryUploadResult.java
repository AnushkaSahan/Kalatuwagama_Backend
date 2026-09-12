package com.kalatuwagama.dto;

/**
 * Result of a single Cloudinary upload.
 *
 * @param url               the secure (https) delivery URL — this is what gets stored in Postgres
 * @param publicId          the Cloudinary public_id — needed later to delete the asset
 * @param originalFilename  original filename as received from the client, for display/logging only
 */
public record CloudinaryUploadResult(String url, String publicId, String originalFilename) {}
