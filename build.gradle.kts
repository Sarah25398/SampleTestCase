plugins {
    id("java")
}
group = "org.example"
version = "1.0-SNAPSHOT"
repositories {
    mavenCentral()
}
dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    // https://mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-java
    implementation("org.seleniumhq.selenium:selenium-java:4.24.0")
    // https://mvnrepository.com/artifact/org.testng/testng
    implementation("org.testng:testng:7.10.2")
    // https://mvnrepository.com/artifact/io.github.bonigarcia/webdrivermanager
    implementation("io.github.bonigarcia:webdrivermanager:5.9.2")
    // https://mvnrepository.com/artifact/io.rest-assured/rest-assured
    implementation("io.rest-assured:rest-assured:5.5.0")
    // https://mvnrepository.com/artifact/org.apache.poi/poi-ooxml
    implementation("org.apache.poi:poi-ooxml:5.3.0")
    // https://mvnrepository.com/artifact/com.mysql/mysql-connector-j
    implementation("com.mysql:mysql-connector-j:9.1.0")
    // https://mvnrepository.com/artifact/com.aventstack/extentreports
    implementation("com.aventstack:extentreports:5.1.2")
    // https://mvnrepository.com/artifact/io.qameta.allure/allure-testng
    implementation("io.qameta.allure:allure-testng:2.29.1")
    implementation ("io.gatling.highcharts:gatling-charts-highcharts:3.9.0")
    implementation ("io.gatling:gatling-app:3.9.0")
    implementation("com.github.stephenc.monte:monte-screen-recorder:0.7.7.0")
    // https://mvnrepository.com/artifact/com.github.stephenc.monte/monte-screen-recorder
    implementation("com.github.stephenc.monte:monte-screen-recorder:0.7.7.0")



}

tasks.test {
    useJUnitPlatform()
}