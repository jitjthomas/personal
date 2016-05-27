acc = 0

def getClear() {
    acc = 0
}

def getResult() {
    println acc
}

def add(x) {
    acc += x
}

def subtract(x) {
    acc -= x
}

add 10
subtract 5
result
clear
result
add 5
subtract 2
result

