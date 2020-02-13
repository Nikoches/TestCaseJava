import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Finder {
    /**
     * Поиск групп людей старше определенного возраста.
     *
     * @param groups    группы
     * @param targetAge возраст для поиска
     * @return список имен групп из списка групп старше возраста targetAge
     */
    public static Set<String> findOldMembers(List<MembersGroup> groups, int targetAge) {
        Set<String> groupsNames = new HashSet<>();
        for (MembersGroup membersGroup : groups) {
            for (Member member : membersGroup.getMembers()) {
                if (member.getAge() > targetAge) {
                    String name = member.getName();
                    groupsNames.add(name);
                }
            }
        }
        return groupsNames;
    }

    /**
     *
     * @param store хранилище групп
     * @param targetAge целевой возраст
     * @return Set имен подходящих по критерию возраста из всех групп
     */
    public static Set<String> findOldMemebers(Map<String, List<Member>> store, int targetAge) {
        Set<String> groupsNames = new HashSet<>();
        store.values().stream().forEach(members -> {
            members.stream().filter(member -> member.getAge() > targetAge).forEach(member -> groupsNames.add(member.getName()));
        });
        return groupsNames;
    }
}
