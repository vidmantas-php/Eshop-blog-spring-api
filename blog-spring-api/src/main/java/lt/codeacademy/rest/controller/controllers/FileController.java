package lt.codeacademy.rest.controller.controllers;

import java.net.URLConnection;

import io.swagger.annotations.ApiOperation;
import lt.codeacademy.rest.services.FileStorageService;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController("FileController")
@RequestMapping("/files")
public class FileController {

    private final FileStorageService fileStorageService;

    public FileController(
            FileStorageService fileStorageService
    ) {
        this.fileStorageService = fileStorageService;
    }

    @PostMapping
    @ApiOperation(value = "Upload File")
    public void uploadFile(@RequestParam("file") MultipartFile file) {
        fileStorageService.storeFile(file);
    }

    @GetMapping("/{fileName}")
    public ResponseEntity<Resource> downloadFile(@PathVariable("fileName") String fileName) {
        Resource resource = fileStorageService.getFile(fileName);

        String contentType = URLConnection.guessContentTypeFromName(resource.getFilename());

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(contentType))
                .body(resource);
    }
}
