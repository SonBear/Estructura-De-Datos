/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package exception;

/**
 *
 * @author jorge.reyes
 */
public class ItemNotFoundException extends RuntimeException {

    public ItemNotFoundException(String msg) {
        super(msg);
    }

}
