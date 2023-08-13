//package com.example.hogwarts.service;
//
//import com.example.hogwarts.model.Avatar;
//import com.example.hogwarts.model.Student;
//import com.example.hogwarts.repositories.AvatarRepository;
//import com.example.hogwarts.repositories.StudentRepository;
//import jakarta.transaction.Transactional;
//import lombok.Value;
//import org.springframework.stereotype.Service;
//import org.springframework.web.multipart.MultipartFile;
//
//import javax.imageio.ImageIO;
//import java.awt.*;
//import java.awt.image.BufferedImage;
//import java.io.*;
//import java.nio.file.Files;
//import java.nio.file.Path;
//
//import static java.nio.file.StandardOpenOption.CREATE_NEW;
//import static jdk.jpackage.internal.IOUtils.getParent;
//
//@Service
//@Transactional
//public class AvatarServiceImpl implements AvatarService {
//    private final AvatarRepository avatarRepository;
//    private final StudentRepository studentRepository;
//
//
//    @Value("${path.to.avatars.folder}")
//    private String avatarsDir;
//    public AvatarServiceImpl (AvatarRepository avatarRepository,StudentRepository studentRepository){
//        this.avatarRepository = avatarRepository;
//        this.studentRepository = studentRepository;
//    }
//    @Override
//    public void uploadAvatar (Long studentId , MultipartFile avatarFile) throws IOException{
//        Student student = studentRepository.getById(studentId);
//        Path filePath = Path.of(avatarsDir,student+ "." + getExtensions(avatarFile.getOriginalFilename()));
//        Files.createDirectories(filePath,getParent());
//        Files.deleteIfExists(filePath);
//        try (
//            InputStream is = avatarFile.getInputStream();
//            OutputStream os = Files.newOutputStream(filePath,CREATE_NEW);
//            BufferedInputStream bis = new BufferedInputStream(is , 1024);
//            BufferedOutputStream bos = new BufferedOutputStream(os,1024)
//        ) {bis.transferTo(bos);
//        }
//            Avatar avatar = findAvatar(studentId);
//            avatar.setStudent(student);
//            avatar.setFilePath(filePath.toString());
//            avatar.setFileSize(avatarFile.getSize());
//            avatar.setMediaType(avatarFile.getContentType());}
//            avatar.setData(generateDataForDB(filePath));
//            avatarRepository.save(avatar);
//
//
//
//        private byte[] generateDataForDB(Path filePath) throws IOException {
//        try(
//                InputStream is = Files.newInputStream(filePath);
//                BufferedInputStream bis = new BufferedInputStream(is , 1024);
//                ByteArrayOutputStream baos = new ByteArrayOutputStream()){
//            BufferedImage image = ImageIO.read(bis);
//
//            int height = image.getHeight()/ (image.getWidth()/100);
//            BufferedImage preview = new BufferedImage(100,height,image.getType());
//            Graphics2D graphics2D = preview.createGraphics();
//            graphics2D.drawImage(image, 0,0,100,height,null);
//            graphics2D.dispose();
//
//            ImageIO.write(preview,getExtensions(filePath.getFileName().toString()),baos);
//            return baos.toByteArray();
//        }
//        }
//
//        public Avatar findAvatar(Long studentId) {
//            return avatarRepository.findByStudentId(studentId).orElse(new Avatar());
//        }
//
//        private String getExtensions(String fileName){
//            return fileName.substring(fileName.lastIndexOf(".")+ 1);
//        }
//
//
//    }
//}
