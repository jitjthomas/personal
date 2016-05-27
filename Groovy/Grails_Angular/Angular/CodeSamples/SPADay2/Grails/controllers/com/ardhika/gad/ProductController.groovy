package com.ardhika.gad

import grails.converters.JSON

class ProductController {
    def list() {
        render Product.list() as JSON
    }

    def get(Long id) {
        def productInstance = Product.get(id)
        render productInstance as JSON
    }

    def delete(Long id) {
        def productInstance = Product.get(id)
        productInstance.delete()
        def responseBody = [message:'successfully deleted']
        render responseBody as JSON
    }

    def update(Long id, Long version) {
        def productInstance = Product.get(id)
        productInstance.properties = request.JSON
        productInstance.category = Category.get(request.JSON.category.id)
        def responseBody = [:]
        if(productInstance.save(flush:true)) {
            responseBody.id = productInstance.id
            responseBody.message = 'Product updated successfully'
            response.status = 200
        }
        else {
            responseBody.message = 'Some error(s) exist'
            response.status = 400
        }
        render responseBody as JSON
    }

    def save() {
        def productInstance = new Product(request.JSON)
        productInstance.category = Category.get(request.JSON.category.id)

        def responseBody = [:]
        if(productInstance.save(flush:true)) {
            responseBody.id = productInstance.id
            responseBody.message = 'Product created successfully'
            response.status = 200
        }
        else {
            responseBody.message = 'Some error(s) exist'
            response.status = 400
        }
        render responseBody as JSON
    }

}
