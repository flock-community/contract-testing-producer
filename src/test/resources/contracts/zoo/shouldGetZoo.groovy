package contracts.zoo

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    request {
        method 'GET'
        url '/zoo/12345'
        headers {
            accept('application/json')
        }
    }
    response {
        status OK()
        body(
                [
                        id     : "12345",
                        address:
                                [
                                        streetName : "street",
                                        houseNumber: "1",
                                        zipCode    : "1234 AA",
                                        country    : "NL"
                                ],
                        mammals: []
                ]
        )
        headers {
            contentType('application/json')
        }
    }

    request {
        method 'GET'
        url '/zoo/abcde'
        headers {
            accept('application/json')
        }
    }
    response {
        status NOT_FOUND()
    }
}
