package com.tn.java.api.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;

@Data
@Entity(name = "contents")
public class ContentDB {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "type", nullable = false)
    private String type;
    @Lob
    @Column(name = "data", nullable = false)
    @Type(type="org.hibernate.type.BinaryType")
    @Basic(fetch = FetchType.LAZY)
    private byte[] data;

    public ContentDB() {
    }

    public ContentDB(String fileName, String contentType, byte[] data) {
        setName(fileName);
        setType(contentType);
        setData(data);
    }

}
