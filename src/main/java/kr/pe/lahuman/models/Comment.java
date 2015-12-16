package kr.pe.lahuman.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by lahuman on 15. 12. 7.
 */

@Entity
public class Comment extends DefaultEntity {


    @Id
    @GeneratedValue
    @Getter @Setter
    private Long id;

    @Column(length = 40)
    @Getter @Setter
    private String name;
    @Column(length = 4)
    @Getter @Setter
    private Code code;
    @Getter @Setter
    private Long codeId;

    @Column(length = 20)
    @Getter @Setter
    private String ip;
    @Column(length = 4000)
    @Getter @Setter
    private String comment;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="main_id")
    @Getter @Setter
    private Comment main;

    @OneToMany(mappedBy = "main",fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    @Getter @Setter
    private Set<Comment> subComment = new HashSet<>();

    public enum Code {
        MYHI,
        PROJ,
        SIPH;
    }
}
