package kr.pe.lahuman.models;

import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by lahuman on 15. 12. 7.
 */
@Data
@Entity
public class Comment extends DefaultEntity {


    @Id
    @GeneratedValue
    private Long id;

    @Column(length = 40)
    private String name;
    @Column(length = 4)
    private String code;
    @Column(length = 20)
    private String ip;
    @Column(length = 4000)
    private String comment;

    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name="main_id")
    private Comment main;

    @OneToMany(mappedBy = "main")
    private Set<Comment> subComment = new HashSet<>();

}
