<h1 align="center">ktor-database</h1>
<p align="center">
	<img src="https://img.shields.io/github/license/talemke/ktor-database?label=License" />
	<img src="https://img.shields.io/badge/Kotlin-1.9-purple?logo=Kotlin" />
</p>



## Features

- Bridge between [Ktor](https://github.com/ktorio/ktor) and [JetBrains/Exposed](https://github.com/JetBrains/Exposed)
- Supports suspending transactions
- Database metrics for specific endpoints
- Multiple databases



## Usage

Step 1. Install the plugin:
```kotlin
// ... (this: Application)

install(Database)

// ...
```

Step 2. Use within calls:
```kotlin
get("/hello_world") {
    val result = call.transaction {
        // Fetch data...
    }
    call.respond(result)
}
```
