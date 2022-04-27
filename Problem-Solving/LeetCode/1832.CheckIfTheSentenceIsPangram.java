/** 1832. Check if the Sentence Is Pangram
    A pangram is a sentence where every letter of the English alphabet
    appears at least once.
    Given a string sentence containing only lowercase English letters,
    return true if sentence is a pangram, or false otherwise.

  * Example 1:
	Input: sentence = "thequickbrownfoxjumpsoverthelazydog"
	Output: true
	Explanation: sentence contains at least one of every letter of the English alphabet.
  
  * Example 2:
	Input: sentence = "leetcode"
	Output: false

  * Constraints:
	* 1 <= sentence.length <= 1000
	* sentence consists of lowercase English letters.
*/


//#1
//O(n), O(1)
// n --> length of the given string
class Solution {
    public boolean checkIfPangram(String sentence) {
        int[] freqCount = new int[26];
        
        for(char ch : sentence.toCharArray())
            freqCount[ch-'a']++;
        
        for(int count : freqCount)
            if(count == 0)
                return false;
        
        return true;
    }
}


//#2
//O(n), O(1)
class Solution {
    public boolean checkIfPangram(String sentence) {
        boolean[] presence = new boolean[26];
        
        for(char ch : sentence.toCharArray())
            presence[ch-'a'] = true;
        
        for(boolean op : presence)
            if(!op)
                return false;
        
        return true;
    }
}


//#3
//O(n), O(1)
class Solution {
    public boolean checkIfPangram(String sentence) {
        String alphabets = "abcdefghijklmnopqrstuvwxyz";
        
        for(char ch : alphabets.toCharArray())
            if(sentence.indexOf(ch) == -1)
                return false;
        
        return true;
    }
}


//#4
//O(n), O(1)
class Solution {
    public boolean checkIfPangram(String sentence) {        
        for(char ch = 'a'; ch <= 'z'; ch++)
            if(sentence.indexOf(ch) == -1)
                return false;
        
        return true;
    }
}