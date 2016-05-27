package com.ardhika.gad

class Product {

    String code
    String name
    String description
    double cost
    Category category

    static constraints = {
        code size:3..3
        name size:5..20
        description size:10..50
        cost nullable:false, scale:2
    }

    String toString() {
        "{$id} - {$code} - {$name} - ${cost}"
    }

}
