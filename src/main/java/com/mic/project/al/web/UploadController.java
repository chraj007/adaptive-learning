package com.mic.project.al.web;

/**
 * Created by veena on 1/1/18.
 */

import com.mic.project.al.model.User;
import com.mic.project.al.model.UserDocuments;
import com.mic.project.al.repository.UserDocumentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.ServletContext;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.List;

@Controller
public class UploadController {

    @Autowired
    private UserDocumentsRepository userDocumentsRepository;
    //Save the uploaded file to this folder
    @Autowired
    ServletContext context;


    @GetMapping("/upload")
    public String index() {
        return "upload";
    }

    @PostMapping("/upload") // //new annotation since 4.3
    public String singleFileUpload(@RequestParam("file") MultipartFile file,
                                   RedirectAttributes redirectAttributes) {

        if (file.isEmpty()) {
            redirectAttributes.addFlashAttribute("message", "Please select a file to upload");
            return "redirect:uploadStatus";
        }

        try {

            org.springframework.security.core.userdetails.User user = (org.springframework.security.core.userdetails.User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            // Get the file and save it somewhere
            byte[] bytes = file.getBytes();
            String fileName = file.getName();
            org.springframework.security.core.userdetails.User userprofile = (org.springframework.security.core.userdetails.User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

            String destPath = "/documents/" + userprofile.getUsername();
            Path path = Paths.get(context.getContextPath() + "src/main/webapp/documents/" + userprofile.getUsername()+"/" + file.getOriginalFilename());
            Files.write(path, bytes);
            UserDocuments userDocuments = new UserDocuments(user.getUsername(),
                    destPath, file.getOriginalFilename(), LocalDateTime.now().toString());

            userDocumentsRepository.save(userDocuments);
            redirectAttributes.addFlashAttribute("message",
                    "You successfully uploaded '" + file.getOriginalFilename() + "'");

        } catch (IOException e) {
            e.printStackTrace();
        }


        return "redirect:/list_documents";
    }

    @GetMapping("/uploadStatus")
    public String uploadStatus() {
        return "uploadStatus";
    }


    @RequestMapping(value = "/list_documents", method = RequestMethod.GET)
    public String userProfile(Model model) {
        org.springframework.security.core.userdetails.User userprofile = (org.springframework.security.core.userdetails.User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        List<UserDocuments> userDocuments = userDocumentsRepository.findByUserName(userprofile.getUsername());
        model.addAttribute("userDocuments", userDocuments);
        return "userDocuments";
    }

    @RequestMapping(value = "/viewDoc/{id}", method = RequestMethod.GET)
    public String viewDoc(Model model, @PathVariable(name = "id") long id) {
        org.springframework.security.core.userdetails.User userprofile = (org.springframework.security.core.userdetails.User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        UserDocuments userDocument = userDocumentsRepository.findOne(id);
        model.addAttribute("userDocument", userDocument);
        return "viewDocument";
    }

}
