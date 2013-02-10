package com.iankwalter.rhinostockexample;

import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;
import org.mozilla.javascript.ScriptableObject;

/**
 * An example of how to use Mozilla Rhino to execute JavaScript within Java
 *
 * @author Ian Kennington Walter
 */
public class EvaluateStock {

    /**
     * Evaluates whether a Stock is undervalued based on logic within a JS script
     *
     * @param args
     */
    public static void main(String[] args) {

        // Define evaluation JavaScript. Typically this would be stored in a file or a database.
        String evaluationScript =
            "var earnings = stock.getNetIncome() * 10; " +
            "earnings += (stock.getTotalCash() - stock.getTotalDebt()); " +
            "if (earnings > stock.getMarketCap()) { " +
            "    stock.setUndervalued(true); " +
            "} else { " +
            "    stock.setUndervalued(false); " +
            "} ";

        // Create a Stock object to evaluate.
        Stock stock = new Stock();
        stock.setNetIncome(10.0);
        stock.setTotalCash(100.0);
        stock.setTotalDebt(0.0);
        stock.setMarketCap(150.0);

        // Create and enter a Context. A Context stores information about the execution environment of a script.
        Context cx = Context.enter();
        try {
            // Initialize the standard objects (Object, Function, etc.). This must be done before scripts can be
            // executed. The null parameter tells initStandardObjects
            // to create and return a scope object that we use
            // in later calls.
            Scriptable scope = cx.initStandardObjects();

            // Pass the Stock Java object to the JavaScript context
            Object wrappedStock = Context.javaToJS(stock, scope);
            ScriptableObject.putProperty(scope, "stock", wrappedStock);

            // Execute the script
            cx.evaluateString(scope, evaluationScript, "EvaluationScript", 1, null);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Exit the Context. This removes the association between the Context and the current thread and is an
            // essential cleanup action. There should be a call to exit for every call to enter.
            Context.exit();
        }

        // Output whether the stock was determined to be undervalued.
        System.out.println("Is stock undervalued?");
        System.out.println(stock.isUndervalued());
    }

}
