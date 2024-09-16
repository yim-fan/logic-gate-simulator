/** Errors.java is a support class used for warnings and fatal error reporting.
 *  Code here produces error messages with a standard prefix and general format.
 *  @author Yimeng Fan, Douglas W. Jones
 *  @version 2017-12-1
 *  Adapted from Logic.java Version 2017-11-25 (the MP5 solution).
 * 
 *  Bug notices in the code indicate unsolved problems
 */
public class Errors {
    // error messages are counted.
    private static int errorCount = 0;

    /** Allow public read-only access to the count of error messages
     * @return the count
     */
    public static int count() {
	return errorCount;
    }

    /** Report nonfatal errors, output a message and return
     * @arg message the message to output
     */
    public static void warn( String message ) {
	System.err.println( "Logic: " + message );
	errorCount = errorCount + 1;
    }

    /** Report fatal errors, output a message and exit, never to return
     * @arg message the message to output
     */
    public static void fatal( String message ) {
	warn( message );
	System.exit( 1 );
    }
}
