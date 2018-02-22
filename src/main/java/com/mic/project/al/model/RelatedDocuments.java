package com.mic.project.al.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "related_documents")
public class RelatedDocuments implements Serializable {

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

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }


}
