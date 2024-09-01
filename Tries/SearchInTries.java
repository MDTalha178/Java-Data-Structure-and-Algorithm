public class SearchInTries {
    public static void main(String args[]){
        String s1[] = {"There", "Their", "The"};

        BuildTrie tries = new BuildTrie();

        for(int i =0; i<s1.length; i++){
            tries.insertInTries(s1[i]);
        }

        // sere we will search
        String s2 = "Thee";
        if(tries.SearchInTries(s2)){
            System.out.println("Word is Present in Tries");
        }else{
            System.out.println("Word is Not present in Tries");
        }

    }
}

// class Node class
class TiesNode{
    TiesNode children[] = new TiesNode[26];
    boolean endOfWord = false;
    String word;


    TiesNode(){
        for(int i=0; i<26; i++){
            children[i] = null;
        }
    }
}

class BuildTrie{

    // here we will define our root
    private TiesNode root = new TiesNode();


    // here we will insert word in ties
    public void insertInTries(String word){

        TiesNode curr = root;

        for(int i=0; i<word.length(); i++){
            int idx = Math.abs('a' - word.charAt(i));

            if(curr.children[idx] == null){
                curr.children[idx] = new TiesNode();
            }
            curr = curr.children[idx];
        }

        curr.endOfWord = true;
        curr.word = word;
    }

    // get root
    public TiesNode getRoot(){
        return root;
    }

    // search int Tries
    boolean SearchInTries(String word){
        TiesNode curr = root;

        for(int i =0; i<word.length(); i++){
            int idx = Math.abs('a' - word.charAt(i));

            if(curr.children[idx] == null){
                return false;
            }

            curr = curr.children[idx];
        }

        if(curr.endOfWord){
            return true;
        }else{
            return false;
        }
    }
}
