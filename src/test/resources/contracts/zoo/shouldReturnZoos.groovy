package contracts.zoo

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    request {
        method 'GET'
        url '/zoo'
        headers {
            accept('application/json')
        }
    }
    response {
        status OK()
        body(
                [
                        [
                                id     : "12345",
                                address:
                                        [
                                                streetName : "Street-1",
                                                houseNumber: "1-a",
                                                zipCode    : "1000 AB",
                                                country    : "NL"
                                        ],
                                mammals: [
                                        [
                                                id     : "1",
                                                name   : "Elephant",
                                                species: "Chorda"
                                        ],
                                        [
                                                id     : "2",
                                                name   : "Crocodile",
                                                species: "Reptile"
                                        ]
                                ]
                        ],
                        [
                                id     : "23456",
                                address:
                                        [
                                                streetName : "Street-2",
                                                houseNumber: "2-a",
                                                zipCode    : "1001 BC",
                                                country    : "BE"
                                        ],
                                mammals: [
                                        [
                                                id     : "3",
                                                name   : "Lama",
                                                species: "Camel"
                                        ]
                                ]
                        ]
                ]
        )
        headers {
            contentType('application/json')
        }
    }
}
