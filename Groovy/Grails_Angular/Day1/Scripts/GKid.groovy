class Kid {
    String name
    int age
    
    String toString() {
        "name : $name, age : $age"
    }
    
    void setAge(int age) {
        if (age >=2 && age <=10) {
            this.age = age
            return 
        }
        this.age = 10
    }
}

def k = new Kid(name:"Peter", age: 12)

println k.name
println k.age
k.age = 15
println k

