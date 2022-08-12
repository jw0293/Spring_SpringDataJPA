package study.datajpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import study.datajpa.dto.MemberDto;
import study.datajpa.entity.Member;

import java.util.Collection;
import java.util.List;

public interface MemberRepository extends JpaRepository<Member, Long> {

    List<Member> findByNameAndAgeGreaterThan(String name, int age);

    @Query("select m from Member m where m.name = :name and m.age = :age")
    List<Member> findUser(@Param("name") String name, @Param("age") int age);

    @Query("select m.name from Member m")
    List<String> findUsernameList();

    @Query("select new study.datajpa.dto.MemberDto(m.id, m.name, t.teamName) from Member m join m.team t")
    List<MemberDto> findMemberDto();

    @Query("select m from Member m where m.name in :names")
    List<Member> findByNames(@Param("names") Collection<String> names);
}
