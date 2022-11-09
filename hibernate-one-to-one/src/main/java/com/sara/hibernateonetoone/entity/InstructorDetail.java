package com.sara.hibernateonetoone.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "instructor_detail")
public class InstructorDetail {

    // annotate the class as an entity and map to the db table
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "youtube_channel")
    private String youtubeChannel;

    @Column(name = "hobby")
    private String hobby;

    // define the feilds


    // annotate the fields with db column names

    // create constructors
    public InstructorDetail(String youtubeChannel, String hobby) {
        this.youtubeChannel = youtubeChannel;
        this.hobby = hobby;
    }



    // generate getters /setters

    public int getId() {
        return id;
    }

    public String getYoutubeChannel() {
        return youtubeChannel;
    }

    public String getHobby() {
        return hobby;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setYoutubeChannel(String youtubeChannel) {
        this.youtubeChannel = youtubeChannel;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    // generate toString method
    @Override
    public String toString() {
        return "InstructorDetail{" +
                "id=" + id +
                ", youtubeChannel='" + youtubeChannel + '\'' +
                ", hobby='" + hobby + '\'' +
                '}';
    }
}
