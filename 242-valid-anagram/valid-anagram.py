class Solution(object):
    def isAnagram(self, s, t):
        """
        :type s: str
        :type t: str
        :rtype: bool
        """
        if len(s) != len(t):
            return False

        freqS = {}
        freqT = {}

        for char in s:
            if char in freqS:
                freqS[char] += 1
            else:
                freqS[char] = 1

        for char in t:
            if char in freqT:
                freqT[char] += 1
            else:
                freqT[char] = 1

        return freqS == freqT