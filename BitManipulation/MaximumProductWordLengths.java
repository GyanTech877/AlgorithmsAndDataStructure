/*
 * Given a string array words, find the maximum value of length(word[i]) * length(word[j]) where the two words do not share common letters. 
 * You may assume that each word will contain only lower case letters. If no such two words exist, return 0.
 */
public class MaximumProductWordLengths {

	public int maxProduct(String[] words) {
		if(words==null && words.length==0) return 0;
		int[] chars = new int[words.length];
		for (int i = 0; i < chars.length; i++) {
			int value = 0;
			for (int j = 0; j < words[i].length(); j++) {
				value |= 1 << (words[i].charAt(j) - 'a');
			}
			chars[i] = value;
		}
		int maxProduct = 0;
		for (int i = 0; i < words.length; i++) {
			for (int j = i + 1; j < words.length; j++) {
				if ((chars[i] & chars[j]) == 0) {
					maxProduct = Math.max(maxProduct, words[i].length() * words[j].length());
				}
			}
		}
		return maxProduct;
	}
}
