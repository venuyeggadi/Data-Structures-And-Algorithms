/* Given a valid (IPv4) IP address, return a defanged version of that IP address.
   A defanged IP address replaces every period "." with "[.]".

 * Example 1:
   Input: address = "1.1.1.1"
   Output: "1[.]1[.]1[.]1"
 * Example 2:
   Input: address = "255.100.50.0"
   Output: "255[.]100[.]50[.]0"

 * Constraints:
   * The given address is a valid IPv4 address.
*/

//#1
class Solution {
    public String defangIPaddr(String address) {
        return address.replace(".", "[.]");
    }
}



//#2
//O(n), O(n)
class Solution {
    public String defangIPaddr(String address) {
        StringBuilder sb = new StringBuilder();
        char[] charArray = address.toCharArray();
        for(char c : charArray) {
            if(c == '.')
                sb.append("[.]");
            else
                sb.append(c);
        }
        
        return sb.toString();
    }
}