import java.io.*;
import java.util.*;

public class Main {
  private static class Node {
    int data;
    ArrayList<Node> children = new ArrayList<>();
  }

  public static void display(Node node) {
    String str = node.data + " -> ";
    for (Node child : node.children) {
      str += child.data + ", ";
    }
    str += ".";
    System.out.println(str);

    for (Node child : node.children) {
      display(child);
    }
  }

  public static Node construct(int[] arr) {
    Node root = null;

    Stack<Node> st = new Stack<>();
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] == -1) {
        st.pop();
      } else {
        Node t = new Node();
        t.data = arr[i];

        if (st.size() > 0) {
          st.peek().children.add(t);
        } else {
          root = t;
        }

        st.push(t);
      }
    }

    return root;
  }
  public static class Pair{
    Node node;
    int state;
    Pair(Node node,int state){
      this.node=node;
      this.state=state;
    }
  }

  public static void IterativePreandPostOrder(Node root) {
    Stack<Pair> stk=new Stack<>();

    Pair rootpair=new Pair(root,-1);
    stk.push(rootpair);

    ArrayList<Integer> preorder = new ArrayList<Integer>();
    ArrayList<Integer> postorder = new ArrayList<Integer>();

    while(stk.size()>0){
          Pair parent =stk.peek();
          if(parent.state==-1){
                 preorder.add(parent.node.data);
                 parent.state++;


          }
          else if(parent.state==parent.node.children.size()){
                  postorder.add(parent.node.data);
                  stk.pop();

          }else{
                Pair child=new Pair(parent.node.children.get(parent.state),-1);
                stk.push(child);
                parent.state++;

          }


    }

    for(Integer i: preorder){
      System.out.print(i+" ");
    }
    System.out.println();
    for (Integer i : postorder) {
      System.out.print(i+" ");
    }
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[] arr = new int[n];
    String[] values = br.readLine().split(" ");
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(values[i]);
    }

    Node root = construct(arr);
    IterativePreandPostOrder(root);
  }

}
