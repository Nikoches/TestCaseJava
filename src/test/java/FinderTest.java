import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FinderTest {
    private List<Member> mm = new LinkedList<>();
    private List<Member> mm1 = new LinkedList<>();
    private List<Member> mm2 = new LinkedList<>();
    private Set<String> hiddenNames = new HashSet<>();
    @BeforeEach
    public void beforeTest(){
        Collections.addAll(mm,new Member("A", 1),new Member("B", 2));
        Collections.addAll(mm1,new Member("C", 3),new Member("D", 4));
        Collections.addAll(mm2,new Member("E", 5),new Member("F", 6));
        Collections.addAll(hiddenNames,"D","E","F");
    }
    @Test
    public void test1() {
        List<MembersGroup> m3 = new LinkedList<>();
        m3.add(new MembersGroup("Group1", mm));
        m3.add(new MembersGroup("Group2", mm1));
        m3.add(new MembersGroup("Group3", mm2));
        assertEquals(hiddenNames, Finder.findOldMembers(m3, 3));

    }

    @Test
    public void test2() {
        MembersGroup membersGroup = new MembersGroup("ss", new LinkedList<>());
        membersGroup.addList(mm, "group1");
        membersGroup.addList(mm1, "group2");
        membersGroup.addList(mm2, "group3");
        assertEquals(hiddenNames, Finder.findOldMemebers(membersGroup.getMemberStore(),3));
    }
}
