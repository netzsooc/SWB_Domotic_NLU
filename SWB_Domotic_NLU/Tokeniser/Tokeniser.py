#!/usr/bin/env python
#-*- encoding:UTF-8 -*-
'''
Created on 27/09/2012

@author: netzsooc
'''

def term_finder(sentence, elements):
    '''Sentence is a string and elements is a list containing elements'''
    for element in elements:
        if term_normaliser(sentence).find(term_normaliser(element)) >= 0:
            return element
    return    

def term_normaliser(term, symbol=""):
    return symbol.join(term.split())


def len_sorted(iterable):
    return sorted(iterable, key=lambda s: len(s), reverse=True)

s = "enciende el foco de la recámara al 50%"
e = len_sorted(["foco de la recámara", "foco de la habitación", 'foco', 
                'foco no conocido'])
tf = term_finder(s, e)
if tf:
    s = s[:s.find(tf)] + term_normaliser(tf, "_") + s[s.find(tf) + len(tf):]
print s