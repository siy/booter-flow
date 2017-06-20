package org.rxbooter.flow;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

public class SrcGen {
    private static final String EXT = ".java";
    private static final String INDENT = "    ";
    private static final String PACKAGE = SrcGen.class.getPackage().getName();
    private static final int NUM_PARAMS = 3;
    public static final String SEPARATOR = ", ";

    public static void main(String[] args) {
        generate("Tuples", SrcGen::generateTuples);
        generate("Functions", SrcGen::generateFunctions);
        generate("Flows", SrcGen::generateFlows);
    }

    public interface Generator {
        void generate(PrintWriter writer, String name);
    }

    private static void generate(String name, Generator generator) {
        try(PrintWriter writer = openWriter(name)) {
            generator.generate(writer, name);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void generateFlows(PrintWriter writer, String name) {
        writer.println("package " + PACKAGE + ";");
        writer.println();
        writer.println("import static " + PACKAGE + ".Functions.*;");
        writer.println("import static " + PACKAGE + ".Tuples.*;");
        writer.println();
        writer.println("public final class " + name + " {");
        writer.println(INDENT + "private " + name + "() {}");
        writer.println();

        for(int i = 1; i <= NUM_PARAMS; i++) { //Inputs
            writer.println(INDENT + "public static<" + typeList("T", i) + "> Flow" + i + "<"
                           + typeList("T", i) + "> with(" + inputClassParamList(i) + ") {");
            writer.println(INDENT + INDENT + "return new Flow" + i + "<>(null);");
            writer.println(INDENT + "}");
            if (i != NUM_PARAMS) {
                writer.println();
            }
        }

        writer.println();
        writer.println(INDENT + "public interface TF<R1, T1> {");
        writer.println(INDENT + INDENT + "R1 apply(T1 param) throws Throwable;");
        writer.println(INDENT + "}");

        writer.println();
        writer.println(INDENT + "public static class Step<R1, T1> {");
        writer.println(INDENT + INDENT + "private final boolean blocking;");
        writer.println(INDENT + INDENT + "private final TF<R1, T1> function;");
        writer.println(INDENT + INDENT + "private long time = Long.MAX_VALUE;");
        writer.println();
        writer.println(INDENT + INDENT + "public Step(boolean blocking, TF<R1, T1> function) {");
        writer.println(INDENT + INDENT + INDENT + "this.blocking = blocking;");
        writer.println(INDENT + INDENT + INDENT + "this.function = function;");
        writer.println(INDENT + INDENT + "}");
        writer.println();
        writer.println(INDENT + INDENT + "public boolean blocking() {");
        writer.println(INDENT + INDENT + INDENT + "return blocking;");
        writer.println(INDENT + INDENT + "}");
        writer.println();
        writer.println(INDENT + INDENT + "public long time() {");
        writer.println(INDENT + INDENT + INDENT + "return time;");
        writer.println(INDENT + INDENT + "}");
        writer.println();
        writer.println(INDENT + INDENT + "public R1 apply(T1 param) throws Throwable {");
        writer.println(INDENT + INDENT + INDENT + "return function.apply(param);");
        writer.println(INDENT + INDENT + "}");
        writer.println();
        writer.println(INDENT + INDENT + "public R1 measure(T1 param) throws Throwable {");
        writer.println(INDENT + INDENT + INDENT + "long start = System.nanoTime();");
        writer.println(INDENT + INDENT + INDENT + "try {");
        writer.println(INDENT + INDENT + INDENT + INDENT + "return function.apply(param);");
        writer.println(INDENT + INDENT + INDENT + "} finally {");
        writer.println(INDENT + INDENT + INDENT + INDENT + "time = System.nanoTime() - start;");
        writer.println(INDENT + INDENT + INDENT + "}");
        writer.println(INDENT + INDENT + "}");
        writer.println(INDENT + "}");
        writer.println();
        writer.println(INDENT + "protected static class Flow {");
        writer.println(INDENT + INDENT + "private final Flow prev;");
        writer.println(INDENT + INDENT + "protected Step<?, ?> step;");
        writer.println();
        writer.println(INDENT + INDENT + "protected Flow(Flow prev) {");
        writer.println(INDENT + INDENT + INDENT + "this.prev = prev;");
        writer.println(INDENT + INDENT + "}");
        writer.println();
        writer.println(INDENT + INDENT + "public <R1, T1> Step<R1, T1> step() {");
        writer.println(INDENT + INDENT + INDENT + "return (Step<R1, T1>) step;");
        writer.println(INDENT + INDENT + "}");
        writer.println();
        writer.println(INDENT + INDENT + "public Flow prev() {");
        writer.println(INDENT + INDENT + INDENT + "return prev;");
        writer.println(INDENT + INDENT + "}");
        writer.println(INDENT + "}");
        writer.println();

        for(int i = 1; i <= NUM_PARAMS; i++) { //Inputs
            writer.println(INDENT + "public static class " + flowNameType("T", i) + " extends Flow {");
            writer.println(INDENT + INDENT + "public Flow" + i + "(Flow prev) {");
            writer.println(INDENT + INDENT + INDENT + "super(prev);");
            writer.println(INDENT + INDENT + "}");
            writer.println();

            //Flow methods
            for (int k = 1; k <= NUM_PARAMS; k++) { //Outputs
                for (int j = 1; j <= i; j++) { //Inputs
                    writer.println(INDENT + INDENT + "public <" + typeList("R", k) + "> "+ flowNameType("R", k) + " apply" + k + "(" + functionNameType(j, k) +  " function) {");
                    writer.println(INDENT + INDENT + INDENT +
                        "step = new Step<>(false, (" + tupleName("T", j) + " param) -> function.apply(" +
                            tupleToParams("T", j) + "));");
                    writer.println(INDENT + INDENT + INDENT + "return new Flow" + k + "<>(this);");
                    writer.println(INDENT + INDENT + "}");

                    if (j != i) {
                        writer.println();
                    }
                }
                if (k != NUM_PARAMS) {
                    writer.println();
                }
            }

            writer.println(INDENT + "}");

            if (i != NUM_PARAMS) {
                writer.println();
            }
        }

        writer.println("}");
    }

    private static String flowNameType(String prefix, int i) {
        return "Flow" + i + "<" + typeList(prefix, i) + ">";
    }

    private static void generateTuples(PrintWriter writer, String name) {
        writer.println("package " + PACKAGE + ";");
        writer.println();
        writer.println("public final class " + name + " {");
        writer.println(INDENT + "private " + name + "() {}");
        writer.println();

        for(int i = 1; i <= NUM_PARAMS; i++) { //Inputs
            writer.println(INDENT + "public static<" + typeList("T", i) + "> Tuple" + i + "<"
                           + typeList("T", i) + "> of(" + inputParamList(i) + ") {");
            writer.println(INDENT + INDENT + "return new Tuple" + i + "<>(" + paramList(i) + ");");
            writer.println(INDENT + "}");
            if (i != NUM_PARAMS) {
                writer.println();
            }
        }

        writer.println();
        writer.println(INDENT + "public static class Tuple {");
        writer.println(INDENT + INDENT + "private final Object[] values;");
        writer.println();
        writer.println(INDENT + INDENT + "protected Tuple(Object ... values) {");
        writer.println(INDENT + INDENT + INDENT + "this.values = values;");
        writer.println(INDENT + INDENT + "}");
        writer.println();
        writer.println(INDENT + INDENT + "public Object get(int i) {");
        writer.println(INDENT + INDENT + INDENT + "return values[i];");
        writer.println(INDENT + INDENT + "}");
        writer.println(INDENT + "}");
        writer.println();

        for(int i = 1; i <= NUM_PARAMS; i++) { //Inputs
                writer.println(INDENT + "public static class Tuple" + i + "<" + typeList("T", i) + "> extends Tuple {");
                writer.println(INDENT + INDENT + "public Tuple" + i + "(" + inputParamList(i) + ") {");
                writer.println(INDENT + INDENT + INDENT + "super(" + paramList(i) + ");");
                writer.println(INDENT + INDENT + "}");
                writer.println(INDENT + "}");

                if (i != NUM_PARAMS) {
                    writer.println();
                }
        }

        writer.println("}");
    }

    private static void generateFunctions(PrintWriter writer, String name) {
        writer.println("package " + PACKAGE + ";");
        writer.println();
        writer.println("import static " + PACKAGE + ".Tuples.*;");
        writer.println();
        writer.println("public interface " + name + " {");

        for(int j = 1; j <= NUM_PARAMS; j++) { //Outputs
            for(int i = 1; i <= NUM_PARAMS; i++) { //Inputs
                writer.println(INDENT + "interface " + functionNameType(i, j) + " {");
                writer.println(INDENT + INDENT + tupleName("R", j) + " apply(" + inputParamList(i) + ");");
                writer.println(INDENT + "}");

                if (i != NUM_PARAMS || j != NUM_PARAMS) {
                    writer.println();
                }
            }
        }

        writer.println("}");
    }

    private static String functionNameType(int i, int j) {
        return "FN" + j + i + typeList(i, j);
    }

    private static String paramList(int count) {
        StringBuilder builder = new StringBuilder();

        for (int i = 1; i <= count; i++) {
            builder.append("param").append(i).append(SEPARATOR);
        }

        builder.setLength(builder.length() - SEPARATOR.length());
        return builder.toString();
    }

    private static String tupleToParams(String prefix, int count) {
        StringBuilder builder = new StringBuilder();

        for (int i = 1; i <= count; i++) {
            builder.append("(T").append(i).append(") ").append("param.get(").append(i-1).append(")").append(SEPARATOR);
        }

        builder.setLength(builder.length() - SEPARATOR.length());
        return builder.toString();
    }

    private static String inputParamList(int count) {
        StringBuilder builder = new StringBuilder();

        for (int i = 1; i <= count; i++) {
            builder.append("T").append(i).append(' ').append("param").append(i).append(SEPARATOR);
        }

        builder.setLength(builder.length() - SEPARATOR.length());
        return builder.toString();
    }

    private static String inputClassParamList(int count) {
        StringBuilder builder = new StringBuilder();

        for (int i = 1; i <= count; i++) {
            builder.append("Class<T").append(i).append("> ").append("param").append(i).append(SEPARATOR);
        }

        builder.setLength(builder.length() - SEPARATOR.length());
        return builder.toString();
    }

    private static String tupleName(String prefix, int j) {
        return "Tuple" + j + "<" + typeList(prefix, j) + ">";
    }

    private static String typeList(int inputs, int outputs) {
        return "<" + typeList("R", outputs) + SEPARATOR + typeList("T", inputs) + ">";
    }

    private static String typeList(String prefix, int count) {
        StringBuilder builder = new StringBuilder();

        for (int i = 1; i <= count; i++) {
            builder.append(prefix).append(i).append(SEPARATOR);
        }

        builder.setLength(builder.length() - SEPARATOR.length());
        return builder.toString();
    }

    private static PrintWriter openWriter(String name) throws IOException {
        return new PrintWriter(new FileOutputStream(name + EXT));
    }
}
