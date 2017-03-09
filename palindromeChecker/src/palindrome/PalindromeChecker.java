package palindrome;

/**
 * Перевірка на паліндром
 * @author Michael
 */
public class PalindromeChecker {

    /**
     * перевіряє чи є рядок паліндромом
     *
     * @param inputString вхідний рядок
     * @return
     * <p>
     * true - якщо вхідний рядок є паліндромом
     * <p>
     * false - якщо вхідний рядок не є паліндромом
     */
    public static boolean checkForPalindrome(String inputString) {
        //приведення до одного регістру
        inputString = inputString.toLowerCase();

        //порожній рядок і рядок з одного символу  не є паліндромами
        if (inputString.length() < 2) {
            return false;
        }

        //попарно рівнюємо i-й спочатку та i-й з кінця символи, до середини рядка
        for (int i = 0, n = inputString.length() - 1; i < (n / 2) + 1; i++) {
            if (inputString.charAt(i) != inputString.charAt(n - i)) {
                return false;
            }
        }

        return true;
    }
}
