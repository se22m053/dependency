package contracts

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    description "should return customer name and balance list"
    request {
        method GET()
        url("/customer-balances") {
//            queryParameters {
//                parameter("number", "2")
//            }
        }
    }
    response {
        body("name": "Manuel",
                "aggregatedBalance": 0)
        status 200
    }
}