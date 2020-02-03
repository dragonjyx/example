package com.example.algo.hash;

import java.util.List;

/**
 * @author oyxl 10071355
 * @version 1.0
 * @description TODO
 * @date 2020/1/21 15:09
 * @blame 仓储开发组
 **/
public abstract class Cluster {

    protected List<Node> nodes;

    public Cluster(List<Node> nodes) {
        this.nodes = nodes;
    }

    public abstract void addNode(Node node);

    public abstract void removeNode(Node node);

    public abstract Node get(String key);

}
