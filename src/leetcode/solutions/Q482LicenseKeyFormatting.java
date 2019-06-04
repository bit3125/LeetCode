package leetcode.solutions;
import java.util.Arrays;

public class Q482LicenseKeyFormatting {

    public String licenseKeyFormatting(String S, int K) {
    	S = S.toUpperCase().replace("-", "");
    	int firstSectLen = S.length()%K;
    	int secNum = S.length()/K+1; 
    	StringBuilder result = new StringBuilder();
    	
    	int idx = 0;
    	result.append(S, idx, idx+firstSectLen);
    	idx = firstSectLen;
    	for (int i=1;i<secNum;i++){
    		if (!(firstSectLen==0 && i==1))
    			result.append("-");
    		result.append(S, idx, idx+K);
    		idx = idx+K;
    	}
    	
    	return result.toString();
    }
    
	
	public static void main(String[] args) {
		Q482LicenseKeyFormatting q = new Q482LicenseKeyFormatting();
//		String S = "5F3Z-2e-9-w";
//		int K = 4;
		String S = "f";
		int K = 2;
		
		System.out.println(q.licenseKeyFormatting(S, K));
		
	}

}
