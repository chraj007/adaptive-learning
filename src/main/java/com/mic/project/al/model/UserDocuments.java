package com.mic.project.al.model;

import javax.persistence.*;

@Table(name = "user_documents")
public class UserDocuments {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "user_name", nullable = false)
    private String userName;
    @Column(name = "file_path", nullable = false)
    private String filePath;
    @Column(name = "title", nullable = false)
    private String documentTitle;
    @Column(name = "uploaded_at", nullable = false)
    private String uploadedAt;

    public UserDocuments() {
    }

    public UserDocuments(String userName, String filePath, String documentTitle, String uploadedAt) {
        this.userName = userName;
        this.filePath = filePath;
        this.documentTitle = documentTitle;
        this.uploadedAt = uploadedAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getDocumentTitle() {
        return documentTitle;
    }

    public void setDocumentTitle(String documentTitle) {
        this.documentTitle = documentTitle;
    }

    public String getUploadedAt() {
        return uploadedAt;
    }

    public void setUploadedAt(String uploadedAt) {
        this.uploadedAt = uploadedAt;
    }

    @Override
    public String toString() {
        return "UserDocuments{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", filePath='" + filePath + '\'' +
                ", documentTitle='" + documentTitle + '\'' +
                ", uploadedAt='" + uploadedAt + '\'' +
                '}';
    }
}
