package com.example.mp3.model.music;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "kinds")
public class Kind {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    String kindName;

    @ManyToMany(mappedBy = "kinds")
    @JsonIgnore
    private Set<Singer> singers;

    public Kind() {
    }

    public Kind(String kindName) {
        this.kindName = kindName;
    }

    public Kind(Long id, String kindName) {
        this.id = id;
        this.kindName = kindName;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getKindName() {
        return kindName;
    }

    public void setKindName(String kindName) {
        this.kindName = kindName;
    }

    public Set<Singer> getSingers() {
        return singers;
    }

    public void setSingers(Set<Singer> singers) {
        this.singers = singers;
    }
}
