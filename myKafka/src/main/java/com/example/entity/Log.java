package com.example.entity;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Getter @Setter @NoArgsConstructor
@Entity
@Table(name = "logtbl")
public class Log {

    @Id
    private int id;

    private String mess;
    private Date insertTime;


    public Log(int id, String mess, Date insertTime) {
        this.id = id;
        this.mess = mess;
        this.insertTime = insertTime;
    }
}