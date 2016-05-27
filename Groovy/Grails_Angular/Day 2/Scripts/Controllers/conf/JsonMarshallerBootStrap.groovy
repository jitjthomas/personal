import com.ardhika.gad.Category
import com.ardhika.gad.Product

class JsonMarshallerBootStrap {

    def init = { servletContext ->
        grails.converters.JSON.registerObjectMarshaller(Product) { Product product ->
            def output = [:]
            output.id = product.id
            output.version = product.version
            output.code = product.code
            output.name = product.name
            output.description = product.description
            output.cost = product.cost
            output.category = [id:product.category.id, name:product.category.name]
            return output
        }

        grails.converters.JSON.registerObjectMarshaller(Category) { Category category ->
            def output = [:]
            output.id = category.id
            output.version = category.version
            output.code = category.code
            output.name = category.name
            output.description = category.description
            return output
        }
    }
    def destroy = {
    }
}
