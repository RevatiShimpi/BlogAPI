package com.BlogAPI.API.entities;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Document(collection="BLOGS")
@Data
public class entities {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int ID;
    @NotNull(message = "Title cannot be null")
    private String title;

    @NotNull(message = "author cannot be null")
    private String author;
    private String contents;
    private String tags;
}
