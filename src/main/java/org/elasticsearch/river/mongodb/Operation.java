package org.elasticsearch.river.mongodb;

public enum Operation {
    INSERT(MongoDBRiver.OPLOG_INSERT_OPERATION), UPDATE(MongoDBRiver.OPLOG_UPDATE_OPERATION), DELETE(MongoDBRiver.OPLOG_DELETE_OPERATION), DROP_COLLECTION(
            "dc"), DROP_DATABASE("dd"), UNKNOWN(null);

    private String value;

    private Operation(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static Operation fromString(String value) {
        if (value != null) {
            for (Operation operation : Operation.values()) {
                if (value.equalsIgnoreCase(operation.getValue())) {
                    return operation;
                }
            }
        }
        return Operation.UNKNOWN;
    }
}
