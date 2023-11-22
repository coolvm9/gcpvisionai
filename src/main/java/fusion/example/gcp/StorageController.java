package fusion.example.gcp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class StorageController {


    @Autowired
    private ResourceLoader resourceLoader;
    @GetMapping("/list")
    public String list(String bucketName ) {
       return "";
    }

    @GetMapping("/createFolder")
    public String createFolder(String folderName) throws IOException {
        return "created Folder";
    }
}