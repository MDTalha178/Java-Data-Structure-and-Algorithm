public class LongestWordInDicronary {
    public static String ans = "";

    public static void getLongestWord(TiesNode root){
        if(root.word != null  && ans.length() < root.word.length()){
            ans = root.word;

        }
        else if(root.word != null && root.word.length() == ans.length()){
            ans = root.word.compareTo(ans) < 0 ? root.word : ans;
        }
        for(int i=0; i<root.children.length; i++){
            // System.out.println(root.children[i].word);
            if(root.children[i] != null && root.children[i].word != null){
                getLongestWord(root.children[i]);
            }
        }

    }
    public static void main(String args[]){
        String s1[] = {"a","banana","app","appl","ap","apply","apple"};

        BuildTrie tries = new BuildTrie();

        for(int i =0; i<s1.length; i++){
            tries.insertInTries(s1[i]);
        }
        TiesNode root = tries.getRoot();
        getLongestWord(root);
        System.out.println(ans);
    }
}
