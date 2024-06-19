/*

Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

Example 1:

Input: n = 3
Output: ["((()))","(()())","(())()","()(())","()()()"]
Example 2:

Input: n = 1
Output: ["()"]

Constraints:

1 <= n <= 8

****************************************************Solution***********************************************/

function generateParenthesis(n) {
    const result = []

    function util(countOfOpeningParenthesis = n, countOfClosingParenthesis = n, ans = '') {
        if (countOfOpeningParenthesis === 0 && countOfClosingParenthesis === 0) {
            result.push(ans)
            return
        }

        if (countOfOpeningParenthesis > 0) {
            util(countOfOpeningParenthesis - 1, countOfClosingParenthesis, ans + '(')
        }

        if (countOfClosingParenthesis > countOfOpeningParenthesis) {
            util(countOfOpeningParenthesis, countOfClosingParenthesis - 1, ans + ')')
        }
    }

    util()
    return result
};