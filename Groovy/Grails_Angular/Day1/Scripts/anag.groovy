def s1 = "Partial Men"
def s2 = "Parliament"
ls1 = s1.toUpperCase().split(' ').join('').toList().sort().join()
ls2 = s2.toUpperCase().split(' ').join('').toList().sort().join()
if (ls1 == ls2) println "Anagram"
else println "Not Anagram"