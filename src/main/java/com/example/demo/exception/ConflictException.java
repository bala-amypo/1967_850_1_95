package com.example.demo.exception;

public class ConflictException {

}
package com.example.demo.exception;

public class ConflictException extends RuntimeException {
    public ConflictException(String message) {
        super(message);
    }
}
