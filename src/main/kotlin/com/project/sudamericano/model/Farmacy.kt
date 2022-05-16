package com.project.sudamericano.model

import javax.persistence.*

@Entity
@Table(name = "farmacy")

class Farmacy {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(updatable = false)

    var id: Long? = null
    var name: String? = null
    var phone: String? = null
    var address: String? = null
    var status: String? = null
    var idUser: Long? = null
    var idCompany: Long? = null
    var idSector: Long? = null

}