public class UniquePrefix {
    public static void main(String args[]){
        String s[] = {"zebra", "dog", "duck", "dove"};

        PrefixTries tries = new PrefixTries();
        for(int i=0; i<s.length; i++){
            tries.insert(s[i]);
        }
        tries.root.freq = -1;
        String ans = "";
        tries.findPrefix(tries.root, ans);
    }
}

class PrefixNode{

    PrefixNode children[] = new PrefixNode[26];
    boolean endOfWord = false;
    int freq;

    PrefixNode(){
        for(int i=0; i<26; i++){
            children[i] = null;
        }
        freq = 1;
    }
}

class PrefixTries{

    public PrefixNode root = new PrefixNode();

    public void insert(String word){

        PrefixNode curr = root;

        for(int i =0; i<word.length(); i++){
            int idx = Math.abs('a' - word.charAt(i));

            if(curr.children[idx] == null){
                curr.children[idx] = new PrefixNode();
            }else{
                curr.children[idx].freq++;
            }
            curr = curr.children[idx];
        }
        curr.endOfWord = true;
    }

    // here we will find prefix
    public  void findPrefix(PrefixNode root, String ans){
        if(root == null){
            return;
        }
        if(root.freq == 1){
            System.out.println(ans);
            return;
        }
        for(int i=0; i<root.children.length; i++){
            if(root.children[i] != null){
                findPrefix(root.children[i], ans+(char) (i+'a'));
            }
        }
    }
}
