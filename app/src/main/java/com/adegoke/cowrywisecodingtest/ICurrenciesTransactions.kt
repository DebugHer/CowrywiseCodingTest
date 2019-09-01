package com.adegoke.cowrywisecodingtest

import io.realm.Realm

interface ICurrenciesTransactions {
    fun addCurrencies(realm: Realm, rates: Rates?):Boolean
}