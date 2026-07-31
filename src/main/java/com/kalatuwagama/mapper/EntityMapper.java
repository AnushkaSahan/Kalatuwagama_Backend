package com.kalatuwagama.mapper;

import com.kalatuwagama.dto.*;
import com.kalatuwagama.entity.*;
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
}