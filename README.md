# quotes

## Introduction

**This appliction is built to show quotes from different authors**

## Installation

In order to use this application you must install Gson library by adding it to your library list or by adding it to dependencies and resync your project in Intelij.

command `compile 'com.google.code.gson:gson:2.8.0'`

## App Usage

**From your terminal use the following commands:**

1. `./gradlew run --args 'author < author name>'` to find the quotes based on author name

2. `./gradlew run --args 'contains <words>'` to search by keyword inside a quote

3. `./gradlew run --args 'random'` to show a random quote
