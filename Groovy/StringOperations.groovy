sb = "Hello"
sb <<= " "
sb <<= "Tom!"
assert sb.toString() == "Hello Tom"
print sb