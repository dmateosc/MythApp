package dmateos.com.mythapp.infrastructure.plugins

import com.typesafe.config.ConfigFactory
import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource
import io.ktor.server.application.*
import io.ktor.server.config.*
import io.ktor.server.engine.*
import org.jetbrains.exposed.sql.Database



fun Application.initDB() {
    val config = HoconApplicationConfig(ConfigFactory.load())

    val hikariConfig = HikariConfig()
    hikariConfig.jdbcUrl = config.propertyOrNull("ktor.datasource1.url")?.getString()
    hikariConfig.username = config.propertyOrNull("ktor.datasource1.user")?.getString()
    hikariConfig.password = config.propertyOrNull("ktor.datasource1.password")?.getString()
    hikariConfig.driverClassName = config.propertyOrNull("ktor.datasource1.driverClassName")?.getString()
    val dataSource = HikariDataSource(hikariConfig)
    Database.connect(dataSource)
}