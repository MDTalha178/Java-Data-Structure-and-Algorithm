public class CountUniqueSubstring {
    public static int st = 0;
    public static int getCount(Node root){
        if(root == null){
            return 0;
        }
        int count = 0;
        for(int i=0; i<26; i++){
            st++;
            if(root.children[i] != null){
                count+=getCount(root.children[i]);
            }
        }
        return count + 1;
    }
    public static void main(String args[]){
        String s  = "ababa";
        BuildTries tries = new BuildTries();

        for(int i=0; i<s.length(); i++){
            String suffix = s.substring(i);
            tries.insert(suffix);
        }
        Node root = tries.getRoot();
        int count = getCount(root);
        System.out.println(count);
        System.out.println(st);
    }
}
