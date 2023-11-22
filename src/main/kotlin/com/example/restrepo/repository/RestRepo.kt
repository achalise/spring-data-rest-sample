package com.example.restrepo.repository

import jakarta.persistence.CascadeType
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.OneToOne
import org.springframework.data.repository.CrudRepository
import org.springframework.data.rest.core.annotation.RepositoryRestResource

@Entity
open class Address(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) open var id: Long? = null,
    open var street: String,
    open var suburb: String,
    open var state: String,
    open var country: String
)

@Entity
open class Customer(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) open var id: Long? = null,
    open var firstName: String,
    open var lastName: String,
    @OneToOne(cascade = [CascadeType.ALL])
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    open var address: Address? = null
)

@RepositoryRestResource
interface AddressRepository: CrudRepository<Address, Long>

@RepositoryRestResource
interface CustomerRepository: CrudRepository<Customer, Long>