package org.rxbooter.flow;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

public class SrcGen {
    private static final String EXT = ".java";
    private static final String INDENT = "    ";
    private static final String PACKAGE = SrcGen.class.getPackage().getName();
    private static final int NUM_PARAMS = 7;
    public static final String SEPARATOR = ", ";

    public static void main(String[] args) {
        // Don't run it for now!
//        generate("Tuples", SrcGen::generateTuples);
//        generate("Functions", SrcGen::generateFunctions);
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
        writer.println("import java.util.function.Consumer;");
        writer.println();
        writer.println("import static " + PACKAGE + ".Functions.*;");
        writer.println("import static " + PACKAGE + ".Tuples.*;");
        writer.println();
        writer.println("public final class " + name + " {");
        writer.println(INDENT + "private " + name + "() {}");
        writer.println();

        for(int i = 1; i <= NUM_PARAMS; i++) { //Inputs
            writer.println(INDENT + "public static<" + typeList("T", i) + "> Flow" + i + "<"
                           + tupleName("T", i) + ", "
                           + typeList("T", i) + "> with(" + inputClassParamList(i) + ") {");
            writer.println(INDENT + INDENT + "return new Flow" + i + "<>(null);");
            writer.println(INDENT + "}");
            writeSeparator(writer, i);
        }
        writer.println();

        writer.println(INDENT + "protected static class Flow<O1 extends Tuple> {");
        writer.println(INDENT + INDENT + "private final Flow<O1> prev;");
        writer.println(INDENT + INDENT + "protected Step<?, ?> step;");
        writer.println();
        writer.println(INDENT + INDENT + "protected Flow(Flow<O1> prev) {");
        writer.println(INDENT + INDENT + INDENT + "this.prev = prev;");
        writer.println(INDENT + INDENT + "}");
        writer.println();
        writer.println(INDENT + INDENT + "public <R1, T1> Step<R1, T1> step() {");
        writer.println(INDENT + INDENT + INDENT + "return (Step<R1, T1>) step;");
        writer.println(INDENT + INDENT + "}");
        writer.println();
        writer.println(INDENT + INDENT + "public Flow<O1> prev() {");
        writer.println(INDENT + INDENT + INDENT + "return prev;");
        writer.println(INDENT + INDENT + "}");
        writer.println();
        writer.println(INDENT + INDENT + "public void apply(Consumer<Step<?, ?>> consumer) {");
        writer.println(INDENT + INDENT + INDENT + "if (prev != null) {");
        writer.println(INDENT + INDENT + INDENT + INDENT + "prev.apply(consumer);");
        writer.println(INDENT + INDENT + INDENT + "}");
        writer.println();
        writer.println(INDENT + INDENT + INDENT + "if (step != null) {");
        writer.println(INDENT + INDENT + INDENT + INDENT + "consumer.accept(step);");
        writer.println(INDENT + INDENT + INDENT + "}");
        writer.println(INDENT + INDENT + "}");
        writer.println(INDENT + "}");
        writer.println();

        for(int i = 1; i <= NUM_PARAMS; i++) { //Inputs
            writer.println(INDENT + "public static class " + flowMainTypeName("T", i) + " extends Flow<O1> {");
            writer.println(INDENT + INDENT + "public Flow" + i + "(Flow<O1> prev) {");
            writer.println(INDENT + INDENT + INDENT + "super(prev);");
            writer.println(INDENT + INDENT + "}");
            writer.println();
            writer.println(INDENT + INDENT + "public ExecutableFlow<O1, " + tupleName("T", i) + "> build() {");
            writer.println(INDENT + INDENT + INDENT + "return new ExecutableFlow<>(this);");
            writer.println(INDENT + INDENT + "}");
            writer.println();

            //Flow methods
            for (int k = 1; k <= NUM_PARAMS; k++) { //Outputs
                for (int j = 1; j <= i; j++) { //Inputs
                    addFlowMethod(writer, k, j, "then", "StepType.SYNC");
                    writer.println();
                    addFlowMethod(writer, k, j, "async", "StepType.ASYNC");
                    writer.println();
                    addFlowMethod(writer, k, j, "await", "StepType.AWAIT");
                    writeInnerSeparator(writer, i, j);
                }
                writeSeparator(writer, k);
            }

            writer.println(INDENT + "}");

            writeSeparator(writer, i);
        }

        writer.println("}");
    }

    private static void writeInnerSeparator(PrintWriter writer, int i, int j) {
        if (j != i) {
            writer.println();
        }
    }

    private static void writeSeparator(PrintWriter writer, int i) {
        writeInnerSeparator(writer, NUM_PARAMS, i);
    }

    private static void addFlowMethod(PrintWriter writer, int k, int j, String name, String stepType) {
        writer.println(INDENT + INDENT + "@SuppressWarnings(\"unchecked\")");
        writer.println(INDENT + INDENT + "public <" + typeList("R", k) + "> " +
                       flowTypeName("R", k) + " " + name + k + "(" + functionNameType(j, k) +  " function) {");
        writer.println(INDENT + INDENT + INDENT +
            "step = new Step<>(" + stepType + ", (" + tupleName("T", j) + " param) -> function.apply(" +
                tupleToParams("T", j) + "));");
        writer.println(INDENT + INDENT + INDENT + "return new Flow" + k + "<>(this);");
        writer.println(INDENT + INDENT + "}");
    }

    private static String flowMainTypeName(String prefix, int i) {
        return "Flow" + i + "<" + "O1 extends Tuple, " + typeList(prefix, i) + ">";
    }

    private static String flowTypeName(String prefix, int i) {
        return "Flow" + i + "<" + "O1, " + typeList(prefix, i) + ">";
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
            writeSeparator(writer, i);
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

            writeSeparator(writer, i);
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
