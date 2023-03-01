import java.util.Collections;
import java.util.ArrayList;

class Solution {
    public static class Node implements Comparable<Node>{
        int x,y,num;
        Node left,right;
        
        public Node(int x,int y,int num){
            super();
            this.x=x;
            this.y=y;
            this.num=num;
        }
        
        public int compareTo(Node o){
            return o.y-this.y;
        }
    }
    public static ArrayList<Node> list=new ArrayList<>();    
    public static int idx1=0,idx2=0;
    public int[][] solution(int[][] nodeinfo) {
        int[][] answer = new int[2][nodeinfo.length];
       
        for(int i=0;i<nodeinfo.length;i++){
            list.add(new Node(nodeinfo[i][0],nodeinfo[i][1],i+1));
        }
        Collections.sort(list);
        
        Node root=list.get(0);
        
        for(int i=1;i<list.size();i++){
            Node child=list.get(i);
            connectNode(root,child);
        }
        
        pre(answer,root);

        post(answer,root);
        
        return answer;
    }
    
    public static void connectNode(Node root, Node child){
        if(child.x<root.x){
            if(root.left==null){
                root.left=child;
            }else{
                connectNode(root.left,child);
            }
        }else{
            if(root.right==null){
                root.right=child;
            }else{
                connectNode(root.right,child);
            }
        }
    }
    
    public static void pre(int arr[][],Node node){
        if(node !=null){
            arr[0][idx1++]=node.num;
            if(node.left!=null)pre(arr,node.left);
            if(node.right!=null)pre(arr,node.right);
        }
    }
    
    public static void post(int arr[][],Node node){
        if(node !=null){
            if(node.left!=null)post(arr,node.left);
            if(node.right!=null)post(arr,node.right);
            arr[1][idx2++]=node.num;     
        }
    }
    
}