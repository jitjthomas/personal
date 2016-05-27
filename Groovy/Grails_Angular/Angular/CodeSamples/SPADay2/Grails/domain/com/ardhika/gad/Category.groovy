package com.ardhika.gad

class Category {

    String code
    String name
    String description

    static hasMany = [products:Product]

    static constraints = {
        code size:3..3
        name size:5..20
        description size:10..50
    }

    String toString() {
        "{$id} - {$code} - {$name}"
    }
}
