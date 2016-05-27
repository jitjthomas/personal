import com.ardhika.gad.Category
import com.ardhika.gad.Product

class BootStrap {

    def init = { servletContext ->

        def c1 = new Category(code:'C01', name:'Toileteries', description:'For personal hygiene')
        def c2 = new Category(code:'C02', name:'Electrical', description:'Household appliances')
        c1.save(flush:true)
        c2.save(flush:true)

        println c1
        println c2
        def p1 = new Product(code:'001', name:'Tooth Brush', description:'With flexible head', cost:25.00, category:c1)
        def p2 = new Product(code:'002', name:'Tooth Paste', description:'contains salt', cost:55.00, category:c1)
        def p3 = new Product(code:'003', name:'Bath Soap', description:'enriched with oil', cost:28.00, category:c1)
        def p4 = new Product(code:'004', name:'Shampoo', description:'Anti dandruf', cost:75.00, category:c1)
        def p5 = new Product(code:'005', name:'Deo - Sports', description:'Sports use', cost:95.00, category:c1)
        p1.save(flush:true)
        p2.save(flush:true)
        p3.save(flush:true)
        p4.save(flush:true)
        p5.save(flush:true)

        println p1
        println p2
        println p3
        println p4
        println p5

    }
    def destroy = {
    }
}
