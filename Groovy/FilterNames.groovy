names = ["Ted", "Fred", "Med", "Sed"]
println names
shortNames = names.findAll{it.size() <= 3}
println shortNames