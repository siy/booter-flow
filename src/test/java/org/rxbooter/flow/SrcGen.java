package org.rxbooter.flow;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

public class SrcGen {
    private static final String EXT = ".java";
    private static final String I = "    ";
    private static final String PACKAGE = SrcGen.class.getPackage().getName();
    private static final int NUM_PARAMS = 9;
    private static final String SEPARATOR = ", ";

    private final String name;
    private PrintWriter writer;

    public SrcGen(String name) {
        this.name = name;
    }

    public static void main(String[] args) {
        new SrcGen("FlowBuilders").generateFlowBuilders();
        new SrcGen("Tuples").generateTuples();
        new SrcGen("Functions").generateFunctions();
    }

    public interface Generator {
        void generate(String name);
    }

    private void generate(Generator generator) {
        try(PrintWriter writer = openWriter(name)) {
            this.writer = writer;
            generator.generate(name);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void generateFlowBuilders() {
        generate(this::generateFlowBuilder);
    }

    private void generateTuples() {
        generate(this::generateTuples);
    }

    private void generateFunctions() {
        generate(this::generateFunctions);
    }

    private void generateFlowBuilder(String name) {
        out(0, "package " + PACKAGE + ";");
        nl();
        out(0, "// WARNING: Generated file, do not edit, all changes will be lost.");
        nl();

        out(0, "import java.util.function.Consumer;");
        nl();
        out(0, "import static " + PACKAGE + ".Functions.*;");
        out(0, "import static " + PACKAGE + ".Step.*;");
        out(0, "import static " + PACKAGE + ".Tuples.*;");
        nl();

        out(0,"public final class " + name + " {");
        out(1, "private " + name + "() {}");
        nl();

        out(1, "/** I1 - holds original input tuple. */");
        out(1, "public static class FlowBuilder0<I1 extends Tuple> {");
        out(2, "private final FlowBuilder0<I1> prev;");
        out(2, "Step<?, ?> step;");
        nl();
        out(2, "FlowBuilder0(FlowBuilder0<I1> prev) {");
        out(3, "this.prev = prev;");
        out(2, "}");
        nl();
        out(2, "public void apply(Consumer<Step<?, ?>> consumer) {");
        out(3, "if (prev != null) {");
        out(3, I + "prev.apply(consumer);");
        out(3, "}");
        nl();
        out(3, "if (step != null) {");
        out(3, I + "consumer.accept(step);");
        out(3, "}");
        out(2, "}");
        nl();
        out(2, "public FlowBuilder0<I1> step(Step<?, ?> step) {");
        out(3, "this.step = step;");
        out(3, "return this;");
        out(2, "}");
        out(1, "}");
        nl();

        for(int i = 1; i <= NUM_PARAMS; i++) { //Inputs
            out(1, "public static class " + flowMainTypeName("T", i) + " extends " + parentBuilderName(i) + " {");
            out(2, "public FlowBuilder" + i + "(FlowBuilder0<I1> prev) {");
            out(3, "super(prev);");
            out(2, "}");
            nl();
            out(2, "@SuppressWarnings(\"unchecked\")");
            out(2, "public Flow<I1, Tuple" + i + "<" + typeList("T", i) + ">> thenReturn" + i + "() {");
            out(3, "return Flow.of(this);");
            out(2, "}");
            nl();

            //Flow methods
            for (int k = 1; k <= NUM_PARAMS; k++) { //Outputs
                addFlowMethod(writer, k, i, "then", "sync");
                nl();
                addFlowMethod(writer, k, i, "thenAsync", "async");
                nl();
                addFlowMethod(writer, k, i, "thenAwait", "await");
                writeSeparator(writer, k);
            }

            out(1, "}");

            writeSeparator(writer, i);
        }

        out(0, "}");
    }

    private String parentBuilderName(int i) {
        String baseTypeList = typeList("T", i - 1);
        String typeList = !baseTypeList.isEmpty() ? ", " + baseTypeList : baseTypeList;
        return "FlowBuilder" + (i - 1) + "<I1" + typeList + ">";
    }

    private void nl() {
        writer.println();
    }

    private void out(String text) {
        writer.println(text);
    }

    private void out(int n, String text) {
        for (int i = 0; i < n; i++) {
            writer.print(I);
        }
        writer.println(text);
    }

    private void writeInnerSeparator(PrintWriter writer, int i, int j) {
        if (j != i) {
            nl();
        }
    }

    private void writeSeparator(PrintWriter writer, int i) {
        writeInnerSeparator(writer, NUM_PARAMS, i);
    }

    private void addFlowMethod(PrintWriter writer, int k, int j, String name, String stepType) {
        out(2, "@SuppressWarnings(\"unchecked\")");
        out(2, "public <" + typeList("R", k) + "> " + flowTypeName("R", k) + " " + name + k + "(" + functionTypeName(j, k) + " function) {");
        out(3, "return new FlowBuilder" + k + "<>(step(Step." + stepType + "(function.asStepFunction())));");
        out(2, "}");
        nl();
        out(2, "@SuppressWarnings(\"unchecked\")");
        out(2, "public <" + typeList("R", k) + "> " + flowTypeName("R", k) + " " + name + k + "(" + functionTypeName(j, k) + " function, " + errorHandlerTypeName(k) + " handler) {");
        out(3, "return new FlowBuilder" + k + "<>(step(Step." + stepType  + "(function.asStepFunction(), handler)));");
        out(2, "}");
    }

    private String flowMainTypeName(String prefix, int i) {
        return "FlowBuilder" + i + "<" + "I1 extends Tuple, " + typeList(prefix, i) + ">";
    }

    private String flowTypeName(String prefix, int i) {
        return "FlowBuilder" + i + "<" + "I1, " + typeList(prefix, i) + ">";
    }

    private void generateTuples(String name) {
        out(0, "package " + PACKAGE + ";");
        nl();
        out(0, "// WARNING: Generated file, do not edit, all changes will be lost.");
        nl();
        out(0, "public final class " + name + " {");
        out(1, "private " + name + "() {}");
        nl();

        for(int i = 1; i <= NUM_PARAMS; i++) { //Inputs
            out(1, "public static<" + typeList("T", i) + "> Tuple" + i + "<" + typeList("T", i) + "> of(" + inputParamList(i) + ") {");
            out(2, "return new Tuple" + i + "<>(" + paramList(i) + ");");
            out(1, "}");
            nl();
            out(1, "public static<" + typeList("T", i) + "> Tuple" + i + "<" + typeList("T", i) + "> with(" + inputParamList(i) + ") {");
            out(2, "return new Tuple" + i + "<>(" + paramList(i) + ");");
            out(1, "}");
            writeSeparator(writer, i);
        }

        nl();
        out(1, "public static class Tuple {");
        out(2, "private final Object[] values;");
        nl();
        out(2, "protected Tuple(Object ... values) {");
        out(3, "this.values = values;");
        out(2, "}");
        nl();
        out(2, "public Object get(int i) {");
        out(3, "return values[i];");
        out(2, "}");
        out(1, "}");
        nl();

        for(int i = 1; i <= NUM_PARAMS; i++) { //Inputs
                out(1, "public static class Tuple" + i + "<" + typeList("T", i) + "> extends Tuple {");
                out(2, "public Tuple" + i + "(" + inputParamList(i) + ") {");
                out(3, "super(" + paramList(i) + ");");
                out(2, "}");
                out(1, "}");

            writeSeparator(writer, i);
        }

        out(0, "}");
    }

    private void generateFunctions(String name) {
        out(0, "package " + PACKAGE + ";");
        nl();
        out(0, "// WARNING: Generated file, do not edit, all changes will be lost.");
        nl();
        out(0, "import static " + PACKAGE + ".Step.*;");
        out(0, "import static " + PACKAGE + ".Tuples.*;");
        nl();
        out(0, "public interface " + name + " {");

        for (int j = 1; j <= NUM_PARAMS; j++) { //Outputs
            String baseName = "FN" + j + "0";
            out(1, "interface " + baseName + typeList(j, 1) + " {");
            out(2, "R1 apply(" + inputParamList(j) + ");");
            out(1, "}");
            nl();

            for(int i = 1; i <= NUM_PARAMS; i++) { //Inputs
                String resultTypeName = "Tuple" + i + "<" + typeList("R", i) + ">";
                String inputTypeName = "Tuple" + j + "<" + typeList("T", j) + ">";
                out(1, "interface FN" + j + i + typeList(j, i) + " extends " + baseName + "<" + resultTypeName + ", " + typeList("T", j) + "> {");
                out(2, "default TF<" + resultTypeName + ", " + inputTypeName + "> asStepFunction() {");
                out(3, "return (" + inputTypeName + " param) -> apply(" + tupleToParams("T", j) + ");");
                out(2, "}");
                out(1, "}");
                writeSeparator(writer, i);
            }
            writeSeparator(writer, j);
        }

        out(0, "}");
    }

    private static String functionTypeName(int inputs, int outputs) {
        return "FN" + inputs + outputs + typeList(inputs, outputs);
    }

    private static String errorHandlerTypeName(int j) {
        return "EH<Tuple" + j + "<" + typeList("R", j) + ">>";
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
        if (count < 1) {
            return "";
        }
        
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
