public class DisJointSet {
    
    public static void main(String args[]){
        int  n =7;
        DisJointSetImplementation disJoinSet = new DisJointSetImplementation(n);

        // here we will call out uninon function
        System.out.println(disJoinSet.find(3));
        disJoinSet.union(1, 3);
        System.out.println(disJoinSet.find(3));

        disJoinSet.union(2,4);
        disJoinSet.union(3, 6);
        disJoinSet.union(1,4);
        System.out.println(disJoinSet.find(4));
        disJoinSet.union(1, 5);
        
    }
}

class DisJointSetImplementation{

    int partentLenght;
    int parent[];
    int rank[];

    DisJointSetImplementation(int partentLenght){
        this.partentLenght = partentLenght;
        this.parent = new int[partentLenght];
        this.rank = new int[partentLenght];
        init();
    }

    public void init(){

        // make all the element of thier own parents
        for(int i=0; i<partentLenght; i++){
            parent[i] = i;
        }
    }

    public int find(int x){

        if(x == parent[x]){
            return x;
        }
        return find(parent[x]);
    }

    public void union(int a, int b){

        // here we need to find out their parent
        int parentA = find(a);
        int parentB = find(b);

        // case 1 rank of parent a equal to rank of parent b
        if(rank[parentA] == rank[parentB]){

            parent[parentB] = parentA;
            rank[parentA]++;
        }

        // case2 rank of parent a is greater thank rank of parent b
        else if(rank[parentA] > rank[parentB]){
            parent[parentB] = parentA;
        }
        // case rank of parent a is less than rank of parent b
        else{
            parent[parentA] = parentB;
        }


    }
}
