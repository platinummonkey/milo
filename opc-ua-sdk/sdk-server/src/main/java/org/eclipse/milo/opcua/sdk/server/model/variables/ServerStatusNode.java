/*
 * Copyright (c) 2016 Kevin Herron
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v1.0 which accompany this distribution.
 *
 * The Eclipse Public License is available at
 * 	http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * 	http://www.eclipse.org/org/documents/edl-v10.html.
 */

package org.eclipse.milo.opcua.sdk.server.model.variables;

import java.util.Optional;

import org.eclipse.milo.opcua.sdk.core.model.variables.ServerStatusType;
import org.eclipse.milo.opcua.sdk.core.nodes.VariableNode;
import org.eclipse.milo.opcua.sdk.core.nodes.VariableTypeNode;
import org.eclipse.milo.opcua.sdk.server.api.UaNodeManager;
import org.eclipse.milo.opcua.sdk.core.annotations.UaVariableNode;
import org.eclipse.milo.opcua.stack.core.types.builtin.DataValue;
import org.eclipse.milo.opcua.stack.core.types.builtin.DateTime;
import org.eclipse.milo.opcua.stack.core.types.builtin.LocalizedText;
import org.eclipse.milo.opcua.stack.core.types.builtin.NodeId;
import org.eclipse.milo.opcua.stack.core.types.builtin.QualifiedName;
import org.eclipse.milo.opcua.stack.core.types.builtin.Variant;
import org.eclipse.milo.opcua.stack.core.types.builtin.unsigned.UByte;
import org.eclipse.milo.opcua.stack.core.types.builtin.unsigned.UInteger;
import org.eclipse.milo.opcua.stack.core.types.enumerated.ServerState;
import org.eclipse.milo.opcua.stack.core.types.structured.BuildInfo;
import org.eclipse.milo.opcua.stack.core.types.structured.ServerStatusDataType;

@UaVariableNode(typeName = "0:ServerStatusType")
public class ServerStatusNode extends BaseDataVariableNode implements ServerStatusType {

    public ServerStatusNode(
        UaNodeManager nodeManager,
        NodeId nodeId,
        VariableTypeNode variableTypeNode) {

        super(nodeManager, nodeId, variableTypeNode);
    }

    public ServerStatusNode(
        UaNodeManager nodeManager,
        NodeId nodeId,
        QualifiedName browseName,
        LocalizedText displayName,
        Optional<LocalizedText> description,
        Optional<UInteger> writeMask,
        Optional<UInteger> userWriteMask,
        DataValue value,
        NodeId dataType,
        Integer valueRank,
        Optional<UInteger[]> arrayDimensions,
        UByte accessLevel,
        UByte userAccessLevel,
        Optional<Double> minimumSamplingInterval,
        boolean historizing) {

        super(nodeManager, nodeId, browseName, displayName, description, writeMask, userWriteMask,
            value, dataType, valueRank, arrayDimensions, accessLevel, userAccessLevel, minimumSamplingInterval, historizing);
    }

    @Override
    public DataValue getValue() {
        ServerStatusDataType value = new ServerStatusDataType(
            getStartTime(),
            getCurrentTime(),
            getState(),
            getBuildInfo(),
            getSecondsTillShutdown(),
            getShutdownReason()
        );

        return new DataValue(new Variant(value));
    }

    @Override
    public DateTime getStartTime() {
        Optional<VariableNode> component = getVariableComponent("StartTime");

        return component.map(node -> (DateTime) node.getValue().getValue().getValue()).orElse(null);
    }

    @Override
    public BaseDataVariableNode getStartTimeNode() {
        Optional<VariableNode> component = getVariableComponent("StartTime");

        return component.map(node -> (BaseDataVariableNode) node).orElse(null);
    }

    @Override
    public void setStartTime(DateTime value) {
        getVariableComponent("StartTime")
            .ifPresent(n -> n.setValue(new DataValue(new Variant(value))));
    }

    @Override
    public DateTime getCurrentTime() {
        Optional<VariableNode> component = getVariableComponent("CurrentTime");

        return component.map(node -> (DateTime) node.getValue().getValue().getValue()).orElse(null);
    }

    @Override
    public BaseDataVariableNode getCurrentTimeNode() {
        Optional<VariableNode> component = getVariableComponent("CurrentTime");

        return component.map(node -> (BaseDataVariableNode) node).orElse(null);
    }

    @Override
    public void setCurrentTime(DateTime value) {
        getVariableComponent("CurrentTime")
            .ifPresent(n -> n.setValue(new DataValue(new Variant(value))));
    }

    @Override
    public ServerState getState() {
        Optional<VariableNode> component = getVariableComponent("State");

        return component.map(node -> (ServerState) node.getValue().getValue().getValue()).orElse(null);
    }

    @Override
    public BaseDataVariableNode getStateNode() {
        Optional<VariableNode> component = getVariableComponent("State");

        return component.map(node -> (BaseDataVariableNode) node).orElse(null);
    }

    @Override
    public void setState(ServerState value) {
        getVariableComponent("State")
            .ifPresent(n -> n.setValue(new DataValue(new Variant(value))));
    }

    @Override
    public BuildInfo getBuildInfo() {
        Optional<VariableNode> component = getVariableComponent("BuildInfo");

        return component.map(node -> (BuildInfo) node.getValue().getValue().getValue()).orElse(null);
    }

    @Override
    public BuildInfoNode getBuildInfoNode() {
        Optional<VariableNode> component = getVariableComponent("BuildInfo");

        return component.map(node -> (BuildInfoNode) node).orElse(null);
    }

    @Override
    public void setBuildInfo(BuildInfo value) {
        getVariableComponent("BuildInfo")
            .ifPresent(n -> n.setValue(new DataValue(new Variant(value))));
    }

    @Override
    public UInteger getSecondsTillShutdown() {
        Optional<VariableNode> component = getVariableComponent("SecondsTillShutdown");

        return component.map(node -> (UInteger) node.getValue().getValue().getValue()).orElse(null);
    }

    @Override
    public BaseDataVariableNode getSecondsTillShutdownNode() {
        Optional<VariableNode> component = getVariableComponent("SecondsTillShutdown");

        return component.map(node -> (BaseDataVariableNode) node).orElse(null);
    }

    @Override
    public void setSecondsTillShutdown(UInteger value) {
        getVariableComponent("SecondsTillShutdown")
            .ifPresent(n -> n.setValue(new DataValue(new Variant(value))));
    }

    @Override
    public LocalizedText getShutdownReason() {
        Optional<VariableNode> component = getVariableComponent("ShutdownReason");

        return component.map(node -> (LocalizedText) node.getValue().getValue().getValue()).orElse(null);
    }

    @Override
    public BaseDataVariableNode getShutdownReasonNode() {
        Optional<VariableNode> component = getVariableComponent("ShutdownReason");

        return component.map(node -> (BaseDataVariableNode) node).orElse(null);
    }

    @Override
    public void setShutdownReason(LocalizedText value) {
        getVariableComponent("ShutdownReason")
            .ifPresent(n -> n.setValue(new DataValue(new Variant(value))));
    }

}
