package Logic;

import Bean.Node;
import Utility.GraphvizController;

import java.util.*;

public class Automaton {
    private Node currentNode;
    public List<String> symbols;

    public Automaton(Node initialNode, List<String> symbols) {
        this.currentNode = initialNode;

        if (symbols == null || symbols.size() != 2) {
            throw new IllegalArgumentException("La lista de símbolos debe contener exactamente 2 elementos.");
        }

        this.symbols = symbols;
    }

    public boolean evaluate(String inputString) {

        for (char symbol : inputString.toCharArray()) {
            if (!symbols.contains(String.valueOf(symbol))) {
                return false;
            }
        }

        int index = 0;
        StringBuilder ConfigGraphviz = new StringBuilder("digraph g\n{\n");
        while (index < inputString.length()) {
            char symbol = inputString.charAt(index);
            Node nextNode = getNextNode(currentNode, symbol, symbols);

            if (nextNode == null) {
                return false;
            }
            ConfigGraphviz.append(String.format("%s -> %s [label=\"%c\"];\n",currentNode.getName(),nextNode.getName(), symbol));
            currentNode = nextNode;
            index++;
        }
        ConfigGraphviz.append("}\n");
        GraphvizController.generate(ConfigGraphviz.toString());
        return currentNode.isFinal();
    }

    private Node getNextNode(Node currentNode, char symbol, List<String> symbols) {
        if (symbols.size() < 2) {
            return null;
        }

        if (String.valueOf(symbol).equals(symbols.get(0))) {
            return currentNode.getLinkA();
        } else if (String.valueOf(symbol).equals(symbols.get(1))) {
            return currentNode.getLinkB();
        }
        return null;
    }

    public void Show() {
        Set<Node> visited = new HashSet<>();
        Queue<Node> queue = new LinkedList<>();
        StringBuilder ConfigGraphviz = new StringBuilder("digraph g\n" +
                "{\n" +
                    "rankdir=LR;\n");

        queue.add(currentNode);
        visited.add(currentNode);

        while (!queue.isEmpty()) {
            Node node = queue.poll();

            if (node.getLinkA() != null) {
                ConfigGraphviz.append(String.format("%s -> %s [label=\"a\", color=red];\n",node.getName(),node.getLinkA().getName()));
                if (!visited.contains(node.getLinkA())) {
                    queue.add(node.getLinkA());
                    visited.add(node.getLinkA());
                }
            }

            if (node.getLinkB() != null) {
                ConfigGraphviz.append(String.format("%s -> %s [label=\"b\", color=blue];\n",node.getName(),node.getLinkB().getName()));
                if (!visited.contains(node.getLinkB())) {
                    queue.add(node.getLinkB());
                    visited.add(node.getLinkB());
                }
            }
        }
        ConfigGraphviz.append("Q0 [color=red];\n");
        ConfigGraphviz.append("}\n");
        GraphvizController.generate(ConfigGraphviz.toString());
    }
}
