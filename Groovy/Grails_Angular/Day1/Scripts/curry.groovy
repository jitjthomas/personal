def mult = { x, y -> x * y }

def twice = mult.curry(2)
def thrice = mult.curry(3) 

assert mult(2,4) == 8
assert twice(3) == 6
assert thrice(4) == 12
