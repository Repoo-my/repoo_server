package com.repoo.domain.main.todolist.domain;

import com.repoo.domain.main.calendar.domain.Calendar;
import io.hypersistence.utils.hibernate.type.array.StringArrayType;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EntityListeners(AuditingEntityListener.class)
public class TodoList {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long todoListId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "calendarId")
    private Calendar calendar;

    private String contents;

    @Type(StringArrayType.class)
    @Column(columnDefinition = "varchar[]")
    private String[] tags;

    public TodoList(Calendar calendar, String contents, String[] tags){
        this.calendar = calendar;
        this.contents = contents;
        this.tags = tags;
    }

    public void update(Calendar calendar, String contents, String[] tags){
        this.calendar = calendar;
        this.contents = contents;
        this.tags = tags;
    }

}
