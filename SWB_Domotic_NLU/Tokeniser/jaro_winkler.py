'''
Created on 27/09/2012

@author: netzsooc
'''
import jellyfish

def jaro_winkler(string1, string2):
    m = 0
    len1 = len(string1)
    len2 = len(string2)
    floor = (max(len1, len2) / 2) - 1
    
    if floor < 0:
        floor = 0
    t = floor / 2
    
#    if not len1 or not len2:
#        return 0
    
    for i in range(max(len1, len2)):
        for j in range(floor):
            

print jellyfish.jaro_winkler("hello", "goodbye")    