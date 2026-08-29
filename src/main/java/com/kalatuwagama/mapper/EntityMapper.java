package com.kalatuwagama.mapper;

import com.kalatuwagama.dto.*;
import com.kalatuwagama.entity.*;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface EntityMapper {

    // TempleHistory
    TempleHistoryDto toDto(TempleHistory entity);
    TempleHistory toEntity(TempleHistoryDto dto);
    void updateEntity(TempleHistoryDto dto, @MappingTarget TempleHistory entity);

    // Monk
    MonkDto toDto(Monk entity);
    Monk toEntity(MonkDto dto);
    void updateEntity(MonkDto dto, @MappingTarget Monk entity);

    // Event
    EventDto toDto(Event entity);
    Event toEntity(EventDto dto);
    void updateEntity(EventDto dto, @MappingTarget Event entity);

    // Gallery
    GalleryDto toDto(Gallery entity);
    Gallery toEntity(GalleryDto dto);
    void updateEntity(GalleryDto dto, @MappingTarget Gallery entity);

    // Announcement
    AnnouncementDto toDto(Announcement entity);
    Announcement toEntity(AnnouncementDto dto);
    void updateEntity(AnnouncementDto dto, @MappingTarget Announcement entity);

    // DonationInfo
    DonationInfoDto toDto(DonationInfo entity);
    DonationInfo toEntity(DonationInfoDto dto);
    void updateEntity(DonationInfoDto dto, @MappingTarget DonationInfo entity);

    // DahamPasalaInfo
    DahamPasalaInfoDto toDto(DahamPasalaInfo entity);
    DahamPasalaInfo toEntity(DahamPasalaInfoDto dto);
    void updateEntity(DahamPasalaInfoDto dto, @MappingTarget DahamPasalaInfo entity);

    // ContactMessage
    ContactMessageDto toDto(ContactMessage entity);
    ContactMessage toEntity(ContactMessageDto dto);
    void updateEntity(ContactMessageDto dto, @MappingTarget ContactMessage entity);

    // Teacher
    TeacherDto toDto(Teacher entity);
    Teacher toEntity(TeacherDto dto);
    void updateEntity(TeacherDto dto, @MappingTarget Teacher entity);

    // Student
    StudentDto toDto(Student entity);
    Student toEntity(StudentDto dto);
    void updateEntity(StudentDto dto, @MappingTarget Student entity);

    // FoundationProject
    FoundationProjectDto toDto(FoundationProject entity);
    FoundationProject toEntity(FoundationProjectDto dto);
    void updateEntity(FoundationProjectDto dto, @MappingTarget FoundationProject entity);

    // User - note: password is ignored in update to avoid accidental override
    UserDto toUserDto(User entity);
    User toEntity(UserDto dto);
    @Mapping(target = "password", ignore = true)
    void updateEntity(UserDto dto, @MappingTarget User entity);

    // Normalize imageFit to "cover" when null (existing records / missing value)
    @AfterMapping
    default void normalizeEventImageFit(Event entity, @MappingTarget EventDto dto) {
        if (dto.imageFit() == null) dto = new EventDto(dto.id(), dto.title(), dto.description(), dto.location(), dto.eventDate(), dto.imageUrl(), "cover", dto.createdAt(), dto.updatedAt());
    }

    @AfterMapping
    default void normalizeMonkImageFit(Monk entity, @MappingTarget MonkDto dto) {
        if (dto.imageFit() == null) dto = new MonkDto(dto.id(), dto.name(), dto.position(), dto.biography(), dto.imageUrl(), "cover", dto.createdAt(), dto.updatedAt());
    }

    @AfterMapping
    default void normalizeTeacherImageFit(Teacher entity, @MappingTarget TeacherDto dto) {
        if (dto.imageFit() == null) dto = new TeacherDto(dto.id(), dto.name(), dto.position(), dto.phone(), dto.imageUrl(), "cover", dto.createdAt(), dto.updatedAt());
    }

    @AfterMapping
    default void normalizeTempleHistoryImageFit(TempleHistory entity, @MappingTarget TempleHistoryDto dto) {
        if (dto.imageFit() == null) dto = new TempleHistoryDto(dto.id(), dto.title(), dto.description(), dto.imageUrl(), "cover", dto.createdAt(), dto.updatedAt());
    }

    @AfterMapping
    default void normalizeFoundationProjectImageFit(FoundationProject entity, @MappingTarget FoundationProjectDto dto) {
        if (dto.imageFit() == null) dto = new FoundationProjectDto(dto.id(), dto.title(), dto.description(), dto.startDate(), dto.endDate(), dto.imageUrl(), "cover");
    }

    @AfterMapping
    default void normalizeDonationInfoImageFit(DonationInfo entity, @MappingTarget DonationInfoDto dto) {
        if (dto.imageFit() == null) dto = new DonationInfoDto(dto.id(), dto.bankName(), dto.accountName(), dto.accountNumber(), dto.branch(), dto.qrImage(), "cover");
    }

    @AfterMapping
    default void normalizeDahamPasalaInfoImageFit(DahamPasalaInfo entity, @MappingTarget DahamPasalaInfoDto dto) {
        if (dto.imageFit() == null) dto = new DahamPasalaInfoDto(dto.id(), dto.introImage(), "cover", dto.createdAt(), dto.updatedAt());
    }

    @AfterMapping
    default void normalizeGalleryImageFit(Gallery entity, @MappingTarget GalleryDto dto) {
        if (dto.imageFit() == null) dto = new GalleryDto(dto.id(), dto.eventId(), dto.imageUrl(), dto.title(), dto.category(), "cover", dto.createdAt(), dto.updatedAt());
    }

    // Ensure entity imageFit defaults to cover on create/update when missing
    @AfterMapping
    default void ensureEventImageFit(EventDto dto, @MappingTarget Event entity) {
        if (entity.getImageFit() == null) entity.setImageFit("cover");
    }

    @AfterMapping
    default void ensureMonkImageFit(MonkDto dto, @MappingTarget Monk entity) {
        if (entity.getImageFit() == null) entity.setImageFit("cover");
    }

    @AfterMapping
    default void ensureTeacherImageFit(TeacherDto dto, @MappingTarget Teacher entity) {
        if (entity.getImageFit() == null) entity.setImageFit("cover");
    }

    @AfterMapping
    default void ensureTempleHistoryImageFit(TempleHistoryDto dto, @MappingTarget TempleHistory entity) {
        if (entity.getImageFit() == null) entity.setImageFit("cover");
    }

    @AfterMapping
    default void ensureFoundationProjectImageFit(FoundationProjectDto dto, @MappingTarget FoundationProject entity) {
        if (entity.getImageFit() == null) entity.setImageFit("cover");
    }

    @AfterMapping
    default void ensureDonationInfoImageFit(DonationInfoDto dto, @MappingTarget DonationInfo entity) {
        if (entity.getImageFit() == null) entity.setImageFit("cover");
    }

    @AfterMapping
    default void ensureGalleryImageFit(GalleryDto dto, @MappingTarget Gallery entity) {
        if (entity.getImageFit() == null) entity.setImageFit("cover");
    }

    @AfterMapping
    default void ensureDahamPasalaInfoImageFit(DahamPasalaInfoDto dto, @MappingTarget DahamPasalaInfo entity) {
        if (entity.getImageFit() == null) entity.setImageFit("cover");
    }
}