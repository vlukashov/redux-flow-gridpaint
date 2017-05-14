# A demo app for using Redux with Flow

This small demo application shows how the principles of [Redux](http://redux.js.org/) can be applied to building an app with [Vaadin Flow](https://github.com/vaadin/flow). It includes a naive own implementation of Redux rather than relying on any existing library.

This application is based off [another Redux demo app](https://github.com/argelius/react-redux-timetravel).

## Installation
Requires Java 8 (JDK) and Maven
```shell
$ git clone https://github.com/vlukashov/redux-flow-gridpaint.git
$ cd redux-flow-gridpaint
$ mvn install
```

## Start
Starts a development server on [localhost:8080](http://localhost:8080)
```shell
$ cd redux-flow-gridpaint
$ mvn jetty:run
```