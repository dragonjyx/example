package com.example.algo.hash;

import java.util.List;

import static java.util.Objects.hash;

/**
 * @author oyxl 10071355
 * @version 1.0
 * @description TODO
 * @date 2020/1/21 15:10
 * @blame 仓储开发组
 **/
public class NormalHashCluster extends Cluster{

    public NormalHashCluster(List<Node> nodes) {
        super(nodes);
    }

    @Override
    public void addNode(Node node) {
        this.nodes.add(node);
    }

    @Override
    public void removeNode(Node node) {
        this.nodes.removeIf(n -> n.getIp().equals(node.getIp()) || n.getDomain().equals(node.getDomain()));
    }

    @Override
    public Node get(String key) {
        long hash = hash(key);
        long index =  hash % nodes.size();
        return nodes.get((int)index);
    }
}
