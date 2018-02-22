package com.kodilla.exception.test;

class RouteNotFoundException extends Exception {
    RouteNotFoundException(String message) {
        super(message);
    }
}
