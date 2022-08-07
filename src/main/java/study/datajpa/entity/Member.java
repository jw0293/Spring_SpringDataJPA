package study.datajpa.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString(of = {"id", "name", "age"})
public class Member {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long id;
    private String name;
    private int age;

    @ManyToOne
    @JoinColumn(name = "team_id")
    private Team team;

    public Member(String name) {
        this.name = name;
    }
}
