class Solution {
    void zigZag(int arr[], int n) {
        for(int i=0; i<n-1; i++){
            if(i%2 == 0 && arr[i]>arr[i+1]){
                int curr = arr[i];
                arr[i] = arr[i+1];
                arr[i+1] = curr;
            }
            else if(i%2 == 1 && arr[i] < arr[i+1]){
                int curr = arr[i];
                arr[i] = arr[i+1];
                arr[i+1] = curr;
            }
        }
    }
}
