package com.example.hogwarts.service;

import com.example.hogwarts.model.Avatar;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface AvatarService {
    void uploadAvatar (Long studentId , MultipartFile avatarFile) throws IOException;

    Avatar findAvatar (Long studentId );
}
