package com.rentx.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@Entity
@Table(name="image")
public class Image {

    public Image(Integer id, String name, String imageType) {
        this.id = id;
        this.name = name;
        this.imageType = imageType;
    }

    @Id
    @Column(name="imageid")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int imageId;

    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "image_type")
    private String imageType;

}
