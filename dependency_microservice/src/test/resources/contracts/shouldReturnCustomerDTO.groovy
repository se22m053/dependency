package contracts

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    description "should return customer DTO list"
    request {
        method GET()
        url("/customer") {
//            queryParameters {
//                parameter("number", "2")
//            }
        }
    }
    response {
        body("name": "Manuel",
                "email": "manuels-email",
                "status": "manuels-status")
        status 200
    }
}
