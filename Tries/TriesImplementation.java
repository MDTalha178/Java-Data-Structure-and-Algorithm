class TriesImplementation{

    public static void main(String args[]){
        BuildTries tries = new BuildTries();

        String s1 = "There";
        tries.insert(s1);


    }
}

class Node{
    Node children[] = new Node[26];
    boolean endOfWord = false;

    Node(){
        for(int i =0; i<26; i++){
            children[i] = null;
        }
    }
}

class BuildTries{

    // here first we need to create root
    public Node root = new Node();


    public void insert(String word){

        Node curr = root;
        for(int i=0; i<word.length(); i++){

            // gere index for current character
            int idx = Math.abs(word.charAt(i) - 'a');

            // here we will that currrent character present at our Tries or not
            if(curr.children[idx] == null){
                curr.children[idx] =  new Node();
            }
            curr = curr.children[idx];
        }
        curr.endOfWord = true;
    }

    public Node getRoot(){
        return root;
    }
}