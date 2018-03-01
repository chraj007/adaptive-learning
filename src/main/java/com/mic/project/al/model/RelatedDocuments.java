package com.mic.project.al.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "related_documents")
public class RelatedDocuments implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "title")
    private String title;
    @Column(name = "description")
    private String description;
    @Column(name = "type")
    private String type;
    @Column(name = "url")
    private String url;
    @Column(name = "thumbNailUrl")
    private String thumbNailUrl;
    @Column(name = "docId")
    private String docId;
    @Column(name = "original_doc_id")
    private long originalDocId;


    public RelatedDocuments() {
    }

    public RelatedDocuments(String title, String description, String type, String url, String thumbNailUrl, String docId) {
        this.title = title;
        this.description = description;
        this.type = type;
        this.url = url;
        this.thumbNailUrl = thumbNailUrl;
        this.docId = docId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getThumbNailUrl() {
        return thumbNailUrl;
    }

    public void setThumbNailUrl(String thumbNailUrl) {
        this.thumbNailUrl = thumbNailUrl;
    }

    public String getDocId() {
        return docId;
    }

    public void setDocId(String docId) {
        this.docId = docId;
    }

    public long getOriginalDocId() {
        return originalDocId;
    }

    public void setOriginalDocId(long originalDocId) {
        this.originalDocId = originalDocId;
    }

    @Override
    public String toString() {
        return "RelatedDocuments{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", type='" + type + '\'' +
                ", url='" + url + '\'' +
                ", thumbNailUrl='" + thumbNailUrl + '\'' +
                ", docId='" + docId + '\'' +
                '}';
    }
}
