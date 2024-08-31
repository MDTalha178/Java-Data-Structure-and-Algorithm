public class wordBreak {
    public static void main(String args[]){

        String s[]  = {"i", "like", "sam", "samsung", "mobile", "ice"};

        WordBreakTries tries = new WordBreakTries();

        // here we will insert in tries
        for(int i =0; i<s.length; i++){
            tries.insert(s[i]);
        }

        // here we will check can we make valid string
        String key = "ilikesamsung";
        if(tries.checkValidString(key)){
            System.out.println("Yes we can make a valid string");
        }else{
            System.out.println("No its valid string");
        }
    }
}

// here we will create a node for Tries 
class WordBreakTriesNode{

    WordBreakTriesNode children[] = new WordBreakTriesNode[26];
    boolean endOfWord = false;


    // constructor for Node
    WordBreakTriesNode(){
        for(int i=0; i<26; i++){
            children[i] = null;
        }
    }

}

class WordBreakTries{

    // here we will create Tries
    private WordBreakTriesNode root = new WordBreakTriesNode();

    public void insert(String word){

        WordBreakTriesNode curr = root;

        for(int i=0; i<word.length(); i++){

            // here we will get current index of char in Tries
            int idx = Math.abs(word.charAt(i) - 'a');

            if(curr.children[idx] == null){
                curr.children[idx] = new WordBreakTriesNode();
            }
            curr = curr.children[idx];
        }
        curr.endOfWord = true;
    }

    // here we will return a root of Tries
    public WordBreakTriesNode getRoot(){
        return root;
    }

    // here we will search in Tries
    public boolean searchInTries(String word){

        WordBreakTriesNode curr = root;

        for(int i =0; i<word.length(); i++){

            int idx =  Math.abs('a' - word.charAt(i));
            if(curr.children[idx] == null){
                return false;
            }
            curr = curr.children[idx];
        }
        return curr.endOfWord == true;
    }

    // here we will check make valid string
    public boolean checkValidString(String key){

        if(key.length() == 0){
            return true;
        }

        for(int i=1; i<=key.length(); i++){
            if(searchInTries(key.substring(0, i))){
                if(checkValidString(key.substring(i))){
                    return true;
                }
            }
        }
        return false;
    }
}
