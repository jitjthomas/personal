num = 7
println num.toString().padLeft(7, '*')

def padLeftStar5 = {num -> num.toString().padLeft(5, '*')}
padLeftStar5 100
println padLeftStar5
