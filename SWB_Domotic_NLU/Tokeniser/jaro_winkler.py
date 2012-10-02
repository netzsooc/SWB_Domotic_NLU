'''
Created on 27/09/2012

@author: netzsooc
'''
import jellyfish

def jaro_winkler(string1, string2):
    if string1 == string2:
        return 1.0
    
    len1 = len(string1)
    len2 = len(string2)
    floor = (max(len1, len2) / 2) - 1
    
    if floor < 0:
        floor = 0
    t = 0
    m = 0
    match1 = ""
    match2 = ""
    
    for i in range(len1):
        start = max(0, i - floor)
        end = min(i + floor + 1, len2)
        for j in range(start, end):
            if string1[i] == string2[j]:
                m += 1
                if i != j:
                    match1 += string1[i]
                    match2 += string2[j]
                    t += 1
                    continue
                match1 += string1[i]
                match2 += string2[j]
    if m == 0:
        return 0
    m = float(m)
    t /= 2.0
    print match1
    print match2
    return (m / len1 + m / len2 + (m - t) / m) / 3
