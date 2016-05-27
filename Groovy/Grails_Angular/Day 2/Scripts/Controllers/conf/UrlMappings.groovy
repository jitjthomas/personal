class UrlMappings {

	static mappings = {
//        "/$controller/$action?/$id?(.$format)?"{
//            constraints {
//                // apply constraints here
//            }
//        }
//
        "/"(uri:"/pages/index.html")
        "500"(view:'/error')

        "/categories"(controller:"Category", action: "list", method: "GET")
        "/category/$id" {
            controller="Category"
            action = [GET:"get", PUT:"update", DELETE:"delete"]
        }
        "/category" (controller:"Category", action:"save", method: "POST")
        "/category/$id/products" (controller: "Category", action: "products", method: "GET")

        "/products" (controller: "Product", action: "list", method: "GET")
        "/product/$id" {
            controller = "Product"
            action =[GET: "get", "PUT": "update", DELETE: "delete"]
        }
        "/product" (controller: "Product", action: "save", method: "POST")
	}
}
