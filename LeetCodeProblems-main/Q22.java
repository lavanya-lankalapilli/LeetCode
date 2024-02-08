class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> answer = new ArrayList<>();
        genParenthUtil(answer, new StringBuilder(), 0, 0, n);

        return answer;
    }

    private void genParenthUtil(List<String> result, StringBuilder str, int leftCount, int rightCount, int n) {
        if (str.length() == 2 * n) {
            result.add(str.toString());
            return;
        }
        if (leftCount < n) {
            str.append('(');
            genParenthUtil(result, str, leftCount + 1, rightCount, n);
            str.deleteCharAt(str.length() - 1);
        }
        if (leftCount > rightCount) {
            str.append(')');
            genParenthUtil(result, str, leftCount, rightCount + 1, n);
            str.deleteCharAt(str.length() - 1);
        }
    }
}
