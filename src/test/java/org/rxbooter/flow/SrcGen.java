package org.rxbooter.flow;

import org.rxbooter.flow.Tuples.Tuple;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

public class SrcGen {
    private static final String EXT = ".java";
    private static final String I = "    ";
    private static final String PACKAGE = SrcGen.class.getPackage().getName();
    private static final int NUM_PARAMS = 7;
    private static final String SEPARATOR = ", ";

    private final String name;
    private PrintWriter writer;

    public SrcGen(String name) {
        this.name = name;
    }

    public static void main(String[] args) {
//        new SrcGen("Flow").generateFlow();
        new SrcGen("FlowBuilders").generateFlowBuilders();
//        new SrcGen("Tuples").generateTuples();
//        new SrcGen("Functions").generateFunctions();
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

//    private void generateFlow() {
//        generate(this::generateFlow);
//    }

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

        out(0, "import java.util.ArrayList;");
        out(0, "import java.util.List;");
        out(0, "import java.util.function.Consumer;");
        nl();
        out(0, "import static " + PACKAGE + ".Functions.*;");
        out(0, "import static " + PACKAGE + ".Tuples.*;");
        nl();

        out(0,"public final class " + name + " {");
        out(1, "private " + name + "() {}");
        nl();

        out(1, "protected static class FlowBuilder<O1 extends Tuple> {");
        out(2, "private final FlowBuilder<O1> prev;");
        out(2, "protected Step<?, ?> step;");
        nl();
        out(2, "protected FlowBuilder(FlowBuilder<O1> prev) {");
        out(3, "this.prev = prev;");
        out(2, "}");
        nl();
        out(2, "@SuppressWarnings(\"unchecked\")");
        out(2, "public <R1, T1> Step<R1, T1> step() {");
        out(3, "return (Step<R1, T1>) step;");
        out(2, "}");
        nl();
        out(2, "public FlowBuilder<O1> prev() {");
        out(3, "return prev;");
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
        out(1, "}");
        nl();

        for(int i = 1; i <= NUM_PARAMS; i++) { //Inputs
            out(1, "public static class " + flowMainTypeName("T", i) + " extends FlowBuilder<O1> {");
            out(2, "public FlowBuilder" + i + "(FlowBuilder<O1> prev) {");
            out(3, "super(prev);");
            out(2, "}");
            nl();
            out(2, "@SuppressWarnings(\"unchecked\")");
            out(2, "public Flow<O1, " + tupleName("T", i) + "> build() {");
            out(3, "return new Flow<>(this);");
            out(2, "}");
            nl();

            //Flow methods
            for (int k = 1; k <= NUM_PARAMS; k++) { //Outputs
                for (int j = 1; j <= i; j++) { //Inputs
                    addFlowMethod(writer, k, j, "apply", "StepType.SYNC");
                    nl();
                    addFlowMethod(writer, k, j, "asyncApply", "StepType.ASYNC");
                    nl();
                    addFlowMethod(writer, k, j, "awaitApply", "StepType.AWAIT");
                    writeInnerSeparator(writer, i, j);
                }
                writeSeparator(writer, k);
            }

            out(1, "}");

            writeSeparator(writer, i);
        }

        out(0, "}");
    }

//    private void generateFlow(String name) {
//        out(0, "package " + PACKAGE + ";");
//        nl();
//
//        out(0, "import java.util.ArrayList;");
//        out(0, "import java.util.List;");
//        out(0, "import java.util.function.Consumer;");
//        nl();
//        out(0, "import static " + PACKAGE + ".Functions.*;");
//        out(0, "import static " + PACKAGE + ".Tuples.*;");
//        nl();
//
//        out(0,"public class " + name + "<O extends Tuple, I extends Tuple> {");
//        out(1, "private final List<Step<? extends Tuple, ? extends Tuple>> steps = new ArrayList<>();");
//        nl();
//        out(1, "@SuppressWarnings(\"unchecked\")");
//        out(1, "public " + name + "(FlowBuilder<O> last) {");
//        out(2, "//TODO: add grouping steps in batches");
//        out(2, "last.apply((step) -> steps.add((Step<Tuple, Tuple>) step));");
//        out(1, "}");
//        nl();
//        out(1, "public " + name + "(Step<O, I> step) {");
//        out(2, "steps.add(step);");
//        out(1, "}");
//        nl();
//
//        for(int i = 1; i <= NUM_PARAMS; i++) { //Inputs
//            out(1, "public static<" + typeList("T", i) + "> FlowBuilder" + i + "<"
//                + tupleName("T", i) + ", "
//                + typeList("T", i) + "> take(" + inputClassParamList(i) + ") {");
//            out(2, "return new FlowBuilder" + i + "<>(null);");
//            out(1, "}");
//            writeSeparator(writer, i);
//        }
//        nl();
//
//        out(1, "protected static class FlowBuilder<O1 extends Tuple> {");
//        out(2, "private final FlowBuilder<O1> prev;");
//        out(2, "protected Step<?, ?> step;");
//        nl();
//        out(2, "protected FlowBuilder(FlowBuilder<O1> prev) {");
//        out(3, "this.prev = prev;");
//        out(2, "}");
//        nl();
//        out(2, "@SuppressWarnings(\"unchecked\")");
//        out(2, "public <R1, T1> Step<R1, T1> step() {");
//        out(3, "return (Step<R1, T1>) step;");
//        out(2, "}");
//        nl();
//        out(2, "public FlowBuilder<O1> prev() {");
//        out(3, "return prev;");
//        out(2, "}");
//        nl();
//        out(2, "public void apply(Consumer<Step<?, ?>> consumer) {");
//        out(3, "if (prev != null) {");
//        out(3, I + "prev.apply(consumer);");
//        out(3, "}");
//        nl();
//        out(3, "if (step != null) {");
//        out(3, I + "consumer.accept(step);");
//        out(3, "}");
//        out(2, "}");
//        out(1, "}");
//        nl();
//
//        for(int i = 1; i <= NUM_PARAMS; i++) { //Inputs
//            out(1, "public static class " + flowMainTypeName("T", i) + " extends FlowBuilder<O1> {");
//            out(2, "public FlowBuilder" + i + "(FlowBuilder<O1> prev) {");
//            out(3, "super(prev);");
//            out(2, "}");
//            nl();
//            out(2, "public " + name + "<O1, " + tupleName("T", i) + "> build() {");
//            out(3, "return new " + name + "<>(this);");
//            out(2, "}");
//            nl();
//
//            //Flow methods
//            for (int k = 1; k <= NUM_PARAMS; k++) { //Outputs
//                for (int j = 1; j <= i; j++) { //Inputs
//                    addFlowMethod(writer, k, j, "apply", "StepType.SYNC");
//                    nl();
//                    addFlowMethod(writer, k, j, "asyncApply", "StepType.ASYNC");
//                    nl();
//                    addFlowMethod(writer, k, j, "awaitApply", "StepType.AWAIT");
//                    writeInnerSeparator(writer, i, j);
//                }
//                writeSeparator(writer, k);
//            }
//
//            out(1, "}");
//
//            writeSeparator(writer, i);
//        }
//
//        out(0, "}");
//    }

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
        out(3, "step = new Step<>(" + stepType + ", (" + tupleName("T", j) + " param) -> function.apply(" + tupleToParams("T", j) + "));");
        out(3, "return new FlowBuilder" + k + "<>(this);");
        out(2, "}");
        nl();
        out(2, "@SuppressWarnings(\"unchecked\")");
        out(2, "public <" + typeList("R", k) + "> " + flowTypeName("R", k) + " " + name + k + "(" + functionTypeName(j, k) + " function, " + errorHandlerTypeName(k) + " handler) {");
        out(3, "step = new Step<>(" + stepType + ", (" + tupleName("T", j) + " param) -> function.apply(" + tupleToParams("T", j) + "), handler::apply);");
        out(3, "return new FlowBuilder" + k + "<>(this);");
        out(2, "}");
    }

    private String flowMainTypeName(String prefix, int i) {
        return "FlowBuilder" + i + "<" + "O1 extends Tuple, " + typeList(prefix, i) + ">";
    }

    private String flowTypeName(String prefix, int i) {
        return "FlowBuilder" + i + "<" + "O1, " + typeList(prefix, i) + ">";
    }

    private void generateTuples(String name) {
        out(0, "package " + PACKAGE + ";");
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
        out(0, "import static " + PACKAGE + ".Tuples.*;");
        nl();
        out(0, "public interface " + name + " {");

        for(int j = 1; j <= NUM_PARAMS; j++) { //Outputs
            for(int i = 1; i <= NUM_PARAMS; i++) { //Inputs
                out(1, "interface " + functionTypeName(i, j) + " {");
                out(2, tupleName("R", j) + " apply(" + inputParamList(i) + ");");
                out(1, "}");

                if (i != NUM_PARAMS || j != NUM_PARAMS) {
                    nl();
                }
            }
        }

        out(0, "}");
    }

    private static String functionTypeName(int inputs, int outputs) {
        return "FN" + outputs + inputs + typeList(inputs, outputs);
    }

    private static String errorHandlerTypeName(int j) {
        return "FN" + j + "1<" + typeList("R", j) + SEPARATOR + "Throwable>";
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
