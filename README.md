# Gradle Play multi module template

A very simple skeleton of a Play application for Gradle, in which some modules can be included/excluded programmatically, and injected
into Play framework.


# Usage scenario

Sometimes, your Gradle project is composed of different modules that live in the same repo and, depending on some properties set at
compile time, you want to enable/disable some modules from the final build.

Here's a very simple multi-module Play project in which you can add few optional libs, and inject them into a controller.

Besides the Play application, located in the `app` folder, there are three modules:
* `api`, which contains a simple trait called `BaseTrait`
* `lib_one`, which depends on `api` and contains few implementation of `BaseTrait`
* `lib_two`, which depends on `api` and `lib_one`, and contains few implementation of `BaseTrait`

# How to build and run the project

> ./gradlew runPlayBinary

and then open a browser to http://localhost:9000. If everything went good, you will see the message
> Traits found in classpath: 5

and, in the console
> from DerivedFive  
  from DerivedFour  
  from DerivedTwo  
  from DerivedOne  
  from DerivedThree > from DerivedOne

last line is not a typo (see the implementation of DerivedThree).

# Toggle inclusion of `lib_one` and/or `lib_two`
You can replace the dependencies in the project `build.gradle`
> play project(":lib_one")  
  play project(":lib_two")

with 
> play project(":lib_${project.property('profile_lib')}")

and then build and run, for example, with
> ./gradlew runPlayBinary -Pprofile_lib=two

to enable only `lib_two`.