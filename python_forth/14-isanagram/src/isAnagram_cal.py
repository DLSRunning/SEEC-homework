def is_anagram(str1, str2):
    if len(str1) != len(str2):
        return False
    else:
        str1_l = []
        for i in range(0, len(str1)):
            str1_l.append(str1[i])
        str1_l.sort()

        str2_l = []
        for i in range(0, len(str2)):
            str2_l.append(str2[i])
        str2_l.sort()

        for i in range(0, len(str2)):
            if str2_l[i] != str1_l[i]:
                return False
        return True

if __name__ == '__main__':
    str1 = input()
    str2 = input()
    print(is_anagram(str1, str2))

