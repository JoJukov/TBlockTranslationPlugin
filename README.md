[![Java CI with Gradle](https://github.com/JoJukov/TBlockTranslationPlugin/actions/workflows/gradle.yml/badge.svg)](https://github.com/JoJukov/TBlockTranslationPlugin/actions/workflows/gradle.yml)
![GitHub all releases](https://img.shields.io/github/downloads/JoJukov/TBlockTranslationPlugin/total)
![GitHub repo size](https://img.shields.io/github/repo-size/JoJukov/TBlockTranslationPlugin)
![GitHub release (latest by date)](https://img.shields.io/github/v/release/JoJukov/TBlockTranslationPlugin)

# TBlockTranslationPlugin

Plugin for text translation in IDE's by Jetbrains.

## Features

* Plugin automatically detects the source language and translates it into the language of your choice.

![image](https://user-images.githubusercontent.com/38620771/118846144-17b1b880-b8d5-11eb-80b0-1f3125c49c8d.png)

* It can can handle cases such as camel case, kebab case, snake case.

![image](https://user-images.githubusercontent.com/38620771/118846586-898a0200-b8d5-11eb-8171-c325e138fb4d.png)
![image](https://user-images.githubusercontent.com/38620771/118846636-9a3a7800-b8d5-11eb-9950-f9d0c15433fc.png)

* Сan automatically select a block of text (words too), without having to select it all.
* Does not require api token from user

## Settings

You can change the language in which the plugin will translate text or text styles that it will process

Go `File ⟶ Settings ⟶ Tools ⟶ TBlock Translator settings`

![image](https://user-images.githubusercontent.com/38620771/118848396-64968e80-b8d7-11eb-9b1d-69b701de249f.png)

## Building from the source

1. Clone the repository using the following command.

    ```
    git clone --recursive https://github.com/JoJukov/TBlockTranslationPlugin.git
    ```
2. Navigate into the cloned repository and run `./gradlew buildPlugin`. In the **build/distributions** directory, **.zip** file with plugin will be created.

   **Note:** On Windows, you don’t need the leading `./` in front of the `gradlew` command

## Installing the plugin to IDEA

### From Jetbrains plugin repository (soon)
1. Go to **Settings** (**Preferences** in **MacOS**)-> **Plugins**. 
2. Select **Browse Repositories** button at the bottom. 
3. Search for **TBlock translator** using the search box. Ballerina plugin will show up. Then you can install the plugin using the Install button.
4. Restart IDEA.

### From a local build
1. Go to **File -> Settings** (**IntelliJ IDEA -> Preferences** in **macOS**) and select **Plugins**.
2. Click **Install plugin from disc** button and select the deployed **plugin zip** file. Please make sure to install the Zip file, not the extracted Jar files. This zip contains an additional library as well. Without this library, the plugin will not work properly.
3. Restart IDEA.


