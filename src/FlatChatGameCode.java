public class FlatChatGameCode {

	static int mod = 1000000007;
	static long A[] = new long[10001];
	static long tot[] = new long[10001];
	static long dp[][] = new long[10001][10001];
	static void pre(int n) {
	  for(int i =1; i<n ;i++) {
	    A[i] = (A[i-1] * A[i-1] + 45L) % mod;
	    tot[i] = A[i] + tot[i-1];
	  }
	}
	
	static long solve(int n)
	{
		for(int itr=1; itr <= n ;itr++) 
		for(int i=0;i<=n-itr ; i++)
		{
			if(itr == 1) {
		    	dp[i][itr] = A[i];
			    continue;
			}
			long p=0L;
			long val1 = A[i] + tot[i+itr-1] - tot[i] - dp[i+1][itr-1] ;
			if(i > 0) p=tot[i-1]; 
			long val2 =  A[i+itr-1] + tot[i+itr-2] - p - dp[i][itr-1] ;
			dp[i][itr] = max(val1,val2);
		}
		return dp[0][n];
	}
	private static long max(long l, long m) {
		if(l > m) return l;
		else return m;
	}

	public static void main(String[] args) {
		int n =10000;
		pre(n);
		System.out.println(solve(n));
	}

}
