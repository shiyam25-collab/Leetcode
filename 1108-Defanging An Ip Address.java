class Solution {
    public String defangIPaddr(String address) {
        // Replaces every period "." with "[.]" and returns the result
        return address.replace(".", "[.]");
    }
}
