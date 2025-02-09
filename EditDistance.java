//time-O(m*n), space - O(m*n)
class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();

        if(m < n) return minDistance(word2, word1);

        int[][] dp = new int[m+1][n+1];

        for(int i=1; i<n+1; i++){
            dp[0][i] = i;
        }

        for(int j=1; j<m+1; j++){
            dp[j][0] = j;
        }

        for(int i=1; i<m+1; i++){
            for(int j=1; j<n+1; j++){
                if(word1.charAt(i-1)==word2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                }
                else{
                    dp[i][j] = 1 + Math.min(dp[i-1][j], Math.min(dp[i][j-1], dp[i-1][j-1]));
                }
            }
        }

        return dp[m][n];
    }
}
