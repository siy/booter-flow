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

    //Note: might have issues in generated code
    public static void main(String[] args) {
        new SrcGen("FlowBuilders").generateFlowBuilders();
        //new SrcGen("Tuples").generateTuples();
        //new SrcGen("Functions").generateFunctions();
        //new SrcGen("Flows").generateFlows();
        //new SrcGen("Reactor").generateReactor();
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

    private void generateReactor() {
        generate(this::generateReactor);
    }

    private void generateReactor(String name) {
        out(0, "package " + PACKAGE + ";");
        nl();
        out(0, "// WARNING: Generated file, do not edit, all changes will be lost.");
        nl();
        out(0, "import java.util.function.Supplier;");
        nl();
        out(0, "import static " + PACKAGE + ".Tuples.*;");
        nl();
        out(0,"public interface " + name + " {");
        out(1,"void async(Runnable runnable);");
        nl();
        out(1,"<T> T await(Supplier<T> supplier);");
        nl();
        out(1,"<T> T awaitAny(Supplier<T>... suppliers);");
        nl();

        for(int i = 1; i <= NUM_PARAMS; i++) { //Inputs
            declareReactorMethod(i, "awaitAll");
            writeSeparator(i);
        }

        out(0,"}");

    }

    private void declareReactorMethod(int i, String functionName) {
        out(1, "default <" + typeList("T", i) + "> " + tupleName("T", i) + " " + functionName + "(" + inputSupplierList(i) + ") {");

        out(2, "return Tuples.of(" + awaitParameters(i) + ");");
        out(1, "}");
    }

    private String awaitParameters(int count) {
        StringBuilder builder = new StringBuilder();
        for (int i = 1; i <= count; i++) {
            builder.append("await(param").append(i).append(")").append(SEPARATOR);
        }

        builder.setLength(builder.length() - SEPARATOR.length());
        return builder.toString();
    }

    private void generateFlowBuilder(String name) {
        out(0, "package " + PACKAGE + ".impl" + ";");
        nl();
        out(0, "// WARNING: Generated file, do not edit, all changes will be lost.");
        nl();
        out(0, "import " + PACKAGE + ".ExecutionType;");
        out(0, "import " + PACKAGE + ".Flow;");
        out(0, "import " + PACKAGE + ".Step;");
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

        out(1, "/** The type {@code I1} holds original input tuple. */");
        out(1, "public static class FlowBuilder0<I1 extends Tuple> {");
        out(2, "protected final FlowBuilder0<I1> prev;");
        out(2, "private ExecutionType type = ExecutionType.SYNC;");
        out(2, "protected Step<?, ?> step;");
        out(2, "@SuppressWarnings(\"rawtypes\")");
        out(2, "private CF condition;");
        nl();
        out(2, "FlowBuilder0(FlowBuilder0<I1> prev) {");
        out(3, "this.prev = prev;");
        out(2, "}");
        nl();
        out(2, "void setAsync() {");
        out(3, "type = ExecutionType.ASYNC;");
        out(2, "}");
        nl();
        out(2, "void setAwait() {");
        out(3, "type = ExecutionType.AWAIT;");
        out(2, "}");
        nl();
        out(2, "void setCondition(CF<?> condition) {");
        out(3, "this.condition = condition;");
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
        out(2, "@SuppressWarnings(\"unchecked\")");
        out(2, "protected<R, T> FlowBuilder0<I1> step(TF<R, T> function) {");
        out(3, "this.step = condition != null ? Step.of(type, (input) -> condition.test(input) ? function.apply((T) input) : input) : Step.of(type, function);");
        out(3, "return this;");
        out(2, "}");
        nl();
        out(2, "@SuppressWarnings({\"rawtypes\", \"unchecked\"})");
        out(2, "protected void setOnError(EH<?> handler) {");
        out(3, "if (prev != null) {");
        out(4, "prev.step.handler((EH) handler);");
        out(3, "}");
        out(2, "}");
        out(1, "}");
        nl();

        for(int i = 1; i <= NUM_PARAMS; i++) { //Inputs
            out(1, "public interface " + flowFullBaseTypeName("T", i) + " {");
            addFlowMethodDeclaration(i, i, "map");
            addFlowConditionalMethodDeclaration(i, "when");
            out(1, "}");
            nl();
            out(1, "public static class " + flowMainTypeName("T", i) + " extends FlowBuilder0<I1> implements " + flowBaseTypeName("T", i) + " {");
            nl();
            out(2, "public FlowBuilder" + i + "(FlowBuilder0<I1> prev) {");
            out(3, "super(prev);");
            out(2, "}");
            nl();
            out(2, "public " + flowTypeName("T", i) + " async() {");
            out(3, "setAsync();");
            out(3, "return this;");
            out(2, "}");
            nl();
            out(2, "public " + flowTypeName("T", i) + " await() {");
            out(3, "setAwait();");
            out(3, "return this;");
            out(2, "}");
            nl();
            out(2, "public " + flowTypeName("T", i) + " onError(" + errorHandlerTypeName("T", i) + " handler) {");
            out(3, "setOnError(handler);");
            out(3, "return this;");
            out(2, "}");
            nl();
            out(2, "public Flow<Tuple" + i + "<" + typeList("T", i) + ">, I1> done() {");
            out(3, "return Flow.of(this);");
            out(2, "}");
            nl();
            out(2, "@Override");
            addFlowMethod(i, i, "map", false);
            nl();
            out(2, "@Override");
            addFlowConditionalMethod(i, "when");
            nl();

            //Flow methods
            for (int k = 1; k <= NUM_PARAMS; k++) { //Outputs
                if (k == i) {
                    continue;
                }
                addFlowMethod(k, i, "mapTo");
                writeSeparator(k);
            }

            out(1, "}");

            writeSeparator(i);
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

    private void writeInnerSeparator(int i, int j) {
        if (j != i) {
            nl();
        }
    }

    private void writeSeparator(int i) {
        writeInnerSeparator(NUM_PARAMS, i);
    }

    private void addFlowMethod(int k, int j, String name) {
        addFlowMethod(k, j, name, true);
    }

    private void addFlowConditionalMethodDeclaration(int k, String name) {
        out(2, flowBaseTypeName("T", k) + " " + name + "(" + conditionFunctionTypeName(k) + " condition);");
    }

    private void addFlowConditionalMethod(int k, String name) {
        String methodStart = "public " + flowBaseTypeName("T", k) + " " + name + "(" + conditionFunctionTypeName(k) + " condition";

        out(2, methodStart + ") {");
        out(3, "setCondition(condition.asConditionFunction());");
        out(3, "return this;");
        out(2, "}");
    }

    private void addFlowMethodDeclaration(int k, int j, String name) {
        out(2, "<" + typeList("R", k) + "> " + flowTypeName("R", k) + " " + name + "(" + functionTypeName(j, k) + " function);");
    }

    private void addFlowMethod(int k, int j, String inputName, boolean ordered) {
        String name = inputName + (ordered ? k : "");
        String methodStart = "public <" + typeList("R", k) + "> " + flowTypeName("R", k) + " " + name + "(" + functionTypeName(j, k) + " function";

        out(2, methodStart + ") {");
        out(3, "return new FlowBuilder" + k + "<>(step(function.asStepFunction()));");
        out(2, "}");
    }

    private String flowMainTypeName(String prefix, int i) {
        return "FlowBuilder" + i + "<" + "I1 extends Tuple, " + typeList(prefix, i) + ">";
    }

    private String flowTypeName(String prefix, int i) {
        return "FlowBuilder" + i + "<" + "I1, " + typeList(prefix, i) + ">";
    }

    private String flowBaseTypeName(String prefix, int i) {
        return "FlowBuilderBase" + i + "<" + "I1, " + typeList(prefix, i) + ">";
    }

    private String flowFullBaseTypeName(String prefix, int i) {
        return "FlowBuilderBase" + i + "<" + "I1 extends Tuple, " + typeList(prefix, i) + ">";
    }

    private void generateTuples(String name) {
        out(0, "package " + PACKAGE + ";");
        nl();
        out(0, "// WARNING: Generated file, do not edit, all changes will be lost.");
        nl();
        out(0, "public final class " + name + " {");
        out(1, "private " + name + "() {}");
        nl();
        out(1, "public static<T1, T2, T3, T4, T5, T6, T7, T8, T9> Tuple9<T1, T2, T3, T4, T5, T6, T7, T8, T9> empty() {");
        out(2, "return new Tuple9<>(null, null, null, null, null, null, null, null, null);");
        out(1, "}");
        nl();

        for(int i = 1; i <= NUM_PARAMS; i++) { //Inputs
            out(1, "public static<" + typeList("T", i) + "> Tuple" + i + "<" + typeList("T", i) + "> of(" + inputParamList(i) + ") {");
            out(2, "return new Tuple" + i + "<>(" + paramList(i) + ");");
            out(1, "}");
            writeSeparator(i);
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
        nl();
        out(2, "public int size() {");
        out(3, "return values.length;");
        out(2, "}");
        out(1, "}");
        nl();

        for(int i = 1; i <= NUM_PARAMS; i++) { //Inputs
                out(1, "public static class Tuple" + i + "<" + typeList("T", i) + "> extends Tuple {");
                out(2, "public Tuple" + i + "(" + inputParamList(i) + ") {");
                out(3, "super(" + paramList(i) + ");");
                out(2, "}");
                nl();
                for(int j = 1; j <= i; j++) { //Getters
                    out(2, "@SuppressWarnings(\"unchecked\")");
                    out(2, "public T" + j + " get" + j + "() {");
                    out(3, "return (T" + j + ") get(" + j+ ");");
                    out(2, "}");
                    writeInnerSeparator(j, i);
                }
                out(1, "}");
            writeSeparator(i);
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
        nl();
        out(1, "//----------------------------------- Condition functions");
        nl();
        for (int j = 1; j <= NUM_PARAMS; j++) { //Inputs
            String typeSpec = "<" + typeList("T", j) + ">";
            out(1, "interface CF" + j + typeSpec + " {");
            out(2, "boolean test(" + inputParamList(j) + ");");
            nl();
            //out(2, "@SuppressWarnings(\"unchecked\")");
            String returnType = "Tuple" + j + typeSpec;
            out(2, "default CF<" + returnType + "> asConditionFunction() {");
            out(3, "return (" + returnType + " param) -> test(" + tupleToParams("T", j) + ");");
            out(2, "}");
            out(1, "}");
            nl();
        }
        out(1, "//----------------------------------- Map functions");
        nl();
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
                //out(2, "@SuppressWarnings(\"unchecked\")");
                out(2, "default TF<" + resultTypeName + ", " + inputTypeName + "> asStepFunction() {");
                out(3, "return (" + inputTypeName + " param) -> apply(" + tupleToParams("T", j) + ");");
                out(2, "}");
                out(1, "}");
                writeSeparator(i);
            }
            writeSeparator(j);
        }

        out(0, "}");
    }

    private static String functionTypeName(int inputs, int outputs) {
        return "FN" + inputs + outputs + typeList(inputs, outputs);
    }

    private static String conditionFunctionTypeName(int inputs) {
        return "CF" + inputs + "<" + typeList("T", inputs) + ">";
    }

    private static String errorHandlerTypeName(String prefix, int j) {
        return "EH<Tuple" + j + "<" + typeList(prefix, j) + ">>";
    }

    private static String errorHandlerTypeName(int j) {
        return errorHandlerTypeName("R", j);
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
            builder.append("param.get" + i + "()").append(SEPARATOR);
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

    private static String inputSupplierList(int count) {
        StringBuilder builder = new StringBuilder();

        for (int i = 1; i <= count; i++) {
            builder.append("Supplier<T").append(i).append("> ").append("param").append(i).append(SEPARATOR);
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
