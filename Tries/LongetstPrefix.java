public class LongetstPrefix {
    public static String ans = "";
    
    public static void  longestPrefix(TiesNode root, StringBuilder temp){

        if(root == null){
            return;
        }

        for(int i=0; i<26; i++){

            if(root.children[i] != null && root.children[i].endOfWord == true){
                char ch = (char) (i + 'a');
                temp.append(ch);

                if(temp.length() > ans.length()){
                    ans = temp.toString();
                }
                longestPrefix(root.children[i], temp);
                temp.deleteCharAt(temp.length() -1);
            }
        }
    }
    public static void main(String args[]){
        String s1[] = {"a", "banana", "app", "apple", "app", "apply"};

        StringBuilder temp = new StringBuilder("");

       
        BuildTrie tries = new BuildTrie();

        for(int i =0; i<s1.length; i++){
            tries.insertInTries(s1[i]);
        }

        TiesNode root = tries.getRoot();
        longestPrefix(root, temp);
        System.out.println(ans);
    }
}
