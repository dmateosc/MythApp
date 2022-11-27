package dmateos.com.mythapp.shared.infrastructure.config

import com.typesafe.config.ConfigFactory
import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource
import io.ktor.server.config.*
import kotlinx.coroutines.Dispatchers
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.Table
import org.jetbrains.exposed.sql.transactions.experimental.newSuspendedTransaction
import org.jetbrains.exposed.sql.transactions.transaction

private lateinit var database: Database
fun initDB() {

    val config = HoconApplicationConfig(ConfigFactory.load())

    val hikariConfig = HikariConfig()
    hikariConfig.jdbcUrl = config.propertyOrNull("ktor.datasource1.url")?.getString()
    hikariConfig.username = config.propertyOrNull("ktor.datasource1.user")?.getString()
    hikariConfig.password = config.propertyOrNull("ktor.datasource1.password")?.getString()
    hikariConfig.driverClassName = config.propertyOrNull("ktor.datasource1.driverClassName")?.getString()
    val dataSource = HikariDataSource(hikariConfig)
    database = Database.connect(dataSource)
}

fun create(clazz: Table) {
    transaction(database) {
        SchemaUtils.create(clazz)
    }
}

suspend fun <T> dbQuery(block: suspend () -> T): T = newSuspendedTransaction(Dispatchers.IO) { block() }