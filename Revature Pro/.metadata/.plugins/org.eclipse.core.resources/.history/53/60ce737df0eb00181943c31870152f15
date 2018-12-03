package program;

class Solution {
public void ReverseChar(char[] str) {
	int len = str.length;
	if(len == 0) return;
	reverse(str, 0, len -1);
	int start = 0;
	int end = 0;
	for(; end < len; end++) {
		while(end < len && str[end] != ' ')
		if (end < len) {
			reverse(str, start, end -1);
			start = end +1;
		}
	}
	reverse(str, start, end - 2);
	}	
	private void reverse(char[] str, int start, int end) {
		while(start < end) {
			char temp = str[start];
			str[start++] = str[end];
			str[end--] = temp;
		}
		return ;
	}
}
