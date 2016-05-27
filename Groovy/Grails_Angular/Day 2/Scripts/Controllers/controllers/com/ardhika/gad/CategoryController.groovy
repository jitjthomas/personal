package com.ardhika.gad

import grails.converters.JSON

class CategoryController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def list() {
        render Category.list() as JSON
    }

    def get(Long id) {
        def categoryInstance = Category.get(id)
        response.status = 200
        render categoryInstance as JSON
    }

    def delete(Long id) {
        def responseBody = [:]
        def categoryInstance = Category.get(id)
        if (categoryInstance.products.size() > 0) {
            response.status = 400
            responseBody.message = "category not empty"
        }
        else {
            response.status = 200
            categoryInstance.delete(flush:true)
            responseBody.message= 'successfully deleted'
        }
        render responseBody as JSON
    }

    def save() {
        def categoryInstance = new Category()
        categoryInstance.properties = request.JSON
        def responseBody = [:]
        if(categoryInstance.save(flush:true)) {
            responseBody.id = categoryInstance.id
            responseBody.message = 'Category created successfully'
            response.status = 200
        }
        else {
            responseBody.message = 'Some error(s) exist'
            response.status = 400
        }
        render responseBody as JSON
    }

    def update(Long id, Long version) {
        println request.JSON
        def categoryInstance = Category.get(id)
        categoryInstance.properties = request.JSON
        def responseBody = [:]
        if(categoryInstance.save(flush:true)) {
            responseBody.id = categoryInstance.id
            responseBody.message = 'Category updated successfully'
            response.status = 200
        }
        else {
            responseBody.message = 'Some error(s) exist'
            response.status = 400
        }
        render responseBody as JSON
    }

    def products(Long id) {
        def categoryInstance = Category.get(id)
        render categoryInstance.products as JSON
    }


}
