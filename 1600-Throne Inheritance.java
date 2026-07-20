import java.util.*;

class ThroneInheritance {
    private final String king;
    // Maps a parent to their list of children in order of birth
    private final Map<String, List<String>> family;
    // Keeps track of dead family members
    private final Set<String> dead;

    public ThroneInheritance(String kingName) {
        this.king = kingName;
        this.family = new HashMap<>();
        this.dead = new HashSet<>();
        family.put(kingName, new ArrayList<>());
    }
    
    public void birth(String parentName, String childName) {
        // Ensure the parent exists in our adjacency map
        family.putIfAbsent(parentName, new ArrayList<>());
        // Add the child to the parent's list of children
        family.get(parentName).add(childName);
    }
    
    public void death(String name) {
        // Mark the person as dead
        dead.add(name);
    }
    
    public List<String> getInheritanceOrder() {
        List<String> order = new ArrayList<>();
        dfs(king, order);
        return order;
    }

    private void dfs(String current, List<String> order) {
        // If the current person is alive, add them to the inheritance order
        if (!dead.contains(current)) {
            order.add(current);
        }
        
        // Recursively visit children in order of birth
        List<String> children = family.get(current);
        if (children != null) {
            for (String child : children) {
                dfs(child, order);
            }
        }
    }
}
