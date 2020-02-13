import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MembersGroup {
    private final String groupName;
    private final List<Member> members;
    //
    private final Map<String, List<Member>> memberStore = new HashMap<>();

    public MembersGroup(String groupName, List<Member> members) {
        this.groupName = groupName;
        this.members = members;
    }

    //Adding list of members, or return list if name of group already exists
    public List<Member> addList(List<Member> members, String groupName) {
        return memberStore.putIfAbsent(groupName, members);
    }

    public Map<String, List<Member>> getMemberStore() {
        return memberStore;
    }

    public String getGroupName() {
        return groupName;
    }

    public List<Member> getMembers() {
        return members;
    }
}
