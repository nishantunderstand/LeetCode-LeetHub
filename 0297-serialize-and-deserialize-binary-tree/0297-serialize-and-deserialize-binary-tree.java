/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root==null){
            return "";
        }
        Queue<TreeNode> que = new LinkedList<>();
        que.add(root);
        StringBuilder res = new StringBuilder();
        while(!que.isEmpty()){                     
            TreeNode node = que.poll();
            if(node==null){
                res.append("null,"); // You need to add , 
            }else{
                res.append(node.val).append(","); // You need to add , 
                que.add(node.left);
                que.add(node.right);
                }
          
        }
        return res.toString();
        
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        int n = data.length();
        if(data==null||data.length()==0){
            return null;
        }
        String[] values = data.split(","); // You need to split the data
        TreeNode root = new TreeNode(Integer.parseInt(values[0]));
        Queue<TreeNode> que = new LinkedList<>();
        que.add(root);
        int i=1;
        while(!que.isEmpty() && i<n){
            TreeNode node = que.poll();
            if(!values[i].equals("null")){
                node.left = new TreeNode(Integer.parseInt(values[i])); // you need to parse the value 
                que.add(node.left);
            }
            i++;
            if(!values[i].equals("null")){ // String need to use equals = will not work
                node.right = new TreeNode(Integer.parseInt(values[i]));
                que.add(node.right);
            }
            i++;

        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));