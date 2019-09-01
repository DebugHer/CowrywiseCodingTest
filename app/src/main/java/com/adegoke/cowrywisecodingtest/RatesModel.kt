package com.adegoke.cowrywisecodingtest

import io.realm.Realm

class RatesModel: ICurrenciesTransactions {
    override fun addCurrencies(realm: Realm, rates: Rates?): Boolean {
        try {
            realm.beginTransaction()
            realm.copyToRealmOrUpdate(rates)
            realm.commitTransaction()
            return true
        } catch (e: Exception) {
            println(e)
            return false
        }
    }
}