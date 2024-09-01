public class PrefixSearch {
    public static void main(String args[]){
        String word[] = {"apple", "app", "mango", "man", "woman"};

        PrefixTrie tries = new PrefixTrie();
        for(int i =0; i<word.length; i++){
            tries.insert(word[i]);
        }
        if(tries.PrefixSearch("man")){
            System.out.println("It's a valid Prfeix");
        }else{
            System.out.println("It's not a valid prefix");
        }
    }
}

class PrefixTriesNode{
    PrefixTriesNode children[] = new PrefixTriesNode[26];
    boolean endOfWord = false;

    PrefixTriesNode(){
        for(int i=0; i<26; i++){
            children[i] = null;
        }
    }
}

class PrefixTrie{

    private PrefixTriesNode root = new PrefixTriesNode();

    public void insert(String word){

        PrefixTriesNode curr = root;

        for(int i=0; i<word.length(); i++){

            int idx = Math.abs('a' - word.charAt(i));
            if(curr.children[idx] == null){
                curr.children[idx] = new PrefixTriesNode();
            }
            curr = curr.children[idx];
        }

    }

    public boolean PrefixSearch(String  prefixKey){

        PrefixTriesNode curr = root;

        for(int i=0; i<prefixKey.length(); i++){

            int idx = Math.abs('a' - prefixKey.charAt(i));
            if(curr.children[idx] == null){
                return false;
            }
            curr = curr.children[idx];
        }
        return true;
    }
}
