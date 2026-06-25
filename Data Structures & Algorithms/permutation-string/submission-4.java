class Solution {
    public static boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }
        int[] s1Count = new int[26];
        int[] windowCount = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            s1Count[s1.charAt(i) - 'a']++;
            windowCount[s2.charAt(i) - 'a']++;
        }
        for (int i = s1.length(); i < s2.length(); i++) {
            // Check if the current window matches s1
            if (Arrays.equals(s1Count, windowCount)) {
                return true;
            }

            // Slide the window:
            // 1. Add the new character entering from the right
            char charEntering = s2.charAt(i);
            windowCount[charEntering - 'a']++;

            // 2. Remove the old character leaving from the left
            char charLeaving = s2.charAt(i - s1.length());
            windowCount[charLeaving - 'a']--;
        }

        // Step 5: Final check for the very last window position
        return Arrays.equals(s1Count, windowCount);

    }
}
